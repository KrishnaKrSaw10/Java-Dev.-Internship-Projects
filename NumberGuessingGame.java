import java.util.Random;
import java.util.Scanner;

/**
 * A classic number guessing game where the user tries to guess a random number.
 * This program includes features like limiting attempts, playing multiple rounds, and scoring.
 */
public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int totalRounds = 0;
        int roundsWon = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        // Loop to allow for multiple rounds of the game
        while (playAgain) {
            int lowerBound = 1;
            int upperBound = 100;
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            int maxAttempts = 10;
            boolean hasGuessedCorrectly = false;
            
            totalRounds++;
            System.out.printf("\nRound %d: I've generated a number between %d and %d. You have %d attempts.%n",
                              totalRounds, lowerBound, upperBound, maxAttempts);

            // Loop for a single round of the game
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                
                try {
                    int userGuess = scanner.nextInt();
                    attempts++;
                    
                    if (userGuess == numberToGuess) {
                        System.out.printf("Congratulations! You guessed the number %d correctly in %d attempts.%n", 
                                          numberToGuess, attempts);
                        roundsWon++;
                        hasGuessedCorrectly = true;
                        break;
                    } else if (userGuess > numberToGuess) {
                        System.out.printf("Too high! You have %d attempts remaining.%n", maxAttempts - attempts);
                    } else {
                        System.out.printf("Too low! You have %d attempts remaining.%n", maxAttempts - attempts);
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear the invalid input
                }
            }
            
            if (!hasGuessedCorrectly) {
                System.out.printf("Sorry, you've run out of attempts. The number was %d.%n", numberToGuess);
            }
            
            // Ask the user if they want to play another round
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            if (!playAgainInput.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }
        
        // Display the final score
        System.out.printf("\n--- Game Over ---\nTotal rounds played: %d\nRounds won: %d\n", totalRounds, roundsWon);
        
        scanner.close();
    }
}
