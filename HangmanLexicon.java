
/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import acm.util.*;

public class HangmanLexicon {
    private ArrayList<String> words;

	/** Returns the number of words in the lexicon. */
	public HangmanLexicon() {
		words = new ArrayList<>();
		try {
			BufferedReader rd = new BufferedReader(new FileReader("HangmanLexicon.txt"));
			while(true){
				String currentWord = rd.readLine();
				if(currentWord == null){
					break;
				}
                words.add(currentWord);
			}
		} catch (IOException e) {
			return;
		}
	}

	public int getWordCount() {
		return words.size();
	}

	/** Returns the word at the specified index. */
	public String getWord(int index) {
		return words.get(index);
	};
}
