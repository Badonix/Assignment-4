/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {
	
	private static GLine body;
	private static GLine leftHand;
	private static GLine rightHand;
	private static GOval head;
	private static GLine leftLeg;
	private static GLine rightLeg;

/** Resets the display so that only the scaffold appears */
	public void reset() {
		drawBody();
		drawHead();
		drawLeftLeg();
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		/* You fill this in */
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		/* You fill this in */
	}
	private void drawHead(){
		double headX = getWidth() / 2 - HEAD_RADIUS;
		double headY = getHeight() / 2 - OFFSET_Y - BODY_LENGTH - HEAD_RADIUS * 2;
		head = new GOval(HEAD_RADIUS * 2, HEAD_RADIUS * 2);
		add(head, headX, headY);
	}
	private void drawBody(){
		double bodyX = getWidth() / 2;
		double bodyY = getHeight() / 2 - OFFSET_Y - BODY_LENGTH;
		body = new GLine(bodyX, bodyY, bodyX, bodyY + BODY_LENGTH);
		add(body);
	}
	private void drawLeftLeg(){
		double legX = getWidth() / 2 - HIP_WIDTH;
		double legY = getHeight() / 2 - OFFSET_Y;
		body = new GLine(legX, legY, getWidth()/2, legY + BODY_LENGTH);
		add(body);
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
	private static final int OFFSET_Y = 20;

}
