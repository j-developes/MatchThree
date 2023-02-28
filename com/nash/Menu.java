package com.nash;

import com.nash.view.ArtJob;

/**
 * @author John Nash
 * 
 *         Menu class provides the user a selection of options such as New Game,
 *         Restart, Quit. Restart is used when the player has no moves. The Menu
 *         can be accessed in game using Escape.
 * 
 * @MenuOn lets the Controller know menu is active.
 * @resetGame if true the game will be reset.
 * @swapNwgameResu swaps the letter from New game to Resume.
 */

public class Menu {

	private MenuCore MenuC = new MenuCore();
	protected boolean MenuOn = true;
	protected boolean resetGame = false;
	protected String swapNwgameResu = "New Game";

	private class MenuCore {

		private int cursor = 2;
		private ArtJob GraphicMenu;

		MenuCore() {
			GraphicMenu = new ArtJob("menu");
		}

		private void scrollUp() {
			cursor++;
			if (cursor > 2) {
				cursor = 0;
			}
		}

		private void scrollDown() {
			cursor--;
			if (cursor < 0) {
				cursor = 2;
			}
		}

		private ArtJob update() {

			GraphicMenu.setSettings(cursor);
			GraphicMenu.nwgame = swapNwgameResu;
			return GraphicMenu;
		}

		private void selectNewGame() {
			swapNwgameResu = "Resume";
			MenuOn = false;
		}

		private void selectReset() {
			resetGame = true;
			MenuOn = false;
		}

		private void selectQuit() {
			System.exit(0);
		}

		private void select() {
			switch (cursor) {
			case 2:
				selectNewGame();
				break;

			case 1:
				selectReset();
				break;

			case 0:
				selectQuit();
				break;
			}
		}

	}

	Menu() {
		updateMenu();
	}

	protected ArtJob updateMenu() {
		return MenuC.update();
	}

	protected void moveCursor(boolean updown) {
		if (updown) {
			MenuC.scrollUp();
		} else {
			MenuC.scrollDown();
		}
	}

	protected void makeSelection() {
		MenuC.select();
	}

}
