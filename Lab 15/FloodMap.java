import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JFileChooser;


/***************************
 * FloodMap.java - working with 2D Arrays and files
 * @author Deyonta Robinson
 * Lab: Lab 15
 * Date: 4/23/2013
 * Course: CSCI 140 & CSCI 140L
 **************************/

public class FloodMap {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1.Declare variables
		String fileName = "";
		double smallest = 0.0;
		double largest = 0.0;
		double [] [] terrainHeight = new double [10] [10];
		double increment = 0.0;
		/*
		if(args.length != 1 )
		{
			System.out.println("No args privided....");
			System.out.println("usage: Flood Map [fileName]");
			System.out.println("Shutting Down.......");
			System.exit(3);
		}*/
		
		//2.Load the data into the array
		terrainHeight = loadData(terrainHeight, fileName);
		
		//3.Find the smallest value in the array
		smallest = findSmallest(largest, terrainHeight);
		System.out.println("The smallest value is: " + smallest);
		
		
		//4.Find the largest value in the array
		largest = findLargest(largest, terrainHeight);
		System.out.println("The largest value is: " + largest);
		
		//5.Simulate the flood
		simulateFlood(terrainHeight, increment, smallest, largest);
		
		/*****
		 * declare variables
		 *	*double level = smallest
		 * loop 10 times
		 * for(integer count = 0; count < 10; count++){
		 *	display Floodmap with level
		 *		*displayFloodMap(array,level)
		 *	update my level
		 *		*level = level +increment
		 * }
		 ****/

	}//end of Main

	

	public static double [][] loadData(double [] [] terrainHeight, String fileName){
		Scanner keyboard = new Scanner(System.in);
		File inputFile = new File("map321.dat");
		int row = 0;
		int col = 0;
		double height = 0.0;
		
		
		try {
			Scanner in = new Scanner(inputFile);
			
			while(in.hasNext())
			{
				height = in.nextDouble();
				if (col < 10)
				{
					terrainHeight[row][col] = height;
				
				}
				else
				{
					row++;
					col = 0;
					terrainHeight[row][col] = height;
				}
				col++;
				//stem.out.println("This is in load array" + terrainHeight[row][col]);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return terrainHeight;
	}		

	public static double findSmallest(double smallest, double [] [] terrainHeight){
		
		smallest = terrainHeight[0][0];
		
		for(int row = 0; row < 10; row++)
		{
			for(int col = 0; col < 10; col++)
			{
				smallest = Math.min( terrainHeight[row][col], smallest);
			}
		}
		
		return smallest;		
	}
	
	public static double findLargest(double largest, double [] [] terrainHeight){
		
		largest = terrainHeight[1][1];
		
		for(int row = 0; row < 10; row++)
		{
			for(int col = 0; col < 10; col++)
			{
				largest = Math.max(terrainHeight[row][col], largest);				
			}
		}
		
		return largest;
	}
	
	public static void simulateFlood(double[][] terrainHeight, double increment, double smallest, double largest){
		
		//1.Declare variables
		increment = 3.0;
		double level = smallest;
		
		
		//2.loop 10 times
		for(int count = 0; count < 10; count++){
			
		
			//2a. displayFloodMap with level
			displayFloodMap(terrainHeight,level);
			System.out.println();
			
			//2b. Update my level
			level = level + increment;
		}
	}
	
	public static void displayFloodMap(double [] [] terrainHeight, double level) {
		
		System.out.println("Printing with water level: " + level);
		
		for(int row = 0; row < 10; row++)
		{
			for(int col = 0; col < 10; col++)
			{
				if(terrainHeight[row][col] <= level)
				{
					System.out.print("*");
				}
				else
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
}//end of FloodMap
