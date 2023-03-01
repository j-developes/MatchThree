package com.nash.art;

import java.awt.Color;
import java.awt.Graphics;


public class PaintMoon{
	
	private static Color planet = new Color(.1f, 0f, .1f, .7f);
	private static int x;
	private static int y;
	private static int width;
	private static int height;

	public static void paintJob(Graphics g) {
		g.setColor(planet);
		g.fillOval(x, y, width, height);
	}
	
	public void setSettings(int X, int Y, int W, int H, Color c) {
		x=X;
		y=Y;
		width=W;
		height=H;
		planet=c;
	}
}
