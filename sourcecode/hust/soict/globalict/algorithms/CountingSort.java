package hust.soict.globalict.algorithms;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.globalict.entity.ElementBox;
import hust.soict.globalict.entity.ElementBoxs;
import hust.soict.globalict.screen.SortFrame;

public class CountingSort extends Sort {
    public CountingSort(ElementBox[] elementBoxs, PointRun pointRun, JPanel pnImitiate) {
        super(elementBoxs, pointRun, pnImitiate);
        // TODO Auto-generated constructor stub
    }

    private ElementBox[] countBoxs;
    private ElementBox[] outputBoxs;

    @Override
    public void addCode() {
        instruction.model.addElement("void CountingSort(int a[], int n) {");
        instruction.model.addElement("     int output[] = new int[n];");
        instruction.model.addElement("     int count[] = new int[10];");
        instruction.model.addElement("     for (int i = 0; i < 10; i++)");
        instruction.model.addElement("         count[i] = 0;");
        instruction.model.addElement("     for (int i = 0; i < n; i++)");
        instruction.model.addElement("         ++count[a[i]];");
        instruction.model.addElement("     for (int i = 1; i < 10; i++)");
        instruction.model.addElement("         count[i] += count[i - 1];");
        instruction.model.addElement("     for (int i = n - 1; i >= 0; i--) {");
        instruction.model.addElement("         output[count[a[i]] - 1] = a[i];");
        instruction.model.addElement("         --count[a[i]];");
        instruction.model.addElement("     }");
        instruction.model.addElement("     for(int i = 0; i < n; i++) ");
        instruction.model.addElement("         a[i] = output[i];");
        instruction.model.addElement("}");
    }

    @Override
    public void sortIncrease(ElementBox[] elementBoxs, PointRun pointRun) {
        this.elementBoxs = elementBoxs;
        this.pointRun = pointRun;
        int n = elementBoxs.length;
        // create countBOX
        JLabel Label1 = new JLabel("Counting Array:");
        Label1.setFont(new Font("Tahoma", Font.BOLD, 15));
        Label1.setBounds(30, 230, 600, 20);
        pnImitiate.add(Label1);
        countBoxs = (new ElementBoxs(pnImitiate, 10, countBoxs, pointRun, 250)).getElementBoxs();
        // create outputBOX
        JLabel Label2 = new JLabel("Output Array:");
        Label2.setFont(new Font("Tahoma", Font.BOLD, 15));
        Label2.setBounds(30, 330, 600, 20);
        pnImitiate.add(Label2);
        outputBoxs = (new ElementBoxs(pnImitiate, n, countBoxs, pointRun, 350)).getElementBoxs();
        this.instruction.highLight(0);
        this.instruction.highLight(1);
        this.instruction.highLight(2);
        for (int i = 0; i < 10; ++i) {
            this.instruction.highLight(3);
            this.instruction.highLight(4);
        }
        for (int i = 0; i < n; i++) {
            this.instruction.highLight(5);
            setValueCountBox(pointRun.getLbPoint1(), i, "i = ");
            this.instruction.highLight(6);
        }
        for (int i = 1; i < 10; i++) {
            this.instruction.highLight(7);
            updateValueCountBoxASC(pointRun.getLbPoint1(), i, "i = ");
            this.instruction.highLight(8);
        }
        // Build the output character array
        // To make it stable we are operating in reverse order.
        for (int i = 0; i < n; i++) {
            this.instruction.highLight(9);
            printToOutputBox(pointRun.getLbPoint1(), i, "i = ");
            this.instruction.highLight(10);
            this.instruction.highLight(11);
            this.instruction.highLight(12);

        }
        this.instruction.highLight(13);
        this.instruction.highLight(14);
        this.instruction.highLight(15);
        this.waitEnd();
    }

    @Override
    public void sortDecrease(ElementBox[] elementBoxs, PointRun pointRun) {
        this.elementBoxs = elementBoxs;
        this.pointRun = pointRun;
        int n = elementBoxs.length;
        // create indexBOX
        JLabel Label1 = new JLabel("Counting Array:");
        Label1.setFont(new Font("Tahoma", Font.BOLD, 15));
        Label1.setBounds(30, 230, 600, 20);
        pnImitiate.add(Label1);
        countBoxs = (new ElementBoxs(pnImitiate, 10, countBoxs, pointRun, 250)).getElementBoxs();
        // create outputBOX
        JLabel Label2 = new JLabel("Output Array:");
        Label2.setFont(new Font("Tahoma", Font.BOLD, 15));
        Label2.setBounds(30, 330, 600, 20);
        pnImitiate.add(Label2);
        outputBoxs = (new ElementBoxs(pnImitiate, n, outputBoxs, pointRun, 350)).getElementBoxs();
        this.instruction.highLight(0);
        this.instruction.highLight(1);
        this.instruction.highLight(2);
        for (int i = 0; i < 10; ++i) {
            this.instruction.highLight(3);
            this.instruction.highLight(4);
        }
        for (int i = 0; i < n; i++) {
            this.instruction.highLight(5);
            setValueCountBox(pointRun.getLbPoint1(), i, "i = ");
            this.instruction.highLight(6);
        }
        for (int i = 8; i >= 0; i--) {
            this.instruction.highLight(7);
            updateValueCountBoxDESC(pointRun.getLbPoint1(), i, "i = ");
            this.instruction.highLight(8);
        }
        // Build the output character array
        // To make it stable we are operating in reverse order.
        for (int i = 0; i < n; i++) {
            this.instruction.highLight(9);
            printToOutputBox(pointRun.getLbPoint1(), i, "i = ");
            this.instruction.highLight(10);
            this.instruction.highLight(11);
            this.instruction.highLight(12);
        }
        this.instruction.highLight(13);
        this.instruction.highLight(14);
        this.instruction.highLight(15);
        this.waitEnd();
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
                    lbPoint.setLocation(elementBoxs[i].getLabel().getX(), 150);
                    elementBoxs[i].setBackground(SystemColor.pink);
                    int value = elementBoxs[i].getValue();
                    int count = countBoxs[value].getValue();
                    count++;
                    countBoxs[value].setValue(count);
                    countBoxs[value].setText(String.valueOf(count));
                    count--;
                    lbPoint.setText("-");
                    Thread.sleep(SortFrame.time * 4);
                    elementBoxs[i].setBackground(SystemColor.green);
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
                    int value1 = countBoxs[i - 1].getValue();
                    int value2 = countBoxs[i].getValue();
                    int value3 = value1 + value2;
                    countBoxs[i].setValue(value3);
                    lbPoint.setLocation(countBoxs[i].getLabel().getX(), 300);
                    countBoxs[i].setText(String.valueOf(value3));
                    lbPoint.setText(s + i);
                    Thread.sleep(SortFrame.time * 4);
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }

    public void printToOutputBox(JLabel lbPoint, int i, String s) {
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
                    lbPoint.setLocation(outputBoxs[i].getLabel().getX(), 400);
                    elementBoxs[i].setBackground(SystemColor.pink);
                    int value = elementBoxs[i].getValue();
                    int value1 = countBoxs[value].getValue() - 1;
                    outputBoxs[value1].setValue(value);
                    outputBoxs[value1].setText(String.valueOf(value));
                    countBoxs[value].setValue(value1);
                    countBoxs[value].setText(String.valueOf(value1));
                    lbPoint.setText(s + i);
                    Thread.sleep(SortFrame.time * 4);
                    elementBoxs[i].setBackground(SystemColor.green);
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
                    int value1 = countBoxs[i + 1].getValue();
                    int value2 = countBoxs[i].getValue();
                    int value3 = value1 + value2;
                    countBoxs[i].setValue(value3);
                    lbPoint.setLocation(countBoxs[i].getLabel().getX(), 300);
                    countBoxs[i].setText(String.valueOf(value3));
                    lbPoint.setText(s + i);
                    Thread.sleep(SortFrame.time * 4);
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }
}
