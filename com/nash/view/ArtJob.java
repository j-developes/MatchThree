package com.nash.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * @author John Nash
 * 
 *         ArtJob is the ArrayList object that passes graphical instructions to
 *         the paintComponent via the PSched.
 * 
 * @name is used to switch between paint methods.
 */

public class ArtJob {

	private String name;
	private int[] xArrayUsed;
	private int[] yArrayUsed;
	private Color colorUsed;
	private int nPointUsed = 0;
	private int cursorUsed = 0;
	public String nwgame = "New Game";
	private String reset = "Reset";
	private String quit = "Quit";
	private String but1 = "Select:              Enter";
	private String but2 = "Movement:    click & drag";
	private String but3 = "Menu:              Escape";
	private int[] rows = { 150, 250, 350, 450, 550 };
	private int[] cols = { 150, 250, 350, 450, 550 };
	private int width = 0;
	private int height = 0;
	private int x = 0;
	private int y = 0;
	private Color cloud = new Color(1f, 0f, 1f, .5f);
	private Color daysky = new Color(1f, 0f, 0f, .5f);
	private Color nightsky = new Color(0f, 0f, .3f, .5f);
	private Color planet = new Color(.1f, 0f, .1f, .7f);
	public Color leve0 = new Color(.5f, 0f, 0f, .7f);
	public Color leve1 = new Color(0f, .5f, 0f, .7f);
	public Color leve2 = new Color(0f, 0f, .5f, .7f);
	public boolean sky = true;
	public String level = "Level 1";
	public String score = "Score  0....";
	public String timer = "00:00";
	public int[][] match3 = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0 } };
	private Font font = new Font("Verdana", Font.BOLD, 14);
	public Color Hidden = new Color(.1f, .1f, .1f, .1f);

	public ArtJob(String commons) {
		name = commons;
	}

	public void setSettings(int nPoint, int[] xArray, int[] yArray, Color color) {
		xArrayUsed = xArray;
		yArrayUsed = yArray;
		colorUsed = color;
		nPointUsed = nPoint;
	}

	public void setSettings(int X, int Y, int W, int H, Color c) {
		width = W;
		height = H;
		x = X;
		y = Y;
		colorUsed = c;
	}

	public void setSettings(int cursor) {
		cursorUsed = cursor;
	}

	public void setSettings(Color c) {
		colorUsed = c;
	}

	public void setScore(String s) {
		score = s;
	}

	public void setTime(String t) {
		timer = t;
	}

	public void paintJob(Graphics g) {

		if (name == null) {
			return;
		}

		switch (name) {
		case "menu":
			paintMenu(g);
			break;

		case "level":
			paintLevelFrame(g);
			paintMatch3Graphics(g);
			break;

		case "player":
			paintSelection(g);
			break;

		case "sky":
			if (sky) {
				g.setColor(daysky);
			} else {
				g.setColor(nightsky);
			}
			g.setColor(colorUsed);
			g.fillRect(0, 0, 800, 800);
			break;

		case "clouds":
			paintClouds(g);
			break;

		case "moon":
			paintMoon(g);
			break;

		case "scene":
			g.setColor(colorUsed);
			g.fillPolygon(xArrayUsed, yArrayUsed, nPointUsed);
			break;
		}
	}

	private void paintSelection(Graphics g) {

		g.setColor(colorUsed);
		g.fillArc(x - 30, y - 40, width, height, 290, 350);

	}

	private void paintMenu(Graphics g) {
		g.setColor(Color.gray);
		g.fill3DRect(300, 200, 400, 400, false);

		g.setFont(font);
		g.setColor(Color.black);
		g.fillRect(0, 0, 800, 800);
		g.setColor(Color.gray);
		g.fill3DRect(280, 230, 300, 400, false);

		if (cursorUsed == 2) {
			g.setColor(Color.green);
			g.fill3DRect(350, 250, 150, 50, false);
			g.setColor(Color.DARK_GRAY);
			g.fill3DRect(350, 320, 150, 50, false);
			g.fill3DRect(350, 390, 150, 50, false);

			g.setColor(Color.black);
			g.drawString(nwgame, 395, 275);
			g.setColor(Color.white);
			g.drawString(reset, 395, 350);
			g.drawString(quit, 400, 415);
		} else if (cursorUsed == 1) {
			g.setColor(Color.green);
			g.fill3DRect(350, 320, 150, 50, false);
			g.setColor(Color.DARK_GRAY);
			g.fill3DRect(350, 250, 150, 50, false);
			g.fill3DRect(350, 390, 150, 50, false);

			g.setColor(Color.black);
			g.drawString(reset, 395, 350);
			g.setColor(Color.white);
			g.drawString(nwgame, 395, 275);
			g.drawString(quit, 400, 415);
		} else {
			g.setColor(Color.green);
			g.fill3DRect(350, 390, 150, 50, false);
			g.setColor(Color.DARK_GRAY);
			g.fill3DRect(350, 250, 150, 50, false);
			g.fill3DRect(350, 320, 150, 50, false);

			g.setColor(Color.black);
			g.drawString(quit, 400, 415);
			g.setColor(Color.white);
			g.drawString(nwgame, 395, 275);
			g.drawString(reset, 395, 350);

		}

		g.setColor(Color.white);
		g.fill3DRect(325, 450, 220, 150, true);
		g.setColor(Color.black);
		g.drawChars(but1.toCharArray(), 0, but1.length(), 335, 475);
		g.drawChars(but2.toCharArray(), 0, but2.length(), 335, 520);
		g.drawChars(but3.toCharArray(), 0, but3.length(), 335, 560);
	}

	private void paintLevelFrame(Graphics g) {
		g.setColor(colorUsed);
		g.fillRoundRect(100, 50, 600, 600, 15, 15);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRoundRect(150, 70, 400, 40, 15, 15);
		g.setColor(Color.black);
		g.setFont(font);
		g.drawString("  -  " + level + "  -  " + timer + "  -  " + score + "  -  ", 170, 95);
		buildBoxes(g, Color.blue);
	}

	private void paintClouds(Graphics g) {
		g.setColor(cloud);
		g.fillPolygon(xArrayUsed, yArrayUsed, nPointUsed);
	}

	private void buildBoxes(Graphics g, Color c) {
		g.setColor(c);
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < cols.length; j++) {
				g.fillRoundRect(rows[i], cols[j], 80, 80, 15, 15);
			}
		}

	}

	private void paintMoon(Graphics g) {
		g.setColor(planet);
		g.fillOval(x, y, width, height);
	}

	private void paintMatch3Graphics(Graphics g) {

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

	private void drawCir(Graphics g, int a, int b) {
		g.setColor(Color.yellow);
		g.fillArc(rows[b] + 15, cols[a] + 15, 50, 50, 0, 360);
	}

	private void drawSqu(Graphics g, int a, int b) {
		g.setColor(Color.red);
		g.fillRect(rows[b] + 15, cols[a] + 15, 50, 50);
	}

	private void drawTri(Graphics g, int a, int b) {

		int[] n = { rows[b] + 15, rows[b] + 70, rows[b] + 37 };
		int[] m = { cols[a] + 17, cols[a] + 17, cols[a] + 65 };

		g.setColor(Color.green);
		g.fillPolygon(n, m, 3);
	}

	private void drawOva(Graphics g, int a, int b) {
		int[] n = { rows[b] + 15, rows[b] + 25, rows[b] + 70, rows[b] + 45, rows[b] + 20 };
		int[] m = { cols[a] + 15, cols[a] + 15, cols[a] + 45, cols[a] + 70, cols[a] + 40 };

		g.setColor(Color.cyan);
		g.fillPolygon(n, m, 5);
	}

	private void drawDia(Graphics g, int a, int b) {
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
