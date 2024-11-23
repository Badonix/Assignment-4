
/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

import java.awt.*;
import java.util.ArrayList;

public class Hangman extends ConsoleProgram {

	private static final int GUESSES = 8;
	public static final int APPLICATION_HEIGHT = 700;

	private static HangmanLexicon lexicon = new HangmanLexicon();
	private static RandomGenerator rgen = RandomGenerator.getInstance();

	private static String word; // The word user has to guess
	private static StringBuilder userGuess = new StringBuilder(); // Users guess (--f-z-e)
	private static ArrayList<Character> guessedLetters = new ArrayList<>(); // ArrayList containing letters user tried

	private static int guessesLeft = GUESSES;
	private static boolean hasWon = false;

	// Canvas to draw man and guesses graphically
	private static HangmanCanvas canvas = new HangmanCanvas();
	
	public void init() {
		add(canvas);
	}

	public void run() {
		initGame();
		while (true) {
			play();
			if (hasWon || guessesLeft == 0) {
				break;
			}
		}
		if (guessesLeft == 0) {
			handleLoss();
		}
	}

	private void play() {
		char currentGuess = readUserInput();
		
		// We need to get valid input (single character, alphabetic)
		while (!validateInput(currentGuess)) {
			currentGuess = readUserInput();
		}
		
		// Checking if letter is is word
		tryLetter(currentGuess);
		
		// Checking if user won
		if (userGuess.toString().equals(word)) {
			handleWin();
			return;
		}
		
		// Printing user's stats/state
		printCurrentState();
	}
	
	private void printCurrentState(){
		println("The word now looks like this: " + userGuess);
		println("You have " + guessesLeft + " guesses left");
	}

	private void handleWin() {
		hasWon = true; // It stops game loop
		println("You guessed the word: " + word);
		println("You win.");
	}

	private void handleLoss() {
		println("You are completly hung.");
		println("The word was: " + word);
		println("You lose.");
	}

	private void tryLetter(char guess) {
		// indexOf returns -1 if there is no such character in word,if it doesn't return -1 then it INCLUDES that letter
		if (word.indexOf(Character.toUpperCase(guess)) != -1) {
			println("That guess is correct");
			// Update userGuess string
			fillTheWord(guess);
		} else {
			println("There are no " + guess + "'s in the word");
			canvas.noteIncorrectGuess(Character.toUpperCase(guess));
			guessesLeft--;
		}
	}

	// Updates userGuess
	private void fillTheWord(char guess) {
		// Iterating over the word
		for (int i = 0; i < word.length(); i++) {
			// If current letter of word == user's guess then replace hyphen with letter
			if (word.charAt(i) == Character.toUpperCase(guess)) {
				userGuess.setCharAt(i, Character.toUpperCase(guess));
			}
		}
		
		// Update the userGuess on canvas
		canvas.displayWord(userGuess.toString());
	}

	
	// Validating input so that user can only enter unused alphabetic character
	private boolean validateInput(char input) {
		// If it already used (is in the list of guessedLetters) then print message and return
		if (guessedLetters.contains(Character.toUpperCase(input))) {
			println("Letter is already used");
			return false;
		}
		
		// Checking if its valid letter
		if (!Character.isLetter(input)) {
			println("Letter is not valid");
			return false;
		}
		
		// Adding to guessedLetters list
		guessedLetters.add(Character.toUpperCase(input));
		return true;
	}

	// Getting input until its not single character and parsing it as character
	private char readUserInput() {
		String text = "";
		while (text.length() != 1) {
			text = readLine("Your guess: ");
			if (text.length() != 1) {
				println("Enter single character");
			}
		}
		
		// To get character from string with length of 1 we just need to return string's character at 0 index
		return text.charAt(0);
	}

	// Choosing random word for user to guess
	private void chooseRandomWord() {
		int wordsCount = lexicon.getWordCount();
		/* Returns random number from 0 to wordsCount
		 * Note: lexicons words are ordered from 0 to length-1
		 * nextInt(n) returns random integer from  0 to n-1 (excluding last) 
		 * so no need for decrementing by 1
		 * 
		 */
		int randomNum = rgen.nextInt(wordsCount);
		word = lexicon.getWord(randomNum);
	}

	private void initGame() {
		canvas.reset();
		chooseRandomWord();
		println("Welcome to Hangman!");
		initUserGuess();
		println("The word now looks like this: " + userGuess);
		println("You have " + guessesLeft + " guesses left");
	}

	private void initUserGuess() {
		for (int i = 0; i < word.length(); i++) {
			userGuess.append("-");
		}
		canvas.displayWord(userGuess.toString());
	}
}
