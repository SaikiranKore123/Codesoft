import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int numberOfAttempts = 10;
        int round = 1;
        int score = 0;

        // Welcome message
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange + ".");

        while (true) {
            // Start a new round
            System.out.println("===== Round " + round + " =====");
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            while (attempts < numberOfAttempts) {
                // Prompt for user input
                System.out.print("Enter your guess (between " + minRange + " and " + maxRange + "): ");

                // Input validation for non-integer input
                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid integer.");
                    scanner.nextLine(); // Consume invalid input
                    continue;
                }

                int userGuess = scanner.nextInt();

                // Input validation for out-of-range guesses
                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Please enter a number within the specified range.");
                    continue;
                }

                attempts++;

                if (userGuess == targetNumber) {
                    // Correct guess
                    System.out.println("Congratulations! You guessed it right in " + attempts + " attempts.");
                    score++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Try a higher number.");
                } else {
                    System.out.println("Try a lower number.");
                }

                if (attempts == numberOfAttempts) {
                    // Out of attempts
                    System.out.println("Sorry, out of attempts. The correct number was: " + targetNumber);
                }
            }

            // Update and print the score
            System.out.println("Your score after round " + round + " is: " + score);

            // Ask if the user wants to play another round and keep asking until valid input is provided
            while (true) 
            {
               System.out.print("Do you want to play another round? (yes/no): ");
               String playAgain = scanner.next().toLowerCase();

               if (playAgain.equals("yes"))
                {
                  break; // Exit the loop if the user wants to play another round
                } else if (playAgain.equals("no"))
                 {
               // End the game if the user doesn't want to play again
                  System.out.println("Thank you for playing! Your final score is: " + score);
                  scanner.close();
                  System.exit(0); // Exit the program
                 } 
                 else
                  {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                  }
            } 
     round++;
        }
    }
}
