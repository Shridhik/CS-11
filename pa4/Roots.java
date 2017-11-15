// Roots.java
// Shridhik John
// shjohn@ucsc.edu
// pa4
// a program that determines the real roots of a polynomial within a specific range 

import java.util.Scanner;
class Roots {
    
    //A call to poly(C, x) will return the value at X of the polynomial with coefficient array C
    static double poly(double[] C, double x)
    {
    double sum = 0.0;
    int i;
    //as long as i is less than the array length, we will increment i and get the coefficient times variable 
        for(i=0; i<C.length; i++) 
            sum += Math.pow(x,i)*C[i];   
    return sum;
    }
    
    
    //Calculates the coefficients of the derivative polynomial, returns derivative of the function poly(C, x)
    static double[] diff(double[] C)
    {
        double D[] = new double[C.length-1];        
        int j;
        int i;
            for(j=0; j<C.length-1; j++){
                i = j+1;
                D[j]= i*C[i];
                //System.out.println(D[j]);
            }
        return D;      
    }
    
    
    //will return an approximation to a root of poly(C, x) in the interval [a, b] whose error is no more than tolerance
    static double findRoot(double[] C, double a, double b, double tolerance)
    {
      double width;
      double mid=0.0;
      width = b-a;
      while ( width>tolerance ){
         mid = (a+b)/2;
         if( poly(C,a)*poly(C,mid)<=0 ){  // if root is in [a, mid]
            b = mid;            //    move b left
         } else {               // else root is in (mid, b] 
            a = mid;            //    move a right
         }
         width = b-a;
      }
    return mid;
    }
    
    
    //Main function
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      double resolution = Math.pow(10,-2);
      double tolerance = Math.pow(10, -12);
      double threshold = Math.pow(10,-5);
      double  L, R, a, b, root, odd_root, even_root;
      int deg, i; 
      boolean oddroot = false;
      boolean evenroot = false;
      System.out.print("Enter the degree: ");
      deg = sc.nextInt();
      double C[] = new double [deg+1];

      System.out.print("Enter "+(deg + 1)+" coefficients: ");
      for (i=0; i<(deg+1); i++){
         C[i] = sc.nextDouble();
           }
      System.out.print("Enter the left and right endpoints: ");
      L = sc.nextDouble();
      R = sc.nextDouble();
      System.out.println();
      //diff(C);
  a = L;
  double[] D = diff(C);
  
 while(a<R) {
  b = a+resolution; // increments b by a + .01

  if( poly(C,a)* poly(C,b)<0) {
   odd_root = findRoot(C,a,b, tolerance);
   System.out.printf("Odd root found at: %.10f%n", odd_root); //prints root, rounds 10 digits
   oddroot=true;
  }
 
 if( poly(D,a)* poly(D,b)<0) {
   root= findRoot(D,a,b, tolerance);
   if(Math.abs(poly(C,root)) < threshold) 
   {
       even_root = findRoot(D,a,b, tolerance);
       System.out.printf("Even root found at: %.10f%n", even_root);
       evenroot=true;
   }   

  }
 // increments by .01
 a += resolution;
 }
 //if no roots are found
if(oddroot==false && evenroot==false)
 System.out.println("No roots were found in the specified range.");
      
 }
}

