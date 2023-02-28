package com.nash.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * 
 * @author John Nash
 * 
 *         View is the JFrame that is initialized and adds GamePanel, the
 *         extended JPanel that utilizes a Canvas.
 */
public class View {

	public JFrame Root;
	public GamePanel ModifiedPanel;
	private ImageIcon ic = new ImageIcon(this.getClass().getResource("match3.png"));

	public View() {
		Root = new JFrame("Match Three!");
		Root.setUndecorated(true);
		Root.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Root.setSize(800, 800);
		Root.setBackground(Color.black);
		ModifiedPanel = new GamePanel();
		Root.add(ModifiedPanel);
		Root.setIconImage(ic.getImage());
	}

	public void startWindow() {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {

				Root.setVisible(true);

			}

		});
	}

}
