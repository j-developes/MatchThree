package com.nash.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * 
 * @author John Nash
 * 
 *         GamePanel extends JPanel in order to override paintComponent. This
 *         allows @GraphicalPainter to use the Graphics object.
 * 
 */

@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	public Canvas Screen = new Canvas();
	public GraphicsPainter Artist = new GraphicsPainter();

	GamePanel() {
		Screen.setBackground(Color.black);
		add(Screen);
	}

	@Override
	protected void paintComponent(Graphics g) {

		Artist.startPainting(g);

	}

}
