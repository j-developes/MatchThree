package com.nash.art;

import java.awt.Color;
import java.awt.Graphics;

public class PaintClouds {

	public static boolean daynight = true;
	public static Color cloud = new Color(1f, 0f, 1f, .5f);
	public static Color darkCloud = new Color(0f,0f,0f);
	public static int xArrayUsed[];
	public static int yArrayUsed[];
	
	public static void paintJob(Graphics g) {
		g.setColor(darkCloud);
		
		if(daynight) {
			g.setColor(cloud);
		}
		
		g.fillPolygon(xArrayUsed, yArrayUsed, xArrayUsed.length);
	}
	
	public void setSettings(int[] xArr, int[] yArr, boolean b) {
		xArrayUsed = xArr;
		yArrayUsed = yArr;
		daynight = b;
	}
}
