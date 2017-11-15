# Makefile
# Shridhik Hurly John
# shjohn@ucsc.edu
# lab4
# A simple Makefile for the GCD program
GCD: GCD.class
	echo Main-class: GCD > Manifest
	jar cvfm GCD Manifest GCD.class
	rm Manifest
	chmod u+x GCD
GCD.class: GCD.java
	javac -Xlint GCD.java
clean:
	rm  GCD.class GCD
submit: Makefile GCD.java
	submit cmps011-pt.s17 lab4 Makefile GCD.java
