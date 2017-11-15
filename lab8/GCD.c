/*
 * GCD.c
 * Shridhik John
 * shjohn@ucsc.edu
 * lab8
 * C program that prompts the user for two positive integers, then prints out the greatest common divisor of the two numbers.
*/

/* GCD.c */
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>

int isInteger(char s[]);
int max(int A,int B);
int min(int A,int B);

int main(){
	int i, n, a, A, B, R;
   	int x[2];
   	char str[100];
 
   	// get two positive integer from the user
         for(i=0; i<2; i++){
            if (i==0)
		   printf("Enter a positive integer: ");
	    else
                   printf("Enter another positive integer: ");

            n = scanf(" %s", str); // read one token from stdin
                           
            while( 1 ){ // seemingly infinite loop
               while( !isInteger(str) ){ // if its not a integer
                  printf("Please enter a positive integer: "); // ask again
                  n = scanf(" %s", str);             // get another string
               }
         
               // at this point str is a string that should be convertable to integer
         
               sscanf(str, "%d", &x[i]);  // convert str to integer and store in array x[]
               if( x[i]>0 ){               // if it's positive
                  break;                   // get out of the while loop
               }
               printf("Please enter a positive integer: "); // otherwise ask again
               n = scanf(" %s", str);                      // and get another
            }
            // break lands here
         }

	 A = max(x[0],x[1]);
	 B = min(x[0],x[1]);
        
	 while(B != 0){
           R= A%B;
           A=B;
           B=R;
         }

         // do the whole thing 3 times and end up here
         printf("The GCD of %d and %d is %d \n", x[0], x[1], A);
         return 0;
}




// Function to checks whether input is an integer
int isInteger(char s[]){
   int i, n;
   
   if( s==NULL ) 
      return 0;
   n = strlen(s);
   if( n==0 ) 
      return 0;
   if( s[0]!='-' && s[0]!='+' && !isdigit(s[0]) )
      return 0;
   for(i=1; i<n; i++){
      if( !isdigit(s[i]) ) 
         return 0;
   }
   return 1;
}


// functions that return max and min values 
int max(int A,int B){
  if (A > B)
	return A;
  else 
	return B;
}


int min(int A,int B){
 if (A < B) 
        return A;
 else 
        return B;
}

