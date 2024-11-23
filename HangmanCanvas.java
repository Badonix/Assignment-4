
/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

	private static GLine body;
	private static GCompound leftHand = new GCompound();
	private static GCompound rightHand = new GCompound();
	private static GOval head;
	private static GCompound leftLeg = new GCompound();
	private static GCompound rightLeg = new GCompound();
	private static GLine leftFoot;
	private static GLine rightFoot;
	private static GCompound beamAndRope = new GCompound();
	private static GLine scaffold;

 	/** Resets the display so that only the scaffold appears */
	public void reset() {
		drawBody();
		drawHead();
		drawLeftLeg();
		drawRightLeg();
//		drawRightFoot();
		drawLeftHand();
		drawRightHand();
		drawBeamAndRope();
		drawScaffold();
	}

	/**
	 * Updates the word on the screen to correspond to the current state of the
	 * game. The argument string shows what letters have been guessed so far;
	 * unguessed letters are indicated by hyphens.
	 */
	public void displayWord(String word) {
		/* You fill this in */
	}

	/**
	 * Updates the display to correspond to an incorrect guess by the user.
	 * Calling this method causes the next body part to appear on the scaffold
	 * and adds the letter to the list of incorrect guesses that appears at the
	 * bottom of the window.
	 */
	public void noteIncorrectGuess(char letter) {
		/* You fill this in */
	}

	private void drawRightFoot(){
		double footX = getWidth() / 2 + HIP_WIDTH;
		double footY = getHeight() / 2 - OFFSET_Y + LEG_LENGTH;
		GLine foot = new GLine(footX, footY, footX + FOOT_LENGTH, footY);

	}
	private void drawHead() {
		double headX = getWidth() / 2 - HEAD_RADIUS;
		double headY = getHeight() / 2 - OFFSET_Y - BODY_LENGTH - HEAD_RADIUS * 2;
		head = new GOval(HEAD_RADIUS * 2, HEAD_RADIUS * 2);
		add(head, headX, headY);
	}

	private void drawBody() {
		double bodyX = getWidth() / 2;
		double bodyY = getHeight() / 2 - OFFSET_Y - BODY_LENGTH;
		body = new GLine(bodyX, bodyY, bodyX, bodyY + BODY_LENGTH);
		add(body);
	}

	private void drawLeftHand() {
		double handX = getWidth() / 2 - UPPER_ARM_LENGTH;
		double handY = getHeight() / 2 - OFFSET_Y - BODY_LENGTH + ARM_OFFSET_FROM_HEAD;
		GLine hand = new GLine(handX, handY, getWidth() / 2, handY);

		double lowerArmX = handX;
		double lowerArmY = handY;
		GLine lowerArm = new GLine(lowerArmX, lowerArmY, lowerArmX, lowerArmY + LOWER_ARM_LENGTH);

		leftHand.add(hand);
		leftHand.add(lowerArm);
		add(leftHand);
	}

	private void drawRightHand() {
		double handX = getWidth() / 2 + UPPER_ARM_LENGTH;
		double handY = getHeight() / 2 - OFFSET_Y - BODY_LENGTH + ARM_OFFSET_FROM_HEAD;
		GLine hand = new GLine(handX, handY, getWidth() / 2, handY);

		double lowerArmX = handX;
		double lowerArmY = handY;
		GLine lowerArm = new GLine(lowerArmX, lowerArmY, lowerArmX, lowerArmY + LOWER_ARM_LENGTH);

		rightHand.add(hand);
		rightHand.add(lowerArm);
		add(rightHand);
	}

	private void drawLeftLeg() {
		double hipX = getWidth() / 2 - HIP_WIDTH;
		double hipY = getHeight() / 2 - OFFSET_Y;
		GLine hip = new GLine(hipX, hipY, getWidth() / 2, hipY);

		double legX = hipX;
		double legY = hipY;
		GLine leg = new GLine(legX, legY, legX, legY + LEG_LENGTH);

		double footX = legX;
		double footY = legY + LEG_LENGTH;
		GLine foot = new GLine(footX, footY, footX - FOOT_LENGTH, footY);

		leftLeg.add(hip);
		leftLeg.add(leg);
		leftLeg.add(foot);
		add(leftLeg);
	}

	private void drawRightLeg() {
		double hipX = getWidth() / 2 + HIP_WIDTH;
		double hipY = getHeight() / 2 - OFFSET_Y;
		GLine hip = new GLine(hipX, hipY, getWidth() / 2, hipY);

		double legX = hipX;
		double legY = hipY;
		GLine leg = new GLine(legX, legY, legX, legY + LEG_LENGTH);


		rightLeg.add(hip);
		rightLeg.add(leg);
		add(rightLeg);
	}

	private void drawBeamAndRope() {
		double ropeX = getWidth() / 2;
		double ropeY = getHeight() / 2 - OFFSET_Y - HEAD_RADIUS * 2 - BODY_LENGTH - ROPE_LENGTH;
		GLine rope = new GLine(ropeX, ropeY, ropeX, ropeY + ROPE_LENGTH);
		beamAndRope.add(rope);

		double beamX = ropeX - BEAM_LENGTH;
		double beamY = ropeY;
		GLine beam = new GLine(beamX, beamY, beamX + BEAM_LENGTH, beamY);
		beamAndRope.add(beam);
		add(beamAndRope);
	}

	private void drawScaffold() {
		double scaffoldX = getWidth() / 2 - BEAM_LENGTH;
		double scaffoldY = getHeight() / 2 - OFFSET_Y - BODY_LENGTH - HEAD_RADIUS * 2 - ROPE_LENGTH;
		scaffold = new GLine(scaffoldX, scaffoldY, scaffoldX, scaffoldY + SCAFFOLD_HEIGHT);
		add(scaffold);
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
