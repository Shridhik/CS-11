//-----------------------------------------------------------
// GCD.java
// Shridhik John
// shjohn@ucsc.edu
// pa3
// A program that calculates the Greatest Common Denominator for 2 positive integers
//-----------------------------------------------------------

import java.util.Scanner;
class GCD{
   public static void main( String[] args ){
   int a, b, A, B, R;
    
        Scanner sc = new Scanner(System.in);
     
      // get two positive integers from the user

        System.out.print("Enter a positive integer: ");

        while(true)
        { // seemingly infinite loop 
            while( !sc.hasNextInt() )
            { // if its not a integer
            sc.next(); // discard the non-integer
            System.out.print("Please enter a positive integer: "); // ask again
            } // at this point we have a double in the input stream, unread
            a = sc.nextInt();
            if (a < 0)
                System.out.print("Please enter a positive integer: ");
            else 
                break;
        }
        
        System.out.print("Enter another positive integer: ");       
        while(true)
        { // seemingly infinite loop 
            while( !sc.hasNextInt() )
            { // if its not a double
            sc.next(); // discard the non-double
            System.out.print("Please enter a positive integer: "); // ask again
            } // at this point we have a double in the input stream, unread
                
            b = sc.nextInt();
            if (b < 0)
                System.out.print("Please enter a positive integer: ");
            else            
                break;       
        }

        A = Math.max(a,b); // finds the max value between the two inputs and stores max in A
        B = Math.min(a, b); // finds the min value between the two inputs and stores min in B

        
        while(B != 0) // When the remainder is not 0 the process will loop
        {
        
            R= A%B; // modulo to calculate theremainder between the  Min and Max 

            A=B; // assigns the devisor as the new dividend
            
            B=R; // assigns the remainder as the new divisor, and then checks the loop to see if the remainder is 0 yet
        
        }
    System.out.println("The GCD of "+ a +" and "+ b +" is " +A+"\n"); 
    }
}
                
          

 

