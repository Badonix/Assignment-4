
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

	private static String word;
	private static StringBuilder userGuess = new StringBuilder();
	private static HangmanLexicon lexicon = new HangmanLexicon();
	private static RandomGenerator rgen = RandomGenerator.getInstance();
	private static ArrayList<Character> guessedLetters = new ArrayList<>();
    public static final int APPLICATION_HEIGHT = 700;
	private static boolean hasWon = false;

	private HangmanCanvas canvas = new HangmanCanvas();
	private static int guessesLeft = GUESSES;

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
		while (!validateInput(currentGuess)) {
			currentGuess = readUserInput();
		}
		
		tryLetter(currentGuess);
		if (userGuess.toString().equals(word)) {
			handleWin();
			return;
		}
		println("The word now looks like this: " + userGuess);
		println("You have " + guessesLeft + " guesses left");

	}

	private void handleWin() {
		hasWon = true;
		println("You guessed the word: " + word);
		println("You win.");
	}

	private void handleLoss() {
		println("You are completly hung.");
		println("The word was: " + word);
		println("You lose.");
	}

	private void tryLetter(char guess) {
		if (word.indexOf(Character.toUpperCase(guess)) != -1) {
			println("That guess is correct");
			fillTheWord(guess);
		} else {
			println("There are no " + guess + "'s in the word");
			guessesLeft--;
		}
	}

	private void fillTheWord(char guess) {
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == Character.toUpperCase(guess)) {
				userGuess.setCharAt(i, Character.toUpperCase(guess));
			}
		}
		canvas.displayWord(userGuess.toString());
	}

	private boolean validateInput(char input) {
		if (guessedLetters.contains(input)) {
			println("Letter is already used");
			return false;
		}
		if (!Character.isLetter(input)) {
			println("Letter is not valid");
			return false;
		}
		guessedLetters.add(Character.toUpperCase(input));
		return true;
	}

	private char readUserInput() {
		String text = "";
		while (text.length() != 1) {
			text = readLine("Your guess: ");
			if (text.length() != 1) {
				println("Enter single character");
			}
		}
		return text.charAt(0);
	}

	private void chooseRandomWord() {
		int wordsCount = lexicon.getWordCount();
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
	}
}
