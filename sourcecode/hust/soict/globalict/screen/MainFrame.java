package hust.soict.globalict.screen;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import hust.soict.globalict.screen.HelpFrame;
import hust.soict.globalict.screen.MainFrame;
import hust.soict.globalict.screen.SortFrame;

public class MainFrame extends JFrame {
	private JLabel background;
	private String AlgorithmName;

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Sort Visualizer");

		background = new JLabel(new ImageIcon("sourcecode/hust/soict/globalict/screen/java2.png"));
		background.setLayout(null);
		add(background);
		// add Look and Feel
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look and feel.
		}
		JButton btnMergeSort = new JButton("Merge Sort");
		btnMergeSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlgorithmName = "Merge Sort";
				SortFrame frame2 = new SortFrame(AlgorithmName);
				frame2.setVisible(true);
				MainFrame.this.setVisible(false);
			}
		});
		btnMergeSort.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMergeSort.setBounds(160, 180, 180, 50);
		background.add(btnMergeSort);
		JButton btnCountingSort = new JButton("Counting Sort");
		btnCountingSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlgorithmName = "Counting Sort";
				SortFrame frame2 = new SortFrame(AlgorithmName);
				frame2.setVisible(true);
				MainFrame.this.setVisible(false);
			}
		});
		btnCountingSort.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCountingSort.setBounds(160, 250, 180, 50);
		background.add(btnCountingSort);

		JButton btnRadixSort = new JButton("Radix Sort");
		btnRadixSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlgorithmName = "Radix Sort";
				SortFrame frame2 = new SortFrame(AlgorithmName);
				frame2.setVisible(true);
				MainFrame.this.setVisible(false);
			}
		});
		btnRadixSort.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRadixSort.setBounds(160, 320, 180, 50);
		background.add(btnRadixSort);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null,
						"Confirm to exit application", "Warning",
						dialogButton);

				if (dialogResult == JOptionPane.YES_OPTION) {
					MainFrame.this.dispose();
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExit.setBounds(160, 460, 180, 50);
		background.add(btnExit);

		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpFrame frame4 = new HelpFrame();
				frame4.setVisible(true);
				MainFrame.this.setVisible(false);
			}
		});
		btnHelp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHelp.setBounds(160, 390, 180, 50);
		background.add(btnHelp);
	}
}
