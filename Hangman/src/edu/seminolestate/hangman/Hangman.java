// Written by Toni Huffman
// 1/26/2017

package edu.seminolestate.hangman;
import java.util.Random;

public class Hangman {
	
	// Dictionary of words
	private final String[] dictionary = {
			"trouble", "copyright", "problem", "form", "problem", "mythical", "discover",
			"consume", "document", "flame", "flow", "chart", "magnetic", "working",
			"predict", "subordinate", "making", "copy", "troublemaking",
			"uncopyrighted", "unmaledictory", "unpredictably"
			};
	
	// Variables for guesses
	private final int NUMBER_WRONG_GUESSES_ALLOWED = 7;
	private int numberOfIncorrectGuesses;
	private int numberOfCorrectGuesses;
	private char[] incorrectLettersGuessed = new char[NUMBER_WRONG_GUESSES_ALLOWED];
	
	// Variables for the mystery word
	private String mysteryWord;
	private StringBuilder mysteryWordWithDashes;
	
	// Constructor
	public Hangman() {
		// Reset guesses
		numberOfCorrectGuesses = 0;
		numberOfIncorrectGuesses = 0;
		
		// Choose random word from dictionary
		int dictionaryIndex = new Random().nextInt(dictionary.length);
		mysteryWord = dictionary[dictionaryIndex];
		
		// Generate mystery word with dashes
		mysteryWordWithDashes = new StringBuilder(mysteryWord);
		for (int i = 0; i < mysteryWord.length(); i++) {
			mysteryWordWithDashes.setCharAt(i, '-');
		}		 
	}
	
	// Guess-related getters
	public String getIncorrectLetters() {
		return new String(incorrectLettersGuessed);
	}
	
	public int getNumberOfGuessesLeft() {
		return NUMBER_WRONG_GUESSES_ALLOWED - numberOfIncorrectGuesses;
	}
	
	// Word-related getters
	public String getMysteryWord() {
		return mysteryWord;
	}
	
	public String getMysteryWordWithDashes() {
		return mysteryWordWithDashes.toString();
	}
	
	
	// Is the guessed letter correct?
	public boolean isCorrectLetter(char letter) {
		char[] correctLetters = mysteryWord.toCharArray();
		// Step through the array, letter by letter
		for (int i = 0; i< correctLetters.length; i++ ) {
			// If the guessed letter matches a correct letter
			if (letter == correctLetters[i]) {
				// Only take action if letter hasn't already been guessed
				if (mysteryWordWithDashes.charAt(i) == '-') {
					mysteryWordWithDashes.setCharAt(i, letter);
					numberOfCorrectGuesses++;
				}
				return true;
			}
		}	
		// If the letter isn't correct, add to array and increment guesses
		incorrectLettersGuessed[numberOfIncorrectGuesses] = letter;
		numberOfIncorrectGuesses++;
		return false;
	}
	
	// Is the guessed word correct?
	public boolean isCorrectWord(String word) {
		if (word.toLowerCase().equals(mysteryWord)) {
			return true;
		} else {
			return false;
		}
	}
	
	// Has the player won?
	public boolean isWinner() {
		if (numberOfCorrectGuesses == mysteryWord.length()) {
			return true;
		} else {
			return false;
		}
	}
	
}
