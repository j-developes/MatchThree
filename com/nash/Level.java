package com.nash;

import java.awt.Color;
import java.util.Random;

import com.nash.view.ArtJob;

/**
 * @author John Nash
 * 
 *         Manages every aspect of Levels, working with several ArtJob objects
 *         to create several background layers.
 */
public class Level {
	private LevelCore Lc;
	private ArtJob LevelGraphics = new ArtJob("level");
	private ArtJob LevelSky = new ArtJob("sky");
	private ArtJob LevelMoon = new ArtJob("moon");
	private ArtJob LevelClouds = new ArtJob("clouds");
	private ArtJob LevelScene = new ArtJob("scene");
	private Match Match3;
	private int counts = 0;
	private int time = 0;
	protected int frame;
	private int level = 0;
	private int missionSecs = 59;
	private int missionMins = 5;

	private class LevelCore {
		int[] xcloud = { 700, 750, 760, 800 };
		int[] ycloud = { 120, 100, 100, 120 };
		int[] xArr = { -50, 0, 50, 150, 200, 250, 300, 350, 400, 450, 500, 550, 600, 650, 700, 750, 800, 850 };
		int[] yArr = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		Random rando = new Random();

		private ArtJob setScene() {

			if (frame % 3 == 0) {

				if (level == 0) {
					setMountainRange(0);
				} else if (level == 1) {
					setMountainRange(100);
				} else {
					setMountainRange(400);
				}
			}

			LevelScene.setSettings(18, xArr, yArr, Color.black);
			return LevelScene;
		}

		private void levelTimer() {

			if (Match3.points > 20) {

				level++;

				if (level > 2) {
					level = 0;
				}
				Match3.points = 0;
				missionMins = 5;
				missionSecs = 59;
			} else if (frame == 59) {
				missionSecs--;
				if (missionSecs < 0) {
					missionSecs = 59;
					missionMins--;
					if (missionMins < 0) {
						// times up!
						level = 0;
						Match3.points = 0;
						missionMins = 5;
						missionSecs = 59;
					}
				}
			} else {
				// pass
			}
		}

		private ArtJob setSky() {

			if (frame == 1) {
				time++;

				if (time < 10) {
					LevelSky.sky = true;
				} else {
					LevelSky.sky = false;
				}

				if (time > 20) {
					time = 0;
				}
			}

			return LevelSky;
		}

		private ArtJob setPlanet() {

			if (frame == 10) {
				counts++;
				LevelMoon.setSettings(counts, 100, 100, 100, Color.black);
			}

			if (counts > 800) {
				counts = -10;
			}
			return LevelMoon;
		}

		private ArtJob setClouds() {

			int yrando = 0;
			int yrand = 0;

			if (frame % 20 == 0) {
				for (int i = 0; i < xcloud.length; i++) {
					xcloud[i]--;
				}
			}

			if (xcloud[3] < 0) {
				yrando = rando.nextInt(500);
				yrand = rando.nextInt(100) + 10;
				xcloud[0] = 700;
				xcloud[1] = 750;
				xcloud[2] = 760;
				xcloud[3] = 800;

				ycloud[0] = yrando;
				ycloud[1] = yrando - yrand;
				ycloud[2] = yrando - yrand;
				ycloud[3] = yrando;
			}

			LevelClouds.setSettings(4, xcloud, ycloud, Color.black);
			return LevelClouds;
		}

		private void resetLevel() {
			level = 0;
			Match3.points = 0;
			missionMins = 5;
			missionSecs = 59;
			Match3.reset();
		}

		private ArtJob setLevel() {

			String m = String.valueOf(missionMins);
			String s = String.valueOf(missionSecs);

			LevelGraphics.timer = "00:" + m + ":" + s;
			LevelGraphics.match3 = Match3.matchMap;
			LevelGraphics.score = "Score " + String.valueOf(Match3.points);
			LevelGraphics.level = "Level " + String.valueOf(level);

			if (level == 0) {
				LevelGraphics.setSettings(LevelGraphics.leve0);
			} else if (level == 1) {
				LevelGraphics.setSettings(LevelGraphics.leve1);
			} else {
				LevelGraphics.setSettings(LevelGraphics.leve2);
			}
			return LevelGraphics;
		}

		private void setMountainRange(int incline) {
			int rise = rando.nextInt(700);
			for (int i = 0; i < yArr.length; i++) {
				if (i != 17) {
					yArr[i] = yArr[i + 1];
				}
			}

			yArr[16] = 800 - rise + incline;
			yArr[0] = 800;
			yArr[17] = 800;

		}

	}

	Level(Match M) {
		Lc = new LevelCore();
		Match3 = M;
	}

	protected void resetLevel() {
		Lc.resetLevel();
	}

	protected void updateMissionTime() {
		Lc.levelTimer();
	}

	protected ArtJob updateScene() {
		return Lc.setScene();
	}

	protected ArtJob updateClouds() {
		return Lc.setClouds();
	}

	protected ArtJob updateSky() {
		return Lc.setSky();
	}

	protected ArtJob updatelevel() {
		return Lc.setLevel();
	}

	protected ArtJob updateMoon() {
		return Lc.setPlanet();
	}
}
