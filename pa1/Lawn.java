//----------------------------------------------------------------------------
// Lawn.java
// Shridhik John
// shjohn@ucsc.edu
// pa1
// program that interacts with user to calculate the lawn area and mowing time
//----------------------------------------------------------------------------

import java.util.Scanner;

class Lawn{

   public static void main( String[] args ){

      double length, width, area, length2, width2, area2, lawn_area, rate;
      int    time, hour, min, sec;
 
      Scanner sc = new Scanner(System.in);
      //input from the user to calculate area of the house, lot, and lawn
      System.out.print("Enter the length and width of the lot, in feet: ");
      length  = sc.nextDouble();
      width = sc.nextDouble();
      area = length*width;
      System.out.print("Enter the length and width of the house, in feet: ");
      length2 = sc.nextDouble();
      width2 = sc.nextDouble();
      area2= length2*width2;
      System.out.print("The lawn area is ");
      lawn_area=(area-area2);  
      System.out.print(lawn_area);
      System.out.println(" square feet.");
      //inputer from the user to calculate the the mowing time of the lawn based off of the given mowing rate
      System.out.print("Enter the mowing rate, in square feet per second: ");
      rate = sc.nextDouble();
      // calculates mowing time and rounds up time to integers with Math.round as referenced in HMS.java
      time = (int)Math.round((lawn_area/rate));
      hour = (time/3600);
      min = (time%3600)/60;
      sec = (time%3600)%60;
      // prints the mowing time in hours, minutes, amd seconds grammatically correct referenced: Plural.java	
      System.out.println("The mowing time is "+hour+" hour"+(hour==1?" ":"s ")+min+" minute"+(min==1?" ":"s ")+"and " +sec+" second"+(sec==1?".":"s."));
   }
}

