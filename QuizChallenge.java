import java.util.Scanner;

public class QuizChallenge {
    private static final Scanner input = new Scanner(System.in);

    private static final String[] QUESTIONS = {
        "Which language is commonly used to create Android apps?",
        "What does CPU stand for?",
        "Which one is used to style a web page?",
        "Which symbol ends most Java statements?",
        "Which data type stores true or false?"
    };

    private static final String[][] OPTIONS = {
        {"A. Java", "B. HTML", "C. CSS", "D. SQL"},
        {"A. Central Program Utility", "B. Central Processing Unit",
         "C. Computer Personal Unit", "D. Control Processing User"},
        {"A. Java", "B. Python", "C. CSS", "D. SQL"},
        {"A. :", "B. ,", "C. .", "D. ;"},
        {"A. int", "B. String", "C. boolean", "D. double"}
    };

    private static final char[] ANSWERS = {'A', 'B', 'C', 'D', 'C'};

    public static void main(String[] args) {
        System.out.println("================================");
        System.out.println("         QUIZ CHALLENGE");
        System.out.println("================================");
        System.out.println("Answer the 5 questions.");
        System.out.println("Type A, B, C, or D.");

        boolean playAgain = true;
        while (playAgain) {
            runQuiz();
            playAgain = askToPlayAgain();
        }

        System.out.println("\\nThank you for playing Quiz Challenge!");
        input.close();
    }

    private static void runQuiz() {
        int score = 0;

        for (int i = 0; i < QUESTIONS.length; i++) {
            System.out.println("\\nQuestion " + (i + 1) + ": " + QUESTIONS[i]);
            for (String option : OPTIONS[i]) {
                System.out.println(option);
            }

            char answer = getAnswer();
            if (answer == ANSWERS[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is "
                        + ANSWERS[i] + ".");
            }
        }

        showResult(score);
    }

    private static char getAnswer() {
        while (true) {
            System.out.print("Your answer: ");
            String response = input.nextLine().trim().toUpperCase();

            if (response.length() == 1
                    && response.charAt(0) >= 'A'
                    && response.charAt(0) <= 'D') {
                return response.charAt(0);
            }

            System.out.println("Invalid input. Please enter A, B, C, or D.");
        }
    }

    private static void showResult(int score) {
        System.out.println("\\n========== QUIZ RESULT ==========");
        System.out.println("Your score: " + score + " out of " + QUESTIONS.length);

        if (score == QUESTIONS.length) {
            System.out.println("Excellent! Perfect score!");
        } else if (score >= 3) {
            System.out.println("Good job! Keep learning!");
        } else {
            System.out.println("Keep practicing. You can do better!");
        }
    }

    private static boolean askToPlayAgain() {
        while (true) {
            System.out.print("\\nTry the quiz again? (yes/no): ");
            String answer = input.nextLine().trim().toLowerCase();

            if (answer.equals("yes") || answer.equals("y")) {
                return true;
            }
            if (answer.equals("no") || answer.equals("n")) {
                return false;
            }

            System.out.println("Please enter yes or no.");
        }
    }
}
