package com.nash.art;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class PaintLevel {
	
	private static boolean sky = true;
	public static Color colorUsed = Color.black;
	public static Color level_0 = new Color(.5f, 0f, 0f, .7f);
	public static Color level_1 = new Color(0f, .5f, 0f, .7f);
	public static Color level_2 = new Color(0f, 0f, .5f, .7f);
	protected static Color cloud = new Color(1f, 0f, 1f, .5f);
	public static String level = "Level 1";
	public static String score = "Score  0....";
	public static String timer = "00:00";
	public static int[][] match3 = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0 } };
	protected static int[] rows = { 150, 250, 350, 450, 550 };
	protected static int[] cols = { 150, 250, 350, 450, 550 };
	public static Font fontused = new Font("Verdana", Font.BOLD, 14);
	
	public static void paintJob(Graphics g) {
		paintLevelFrame(g);
		paintMatch3Graphics(g);
	}
	
	public void setScore(String s) {
		score = s;
	}

	public static void setTime(String t) {
		timer = t;
	}
	
	public static void setLevel(Color c) {
		colorUsed = c;
	}
	
	private static void paintLevelFrame(Graphics g) {
		g.setColor(colorUsed);
		g.fillRoundRect(100, 50, 600, 600, 15, 15);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRoundRect(150, 70, 400, 40, 15, 15);
		g.setColor(Color.black);
		g.setFont(fontused);
		g.drawString("  -  " + level + "  -  " + timer + "  -  " + score + "  -  ", 170, 95);
		buildBoxes(g, Color.blue);
	}
	
	private static void paintMatch3Graphics(Graphics g) {

		for (int i = 0; i < match3.length; i++) {
			for (int j = 0; j < 5; j++) {

				switch (match3[i][j]) {

				case 0:
					drawCir(g, i, j);
					break;
				case 1:
					drawSqu(g, i, j);
					break;
				case 2:
					drawTri(g, i, j);
					break;
				case 3:
					drawOva(g, i, j);
					break;
				case 4:
					drawDia(g, i, j);
					break;
				}

			}
		}

	}
	
	private static void drawCir(Graphics g, int a, int b) {
		g.setColor(Color.yellow);
		g.fillArc(rows[b] + 15, cols[a] + 15, 50, 50, 0, 360);
	}

	private static void drawSqu(Graphics g, int a, int b) {
		g.setColor(Color.red);
		g.fillRect(rows[b] + 15, cols[a] + 15, 50, 50);
	}

	private static void drawTri(Graphics g, int a, int b) {

		int[] n = { rows[b] + 15, rows[b] + 70, rows[b] + 37 };
		int[] m = { cols[a] + 17, cols[a] + 17, cols[a] + 65 };

		g.setColor(Color.green);
		g.fillPolygon(n, m, 3);
	}

	private static void drawOva(Graphics g, int a, int b) {
		int[] n = { rows[b] + 15, rows[b] + 25, rows[b] + 70, rows[b] + 45, rows[b] + 20 };
		int[] m = { cols[a] + 15, cols[a] + 15, cols[a] + 45, cols[a] + 70, cols[a] + 40 };

		g.setColor(Color.cyan);
		g.fillPolygon(n, m, 5);
	}
	
	private static void buildBoxes(Graphics g, Color c) {
		g.setColor(c);
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < cols.length; j++) {
				g.fillRoundRect(rows[i], cols[j], 80, 80, 15, 15);
			}
		}

	}

	private static void drawDia(Graphics g, int a, int b) {
		if (sky) {
			g.setColor(Color.DARK_GRAY);
		} else {
			g.setColor(cloud);
		}

		int[] n = { rows[b] + 15, rows[b] + 55, rows[b] + 70 };
		int[] m = { cols[a] + 15, cols[a] + 15, cols[a] + 70 };

		g.fillPolygon(n, m, 3);
	}
}
