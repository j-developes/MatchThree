package com.nash;

import com.nash.view.View;

/**
 * @author John Nash
 * 
 *         PSched is the Paint Scheduler. It initializes the game modules that
 *         will report an ArtJob object before it can be painted using the paint
 *         component in a modified JPanel.
 * 
 * @ArtJob
 */
public class PSched {

	Player LaPlay;
	Menu Menus;
	PSchedCore Core;
	Level LevelZero;
	View Gui;

	private class PSchedCore {

		int updateFrame = 0;

		private void updateGraphics() {
			Gui.ModifiedPanel.repaint();
		}

		private void updateFrame() {
			updateFrame++;
			if (updateFrame > 60) {
				updateFrame = 0;
			}

			LevelZero.frame = updateFrame;
		}

		private void getUpdatedGraphics() {

			if (Menus.MenuOn == false) {
				LevelZero.updateMissionTime();
				Gui.ModifiedPanel.Artist.addJob(LevelZero.updateSky(), 5);
				Gui.ModifiedPanel.Artist.addJob(LevelZero.updateMoon(), 4);
				Gui.ModifiedPanel.Artist.addJob(LevelZero.updateClouds(), 4);
				Gui.ModifiedPanel.Artist.addJob(LevelZero.updateScene(), 3);
				Gui.ModifiedPanel.Artist.addJob(LevelZero.updatelevel(), 2);
				Gui.ModifiedPanel.Artist.addJob(LaPlay.update(), 1);
			} else {
				Gui.ModifiedPanel.Artist.addJob(Menus.updateMenu(), 5);
			}
		}
	}

	PSched(Player P, Menu M, Level L) {
		LaPlay = P;
		LevelZero = L;
		Menus = M;
		Core = new PSchedCore();
		Gui = new View();
		Gui.startWindow();
		update();
	}

	protected void update() {
		Core.updateFrame();
		Core.getUpdatedGraphics();
		Core.updateGraphics();
	}
}
