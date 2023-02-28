package com.nash;

import java.util.Random;

/**
 * @author John Nash
 * 
 *         Match handles the matchMap which is the key array that offers the
 *         selections for the user. The Player input is received and filtered
 *         using @checkPoints before a change is fully made.
 * 
 */
public class Match {

	private MatchCore MatchC;
	public int[][] matchMap = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0 } };
	public int[][] test = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0 } };;
	public int points = 0;

	private class MatchCore {
		Random rando = new Random();

		MatchCore() {
			randomizeMatchThree();
			points = 0;
		}

		private void randomizeMatchThree() {
			for (int i = 0; i < matchMap.length; i++) {
				for (int j = 0; j < 5; j++) {

					matchMap[i][j] = rando.nextInt(5);
				}
			}

			checkIfMatchesRemain();
		}

		private boolean checkPoints(int x1, int y1, int x2, int y2) {

			int temp = 0;

			temp = matchMap[y1][x1];
			matchMap[y1][x1] = matchMap[y2][x2];
			matchMap[y2][x2] = temp;

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < matchMap.length; j++) {
					for (int k = 0; k < 5; k++) {

						if (k < 3) {
							if (matchMap[j][k] == i && matchMap[j][k + 1] == i && matchMap[j][k + 2] == i) {
								return true;
							}
						} else {
							if (matchMap[j][k] == i && matchMap[j][k - 1] == i && matchMap[j][k - 2] == i) {
								return true;
							}
						}

					}
				}

				for (int j = 0; j < matchMap.length; j++) {
					for (int k = 0; k < 5; k++) {

						if (j < 3) {
							if (matchMap[j][k] == i && matchMap[j + 1][k] == i && matchMap[j + 2][k] == i) {
								return true;
							}
						} else {
							if (matchMap[j][k] == i && matchMap[j - 1][k] == i && matchMap[j - 2][k] == i) {
								return true;
							}
						}
					}
				}
			}

			temp = 0;

			temp = matchMap[y1][x1];
			matchMap[y1][x1] = matchMap[y2][x2];
			matchMap[y2][x2] = temp;

			return false;
		}

		private void checkIfMatchesRemain() {

			boolean repeatCheck = true;

			while (repeatCheck) {
				repeatCheck = false;

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < matchMap.length; j++) {
						for (int k = 0; k < 5; k++) {

							if (k < 3) {
								if (matchMap[j][k] == i && matchMap[j][k + 1] == i && matchMap[j][k + 2] == i) {
									matchMap[j][k] = rando.nextInt(5);
									matchMap[j][k + 1] = rando.nextInt(5);
									matchMap[j][k + 2] = rando.nextInt(5);
									points++;
									repeatCheck = true;
								}
							} else {
								if (matchMap[j][k] == i && matchMap[j][k - 1] == i && matchMap[j][k - 2] == i) {
									matchMap[j][k] = rando.nextInt(5);
									matchMap[j][k - 1] = rando.nextInt(5);
									matchMap[j][k - 2] = rando.nextInt(5);
									points++;
									repeatCheck = true;
								}
							}
						}
					}

					for (int j = 0; j < matchMap.length; j++) {
						for (int k = 0; k < 5; k++) {

							if (j < 3) {
								if (matchMap[j][k] == i && matchMap[j + 1][k] == i && matchMap[j + 2][k] == i) {
									matchMap[j][k] = rando.nextInt(5);
									matchMap[j + 1][k] = rando.nextInt(5);
									matchMap[j + 2][k] = rando.nextInt(5);
									points++;
									repeatCheck = true;
								}
							} else {
								if (matchMap[j][k] == i && matchMap[j - 1][k] == i && matchMap[j - 2][k] == i) {
									matchMap[j][k] = rando.nextInt(5);
									matchMap[j - 1][k] = rando.nextInt(5);
									matchMap[j - 2][k] = rando.nextInt(5);
									points++;
									repeatCheck = true;
								}
							}
						}
					}
				}
			}
		}

	}

	Match() {
		MatchC = new MatchCore();
	}

	protected void findMatch(int x1, int y1, int x2, int y2) {

		if (MatchC.checkPoints(x1, y1, x2, y2)) {
			MatchC.checkIfMatchesRemain();
		}

	}

	protected void reset() {
		MatchC.randomizeMatchThree();
	}

}
