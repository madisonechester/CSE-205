// Assignment #: 1
//         Name: Madison Chester
//    StudentID: 1219358478
//      Lecture: 10:10-11:00
//  Description: This class reads an integer from a keyboard and prints it out
//               along with other messages.

import java.util.Scanner; //// use the Scanner class located in the "java.util" directory
import java.io.FileInputStream;
import java.io.IOException; 

public class Assignment1
 {
  public static void main (String[] args)
   {
	  try{
	      System.setIn(new FileInputStream("./tests/input1.txt"));
	  }catch(IOException e){
	       e.printStackTrace();
	     }
	  
     int number;

     Scanner console = new Scanner(System.in);

     number = console.nextInt();     // read an integer entered by a user
     

     // display the number with other messages
	     System.out.print("This program reads an integer from a keyboard\n"
	                    + "and prints it out on the display screen.\n"
	                    + "Make sure that you get the exact same output as the expected one.\n"
                   + "The read number is: " + number + "\n");
   }
 }


