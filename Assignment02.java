//=============================================== 
// AUTHOR: Ian Utnehmer  
// COURSE: CS 112 Intro to CS II - Java  
// SECTION: 6/21
// ASSIGNMENT: Assignment 02
//=============================================== 

//===============================================  
// Circles program.
// Using File IO, we will read in circle and sphere
// values from a file. We will store circles in
// a Circle object array, and the spheres
// in a spheres object array. Then, we will 
// print out the center, radius, and area/vol
// of each circle, as well as duplicate circle
//count.
//==============================================

//=============================================== 
// IMPORTS 
//=============================================== 
import java.io.File;
import java.util.Scanner;

public class Assignment02 {
	// Take in a the array of circles so we can make a 
	// copy of that array and manipulate its copies.
	// (We need to remove values that were already marked
	// as duplicates so as to not accidentally 
	// mark the original value as its duplicate, doubling
	// the duplicate count)
	public static int detectDupCircles(Circle[] circleArray) {
		Circle[] arrayOfCircle = circleArray;
		int duplicateCirclesCount = 0;
		for (int x = 0; x < arrayOfCircle.length; x++) {
			for (int i = 0; i < arrayOfCircle.length; i++) {
				if (arrayOfCircle[x].equals(arrayOfCircle[i]) && x != i) {
					duplicateCirclesCount++;
					arrayOfCircle[x] = null;
					break;
				}
			}
		}
		return duplicateCirclesCount;
	}
	
	public static void scaleCircles(Circle circleObj, double scale) {
		circleObj.tempRadius = circleObj.getRadius();
		circleObj.tempRadius *= scale;
		circleObj.setRadius(circleObj.tempRadius);
	}
	
	public static void printCircles(Circle circleObj) {
		System.out.printf("%s\n", circleObj.toString());
	}
	
	// 2 circles, 2 spheres.
	public static void main(String[] args) throws Exception {

		double xCoordinate;
		double yCoordinate;
		double zCoordinate;
		double radius;
		int numCircles;
		double scale;
		int duplicateCirclesCount;
		int duplicateSpheresCount;
		
		File textFile = new File("circles.txt");
		Scanner fileReader = new Scanner(textFile);
		numCircles = Integer.parseInt(fileReader.nextLine());
		Circle[] circles = new Circle[numCircles]; // # of circles = # of spheres
		Sphere[] spheres = new Sphere[numCircles];
		double[] scales = new double[numCircles];
		Circle[] tempCircles = circles;
		Sphere[] tempSpheres = spheres;
		duplicateSpheresCount = 0;
		duplicateCirclesCount = 0;
		scale = 1.00;
		
		// In the input, we are first reading in the circles, 
		// so we input to the array the circles first.
		for (int x = 0; x < circles.length; x++){
			xCoordinate = Double.parseDouble(fileReader.nextLine());
			yCoordinate = Double.parseDouble(fileReader.nextLine());
			radius = Double.parseDouble(fileReader.nextLine());
			circles[x] = new Circle(xCoordinate, yCoordinate, radius);
		}
		// Reading in the spheres
		for (int x = 0; x < circles.length; x++){
			xCoordinate = Double.parseDouble(fileReader.nextLine());
			yCoordinate = Double.parseDouble(fileReader.nextLine());
			zCoordinate = Double.parseDouble(fileReader.nextLine());
			radius = Double.parseDouble(fileReader.nextLine());
			spheres[x] = new Sphere(xCoordinate, yCoordinate, zCoordinate, radius);
		}
		
		for (int x = 0; x < circles.length; x++	) { // get scales
			scales[x] = Double.parseDouble(fileReader.nextLine());
		}
		for (int x = 0; x < scales.length; x++) { // Getting scale #
			scale *= scales[x];
		}
		//printing circles...
		System.out.printf("\n=================\nprintCircles:(%d)\n=================\n", (numCircles*2));
		for (int x = 0; x < circles.length; x++) {
			printCircles(circles[x]);
		}
		for (int x = 0; x < circles.length; x++) {
			printCircles(spheres[x]);
		}
		// Print output includes opening parenthesis for simplicity
		System.out.printf("\n=================\nscaleAllCircles:\n=================\n(");
		// Printing the scales...
		for (int x = 0; x < scales.length; x++) {
			System.out.printf("%.2f ", scales[x]);
		}
		System.out.printf(")"); // Add the closing parenthesis after scales are printed
		// Scaling circles (Takes in each object and multiplies its radius)
		for (int x = 0; x < circles.length; x++) {
			scaleCircles(circles[x], scale);
		}
		for (int x = 0; x < circles.length; x++) {
			scaleCircles(spheres[x], scale);
		}
		// Printing the now scaled circles
		System.out.printf("\n\n=================\nprintCircles (%d)\n=================\n", (numCircles * 2));
		for (int x = 0; x < circles.length; x++) {
			printCircles(circles[x]);
		}
		for (int x = 0; x < circles.length; x++) {
			printCircles(spheres[x]);
		}
		// detectDupCircles goes here
		System.out.printf("\n\n=================\ndetectDupCircles:\n=================\n");
		duplicateCirclesCount = detectDupCircles(tempCircles);
		duplicateSpheresCount = detectDupCircles(tempSpheres);

		System.out.printf("Duplicate Circle: %d\n", duplicateCirclesCount);
		System.out.printf("Duplicate Sphere: %d\n", duplicateSpheresCount);
	}
}