package hust.soict.globalict.algorithms;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.globalict.entity.ElementBox;

public abstract class Sort {
	public static int curT = -1;
	public static Thread[] threads = new Thread[1000000];
	public Color processingColor = new Color(255, 153, 153);
	public Instruction instruction = new Instruction();
	public ElementBox[] elementBoxs;
	public PointRun pointRun;
	public JPanel pnImitiate;

	public void setPnImitiate(JPanel pnImitiate) {
		this.pnImitiate = pnImitiate;
	}

	public void setelementBoxs(ElementBox[] elementBoxs) {
		this.elementBoxs = elementBoxs;
	}

	public Sort(ElementBox[] elementBoxs, PointRun pointRun, JPanel pnImitiate) {
		this.elementBoxs = elementBoxs;
		this.pointRun = pointRun;
		this.pnImitiate = pnImitiate;
	}

	public void waitEnd() {
		curT++;
		int cur = curT;
		threads[cur] = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					if (cur != 0) {
						threads[cur - 1].join();
					}
					JOptionPane.showMessageDialog(null, "ARRAY HAS BEEN SORTED", "DONE",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		threads[cur].start();
	}

	public abstract void addCode();

	public abstract void sortIncrease(ElementBox[] elementBoxs, PointRun pointRun);

	public abstract void sortDecrease(ElementBox[] elementBoxs, PointRun pointRun);
}
