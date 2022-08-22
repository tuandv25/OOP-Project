package hust.soict.globalict.entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ElementBox {
	private JLabel label;
	private int value;

	public JLabel getLabel() {
		return label;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public ElementBox() {
		label = new JLabel();
		value = 0;
		label.setSize(50, 50);
		label.setOpaque(true);
		label.setForeground(Color.blue);
		label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		// set text alignment center
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		setBackground(SystemColor.inactiveCaption);
		setText("0");
	}

	public void setText(String string) {
		label.setText(string);
	}

	public void setBackground(Color c) {
		label.setBackground(c);
	}

}
