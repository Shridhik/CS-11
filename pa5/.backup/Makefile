# A simple Makefile for the Queens program
Queens: Queens.class
	echo Main-class: Queens > Manifest 
	jar cvfm Queens Manifest Queens.class
	rm Manifest
	chmod u+x Queens

Queens.class: Queens.java
	javac -Xlint Queens.java

clean:
	rm Queens.class Queens

submit: Makefile Queens.java
	submit cmps011-pt.s17 pa5 Makefile Queens.java

check: 
	ls  /afs/cats.ucsc.edu/class/cmps011-pt.s17/pa5/shjohn
