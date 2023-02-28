package com.nash;

import java.awt.Color;

import com.nash.view.ArtJob;

/**
 * 
 * @author John Nash
 *
 *         Player class handles some ui graphics to indicate user selections but
 *         mostly sends user input through several filter methods before handed
 *         off to Match which will eventually swap two elements based on input.
 * 
 *         The input to the controller is mouse pressed then mouse released.
 *         controller -> check -> getPoints -> setPoints -> lastCheck ->
 *         Match3.findMatch
 */
public class Player {

	private Match Match3;
	PlayerCore PC;
	ArtJob PlayerGraphics = new ArtJob("player");

	private class PlayerCore {
		private boolean firstValueUnset = true;
		private boolean secValueUnset = true;
		private int x1 = 0;
		private int x2 = 0;
		private int y1 = 0;
		private int y2 = 0;

		private ArtJob updatePlayer() {

			return PlayerGraphics;
		}

		private void getPoints(int x, int y) {
			PlayerGraphics.setSettings(x, y, 10, 10, Color.red);
			int tempX = check(x);
			int tempY = check(y);

			if (tempX != -1 && tempY != -1) {
				PlayerGraphics.setSettings(x, y, 30, 30, Color.white);
				if (setPoints(tempX, tempY)) {
					if (lastCheck()) {
						Match3.findMatch(x1, y1, x2, y2);
						firstValueUnset = true;
						secValueUnset = true;
					} else {
						firstValueUnset = true;
						secValueUnset = true;
					}
				} else {
					if (!firstValueUnset && !secValueUnset) {
						firstValueUnset = true;
						secValueUnset = true;
					}
				}
			}

		}

		private void release() {
			x1 = x2 = y1 = y2 = -1;
			firstValueUnset = true;
			secValueUnset = true;
		}

		private boolean lastCheck() {

			if (x1 == x2 && y1 == y2) {
				return false;
			} else if (x1 + 1 == x2 || x1 - 1 == x2) {

				if (y1 == y2) {

					// True use values
					return true;
				} else {
					return false;
				}
			} else if (y1 + 1 == y2 || y1 - 1 == y2) {
				if (x1 == x2) {

					// True use values
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}

		private boolean setPoints(int x, int y) {

			if (firstValueUnset) {
				x1 = x;
				y1 = y;
				firstValueUnset = false;
				return false;
			} else {
				x2 = x;
				y2 = y;
				return true;
			}
		}

		private int check(int n) {
			// private int[] cols = {150,250,350,450,550};

			int lim = 150;

			for (int i = 0; i < 5; i++) {

				if (i == 1) {
					lim = 250;
				} else if (i == 2) {
					lim = 350;
				} else if (i == 3) {
					lim = 450;
				} else if (i == 4) {
					lim = 550;
				} else {
					i = 0;
					lim = 150;
				}

				if (n > lim && n < lim + 100) {
					return i;
				}
			}

			return -1;
		}

	}

	Player(Match M) {
		PC = new PlayerCore();
		Match3 = M;
	}

	protected ArtJob update() {
		return PC.updatePlayer();
	}

	protected void click(int x, int y) {
		PC.getPoints(x, y);
	}

	protected void unclick() {
		PC.release();
	}

}
