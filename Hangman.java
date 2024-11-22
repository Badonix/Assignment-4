/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {

	private static String word;
	private static String userGuess;
	private static HangmanLexicon lexicon = new HangmanLexicon();
	private static RandomGenerator rgen = RandomGenerator.getInstance();
    public void run() {
		println("Welcome to Hangman!");
		chooseRandomWord();
		println("Current word is " + word);
	}
    
    private void chooseRandomWord(){
    	int wordsCount = lexicon.getWordCount();
    	
    	// It will return random number from 0 to wordsCount - 1
    	int randomNum = rgen.nextInt(wordsCount); 
    	println(randomNum);
    	word = lexicon.getWord(randomNum);
    }

}
