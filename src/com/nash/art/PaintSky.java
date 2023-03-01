package com.nash.art;

import java.awt.Color;
import java.awt.Graphics;

public class PaintSky {
	public static boolean sky = true;
	private static Color daysky = new Color(1f, 0f, 0f, .5f);
	private static Color nightsky = new Color(0f, 0f, .3f, .5f);
	
	public static void paintJob(Graphics g) {
		if (sky) {
			g.setColor(daysky);
		} else {
			g.setColor(nightsky);
		}
		g.fillRect(0, 0, 800, 800);
	}
	
	public void setColor(boolean b) {
		sky = b;
	}
}
