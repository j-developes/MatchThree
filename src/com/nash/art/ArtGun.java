package com.nash.art;

import java.awt.Graphics;

public class ArtGun {
	
	public Graphics fireArt(String s, Graphics g) {

		switch(s) {
		case "menu":
			PaintMenu.paintJob(g);
			return g;
		case "level":
			PaintLevel.paintJob(g);
			return g;
		case "sky":
			PaintSky.paintJob(g);
			return g;
		case "player":
			PaintPlayer.paintJob(g);
			return g;
		case "clouds":
			PaintClouds.paintJob(g);
			return g;
		case "moon":
			PaintMoon.paintJob(g);
			return g;
		case "scene":
			PaintScene.paintJob(g);
			return g;
		}
		
		return g;
	}
	
}