package hust.soict.globalict.algorithms;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PointRun {
	JLabel lbPoint1, lbPoint2, lbPointM;

	public JLabel getLbPoint1() {
		return lbPoint1;
	}

	public JLabel getLbPoint2() {
		return lbPoint2;
	}

	public JLabel getLbPointM() {
		return lbPointM;
	}

	public PointRun() {
		// Construct 3 label
		lbPoint1 = new JLabel();
		lbPoint2 = new JLabel();
		lbPointM = new JLabel();
		// set lbPoint1
		lbPoint1.setSize(50, 25);
		lbPoint1.setOpaque(true);
		lbPoint1.setLocation(25, 25);
		lbPoint1.setFont(new Font("Helvetica", Font.BOLD, 17));
		lbPoint1.setBackground(SystemColor.menu);
		lbPoint1.setHorizontalAlignment(SwingConstants.CENTER);
		lbPoint1.setVerticalAlignment(SwingConstants.CENTER);

		lbPoint2.setSize(50, 25);
		lbPoint2.setOpaque(true);
		lbPoint2.setLocation(25, 25);
		lbPoint2.setFont(new Font("Helvetica", Font.BOLD, 17));
		lbPoint2.setBackground(SystemColor.menu);
		lbPoint2.setHorizontalAlignment(SwingConstants.CENTER);
		lbPoint2.setVerticalAlignment(SwingConstants.CENTER);

		lbPointM.setSize(50, 25);
		lbPointM.setOpaque(true);
		lbPointM.setLocation(25, 25);
		lbPointM.setFont(new Font("Helvetica", Font.BOLD, 17));
		lbPointM.setBackground(SystemColor.menu);
		lbPointM.setHorizontalAlignment(SwingConstants.CENTER);
		lbPointM.setVerticalAlignment(SwingConstants.CENTER);
	}
}
