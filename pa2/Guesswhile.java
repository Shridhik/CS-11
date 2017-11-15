//-----------------------------------------------------------
// To change this license header, choose License Headers in Project Properties.
// Guess.java
// shjohn@ucsc.edu
// Pa2
// An interactive game that asks to guess a number between 1 to 10 in three guesses
//-----------------------------------------------------------

import java.util.Scanner;

class Guess{

   public static void main( String[] args ){
        Scanner sc = new Scanner(System.in);
        //Generates a random number between 1 and 10
        int n,a,b,c;
        boolean guess = false;
        n =(int)((Math.random()*10)+1);
        //Sytem output and input
        System.out.println("\nI'm thinking of an integer in the range 1 to 10. You have three guesses.");
        
        while (guess==false)
        {    
            System.out.print("\nEnter your first guess:");
            a = sc.nextInt();
            if (a>n){
                System.out.println("Your guess is too high.");
            }
        
            else if (a<n){
                System.out.println("Your guess it too low.");   
            }
        
            else { 
                System.out.println("You Win!\n");
                guess=true;
		break;
            	}
     
            System.out.print("\nEnter your second guess:");
            b = sc.nextInt();
    
            if (b>n){
                System.out.println("Your guess is too high.");
            }
            
            else if (b<n){
                System.out.println("Your guess is too low.");   
            }
            else { 
                System.out.println("You Win!\n");
                guess = true;
           	break;
            	}
            System.out.println();
            System.out.print("Enter your third guess:");
            c = sc.nextInt();

            if (c>n){
                System.out.println("Your guess is too high.");
                System.out.println();
                System.out.println("You Lose. The number was "+n+".\n");
		break; 
            }
            else if (c<n){
                System.out.println("Your guess it too low."); 
                System.out.println();
                System.out.println("You Lose. The number was "+n+".\n"); 
		break; 
            }
            else { 
                System.out.println("You Win!\n");
		break;
            }
        }
            
    }
}

