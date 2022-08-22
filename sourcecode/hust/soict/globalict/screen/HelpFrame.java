package hust.soict.globalict.screen;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import hust.soict.globalict.screen.HelpFrame;

public class HelpFrame extends JFrame {
    private JPanel contentPane;

    public HelpFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(710, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Help");

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(198, 252, 252));

        JLabel lblNewLabel = new JLabel("1. Main menu");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setBounds(27, 70, 440, 17);
        contentPane.add(lblNewLabel);

        JLabel lblChoose = new JLabel(
                "- Click on 1 of 3 buttons corresponding to 3 sort algorithms: Merge Sort, Counting Sort, Radix Sort.");
        lblChoose.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblChoose.setBounds(47, 90, 740, 17);
        contentPane.add(lblChoose);

        JLabel lblClickexit = new JLabel("- Click Exit to exit the program.");
        lblClickexit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblClickexit.setBounds(47, 110, 440, 17);
        contentPane.add(lblClickexit);

        JLabel lblGenerateArray = new JLabel("2. Generate array in Array Initialization section");
        lblGenerateArray.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblGenerateArray.setBounds(27, 140, 440, 17);
        contentPane.add(lblGenerateArray);

        JLabel lblSizeArray = new JLabel(
                "- Enter the size of array, you can change it by clicking on upper or lower buttons.");
        lblSizeArray.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblSizeArray.setBounds(47, 160, 540, 17);
        contentPane.add(lblSizeArray);

        JLabel lblCreate = new JLabel("- Click on Create button to generate array.");
        lblCreate.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCreate.setBounds(47, 180, 540, 17);
        contentPane.add(lblCreate);

        JLabel lblIfYou = new JLabel("- Click on Random button if you want to generate random array.");
        lblIfYou.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblIfYou.setBounds(47, 200, 669, 17);
        contentPane.add(lblIfYou);

        JLabel lblByHand = new JLabel("- Click on By Hand button if you want to generate array by hand.");
        lblByHand.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblByHand.setBounds(47, 220, 440, 17);
        contentPane.add(lblByHand);

        JLabel lblSave = new JLabel("- Click on Save button to save array and algorithm before starting to sort.");
        lblSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblSave.setBounds(47, 240, 600, 17);
        contentPane.add(lblSave);

        JLabel lblClickOn = new JLabel("3. Control sort algorithm in Control section");
        lblClickOn.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblClickOn.setBounds(27, 270, 440, 17);
        contentPane.add(lblClickOn);

        JLabel lblViewSort = new JLabel("- You can choose sort acending or desending by clicking on them.");
        lblViewSort.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblViewSort.setBounds(47, 290, 640, 17);
        contentPane.add(lblViewSort);

        JLabel lblSortSpeed = new JLabel("- You can change sort speed by chaning the slider.");
        lblSortSpeed.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblSortSpeed.setBounds(47, 310, 440, 17);
        contentPane.add(lblSortSpeed);

        JLabel lblClickplay = new JLabel("- Click on Start Sorting to view the sorting visualization.");
        lblClickplay.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblClickplay.setBounds(47, 330, 440, 17);
        contentPane.add(lblClickplay);

        JLabel lblClickpause = new JLabel("- Click on Pause to pause the visualization.");
        lblClickpause.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblClickpause.setBounds(47, 350, 648, 17);
        contentPane.add(lblClickpause);

        JLabel lblBackTo = new JLabel("4. Back to main menu and Dark mode");
        lblBackTo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblBackTo.setBounds(27, 380, 440, 17);
        contentPane.add(lblBackTo);

        JLabel lblClickback = new JLabel("- Click on Back To Menu to return to main menu.");
        lblClickback.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblClickback.setBounds(47, 400, 648, 17);
        contentPane.add(lblClickback);

        JLabel lblExitProgram = new JLabel("- You can view the dark mode screen by clicking on Dark Mode.");
        lblExitProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblExitProgram.setBounds(47, 420, 440, 17);
        contentPane.add(lblExitProgram);

        JLabel lblAim = new JLabel("Aim of the program: ");
        lblAim.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAim.setBounds(27, 440, 440, 17);
        contentPane.add(lblAim);

        JLabel lblContentAim = new JLabel(
                "- Application to explain three sorting algorithms on an array:\n merge sort, counting sort, and radix sort.");
        lblContentAim.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblContentAim.setBounds(47, 460, 650, 17);
        contentPane.add(lblContentAim);

        JLabel lblSortVisualizationApplication = new JLabel("SORT VISUALIZATION APPLICATION");
        lblSortVisualizationApplication.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblSortVisualizationApplication.setBounds(210, 24, 440, 17);
        contentPane.add(lblSortVisualizationApplication);

        // add button
        JButton btnBack = new JButton();
        btnBack = new JButton("Back to menu");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame frame3 = new MainFrame();
                frame3.setVisible(true);
                HelpFrame.this.setVisible(false);
            }
        });
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnBack.setBounds(20, 500, 120, 30);
        contentPane.add(btnBack);
        // add Look And Feel
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
    }
}
