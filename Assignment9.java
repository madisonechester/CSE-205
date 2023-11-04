// Assignment #: 9
//         Name: Madison Chester
//    StudentID: 1219358478
//      Lecture: MWF 10:10-11:00
//  Description: This program reads in a sequence of numbers from standard input until 0 is read, stores the numbers in an array, then finds the minimum number,
//               the sum of numbers at odd indexes, the sum of positive numbers, and the total count of negative numbers using recursion.

import java.io.*;
import java.text.DecimalFormat;

public class Assignment9
{
    public static void main(String[] args)
    {
       
    	try{ 
    	    System.setIn(new FileInputStream("./tests/input4.txt")); }
    	catch (IOException e) { 
    	    e.printStackTrace(); }
    	
    	// instantiate the array
        double[] numbers = new double[100];
        // index used for the array of numbers to be read
        int i = 0;
        // where to save one line of input
        String line;
        
        // Try-Catch block for input stream and buffered reader io exceptions
        try
        {
            // Create an input stream reader and buffered reader object
            // while or do-While loop to store all integers in the array until 0
            // read in the number as a string and parse to an integer and assign
            // it to array element
            // Continue iterating until 0 is entered
        	
        	InputStreamReader inputStream = new InputStreamReader(System.in);
        	BufferedReader bufferRead = new BufferedReader(inputStream);
        	line = bufferRead.readLine();
        	double input;
        	while (Double.parseDouble(line) != 0.0) {
        		numbers[i] = Double.parseDouble(line);
        		i++;
        		line = bufferRead.readLine();
        	}
        	
        } // end of try block
        // Catch an IO Exception and print out that it occurs
        catch (IOException ex)
        {
            System.out.println("IO Exception");
        }
        // Call recursive functions findMin, findSumAtOdd, findPositiveSum,
        // findNegative
        // Print out results in the required format
        
        DecimalFormat input1 = new DecimalFormat("0.00");
        String firstOutput = new String(input1.format(findMin(numbers, 0, i)));
        DecimalFormat input2 = new DecimalFormat("0.0##");
        String secondOutput = new String(input2.format(findSumAtOdd(numbers, 0, i)));
        DecimalFormat input3 = new DecimalFormat("0.#");
        String thirdOutput = new String(input3.format(findPositiveSum(numbers, 0, i)));
        DecimalFormat input4 = new DecimalFormat("0");
        String fourthOutput = new String(input4.format(findNegative(numbers, 0, i)));
        
        System.out.println("The minimum number is " + firstOutput);
        System.out.println("The sum of numbers at odd indexes is " + secondOutput);
        System.out.println("The sum of positive numbers is " + thirdOutput);
        System.out.println("The total count of negative numbers is " + fourthOutput);
        
    } // End main method
    // Recursive static method to find the smallest number in the array
    public static double findMin(double[] numbers, int startIndex, int endIndex)
    {
    	double min = 0;
    	if (startIndex == endIndex)
    		return numbers[startIndex];
    	else {
    		min = findMin(numbers, startIndex + 1, endIndex);
    		if (numbers[startIndex] <= min)
    			return numbers[startIndex];
    		else 
    			return min;
    	}
    }
    
    public static double findSumAtOdd(double[] numbers, int startIndex, int endIndex)
    {
        double sumOdd = 0;
        if (startIndex == endIndex) {
        	if (startIndex % 2 != 0)
        		return numbers[startIndex];
        	else 
        		return 0;
        }
        else {
        	sumOdd = findSumAtOdd(numbers, startIndex + 1, endIndex);
        	if (startIndex % 2 != 0)
        		return sumOdd += numbers[startIndex];
        	else 
        		return sumOdd;
        }
        		
    }
    // Recursive static method to find the sum of positive numbers in the array
    // between the indexes startIndex and endIndex (parameter)
    public static double findPositiveSum(double[] numbers, int startIndex, int endIndex)
    {
    	double positiveSum = 0;
        if (startIndex == endIndex) {
        	if (numbers[startIndex] > 0)
        		return numbers[startIndex];
        	else
        		return 0;
        }
        else {
        	positiveSum = findPositiveSum(numbers, startIndex + 1, endIndex);
        	if (numbers[startIndex] > 0)
        		return positiveSum += numbers[startIndex];
        	else 
        		return positiveSum;
        }
    }
    // Recursive static method to find how many negative numbers are between the
    // indexes startIndex and endIndex
    public static int findNegative(double[] numbers, int startIndex, int endIndex)
    {
    	int count = 0;
    	if (startIndex == endIndex) {
    		if (numbers[startIndex] < 0)
    			return 1;
    		else 
    			return 0;
    	}
        else {
        	count = findNegative(numbers, startIndex + 1, endIndex);
        	if (numbers[startIndex] < 0)
        		return count += 1;
        	else 
        		return count;
        }
    }
}// End Assignment9 class