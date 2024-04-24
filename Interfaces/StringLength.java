import java.util.Scanner;

public class StringLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of the string:");
        int length = scanner.nextInt();
        scanner.close();
        
        System.out.println("The length of the string is: " + length);
    }
}
