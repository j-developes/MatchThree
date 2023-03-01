package com.nash;

import java.io.IOException;

/**
 * @author John Nash
 * @version 1.0 MatchThree is a simple matching game.
 */
public class MatchThree {

	static Core GameCore;

	private static class Core {

		private Controller Ctrl;

		Core() {
			Ctrl = new Controller();
		}

		private void gameStart() {
			Ctrl.startClock();
		}

	}

	public static void main(String[] args) throws IOException {
		args = null;

		GameCore = new Core();
		GameCore.gameStart();
	}
}
