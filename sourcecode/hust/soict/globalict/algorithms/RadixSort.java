package hust.soict.globalict.algorithms;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.globalict.entity.ElementBox;
import hust.soict.globalict.entity.ElementBoxs;
import hust.soict.globalict.screen.SortFrame;

public class RadixSort extends Sort {
	public RadixSort(ElementBox[] elementBoxs, PointRun pointRun, JPanel pnImitiate) {
		super(elementBoxs, pointRun, pnImitiate);
		// TODO Auto-generated constructor stub
	}

	private ElementBox[] indexBoxs;
	private ElementBox[] countBoxs;
	private ElementBox[] radixBoxs;
	private int memory[];

	@Override
	public void addCode() {
		instruction.model.addElement("void RadixSort(int a[],int n) {");
		instruction.model.addElement("    int max = a[0];");
		instruction.model.addElement("    for (int i = 0; i < n; i++) {");
		instruction.model.addElement("        if (a[i] > max) max = a[i];");
		instruction.model.addElement("    for (int exp = 1; max / exp > 0; exp *= 10){");
		instruction.model.addElement("        int i;");
		instruction.model.addElement("        int output[] = new int[n];");
		instruction.model.addElement("        int count[] = new int[10];");
		instruction.model.addElement("        for (i = 0; i < 10; i++)");
		instruction.model.addElement("            count[i] = 0;");
		instruction.model.addElement("        for (i = 0; i < n; i++)");
		instruction.model.addElement("            count[(a[i] / exp) % 10]++;");
		instruction.model.addElement("        for (i = 1; i < 10; i++)");
		instruction.model.addElement("            count[i] += count[i - 1];");
		instruction.model.addElement("        for (i = n - 1; i >= 0; i--) {");
		instruction.model.addElement("            output[count[(a[i]/exp)%10]-1]=a[i];");
		instruction.model.addElement("            count[(a[i] / exp) % 10]--;");
		instruction.model.addElement("        }");
		instruction.model.addElement("    for (int i = 0; i < n; i++)");
		instruction.model.addElement("         a[i] = output[i];");
		instruction.model.addElement("    }");
	}

	@Override
	public void sortIncrease(ElementBox[] elementBoxs, PointRun pointRun) {
		this.elementBoxs = elementBoxs;
		this.pointRun = pointRun;
		int n = elementBoxs.length;
		// create indexBOX
		JLabel Label1 = new JLabel("Digit Array:");
		Label1.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label1.setBounds(30, 230, 600, 20);
		pnImitiate.add(Label1);
		indexBoxs = (new ElementBoxs(pnImitiate, n, indexBoxs, pointRun, 250)).getElementBoxs();
		// create countBOX
		JLabel Label2 = new JLabel("Counting Array:");
		Label2.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label2.setBounds(30, 330, 600, 20);
		pnImitiate.add(Label2);
		countBoxs = (new ElementBoxs(pnImitiate, 10, countBoxs, pointRun, 350)).getElementBoxs();
		// create radixBOX
		JLabel Label3 = new JLabel("Output Array (Each loop):");
		Label3.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label3.setBounds(30, 430, 600, 20);
		pnImitiate.add(Label3);
		radixBoxs = (new ElementBoxs(pnImitiate, n, radixBoxs, pointRun, 450)).getElementBoxs();
		// create array memory
		memory = new int[n];
		int max = elementBoxs[0].getValue();
		for (int i = 0; i < n; i++) {
			if (elementBoxs[i].getValue() > max)
				max = elementBoxs[i].getValue();
		}
		this.instruction.highLight(0);
		this.instruction.highLight(1);
		this.instruction.highLight(2);
		this.instruction.highLight(3);
		for (int exp = 1; max / exp > 0; exp *= 10) {

			for (int i = 0; i < n; i++) {
				getDigits(pointRun.getLbPoint1(), i, "i = ", exp);
			}
			//
			this.instruction.highLight(4);
			this.instruction.highLight(5);
			this.instruction.highLight(6);
			this.instruction.highLight(7);

			for (int i = 0; i < 10; ++i) {
				this.instruction.highLight(8);
				resetCountBox(pointRun.getLbPoint1(), i, "");
				this.instruction.highLight(9);
			}
			for (int i = 0; i < n; i++) {
				this.instruction.highLight(10);
				setValueCountBox(pointRun.getLbPoint1(), i, "i = ");
				this.instruction.highLight(11);
			}
			for (int i = 1; i < 10; i++) {
				this.instruction.highLight(12);
				updateValueCountBoxASC(pointRun.getLbPoint1(), i, "i = ");
				this.instruction.highLight(13);
			}
			// Build the output character array
			// To make it stable we are operating in reverse order.
			for (int i = n - 1; i >= 0; i--) {
				this.instruction.highLight(14);
				printToRadixBox(pointRun.getLbPoint1(), i, "i = ");
				this.instruction.highLight(15);
				this.instruction.highLight(16);
				this.instruction.highLight(17);
			}
		}
		this.instruction.highLight(18);
		this.instruction.highLight(19);
		this.instruction.highLight(20);
		this.waitEnd();
	}

	@Override
	public void sortDecrease(ElementBox[] elementBoxs, PointRun pointRun) {
		this.elementBoxs = elementBoxs;
		this.pointRun = pointRun;
		int n = elementBoxs.length;
		// create indexBOX
		JLabel Label1 = new JLabel("Digit Array:");
		Label1.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label1.setBounds(30, 230, 600, 20);
		pnImitiate.add(Label1);
		indexBoxs = (new ElementBoxs(pnImitiate, n, indexBoxs, pointRun, 250)).getElementBoxs();
		// create countBOX
		JLabel Label2 = new JLabel("Counting Array:");
		Label2.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label2.setBounds(30, 330, 600, 20);
		pnImitiate.add(Label2);
		countBoxs = (new ElementBoxs(pnImitiate, 10, countBoxs, pointRun, 350)).getElementBoxs();
		// create radixBOX
		JLabel Label3 = new JLabel("Output Array (Each loop):");
		Label3.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label3.setBounds(30, 430, 600, 20);
		pnImitiate.add(Label3);
		radixBoxs = (new ElementBoxs(pnImitiate, n, radixBoxs, pointRun, 450)).getElementBoxs();
		// create array memory
		memory = new int[n];
		int max = elementBoxs[0].getValue();
		for (int i = 0; i < n; i++) {
			if (elementBoxs[i].getValue() > max)
				max = elementBoxs[i].getValue();
		}
		this.instruction.highLight(0);
		this.instruction.highLight(1);
		this.instruction.highLight(2);
		this.instruction.highLight(3);
		for (int exp = 1; max / exp > 0; exp *= 10) {

			for (int i = 0; i < n; i++) {
				getDigits(pointRun.getLbPoint1(), i, "i = ", exp);
			}
			//
			this.instruction.highLight(4);
			this.instruction.highLight(5);
			this.instruction.highLight(6);
			this.instruction.highLight(7);
			for (int i = 0; i < 10; ++i) {
				this.instruction.highLight(8);
				resetCountBox(pointRun.getLbPoint1(), i, "");
				this.instruction.highLight(9);
			}
			for (int i = 0; i < n; i++) {
				this.instruction.highLight(10);
				setValueCountBox(pointRun.getLbPoint1(), i, "i = ");
				this.instruction.highLight(11);
			}
			for (int i = 8; i >= 0; i--) {
				this.instruction.highLight(12);
				updateValueCountBoxDESC(pointRun.getLbPoint1(), i, "i = ");
				this.instruction.highLight(13);
			}
			// Build the output character array
			// To make it stable we are operating in reverse order.
			for (int i = n - 1; i >= 0; i--) {
				this.instruction.highLight(14);
				printToRadixBox(pointRun.getLbPoint1(), i, "i = ");
				this.instruction.highLight(15);
				this.instruction.highLight(16);
				this.instruction.highLight(17);

			}
		}
		this.instruction.highLight(18);
		this.instruction.highLight(19);
		this.instruction.highLight(20);
		this.waitEnd();
	}

	public void getDigits(JLabel lbPoint, int i, String s, int exp) {
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
					lbPoint.setLocation(elementBoxs[i].getLabel().getX(), 150);
					elementBoxs[i].setBackground(SystemColor.yellow);
					memory[i] = elementBoxs[i].getValue();
					int value = (elementBoxs[i].getValue() / exp) % 10;
					indexBoxs[i].setValue(value);
					indexBoxs[i].setText(String.valueOf(value));
					lbPoint.setText("-");
					Thread.sleep(SortFrame.time * 4);
					elementBoxs[i].setBackground(SystemColor.green);
				} catch (Exception e) {
				}
			}
		});
		threads[cur].start();
	}

	public void setValueCountBox(JLabel lbPoint, int i, String s) {
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
					lbPoint.setLocation(indexBoxs[i].getLabel().getX(), 300);
					indexBoxs[i].setBackground(SystemColor.pink);
					int value = indexBoxs[i].getValue();
					int count = countBoxs[value].getValue();
					count++;
					countBoxs[value].setValue(count);
					countBoxs[value].setText(String.valueOf(count));
					count--;
					lbPoint.setText(s + i);
					Thread.sleep(SortFrame.time * 4);
					indexBoxs[i].setBackground(SystemColor.inactiveCaption);
				} catch (Exception e) {
				}
			}
		});
		threads[cur].start();
	}

	public void updateValueCountBoxASC(JLabel lbPoint, int i, String s) {
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
					lbPoint.setLocation(countBoxs[i].getLabel().getX(), 400);
					int value1 = countBoxs[i - 1].getValue();
					int value2 = countBoxs[i].getValue();
					int value3 = value1 + value2;
					countBoxs[i].setValue(value3);
					countBoxs[i].setText(String.valueOf(value3));
					lbPoint.setText(s + i);
					Thread.sleep(SortFrame.time * 4);
				} catch (Exception e) {
				}
			}
		});
		threads[cur].start();
	}

	public void printToRadixBox(JLabel lbPoint, int i, String s) {
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
					lbPoint.setLocation(radixBoxs[i].getLabel().getX(), 500);
					int value = indexBoxs[i].getValue();
					int value1 = countBoxs[value].getValue() - 1;
					radixBoxs[value1].setValue(value);
					radixBoxs[value1].setText(String.valueOf(value));
					countBoxs[value].setValue(value1);
					countBoxs[value].setText(String.valueOf(value1));
					// update elementBoxs
					int value2 = memory[i];
					elementBoxs[value1].setValue(value2);
					elementBoxs[value1].setText(String.valueOf(value2));
					lbPoint.setText(s + i);
					Thread.sleep(SortFrame.time * 4);
				} catch (Exception e) {
				}
			}
		});
		threads[cur].start();
	}

	public void updateValueCountBoxDESC(JLabel lbPoint, int i, String s) {
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
					lbPoint.setLocation(countBoxs[i].getLabel().getX(), 400);
					int value1 = countBoxs[i + 1].getValue();
					int value2 = countBoxs[i].getValue();
					int value3 = value1 + value2;
					countBoxs[i].setValue(value3);
					countBoxs[i].setText(String.valueOf(value3));
					lbPoint.setText(s + i);
					Thread.sleep(SortFrame.time * 4);
				} catch (Exception e) {
				}
			}
		});
		threads[cur].start();
	}

	public void resetCountBox(JLabel lbPoint, int i, String s) {
		Sort.curT++;
		int cur = Sort.curT;
		Thread[] threads = Sort.threads;
		threads[cur] = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					if (cur != 0)
						threads[cur - 1].join();
					lbPoint.setLocation(countBoxs[i].getLabel().getX(), 600);
					countBoxs[i].setValue(0);
					countBoxs[i].setText(String.valueOf(0));
					lbPoint.setText("");
					Thread.sleep(SortFrame.time / 10);
				} catch (Exception e) {
				}
			}
		});
		threads[cur].start();
	}
}
