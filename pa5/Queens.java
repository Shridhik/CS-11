
// Queens.java
// Shridhik John
// shjohn@ucsc.edu
// pa5
// program that finds all solutions to the n-Queens problem, for 1 <= n <= 13

public class Queens {

    public static void main(String[] args) {
    int n=0, f;
    boolean verbose = false;
    int a= args.length;
    int[] Array;
        //if -v is an input, ask for an integer, set verbose as true to print possibilities, and catch erros
        if (a<1 || a>2){
            usage();
        }
        
        if (a==1){
                    try{
                        n = Integer.parseInt(args[0]);
                        }            
                    catch (Exception error){
                        usage();
                        }
        }

         else{
                    try{
                        if (args[0].equals("-v"))
                            verbose=true;
                        else
                            usage();
                        
                        n= Integer.parseInt(args[1]);
                        }            
                    catch (Exception error){
                        usage();
                        }
        }
	
           
    // assigns the factorial of input n to f using the factorial function
    f = fact(n);
    //initialize array with n elements
    Array = new int[n+1];
    int cnt=0;
    for(int i=1; i<=f; i++) 
    {      
        nextPermutation(Array);
        
        if (isSolution(Array)){
            cnt ++;
            if (verbose){
               printArray(Array);
            }
        }
   }
   System.out.println(n+"-Queens has "+cnt+" solutions");    
   
}
   static void usage() {
   System.out.println("Usage: Queens [-v] number");
   System.out.println("Option: -v verbose output, print all solutions");
   System.exit(0);        
  }
 
    // function that calculates the factorial for n elements 
 static int fact(int n)
{
    int product = 1, i = 1;
    while(i<=n)
    {
        product *= i;
        i++;
    }
    return product;
}


   // printArray()
   // prints the contents of an int array to stdout
   static void printArray(int[] A)
   {
      //if(A[1] != 0)
      {
      System.out.print("(");
      for(int i=1; i<A.length; i++)
         if (i<A.length-1) System.out.print(A[i]+", ");
         else System.out.print(A[i]);
      System.out.println(")");
      }
   }


static void nextPermutation(int[]A) {

   int s=0,p=0;
   boolean reverse_array = true;
   // assigning pivot - scan from right to left, find the first element that is less than its previous one.

   for(int i=A.length-2; i>=0; i--) {
    // if current element is less than right hand neighbour
    if(A[i]<A[i+1]) {
      p = i;   // call current element pivot and stop scanning (break)
      reverse_array = false;  // reverse= false
      break;
    }
   }
    //if the left end was reached without finding a pivot
    // reverse the array (permutation was lexicographically last, so start over or initialize)
 if( reverse_array ) {
   for(int i=1; i<A.length; i++) {
     A[i] = i;
   }
   return; 
 }
  // scans from right to left again
  // and if current element is larger than pivot scans and assigns current element as successor
  for(int i=A.length-1; i>0; i--) {
    if(A[i] > A[p]) {
     s = i;
     break;
    }
  }
 // swap the pivot and successor
 swap(p, s, A);
 //reverse the portion of the array to the right of where the pivot was found
 reverse(p, A);
 }
 
 static void reverse(int pivot, int[] Array) {
   //reverse the portion of the array to the right of where the pivot was found
   int i=pivot+1; int j= Array.length-1;

   while(i<j) {
    swap(i,j,Array);
    i++;
    j--;
   }
    return;
  } 

 static void swap(int a, int b, int[] Array) {
   // swaps 2 elements of location a and b in an Array
   int temp = Array[a];
   Array[a] = Array[b];
   Array[b] = temp;
 }
 
static boolean isSolution(int[] Array){ 
    // Loops through entier row
    for(int i =1; i<Array.length; i++) {
      // Loops through entier column
      for (int j =1; j<Array.length; j++) {
        // Return false when diagonal or horizontol or vertical from each other
        if( i!=j  &&  Array[i]!=Array[j] && Math.abs(i-j) == Math.abs(Array[i]-Array[j])  ) {
          return false;
        }
      }
    }
    return true;
  
}

 
 
}
