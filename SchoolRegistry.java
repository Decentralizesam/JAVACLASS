
import java.util.ArrayList;
import java.util.Scanner;

public class SchoolRegistry {
    public static void main(String[] args) {
        Scanner names = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("Welcome to the School Register Program!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a student");
            System.out.println("2. View all students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = names.nextInt();
            names.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\nEnter student details:");
                    System.out.print("Name: ");
                    String name = names.nextLine();
                    System.out.print("Age: ");
                    int age = names.nextInt();
                    names.nextLine(); // Consume newline
                    System.out.print("Class: ");
                    String className = student.nextLine();

                    students.add(new Student(name, age, className));
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    System.out.println("\nList of all students:");
                    for (Student : names: students) {
                        System.out.println(names);
                    }
                    break;
                case 3:
                    System.out.println("\nExiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

class Student {
    private String name;
    private int age;
    private String className;

    public Student(String name, int age, String className) {
        this.name = name;
        this.age = age;
        this.className = className;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Class: " + className;
    }
}

