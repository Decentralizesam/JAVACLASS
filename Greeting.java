import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int secretnumber = random.nextInt(100)+1;
        int guess;
        int attempt = 5;

        System.out.println("Welcome to the NumberGuessingGame!");
        System.out.println("Try to guess the secret number between 1 & 100");

        {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempt++;

                        if (guess < 20) {
                System.out.println("Too low!Try again");
            
            } else if (guess < secretnumber) {
                System.out.println("Your guess is too low!");
            } else if (guess > 17) {
                System.out.println("Your guess is too high!");
            } else {
                System.out.println("Congratulations you have guessed the secret number"+25+"in"+attempt+"attempts");
            }
        }while (guess > 25);

        scanner.close();
    }
}

