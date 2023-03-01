package com.nash.art;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class PaintMenu {
	
	private static String nwgame = "New Game";
	private static String reset = "Reset";
	private static String quit = "Quit";
	private static String but1 = "Select:              Enter";
	private static String but2 = "Movement:    click & drag";
	private static String but3 = "Menu:              Escape";
	private static int cursorUsed = 0;
	private static Font fontused = new Font("Verdana", Font.BOLD, 14);

	
	public static void paintJob(Graphics g) {
		g.setColor(Color.gray);
		g.fill3DRect(300, 200, 400, 400, false);

		g.setFont(fontused);
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
	
	public void setSettings(int cursor) {
		cursorUsed = cursor;
	}
	
	public void setNwgame(String s) {
		nwgame = s;
	}

}
