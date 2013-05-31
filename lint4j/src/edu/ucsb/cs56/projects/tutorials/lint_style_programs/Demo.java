package edu.ucsb.cs56.projects.tutorials.lint_style_programs;

public class Demo {

    void AssignmentNoEffect(){
	int x = 5;
	x = x;
    }
    void AssignmentToBoolean(){
	int x;
	boolean f;
	if(f = true)
	    x = 2;
    }
    public static void main (String [] args) {
	System.out.println("This Compiles and Runs");
    }




}