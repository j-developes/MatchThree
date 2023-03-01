package com.nash.art;

import java.awt.Color;
import java.awt.Graphics;

public class PaintPlayer {
	
	protected static Color colorUsed;
	protected static int width = 0;
	protected static int height = 0;
	protected static int x = 0;
	protected static int y = 0;
	
	public static void paintJob(Graphics g) {
		g.setColor(colorUsed);
		g.fillArc(x - 30, y - 40, width, height, 290, 350);
	}
	
	public void setSettings(int X, int Y, int W, int H, Color c) {
		width = W;
		height = H;
		x = X;
		y = Y;
		colorUsed = c;
	}
}
