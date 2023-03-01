package com.nash.view;

import java.awt.Graphics;
import java.util.ArrayList;
import com.nash.art.ArtGun;

/**
 * 
 * @author John Nash
 * 
 *         GraphicsPainter manages the ArtJobs that are added each time PSced
 *         updates. The jobs are painted when repaint is issued by Clock. The
 *         jobs are painted in the order of their depth.
 * 
 *         depth 1 is closest and depth 5 is far away.
 */
public class GraphicsPainter {

	// List5 background, List1 front
	private ArtGun AGun = new ArtGun();
	private ArrayList<String> ArtInstructionList1 = new ArrayList<String>();
	private ArrayList<String> ArtInstructionList2 = new ArrayList<String>();
	private ArrayList<String> ArtInstructionList3 = new ArrayList<String>();
	private ArrayList<String> ArtInstructionList4 = new ArrayList<String>();
	private ArrayList<String> ArtInstructionList5 = new ArrayList<String>();

	public void startPainting(Graphics g) {
		g.clearRect(0, 0, 800, 800);

		for (int i = 0; i < ArtInstructionList5.size(); i++) {
			g = AGun.fireArt(ArtInstructionList5.get(i), g);
			ArtInstructionList5.remove(i);
		}

		for (int j = 0; j < ArtInstructionList4.size(); j++) {
			int uh = ArtInstructionList4.size();
			g = AGun.fireArt(ArtInstructionList4.get(j), g);
			ArtInstructionList4.remove(j);
		}

		for (int k = 0; k < ArtInstructionList3.size(); k++) {
			g = AGun.fireArt(ArtInstructionList3.get(k), g);
			ArtInstructionList3.remove(k);
		}

		for (int m = 0; m < ArtInstructionList2.size(); m++) {
			g = AGun.fireArt(ArtInstructionList2.get(m), g);
			ArtInstructionList2.remove(m);
		}

		for (int n = 0; n < ArtInstructionList1.size(); n++) {
			g = AGun.fireArt(ArtInstructionList1.get(n), g);
			ArtInstructionList1.remove(n);
		}

	}

	public void addJob(String param, int depth) {

		// depth - 5 is background, 1 is front.

		switch (depth) {
		case 5:
			ArtInstructionList5.add(param);
			break;

		case 4:
			ArtInstructionList4.add(param);
			break;

		case 3:
			ArtInstructionList3.add(param);
			break;

		case 2:
			ArtInstructionList2.add(param);
			break;

		case 1:
			ArtInstructionList1.add(param);
			break;

		default:
			return;
		}
	}

	public void addJob(String[][] entireUpdate) {

		// [0][0] == param   [0][1] == depth

		for (int i = 0; i < entireUpdate.length; i++) {

			int depth = Integer.parseInt(entireUpdate[i][1]);
			switch (depth) {
			case 5:
				ArtInstructionList5.add(entireUpdate[i][0]);
				break;

			case 4:
				ArtInstructionList4.add(entireUpdate[i][0]);
				break;

			case 3:
				ArtInstructionList3.add(entireUpdate[i][0]);
				break;

			case 2:
				ArtInstructionList2.add(entireUpdate[i][0]);
				break;

			case 1:
				ArtInstructionList1.add(entireUpdate[i][0]);
				break;

			default:
				return;
			}
		}
	}

}
