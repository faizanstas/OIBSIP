import java.util.Random;
import javax.swing.JOptionPane;

public class OASIS_NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        
        int maxNumber = 100;
        int secretNumber = random.nextInt(maxNumber) + 1;
        int maxGuesses = 10;
        int guesses = 0;
        int score = 0;
        boolean playAgain = true;
        
        JOptionPane.showMessageDialog(null, "Welcome to the Guess the Number game!");
        
        while (playAgain) {
            guesses = 0;
            
            while (guesses < maxGuesses) {
                String guessString = JOptionPane.showInputDialog(null, "Guess a number between 1 and " + maxNumber + " (" + (maxGuesses - guesses) + " guesses left):");
                
                if (guessString == null) {
                  JOptionPane.showMessageDialog(null, "Game cancelled.");
                    playAgain = false;
                    break;
                }
                
                int guess = Integer.parseInt(guessString);
                
                if (guess < 1 || guess > maxNumber) {
                    JOptionPane.showMessageDialog(null, "Invalid guess. Please enter a number between 1 and " + maxNumber + ".");
                } else {
                    guesses++;
                    
                    if (guess < secretNumber) {
                        JOptionPane.showMessageDialog(null, "Too low! Guess again.");
                    } else if (guess > secretNumber) {
                        JOptionPane.showMessageDialog(null, "Too high! Guess again.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Congratulations! You guessed the secret number in " + guesses + " guesses!");
                        score += maxGuesses - guesses + 1;
                        break;
                    }
                }
            }
            
            if (guesses == maxGuesses) {
                JOptionPane.showMessageDialog(null, "Sorry, you ran out of guesses. The secret number was " + secretNumber + ".");
            }
            
            int option = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play again?", JOptionPane.YES_NO_OPTION);
            playAgain = (option == JOptionPane.YES_OPTION);
            
            if (!playAgain) {
                JOptionPane.showMessageDialog(null, "Your final score is " + score + " points. Thanks for playing!");
            } else {
                secretNumber = random.nextInt(maxNumber) + 1;
            }
        }
    }
}
