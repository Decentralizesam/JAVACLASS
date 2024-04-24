import java.util.Scanner;
public class Insert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the student:");
        String name = scanner.next();
        System.out.println("Enter the marks of the student:");
        int marks = scanner.nextInt();
        scanner.close();
        System.out.println("The name of the student is: " + name);
        System.out.println("The marks of the student is: " + marks);
    }
}
