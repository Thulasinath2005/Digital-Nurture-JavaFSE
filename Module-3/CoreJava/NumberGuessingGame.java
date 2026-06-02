import java.util.Random;
import java.util.Scanner;

// Exercise 10: Number Guessing Game
public class NumberGuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int secret = rand.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        int attempts = 0;

        System.out.println("I have picked a number between 1 and 100. Try to guess it!");

        while (true) {
            System.out.print("Your guess: ");
            int guess = sc.nextInt();
            attempts++;

            if      (guess < secret) System.out.println("Too low! Try higher.");
            else if (guess > secret) System.out.println("Too high! Try lower.");
            else {
                System.out.println("🎉 Correct! The number was " + secret + ". You got it in " + attempts + " attempts.");
                break;
            }
        }
        sc.close();
    }
}
