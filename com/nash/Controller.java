package com.nash;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 * @author John Nash
 * 
 *         Controller class responsible for handling player input between
 *         modules.
 */
public class Controller {

	ControllerRelm Game;

	private class ControllerRelm implements MouseListener {

		private Clock GameClock;
		private Player LaPlayer;
		private Level LevelZero;
		private PSched PaintScheduler;
		private Menu Menus;
		private Match Match3;
		private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
		private static final String MOVE_UP = "move up";
		private static final String MOVE_DOWN = "move down";
		private static final String SPACE_BAR = "fire";
		private static final String ESC_MENU = "menu";
		private static final String ENTER = "Enter";

		ControllerRelm() {
			Match3 = new Match();
			LaPlayer = new Player(Match3);
			Menus = new Menu();
			LevelZero = new Level(Match3);
			PaintScheduler = new PSched(LaPlayer, Menus, LevelZero);
			GameClock = new Clock(PaintScheduler);
			installKeyboardControls();
		}

		@SuppressWarnings("serial")
		private void installKeyboardControls() {

			PaintScheduler.Gui.ModifiedPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("W"), MOVE_UP);
			PaintScheduler.Gui.ModifiedPanel.getActionMap().put(MOVE_UP, new AbstractAction() {

				@Override
				public void actionPerformed(ActionEvent e) {

					if (Menus.MenuOn) {
						Menus.moveCursor(true);
					}
				}
			});

			PaintScheduler.Gui.ModifiedPanel.addMouseListener(this);
			PaintScheduler.Gui.ModifiedPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("UP"), MOVE_UP);
			PaintScheduler.Gui.ModifiedPanel.getActionMap().put(MOVE_UP, new AbstractAction() {

				@Override
				public void actionPerformed(ActionEvent e) {

					if (Menus.MenuOn) {
						Menus.moveCursor(true);
					}
				}
			});

			PaintScheduler.Gui.ModifiedPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("S"), MOVE_DOWN);
			PaintScheduler.Gui.ModifiedPanel.getActionMap().put(MOVE_DOWN, new AbstractAction() {

				private static final long serialVersionUID = -6269077816404417475L;

				@Override
				public void actionPerformed(ActionEvent e) {

					if (Menus.MenuOn) {
						Menus.moveCursor(false);
					}
				}
			});

			PaintScheduler.Gui.ModifiedPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("DOWN"), MOVE_DOWN);
			PaintScheduler.Gui.ModifiedPanel.getActionMap().put(MOVE_DOWN, new AbstractAction() {

				private static final long serialVersionUID = -6269077816404417475L;

				@Override
				public void actionPerformed(ActionEvent e) {

					if (Menus.MenuOn) {
						Menus.moveCursor(false);
					}
				}
			});

			PaintScheduler.Gui.ModifiedPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("SPACE"), SPACE_BAR);
			PaintScheduler.Gui.ModifiedPanel.getActionMap().put(SPACE_BAR, new AbstractAction() {

				private static final long serialVersionUID = 7786485181332246698L;

				@Override
				public void actionPerformed(ActionEvent e) {
					if (Menus.MenuOn) {
						Menus.makeSelection();
					}

					if (Menus.resetGame) {
						// will reset level to 0
						LevelZero.resetLevel();
						Menus.resetGame = false;
						Menus.MenuOn = false;
					}
				}
			});

			PaintScheduler.Gui.ModifiedPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("ENTER"), ENTER);
			PaintScheduler.Gui.ModifiedPanel.getActionMap().put(ENTER, new AbstractAction() {

				private static final long serialVersionUID = 7786485181332246698L;

				@Override
				public void actionPerformed(ActionEvent e) {
					if (Menus.MenuOn) {
						Menus.makeSelection();
					}

					if (Menus.resetGame) {
						// will reset level to 0
						LevelZero.resetLevel();
						Menus.resetGame = false;
						Menus.MenuOn = false;
					}

				}
			});

			PaintScheduler.Gui.ModifiedPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("ESCAPE"), ESC_MENU);
			PaintScheduler.Gui.ModifiedPanel.getActionMap().put(ESC_MENU, new AbstractAction() {

				private static final long serialVersionUID = 7786485181332246698L;

				@Override
				public void actionPerformed(ActionEvent e) {

					if (Menus.MenuOn) {
						Menus.MenuOn = false;
					} else {
						Menus.MenuOn = true;
					}

				}
			});

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// pass
		}

		@Override
		public void mousePressed(MouseEvent e) {

			int a = e.getLocationOnScreen().x;
			int b = e.getLocationOnScreen().y;

			LaPlayer.click(a, b);

		}

		@Override
		public void mouseReleased(MouseEvent e) {

			int a = e.getLocationOnScreen().x;
			int b = e.getLocationOnScreen().y;

			LaPlayer.click(a, b);
			LaPlayer.unclick();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// pass
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// pass
		}
	}

	Controller() {
		Game = new ControllerRelm();
	}

	protected void startClock() {
		Game.GameClock.startClock();
	}
}
