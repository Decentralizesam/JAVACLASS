import java.util.Scanner;

public class StudentProgram {
   
  // Manin Driver Method 
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);

        // Create an array to store student objects
        Student[] students = new Student[4];

        // Input details for each student
        for (int i = 0; i < 4; i++) {
            System.out.println("Enter name of student " + (i+1) + ":");
            String name = obj.nextLine();

            System.out.println("Enter class of student " + (i+1) + ":");
            String studentClass = obj.nextLine();

            // Create a student object with input details
            students[i] = new Student(name, studentClass);
        }

        // Output details of each student
        System.out.println("Students Details:");
        for (int i = 0; i < 4; i++) {
            System.out.println("Student " + (i+1) + ": " + students[i]);
        }
    }
}

///Fields 
class Student {
    private String name;
    private String studentClass;

    // Constructor
    public Student(String name, String studentClass) {
        this.name = name;
        this.studentClass = studentClass;
    }

    // toString method to represent the object as a string
    @Override
    public String toString() {
        return "Name: " + name + ", Class: " + studentClass;
    }
}

//PROCEDURES OF HOW THE CODE WAS WRITTEN:

//import scanner to allow user to insert in name & age 
//class name should Corresponding to the file name 
//then put in the entry point where the code starts to execute
//add in scanner 
//Create an array to store student Objects
//use forloop to input the student details 
// create a student object with input details
// input details for each student
//create new of both name & student class
//create construtors with parameters
// then tostring method to represent the object a string


//Inheritance
//Make it Dynamic 
//File handling
//Method that write to afile 
//Method to Display 
//Exceptions
// Interfaces
//Graphical work
//Jframework
//Title for the project
//One project with many Applications
//User has to insert as many students as they want
//Use GUI
//Multithreading



/// THE END!!





