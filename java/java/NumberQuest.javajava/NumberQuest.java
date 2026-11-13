
import java.util.Random;
import java.util.Scanner;

public class NumberQuest {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        String playAgain;

        System.out.println("================================");
        System.out.println("       WELCOME TO NUMBER QUEST");
        System.out.println("================================");

        do {

            int secretNumber = random.nextInt(100) + 1;
            int guess = 0;
            int attempts = 0;

            System.out.println("\nGuess the number from 1 to 100!");

            while (guess != secretNumber) {

                System.out.print("Enter your guess: ");

                if (!input.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number.");
                    input.next();
                    continue;
                }

                guess = input.nextInt();
                attempts++;

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                }
                else if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                }
                else if (guess > secretNumber) {
                    System.out.println("Too high! Try again.");
                }
                else {
                    System.out.println("\nCongratulations! You guessed it!");
                    System.out.println("Number of attempts: " + attempts);

                    int points = Math.max(0, 100 - (attempts - 1) * 5);
                    score += points;

                    System.out.println("Points earned: " + points);
                    System.out.println("Total score: " + score);
                }
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            playAgain = input.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\n================================");
        System.out.println("          GAME OVER");
        System.out.println("================================");
        System.out.println("Your final score is: " + score);
        System.out.println("Thank you for playing Number Quest!");

        input.close();
    }
}
