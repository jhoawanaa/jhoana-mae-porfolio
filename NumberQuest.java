import java.util.Random;
import java.util.Scanner;

public class NumberQuest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        String playAgain;

        System.out.println("=== NUMBER QUEST ===");

        do {
            int secret = random.nextInt(100) + 1;
            int guess = 0;
            int attempts = 0;

            System.out.println("\nGuess the number from 1 to 100!");

            while (guess != secret) {
                System.out.print("Enter your guess: ");

                if (!input.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    input.next();
                    continue;
                }

                guess = input.nextInt();
                attempts++;

                if (guess < secret) {
                    System.out.println("Too low! Try again.");
                } else if (guess > secret) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Correct! You win!");
                    score += 100 - attempts;
                    System.out.println("Attempts: " + attempts);
                    System.out.println("Score: " + score);
                }
            }

            System.out.print("\nPlay again? (yes/no): ");
            playAgain = input.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Final Score: " + score);
        System.out.println("Thank you for playing!");
        input.close();
    }
}