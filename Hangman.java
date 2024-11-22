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

    private static int guessesLeft = GUESSES;
	public void run() {
    	initGame();
    	while(guessesLeft > 0){
    		play();
    	}
	}
	
	private void play(){
		char currentGuess = readUserInput();
		while(!validateInput(currentGuess)){
			currentGuess = readUserInput();
		
		};
		fillTheWord(currentGuess);		
	}
	
	private void fillTheWord(char guess){
		if(word.indexOf(Character.toUpperCase(guess)) != -1){
			println("GOOD GUESS");
		}else{
			guessesLeft--;
		}
	}
	
	
	private boolean validateInput(char input){
		if(guessedLetters.contains(input)){
			println("Letter is already used");
			return false;
		}
		if(!Character.isLetter(input)){
			println("Letter is not valid");
			return false;
		}
		guessedLetters.add(input);
		return true;
	}
	
	private char readUserInput() {
		String text = "";
		while (text.length() != 1) {
			text = readLine("Your guess: ");
			if(text.length() != 1){
				println("Enter single character");
			}
		}
		return text.charAt(0);
	}
	

    private void chooseRandomWord(){
    	int wordsCount = lexicon.getWordCount();
    	int randomNum = rgen.nextInt(wordsCount); 
    	word = lexicon.getWord(randomNum);
    }
    
    private void initGame(){
    	chooseRandomWord();
		println("Welcome to Hangman!");
		initUserGuess();
		println("The word now looks like this: " + userGuess);
		println("You have " + guessesLeft + " guesses left");
    }
    
    private void initUserGuess(){
    	for(int i = 0; i < word.length(); i++){
    		userGuess.append("_");
    		if(i != word.length() - 1){
    			userGuess.append(" ");
    		}
    	}
    }

}
