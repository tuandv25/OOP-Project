package hust.soict.globalict.algorithms;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.globalict.entity.ElementBox;
import hust.soict.globalict.screen.SortFrame;

public class MergeSort extends Sort {
	private int[] oriLocat = new int[15];

	public MergeSort(ElementBox[] elementBoxs, PointRun pointRun, JPanel pnImitiate) {
		super(elementBoxs, pointRun, pnImitiate);
		// TODO Auto-generated constructor stub
	}

	public void addCode() {
		instruction.model.addElement("void MergeSort(int left, int right) {");
		instruction.model.addElement("    if (left < right) {");
		instruction.model.addElement("        int mid = (left + right) / 2;");
		instruction.model.addElement("        MergeSort(left, mid);");
		instruction.model.addElement("        MergeSort(mid + 1, right);");
		instruction.model.addElement("        Merge(left, mid, right);");
		instruction.model.addElement("    }");
		instruction.model.addElement("}");
		instruction.model.addElement("public void Merge(int left, int mid, int right) {");
		instruction.model.addElement("    int n1 = mid - left + 1;");
		instruction.model.addElement("    int n2 = right - mid;");
		instruction.model.addElement("    int[] T = new int[n1 + n2];");
		instruction.model.addElement("    int[] L = new int[n1];");
		instruction.model.addElement("    int[] R = new int[n2];");
		instruction.model.addElement("    int i, j, k;");
		instruction.model.addElement("    for (i = 0; i < n1; i ++)");
		instruction.model.addElement("        L[i] = array[left + i];");
		instruction.model.addElement("    for (j = 0; j < n2; j ++)");
		instruction.model.addElement("        R[j] = array[mid + 1 + j];");
		instruction.model.addElement("    i = 0; j = 0;");
		instruction.model.addElement("    k = left;");
		instruction.model.addElement("    while (i < n1 && j < n2) {");
		instruction.model.addElement("        if (L[i] <= R[j]) {");
		instruction.model.addElement("            array[k] = L[i];");
		instruction.model.addElement("            i ++;");
		instruction.model.addElement("        } else {");
		instruction.model.addElement("            array[k] = R[j];");
		instruction.model.addElement("            j ++;");
		instruction.model.addElement("        }");
		instruction.model.addElement("        k ++;");
		instruction.model.addElement("    }");
		instruction.model.addElement("    while (i < n1) {");
		instruction.model.addElement("        array[k] = L[i];");
		instruction.model.addElement("        i ++; k++;");
		instruction.model.addElement("    }");
		instruction.model.addElement("    while (j < n2) {");
		instruction.model.addElement("        array[k] = R[j];");
		instruction.model.addElement("        j ++; k++;");
		instruction.model.addElement("    }");
		instruction.model.addElement("}");
	};

	@Override
	public void sortIncrease(ElementBox[] elementBoxs, PointRun pointRun) {
		this.elementBoxs = elementBoxs;
		this.pointRun = pointRun;
		for (int i = 0; i < elementBoxs.length; i++)
			oriLocat[i] = elementBoxs[i].getLabel().getX();
		MergeSortIncrease(0, elementBoxs.length - 1);
		this.waitEnd();
	}

	public void MergeSortIncrease(int left, int right) {
		this.instruction.highLight(0);
		this.instruction.highLight(1);
		if (left < right) {
			this.instruction.highLight(2);
			int mid = (left + right) / 2;
			MergeSortIncrease(left, mid);
			MergeSortIncrease(mid + 1, right);
			MergeIncrease(left, mid, right);
		}
	}

	public void MergeIncrease(int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;
		int[] T = new int[n1 + n2];
		int[] L = new int[n1];
		int[] R = new int[n2];
		int i, j, k;
		this.instruction.highLight(8);
		this.instruction.highLight(9);
		this.instruction.highLight(10);
		this.instruction.highLight(11);
		this.instruction.highLight(12);
		this.instruction.highLight(13);
		this.instruction.highLight(14);
		this.instruction.highLight(15);
		for (i = 0; i < n1; i++) {
			L[i] = elementBoxs[left + i].getValue();
			this.instruction.highLight(16);
		}
		this.instruction.highLight(17);
		for (j = 0; j < n2; j++) {
			R[j] = elementBoxs[mid + 1 + j].getValue();
			this.instruction.highLight(18);
		}

		setlbPoint(pointRun.getLbPoint1(), left, "i = ");
		setlbPoint(pointRun.getLbPoint2(), mid + 1, "j = ");
		PutUp(left, right);
		i = 0;
		j = 0;
		k = left;
		this.instruction.highLight(19);
		this.instruction.highLight(20);
		while (i < n1 && j < n2) {
			this.instruction.highLight(21);
			setlbPoint(pointRun.getLbPointM(), k, "k = ");
			if (L[i] <= R[j]) {
				this.instruction.highLight(22);
				setlbPoint(pointRun.getLbPoint1(), left + i, "i = ");
				this.instruction.highLight(23);
				elementBoxs[k].setValue(L[i]);
				PutDown(elementBoxs[left + i].getLabel(), oriLocat[k], 150);
				this.instruction.highLight(24);
				i++;
			} else {
				this.instruction.highLight(25);
				setlbPoint(pointRun.getLbPoint2(), mid + 1 + j, "j = ");
				this.instruction.highLight(26);
				elementBoxs[k].setValue(R[j]);
				PutDown(elementBoxs[mid + 1 + j].getLabel(), oriLocat[k], 150);
				this.instruction.highLight(27);
				j++;
			}
			this.instruction.highLight(28);
			this.instruction.highLight(29);
			this.instruction.highLight(30);
			k++;
		}
		while (i < n1) {
			this.instruction.highLight(31);
			setlbPoint(pointRun.getLbPointM(), k, "k = ");
			setlbPoint(pointRun.getLbPoint1(), left + i, "i = ");
			this.instruction.highLight(32);
			elementBoxs[k].setValue(L[i]);
			PutDown(elementBoxs[left + i].getLabel(), oriLocat[k], 150);
			i++;
			k++;
			this.instruction.highLight(33);
			this.instruction.highLight(34);
		}
		while (j < n2) {
			this.instruction.highLight(35);
			setlbPoint(pointRun.getLbPointM(), k, "k = ");
			setlbPoint(pointRun.getLbPoint2(), mid + 1 + j, "j = ");
			this.instruction.highLight(36);
			elementBoxs[k].setValue(R[j]);
			PutDown(elementBoxs[mid + 1 + j].getLabel(), oriLocat[k], 150);
			j++;
			k++;
			this.instruction.highLight(37);
			this.instruction.highLight(38);
			this.instruction.highLight(39);
		}
		for (i = 0; i < n1 + n2; i++)
			T[i] = elementBoxs[left + i].getValue();
		Relocat(left, right, T);
	}

	@Override
	public void sortDecrease(ElementBox[] elementBoxs, PointRun pointRun) {
		this.elementBoxs = elementBoxs;
		this.pointRun = pointRun;
		for (int i = 0; i < elementBoxs.length; i++)
			oriLocat[i] = elementBoxs[i].getLabel().getX();
		MergeSortDecrease(0, elementBoxs.length - 1);
		this.waitEnd();
	}

	public void MergeSortDecrease(int left, int right) {
		this.instruction.highLight(0);
		this.instruction.highLight(1);
		if (left < right) {
			this.instruction.highLight(2);
			int mid = (left + right) / 2;
			MergeSortDecrease(left, mid);
			MergeSortDecrease(mid + 1, right);
			MergeDecrease(left, mid, right);
		}
	}

	public void MergeDecrease(int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;
		int[] T = new int[n1 + n2];
		int[] L = new int[n1];
		int[] R = new int[n2];
		int i, j, k;
		this.instruction.highLight(8);
		this.instruction.highLight(9);
		this.instruction.highLight(10);
		this.instruction.highLight(11);
		this.instruction.highLight(12);
		this.instruction.highLight(13);
		this.instruction.highLight(14);
		this.instruction.highLight(15);
		for (i = 0; i < n1; i++) {
			L[i] = elementBoxs[left + i].getValue();
			this.instruction.highLight(16);
		}

		this.instruction.highLight(17);
		for (j = 0; j < n2; j++) {
			R[j] = elementBoxs[mid + 1 + j].getValue();
			this.instruction.highLight(18);
		}

		setlbPoint(pointRun.getLbPoint1(), left, "i = ");
		setlbPoint(pointRun.getLbPoint2(), mid + 1, "j = ");
		PutUp(left, right);
		i = 0;
		j = 0;
		k = left;
		this.instruction.highLight(19);
		this.instruction.highLight(20);
		while (i < n1 && j < n2) {
			this.instruction.highLight(21);
			setlbPoint(pointRun.getLbPointM(), k, "k = ");
			if (L[i] >= R[j]) {
				this.instruction.highLight(22);
				setlbPoint(pointRun.getLbPoint1(), left + i, "i = ");
				this.instruction.highLight(23);
				elementBoxs[k].setValue(L[i]);
				PutDown(elementBoxs[left + i].getLabel(), oriLocat[k], 150);
				this.instruction.highLight(24);
				i++;
			} else {
				this.instruction.highLight(25);
				setlbPoint(pointRun.getLbPoint2(), mid + 1 + j, "j = ");
				this.instruction.highLight(26);
				elementBoxs[k].setValue(R[j]);
				PutDown(elementBoxs[mid + 1 + j].getLabel(), oriLocat[k], 150);
				this.instruction.highLight(27);
				j++;
			}
			this.instruction.highLight(28);
			this.instruction.highLight(29);
			this.instruction.highLight(30);
			k++;
		}
		while (i < n1) {
			this.instruction.highLight(31);
			setlbPoint(pointRun.getLbPointM(), k, "k = ");
			setlbPoint(pointRun.getLbPoint1(), left + i, "i = ");
			this.instruction.highLight(32);
			elementBoxs[k].setValue(L[i]);
			PutDown(elementBoxs[left + i].getLabel(), oriLocat[k], 150);
			i++;
			k++;
			this.instruction.highLight(32);
			this.instruction.highLight(34);
		}
		while (j < n2) {
			this.instruction.highLight(35);
			setlbPoint(pointRun.getLbPointM(), k, "k = ");
			setlbPoint(pointRun.getLbPoint2(), mid + 1 + j, "j = ");
			this.instruction.highLight(36);
			elementBoxs[k].setValue(R[j]);
			PutDown(elementBoxs[mid + 1 + j].getLabel(), oriLocat[k], 150);
			j++;
			k++;
			this.instruction.highLight(37);
			this.instruction.highLight(38);
			this.instruction.highLight(39);
		}
		for (i = 0; i < n1 + n2; i++)
			T[i] = elementBoxs[left + i].getValue();
		Relocat(left, right, T);
	}

	public void PutUp(int left, int right) {
		Sort.curT++;
		int cur = Sort.curT;
		Thread[] threads = Sort.threads;
		threads[cur] = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					if (cur != 0)
						threads[cur - 1].join();
					int mid = (left + right) / 2;
					for (int i = left; i <= right; i++) {
						if (i < mid + 1)
							((ElementBox) elementBoxs[i]).setBackground(new Color(153, 255, 153));
						else
							((ElementBox) elementBoxs[i]).setBackground(new Color(255, 255, 153));
					}
					while (elementBoxs[right].getLabel().getY() > 50) {
						for (int i = left; i <= right; i++) {
							if (elementBoxs[i].getLabel().getY() > 50)
								elementBoxs[i].getLabel().setLocation(elementBoxs[i].getLabel().getX(),
										elementBoxs[i].getLabel().getY() - 10);
						}
						Thread.sleep(SortFrame.time);
					}
				} catch (Exception e) {
				}
			}
		});
		threads[cur].start();
	}

	public void PutDown(JLabel lb1, int x, int y) {
		Sort.curT++;
		int cur = Sort.curT;
		Thread[] threads = Sort.threads;
		threads[cur] = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					if (cur != 0) {
						threads[cur - 1].join();
					}
					int x1 = lb1.getX();
					lb1.setBackground(processingColor);
					while (lb1.getY() < 100) {
						lb1.setLocation(x1, lb1.getY() + 10);
						Thread.sleep(SortFrame.time);
					}
					int y1 = lb1.getY();
					if (x1 < x) {
						while (lb1.getX() < x) {
							lb1.setLocation(lb1.getX() + 10, y1);
							Thread.sleep(SortFrame.time);
						}
						while (lb1.getY() < y) {
							lb1.setLocation(x, lb1.getY() + 10);
							Thread.sleep(SortFrame.time);
						}
					} else {
						while (lb1.getX() > x) {
							lb1.setLocation(lb1.getX() - 10, y1);
							Thread.sleep(SortFrame.time);
						}
						while (lb1.getY() < y) {
							lb1.setLocation(x, lb1.getY() + 10);
							Thread.sleep(SortFrame.time);
						}
					}
					lb1.setBackground(SystemColor.green);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		threads[cur].start();
	}

	public void Relocat(int left, int right, int[] T) {
		Sort.curT++;
		int cur = Sort.curT;
		Thread[] threads = Sort.threads;
		threads[cur] = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					if (cur != 0)
						threads[cur - 1].join();
					for (int i = left; i <= right; i++) {
						if (elementBoxs[i].getLabel().getX() != oriLocat[i]) {
							elementBoxs[i].getLabel().setLocation(oriLocat[i], 150);
							elementBoxs[i].getLabel().setText(T[i - left] + "");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		threads[cur].start();
	}

	public void setlbPoint(JLabel lbPoint, int i, String s) {
		Sort.curT++;
		int cur = Sort.curT;
		Thread[] threads = Sort.threads;
		threads[cur] = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					if (cur != 0)
						threads[cur - 1].join();
					if (lbPoint == pointRun.getLbPointM()) {
						lbPoint.setLocation(oriLocat[i], 200);
						lbPoint.setText(s + i);
					} else {
						lbPoint.setLocation(elementBoxs[i].getLabel().getX(), 250);
						lbPoint.setText(s + i);
					}
				} catch (Exception e) {
				}
			}
		});
		threads[cur].start();
	}

}
