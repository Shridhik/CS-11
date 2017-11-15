//-----------------------------------------------------------------------------
// Complex.java
// Shridhik John
// shjohn@ucsc.edu
// pa6
// Represents complex numbers as a pair of doubles
//-----------------------------------------------------------------------------

class Complex{

   //--------------------------------------------------------------------------
   // Private Data Fields 
   //--------------------------------------------------------------------------
   private double re;
   private double im;
   
   //--------------------------------------------------------------------------
   // Public Constant Fields 
   //--------------------------------------------------------------------------
   public static final Complex ONE = Complex.valueOf(1,0);
   public static final Complex ZERO = Complex.valueOf(0,0);
   public static final Complex I = Complex.valueOf(0,1);

   //--------------------------------------------------------------------------
   // Constructors 
   //--------------------------------------------------------------------------
   Complex(double a, double b){
      this.re = a;
      this.im = b;
   }

   Complex(double a){
      this.re = a;
      this.im = 0;
   }

   Complex(String s){
      // It should accept expressions like "-2+3i", "2-3i", "3", "5i", etc..
      // Throw a NumberFormatException if s cannot be parsed as Complex.
   
      double[] part = new double[2];
      String STR = s.trim();
      String NUM = "(\\d+\\.\\d*|\\.?\\d+)";
      String SGN = "[+-]?";
      String OP =  "\\s*[+-]\\s*";
      String I =   "i";
      String OR =  "|";
      String REAL = SGN+NUM;
      String IMAG = SGN+NUM+"?"+I;
      String COMP = REAL+OR+
                    IMAG+OR+
                    REAL+OP+NUM+"?"+I;

      if( !STR.matches(COMP) ){
         throw new NumberFormatException(
                   "Cannot parse input string \""+STR+"\" as Complex");
      }
      STR = STR.replaceAll("\\s","");
      if( STR.matches(REAL) ){
         part[0] = Double.parseDouble(STR);
         part[1] = 0;
      }else if( STR.matches(SGN+I) ){
         part[0] = 0;
         part[1] = Double.parseDouble( STR.replace( I, "1.0" ) );
      }else if( STR.matches(IMAG) ){
         part[0] = 0;
         part[1] = Double.parseDouble( STR.replace( I , "" ) );
      }else if( STR.matches(REAL+OP+I) ){
         part[0] = Double.parseDouble( STR.replaceAll( "("+REAL+")"+OP+".+" , "$1" ) );
         part[1] = Double.parseDouble( STR.replaceAll( ".+("+OP+")"+I , "$1"+"1.0" ) );
      }else{   //  s.matches(REAL+OP+NUM+I) 
         part[0] = Double.parseDouble( STR.replaceAll( "("+REAL+").+"  , "$1" ) );
         part[1] = Double.parseDouble( STR.replaceAll( ".+("+OP+NUM+")"+I , "$1" ) );
      }
      this.re = part[0];
      this.im = part[1];
   }
   //---------------------------------------------------------------------------
   // Public methods 
   //---------------------------------------------------------------------------

   // Complex arithmetic -------------------------------------------------------

   // copy()
   // Return a new Complex equal to this Complex
   Complex copy(){
     return new Complex(this.re,this.im);
   }
   
   // add()
   // Return a new Complex representing the sum this plus z.
   Complex add(Complex z){
      double re = z.re + this.re; //a+c
      double im = z.im + this.im; //b+d
      return new Complex(re,im);
   }
   
   // negate()
   // Return a new Complex representing the negative of this.
   Complex negate(){
      double re = this.re * (-1.0);
      double im = this.im * (-1.0);
      return new Complex(re,im);
   }

   // sub()
   // Return a new Complex representing the difference this minus z.
   Complex sub(Complex z){
      double re = this.re - z.re;   
      double im = this.im - z.im;
      return new Complex(re,im);
   }

   // mult()
   // Return a new Complex representing the product this times z.
   Complex mult(Complex z){
      double re =(this.re * z.re)-(this.im * z.im); //ac-bd
      double im = (this.re * z.im)+(z.re * this.im);//ad+bc
	return new Complex(re,im);
   }

   // recip()
   // Return a new Complex representing the reciprocal of this.
   // Throw an ArithmeticException with appropriate message if 
   // this.equals(Complex.ZERO).
   Complex recip(){
     if( this.equals(Complex.ZERO)) 
        throw new ArithmeticException("Cannot get the reciprocal for zero");	
     else{
	 double re = (this.re/((this.re * this.re)+(this.im * this.im)));
     	 double im = ((-1.0 * this.im)/((this.re * this.re)+(this.im * this.im)));
         return new Complex(re,im);
        }	
   }

   // div()
   // Return a new Complex representing the quotient of this by z.
   // Throw an ArithmeticException with appropriate message if 
   // z.equals(Complex.ZERO).
   Complex div(Complex z){
     if( z.equals(Complex.ZERO)) 
        throw new ArithmeticException("not divisible by zero");
     else{ 
    	 double re = (((this.re * z.re)+(this.im * z.im))/((z.re * z.re)+(z.im * z.im)));
    	 double im = (((z.re * this.im)-(z.im * this.re))/((z.re * z.re)+(z.im * z.im)));
	return new Complex(re,im);
        }
   }

   // conj()
   // Return a new Complex representing the conjugate of this Complex.
   Complex conj(){
      	double re = this.re;
	double im = this.im * (-1.0);
	
        return new Complex(re,im);
   }
   
   // Re()
   // Return the real part of this.
   double Re(){
      return re;
   }

   // Im()
   // Return the imaginary part of this.
   double Im(){
      return im;
   }

   // abs()
   // Return the modulus of this Complex, i.e. the distance between 
   // points (0, 0) and (re, im).
   double abs(){
      return Math.sqrt(((this.re * this.re)+(this.im * this.im)));
   }

   // arg()
   // Return the argument of this Complex, i.e. the angle this Complex
   // makes with positive real axis.
   double arg(){
      return Math.atan2(im, re);
   }

   // Other functions ---------------------------------------------------------
   
   // toString()
   // Return a String representation of this Complex.
   // The String returned will be readable by the constructor Complex(String s)
   public String toString(){
      String complex;
         if (this.re == 0.0){
             complex =  new String(this.im + "i");
         }
         else if (this.im == 0.0){
              complex =  new String(this.re + "");
         }
         else{
              if (this.im < 0.0)
			complex =  new String(this.re + "" + this.im + "i");
	      else
			complex =  new String(this.re + "+" + this.im + "i");
         }
   return complex;
   }

   // equals()
   // Return true iff this and obj have the same real and imaginary parts.
   public boolean equals(Object x){
      Complex p;
      boolean eq = false;

      if( x instanceof Complex ){  // try leaving out this check
         p = (Complex) x;
         eq = this.re==p.re &&
              this.im==p.im;
      }
      return eq;
   }
   

   // valueOf()
   // Return a new Complex with real part a and imaginary part b.
   static Complex valueOf(double a, double b){
      return new Complex(a,b);
   }

   // valueOf()
   // Return a new Complex with real part a and imaginary part 0.
   static Complex valueOf(double a){
      return new Complex(a,0);
   }

   // valueOf()
   // Return a new Complex constructed from s.
   static Complex valueOf(String s){
      return new Complex(s);
   }

}
