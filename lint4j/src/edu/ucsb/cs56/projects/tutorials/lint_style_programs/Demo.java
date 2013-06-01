package edu.ucsb.cs56.projects.tutorials.lint_style_programs;

public class Demo {

    public void assignmentNoEffect(){
	int a = 5;
	a = a; // Statemenet has no effect
    }
    public void assignmentToBoolean(){
	int a;
	boolean f;
	if(f = true) // Should be (f == true)
	    a = 2;
    }
    public void Demo(){
	// Method should not have constructor name
    }
    public void equalsArray(){
	int[] a = {0,1};
	int[] b = {0,0};
	int x;
	if(a.equals(b)){ // equals method on array types tests identity only, consider using Arrays.equal()
	    x = 1;}
    }
    public void equalsString(){
	String a = "Hi";
	String b = "There";
	if(a == b){ // Strings should be compared using equals() method
	    b = "Hi";}
    }
    public void comparingFloatingPoints(){
	float a = 0.1;
	float b = 1.1;
	if(a == b){ // Equality checks with floating point numbers can lead to unexpected behavior
	    b = 2.2;}
    }
    public static void main (String [] args) {
	System.out.println("This Compiles and Runs");
	return 0; // Should not return anything
    }




}
