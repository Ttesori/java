// Written by Toni Huffman
// 1/26/2017

package edu.seminolestate.hangman;
import edu.seminolestate.hangman.Hangman;
import java.util.Scanner;

public class HangmanApplication {

	public static void main(String[] args) {
		// Initialize game
		System.out.println("Welcome to HANGMAN!");
		System.out.println("===================");
		Hangman hangman = new Hangman();
		Scanner input = new Scanner(System.in);
		int option = 0;
		
		// Print initial board
		System.out.print("Mystery word: ");
		System.out.println(hangman.getMysteryWordWithDashes());
		
		while (option != 3) {
			// Print main menu
			System.out.println();
			System.out.println("Choose an option.");
			System.out.println("1. Guess a letter");
			System.out.println("2. Guess the word");
			System.out.println("3. Quit");
			option = input.nextInt();
			
			// If the player chooses to guess a letter
			if (option == 1) {
				System.out.print("Enter a letter: ");
				char guess = input.next().charAt(0);
				
				// Check to see if letter is correct
				System.out.println();
				if (hangman.isCorrectLetter(guess)) {
					System.out.println("You guessed correctly!");
				} else {
					System.out.println("Sorry, that letter is not in the word.");
				}
				
				// Check to see if the player won
				if (hangman.isWinner()) {
					System.out.println();
					System.out.println("Congratulations, you won!");
					System.out.println("The correct word was " + hangman.getMysteryWord());
					System.out.println("Starting new game...");
					hangman = new Hangman();
				} else if (hangman.getNumberOfGuessesLeft() > 0 ) {
					// If the player didn't win but has guesses left
					System.out.println("You have " + hangman.getNumberOfGuessesLeft() + " guess(es) left.");
					System.out.println("Incorrect guesses: " + hangman.getIncorrectLetters());
					System.out.print("Mystery word: ");
					System.out.println(hangman.getMysteryWordWithDashes());
				} else {
					// The player loses
					System.out.println("Sorry, you lose!");
					System.out.println("The correct word was: " + hangman.getMysteryWord());
					System.out.println();
					System.out.println("Starting new game...");
					hangman = new Hangman();
				}
			} else if (option == 2) {
				// The player guesses a whole word
				System.out.print("Enter the word you'd like to guess: ");
				String guess = input.next();
				System.out.println();
				
				// Check the player's guess
				if (hangman.isCorrectWord(guess)) {
					// The player guessed correctly
					System.out.println("Congratulations, you won!");
					System.out.println("The correct word was " + hangman.getMysteryWord());
					System.out.println("Starting new game...");
					hangman = new Hangman();
				} else {
					// The player guessed incorrectly
					System.out.println("Sorry, that word is not correct.");
					System.out.println("You have " + hangman.getNumberOfGuessesLeft() + " guess(es) left.");
					System.out.println("Incorrect guesses: " + hangman.getIncorrectLetters());
					System.out.print("Mystery word: ");
					System.out.println(hangman.getMysteryWordWithDashes());
				}
			}
		}
		// The user has pressed the quit key
		System.out.println("Goodbye! Thanks for playing...");
	}

}
