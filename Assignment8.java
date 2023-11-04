// Assignment: ASU CSE205 - Assignment 8 
// Name: Madison Chester
// StudentID: 1219358478
// Lecture: MWF 10:00-11:00
// Description: The Assignment 8 class displays a menu of choices to a user and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is entered. 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Assignment8
{
    public static void main(String[] args)
    {
    	
    	try{ 
    	    System.setIn(new FileInputStream("./tests/input4.txt")); }
    	catch (IOException e) { 
    	    e.printStackTrace(); }
    	
        // Menu options
        char inputOpt = ' ';
        String inputLine = null;
        // Course and Instructor information
        String courseName = null, courseUniversity = null;
        String instrFirstName = null, instrLastName = null, instrOfficeNum = null;
        // Output information
        String outFilename = null, inFilename = null;
        String outMsg = null;
        //String inMsg = null;
        // Course manager
        CourseManagement courseManager = new CourseManagement();
        // Operation result
        // boolean opResult = false;

        try
        {
            printMenu();

            // create a BufferedReader object to read input from a keyboard
	    InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);

            do
            {
                System.out.print("\nWhat action would you like to perform?\n");
                inputLine = stdin.readLine().trim();
                if (inputLine.isEmpty())
                {
                    continue;
                }
                inputOpt = inputLine.charAt(0);
                inputOpt = Character.toUpperCase(inputOpt);

                switch (inputOpt) {

                case 'A': // Add a new Course
                    System.out.print("Please enter the course information:\n");
                    System.out.print("Enter the course name:\n");
                    courseName = stdin.readLine().trim();
                    System.out.print("Enter the university name:\n");
                    courseUniversity = stdin.readLine().trim();
                    System.out.print("Enter the instructor's first name:\n");
                    instrFirstName = stdin.readLine().trim();
                    System.out.print("Enter the instructor's last name\n");
                    instrLastName = stdin.readLine().trim();
                    System.out.print("Enter the instructor's office number:\n");
                    instrOfficeNum = stdin.readLine().trim();

/************************************************************************************
***  Complete the code by calling the addCourse method, and if the course is added successfully, show
"Course added\n" on screen, otherwise show "Course NOT added\n"
***********************************************************************************/
                   if (courseManager.addCourse(courseName, courseUniversity, instrFirstName, instrLastName, instrOfficeNum)) {
                	   System.out.print("Course added\n"); }
                   else 
                	   System.out.print("Course NOT added\n");

                    break;

                case 'C': // Create a new CourseManagement
                    courseManager = new CourseManagement();
                    break;

                case 'D': // Search a Course
                    System.out.print("Please enter the course name to search:\n");
                    courseName = stdin.readLine().trim();
                    System.out.print("Please enter the university name to search:\n");
                    courseUniversity = stdin.readLine().trim();
/************************************************************************************
***  Complete the code, if the course in the specific university is found
show course found, otherwise is not found
***********************************************************************************/
                    // search course list by courseName and courseUniversity
                    if (courseManager.courseExists(courseName, courseUniversity) != -1) {
                    	System.out.print(courseName + " at " + courseUniversity + " is found\n");
                    }
                    else {
                    	System.out.print(courseName + " at " + courseUniversity + " is NOT found\n");
                    }
                    
                    break;

                case 'E': // Search an instructor
                    System.out.print("Please enter the instructor's first name to search:\n");
                    instrFirstName = stdin.readLine().trim();
                    System.out.print("Please enter the instructor's last name to search:\n");
                    instrLastName = stdin.readLine().trim();
                    System.out.print("Please enter the instructor's office number to search:\n");
                    instrOfficeNum = stdin.readLine().trim();
/************************************************************************************
***  Complete the code, if the instructor is found print instructor's first name, last name,
and office number, otherwise print not found

***********************************************************************************/
                    if (courseManager.instructorExists(instrFirstName,instrLastName,instrOfficeNum) != -1) {
                    	System.out.print("Instructor: " + instrFirstName + " " + instrLastName + ", " + instrOfficeNum + " is found\n");
                    }
                    else { 
                    	System.out.print("Instructor: " + instrFirstName + " " + instrLastName + ", " + instrOfficeNum + " is NOT found\n");
                    }
                 
                    break;

                case 'L': // List courses
                    System.out.print("\n" + courseManager.listCourses() + "\n");
                    break;

                case 'N': // Sort by course names
/************************************************************************************
***  Complete the following code. Sort by course names in alphabetical order
***********************************************************************************/
                 
                	courseManager.sortByCourseName();
                    System.out.print("sorted by course names\n");
                    break;

                case 'P': // Sort by instructor names
                    courseManager.sortByCourseInstructor();
                    System.out.print("sorted by current instructor names\n");
                    break;

                case 'Q': // Quit
                    break;

                case 'R': // Remove a course
                    System.out.print("Please enter the course name to remove:\n");
                    courseName = stdin.readLine().trim();
                    System.out.print("Please enter the university name to remove:\n");
                    courseUniversity = stdin.readLine().trim();
/************************************************************************************
***  Complete the code, if the course with above name and university is found
remove it. Show the relevant info. accordingly.
***********************************************************************************/
                    
                    if (courseManager.courseExists(courseName,courseUniversity) != -1) {
                    	courseManager.removeCourse(courseName,courseUniversity);
                    	System.out.print(courseName + " at " + courseUniversity + " is removed\n"); }
                    else { 
                    	System.out.print(courseName + " at " + courseUniversity + " is NOT removed\n");
                    }
                    	
                    break;

                case 'T': // Close CourseManagement
                    courseManager.closeCourseManagement();
                    System.out.print("Course management system closed\n");
                    break;

                case 'U': // Write strings to a text file
                    System.out.print("Please enter a file name that we will write to:\n");
                    outFilename = stdin.readLine().trim();
                    System.out.print("Please enter a string to write inside the file:\n");
                    outMsg = stdin.readLine().trim();
/************************************************************************************
***  Complete the following statement, write above string inside the relevant file
***********************************************************************************/
                    try
                    {
                        outMsg += "\n";
                        FileWriter fileWrite = new FileWriter(outFilename);
                        BufferedWriter writer = new BufferedWriter(fileWrite);
                        PrintWriter out = new PrintWriter(writer);
                        out.print(outMsg);
                        writer.close();
                        out.close();
                        System.out.print(outFilename + " is written\n");
                    }
                    catch (IOException e)
                    {
                        System.out.print("Write string inside the file error\n");
                    }
                    break;

                case 'V': // Read strings from a text file
                    System.out.print("Please enter a file name which we will read from:\n");
                    inFilename = stdin.readLine().trim();
/************************************************************************************
***  Complete the code, read from above text file
***********************************************************************************/
                    try
                    {
                    	FileReader fileRead = new FileReader(inFilename);
                    	BufferedReader fileToRead = new BufferedReader(fileRead);
                    	String firstLine = new String(fileToRead.readLine());
                    	System.out.print(inFilename + " was read\n");
                    	System.out.print("The first line of the file is:\n" + firstLine + "\n");
                    	fileToRead.close();
                    }
                    catch (FileNotFoundException e)
                    {
                        System.out.print(inFilename + " was not found\n");
                    }
                    catch (IOException e)
                    {
                        System.out.print("Read string from the file error\n");
                    }
                    break;

                case 'W': // Serialize CourseManagement to a data file
                    System.out.print("Please enter a file name to write:\n");
                    outFilename = stdin.readLine().trim();
/************************************************************************************
***  Complete the code, write object courseManage1 inside the data file
***********************************************************************************/
                    try
                    {
                    	FileOutputStream fileWrite = new FileOutputStream(outFilename);
                    	ObjectOutputStream objOut = new ObjectOutputStream(fileWrite);
                    	objOut.writeObject(courseManager);
                    	objOut.close();
                    }
                    catch (NotSerializableException e)
                    {
                        System.out.print("Not serializable exception\n");
                    }
                    catch (IOException e)
                    {
                        System.out.print("Data file written exception\n");
                    }
                    break;

              
  	      case 'X': // Deserialize CourseManagement from a data file
                    System.out.print("Please enter a file name which we will read from:\n");
                    inFilename = stdin.readLine().trim();
/************************************************************************************
***  Complete the following statement, read object from the data file and save the object
as courseManager
***********************************************************************************/
                    
                    try
                    {
                    	FileInputStream fileInput = new FileInputStream(inFilename);
                    	ObjectInputStream objInput = new ObjectInputStream(fileInput);
                    	courseManager = (CourseManagement)objInput.readObject();
                    	System.out.print(inFilename + " was read\n"); 
                    	objInput.close();
                    }
                    catch (ClassNotFoundException e)
                    {
                        System.out.print("Class not found exception\n");
                    }
                    catch (NotSerializableException e)
                    {
                        System.out.print("Not serializable exception\n");
                    }
                    catch (IOException e)
                    {
                    	e.printStackTrace();
                        System.out.print("Data file read exception\n");
                    }
                    
                    break;

                case '?': // Display help
                    printMenu();
                    break;

                default:
                    System.out.print("Unknown action\n");
                    break;
                }

            } while (inputOpt != 'Q' || inputLine.length() != 1);
        }
        catch (IOException exception)
        {
            System.out.print("IO Exception\n");
        }
    }

    public static void printMenu()
    {
        System.out.print("Choice\t\tAction\n" + "------\t\t------\n" + "A\t\tAdd a course\n"
                + "C\t\tCreate a CourseManagement\n" + "D\t\tSearch a course\n" + "E\t\tSearch an instructor\n"
                + "L\t\tList courses\n" + "N\t\tSort by course names\n" + "P\t\tSort by current instructor name\n"
                + "Q\t\tQuit\n" + "R\t\tRemove a course\n" + "T\t\tClose CourseManagement\n"
                + "U\t\tWrite strings to a text file\n" + "V\t\tRead strings from a text file\n"
                + "W\t\tSerialize CourseManagement to a data file\n"
                + "X\t\tDeserialize CourseManagement from a data file\n" + "?\t\tDisplay Help\n");
    }
    
}
