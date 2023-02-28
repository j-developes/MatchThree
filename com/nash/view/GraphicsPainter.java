package com.nash.view;

import java.awt.Graphics;
import java.util.ArrayList;

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
	private ArrayList<ArtJob> ArtInstructionList1 = new ArrayList<ArtJob>();
	private ArrayList<ArtJob> ArtInstructionList2 = new ArrayList<ArtJob>();
	private ArrayList<ArtJob> ArtInstructionList3 = new ArrayList<ArtJob>();
	private ArrayList<ArtJob> ArtInstructionList4 = new ArrayList<ArtJob>();
	private ArrayList<ArtJob> ArtInstructionList5 = new ArrayList<ArtJob>();

	public void startPainting(Graphics g) {
		g.clearRect(0, 0, 800, 800);

		for (int i = 0; i < ArtInstructionList5.size(); i++) {
			ArtInstructionList5.get(i).paintJob(g);
			ArtInstructionList5.remove(i);
		}

		for (int j = 0; j < ArtInstructionList4.size(); j++) {
			ArtInstructionList4.get(j).paintJob(g);
			ArtInstructionList4.remove(j);
		}

		for (int k = 0; k < ArtInstructionList3.size(); k++) {
			ArtInstructionList3.get(k).paintJob(g);
			ArtInstructionList3.remove(k);
		}

		for (int m = 0; m < ArtInstructionList2.size(); m++) {
			ArtInstructionList2.get(m).paintJob(g);
			ArtInstructionList2.remove(m);
		}

		for (int n = 0; n < ArtInstructionList1.size(); n++) {
			ArtInstructionList1.get(n).paintJob(g);
			ArtInstructionList1.remove(n);
		}

	}

	public void addJob(ArtJob parm, int depth) {

		// depth - 5 is background, 1 is front.

		switch (depth) {
		case 5:
			ArtInstructionList5.add(parm);
			break;

		case 4:
			ArtInstructionList4.add(parm);
			break;

		case 3:
			ArtInstructionList3.add(parm);
			break;

		case 2:
			ArtInstructionList2.add(parm);
			break;

		case 1:
			ArtInstructionList1.add(parm);
			break;

		default:
			return;
		}
	}

}
