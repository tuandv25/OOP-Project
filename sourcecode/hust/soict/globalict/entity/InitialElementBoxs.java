package hust.soict.globalict.entity;

import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import hust.soict.globalict.algorithms.PointRun;
import hust.soict.globalict.algorithms.Sort;

public class InitialElementBoxs extends ElementBoxs {

	// Constructor --> create array
	public InitialElementBoxs(JPanel pnImitiate, JSpinner spNum, ElementBox[] elementBoxs, PointRun pointRun,
			int yLocation) {
		super(pnImitiate, (Integer) spNum.getValue(), elementBoxs, pointRun, yLocation);
		setPnImitiate(pnImitiate);
		// Delete older array
		deleteArray();
		// Get number
		num = (Integer) spNum.getValue();
		elementBoxs = new ElementBox[num];

		for (int i = 0; i < num; i++) {
			// Create element box
			elementBoxs[i] = new ElementBox();
			elementBoxs[i].setBackground(SystemColor.green);
			pnImitiate.add(elementBoxs[i].getLabel());
			// set location label
			if (i == 0)
				elementBoxs[i].getLabel().setLocation((16 - num) * 35, yLocation);
			else
				elementBoxs[i].getLabel().setLocation(elementBoxs[i - 1].getLabel().getX() + 70, yLocation);
		}
		setElementBoxs(elementBoxs);
		pnImitiate.add(pointRun.getLbPoint1());
		pnImitiate.add(pointRun.getLbPoint2());
		pnImitiate.add(pointRun.getLbPointM());

		pnImitiate.setVisible(true);
		pnImitiate.validate();
		pnImitiate.repaint();
	}

	public void deleteArray() {
		// Delete all component of pnImitiate
		pnImitiate.removeAll();
		// Interrupt all threads
		for (int i = 0; i < Sort.curT; i++) {
			if (Sort.threads[i].isAlive()) {
				try {
					Sort.threads[i].interrupt();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		Sort.curT = -1;

		pnImitiate.revalidate();
		pnImitiate.repaint();
	}

	public void createRandom(int max) {
		Random rand = new Random();
		for (int i = 0; i < num; i++) {
			int ranNum = rand.nextInt(max) + 0;
			elementBoxs[i].getLabel().setText(String.valueOf(ranNum));
			elementBoxs[i].setValue(ranNum);
		}
		pnImitiate.setVisible(true);
		pnImitiate.validate();
		pnImitiate.repaint();
	}

	public void setZero() {
		for (int i = 0; i < num; i++) {
			elementBoxs[i].setText("0");
			elementBoxs[i].setValue(0);
		}

		for (int i = 0; i < Sort.curT; i++) {
			if (Sort.threads[i].isAlive()) {
				try {
					Sort.threads[i].interrupt();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		this.pnImitiate.revalidate();
		this.pnImitiate.repaint();
	}

	public void createHand() {
		// GUI enter elements of array
		JButton btnOK;
		JSpinner[] txtArrays = new JSpinner[num];
		JLabel[] lbArrays = new JLabel[num];

		JFrame arrayInput = new JFrame();
		arrayInput.setTitle("Input the array");
		arrayInput.setBounds(100, 100, 504, 312);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		arrayInput.setContentPane(contentPane);
		contentPane.setLayout(null);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		arrayInput.setLocation(dim.width / 2 - arrayInput.getSize().width / 2,
				dim.height / 2 - arrayInput.getSize().height / 2);
		for (int i = 0; i < num; i++) {
			lbArrays[i] = new JLabel("A[" + i + "]:");
			SpinnerModel smValue = new SpinnerNumberModel(0, 0, 100, 1);
			txtArrays[i] = new JSpinner(smValue);
			JFormattedTextField txt = ((JSpinner.NumberEditor) txtArrays[i].getEditor()).getTextField();
			((NumberFormatter) txt.getFormatter()).setAllowsInvalid(false);
			contentPane.add(lbArrays[i]);
			contentPane.add(txtArrays[i]);
			lbArrays[i].setSize(40, 30);
			if (i == 0 || i == 5 || i == 10)
				lbArrays[i].setLocation(150 * (i + 1) / 5, 30);
			else
				lbArrays[i].setLocation(lbArrays[i - 1].getX(), lbArrays[i - 1].getY() + 40);
			txtArrays[i].setSize(50, 30);
			txtArrays[i].setLocation(lbArrays[i].getX() + 40, lbArrays[i].getY());
		}
		contentPane.setVisible(true);
		contentPane.validate();
		contentPane.repaint();

		btnOK = new JButton("Confirm");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < num; i++) {
					elementBoxs[i].setValue((int) txtArrays[i].getValue());
					elementBoxs[i].setText(String.valueOf(elementBoxs[i].getValue()));
				}
				pnImitiate.setVisible(true);
				pnImitiate.validate();
				pnImitiate.repaint();
				JOptionPane.showMessageDialog(arrayInput, "Initialize the array data successfully");
				arrayInput.dispatchEvent(new WindowEvent(arrayInput, WindowEvent.WINDOW_CLOSING));
			}
		});
		btnOK.setBackground(SystemColor.activeCaption);
		btnOK.setBounds(185, 237, 120, 25);
		contentPane.add(btnOK);
		arrayInput.setVisible(true);
	}

}
