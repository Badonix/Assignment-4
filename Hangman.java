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
    	initGame();
	}
    
    private void chooseRandomWord(){
    	int wordsCount = lexicon.getWordCount();
    	int randomNum = rgen.nextInt(wordsCount); 
    	word = lexicon.getWord(randomNum);
    }
    
    private void initGame(){
    	chooseRandomWord();
		println("Welcome to Hangman!");
    }

}
