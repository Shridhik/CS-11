/*
 *  Sphere.c
 *  Shridhik John
 *  shjohn@ucsc.edu
 *  lab7
 *  program that takes in a radius as an inpu and outputs the volume and surface area of the sphere
*/

/* Sphere.c */
#include<stdio.h>
#include<stdlib.h>
#include<math.h>
int main(void){
	const double pi = 3.141592654;
	double R, SA, V;
	printf("Enter the radius of the sphere: ");
	scanf("%lf",&R);
	SA = 4*pi*pow(R,2);
	V = (4.0/3.0)*(pi*pow(R,3));
	printf("The volume is %f and the surface area is %f.\n", V, SA);
}
