package com.nash.art;

import java.awt.Color;
import java.awt.Graphics;

public class PaintScene {
	protected static Color color = new Color(1f, 0f, 1f, .5f);
	private static int xArrayUsed[];
	private static int yArrayUsed[];
	private static int point = 0;
	
	public static void paintJob(Graphics g) {
		g.setColor(color);
		g.fillPolygon(xArrayUsed, yArrayUsed, point);
	}
	
	public void setSettings(int num, int x[], int y[], Color c) {
		point = num;
		xArrayUsed = x;
		yArrayUsed = y;
		color = c;
	}
}
