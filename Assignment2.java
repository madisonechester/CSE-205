// Assignment #: 2
//         Name: Madison Chester
//    StudentID: 1219358478
//      Lecture: 10:10-11:00 
//  Description: Reads in an unspecified number of integers from standard input, performs some calculations on the inputted numbers, 
//					and outputs the results of those calculations to standard output.

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class Assignment2
 {
	
	public static void main(String[] args) { 
		
		try{
			System.setIn(new FileInputStream("./tests/input1.txt"));
			}catch(IOException e){
				e.printStackTrace();
		}
		
		int value;
		
		//public Assignment2() {
			//value = 0;
		//}
		
		int minInt = 0;
	    int largOddInt = 0;
	    int numbNegInt = 0;
	    int sumEvenInt = 0;
	
	    Scanner scan = new Scanner (System.in); 
	    value = scan.nextInt();
	    minInt = value;
        
	    while (value != 0) {
	    	if (value < minInt) {
	      	  minInt = value; }
	        if (value % 2 != 0 && value > largOddInt) {
	      	  largOddInt = value; }
	        if (value < 0) {
	      	  numbNegInt++; }
	        if (value % 2 == 0) {
	       	  sumEvenInt = sumEvenInt + value; } 
	        value = scan.nextInt();
	    } 
	
	    System.out.println("The minimum integer is " + minInt);
        System.out.println("The largest odd integer in the sequence is " + largOddInt);
        System.out.println("The count of negative integers in the sequence is " + numbNegInt);
        System.out.println("The sum of even integers is " + sumEvenInt); 
        
    }  
 }
	  
