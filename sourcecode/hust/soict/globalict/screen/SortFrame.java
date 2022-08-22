package hust.soict.globalict.screen;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.NumberFormatter;

import hust.soict.globalict.algorithms.*;
import hust.soict.globalict.entity.*;
import hust.soict.globalict.screen.SortFrame;

public class SortFrame extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Launch the application.
     */

    private JPanel contentPane;
    private JPanel pnImitiate;
    private JPanel pnArray;
    private JPanel pnCreateArray;
    private JPanel pnSetValueArray;
    private JPanel pnCode;
    private JPanel pnControl;
    private JScrollPane pnScroll;

    private JLabel lbNum, lbMaxNum;
    private JSpinner spNum;
    private JButton btnCreateArray, btnDeleteArray, btnSetZero;
    private JButton btnRandom, btnByHand, btnSave;
    private JButton btnSort, btnStop;
    private JRadioButton rdIncrease, rdDecrease;
    private JSlider slSize;
    private JSlider slSpeed;

    private ActionListener eIncrease, eDecrease;
    private ChangeListener eSize;
    private ChangeListener eSpeed;

    private InitialElementBoxs initialElementBoxs;
    private Sort algorithm;
    public static int time = 50;
    private ElementBox[] elementBoxs;
    private PointRun pointRun;

    // Create the application.

    public SortFrame(String algorithmName) {
        setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        setTitle("Algorithm simulation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(47, 100, 1650, 930);
        setLocationRelativeTo(null);
        setResizable(false);
        contentPane = new JPanel();

        contentPane.setBackground(SystemColor.menu);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

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

        pnArray = new JPanel();
        pnArray.setBackground(SystemColor.menu);
        pnArray.setBorder(new TitledBorder(null, "Data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnArray.setBounds(500, 590, 330, 300);
        contentPane.add(pnArray);

        pnCode = new JPanel();
        pnCode.setBounds(20, 20, 450, 866);
        pnCode.setBackground(SystemColor.menu);
        pnCode.setBorder(new TitledBorder(null, "Pseudo Code", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contentPane.add(pnCode);

        pnControl = new JPanel();
        pnControl.setBackground(SystemColor.menu);
        pnControl.setBorder(new TitledBorder(null, "Control", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnControl.setBounds(840, 590, 400, 300);
        pnControl.setLayout(null);
        contentPane.add(pnControl);

        slSpeed = new JSlider();
        slSpeed.setOrientation(SwingConstants.HORIZONTAL);
        slSpeed.setBounds(70, 200, 260, 30);
        slSpeed.setMinimum(1);
        slSpeed.setMaximum(9);
        slSpeed.setValue(5);
        pnControl.add(slSpeed);

        rdIncrease = new JRadioButton("Sort ascending");
        rdIncrease.setBounds(60, 80, 160, 30);
        pnControl.add(rdIncrease);

        rdDecrease = new JRadioButton("Sort descending");
        rdDecrease.setBounds(60, 130, 160, 30);
        pnControl.add(rdDecrease);

        btnSort = new JButton("Start sorting");
        btnSort.setBackground(SystemColor.activeCaption);
        btnSort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdIncrease.isSelected()) {
                    algorithm.sortIncrease(elementBoxs, pointRun);
                } else {
                    algorithm.sortDecrease(elementBoxs, pointRun);
                }
                setState(4);
            }
        });
        btnSort.setBounds(240, 80, 120, 30);
        pnControl.add(btnSort);

        btnStop = new JButton("PAUSE");
        btnStop.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            public void actionPerformed(ActionEvent e) {
                if (btnStop.getText().equals("PAUSE")) {
                    btnStop.setText("PLAY");
                    for (int i = 0; i <= Sort.curT; i++) {
                        if (Sort.threads[i].isAlive()) {
                            try {
                                Sort.threads[i].suspend();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                } else {
                    btnStop.setText("PAUSE");
                    for (int i = 0; i <= Sort.curT; i++) {
                        try {
                            Sort.threads[i].resume();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        });
        btnStop.setBackground(SystemColor.activeCaption);
        btnStop.setBounds(240, 130, 120, 30);
        pnControl.add(btnStop);
        // Other button
        JPanel pnBack = new JPanel();
        pnBack.setBackground(SystemColor.menu);
        pnBack.setBorder(new TitledBorder(null, "Other Button", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnBack.setBounds(1250, 590, 350, 300);
        contentPane.add(pnBack);
        pnBack.setLayout(null);

        JButton btnBack = new JButton();
        btnBack = new JButton("Back to menu");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame frame3 = new MainFrame();
                frame3.setVisible(true);
                SortFrame.this.setVisible(false);
            }
        });
        btnBack.setBackground(SystemColor.activeCaption);
        btnBack.setBounds(95, 200, 120, 30);
        pnBack.add(btnBack);

        JButton btnDark = new JButton();
        btnDark = new JButton("Dark mode");
        btnDark.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color color = new Color(40, 40, 40);
                Color color2 = new Color(70, 70, 70);
                contentPane.setBackground(color);
                pnArray.setBackground(color2);
                pnControl.setBackground(color2);
                pnCode.setBackground(color2);
                pnImitiate.setBackground(color2);
                pnBack.setBackground(color2);
                pnCreateArray.setBackground(color2);
                pnSetValueArray.setBackground(color2);
                pnScroll.setBackground(color2);
                pnScroll.getViewport().setBackground(color2);
            }
        });
        btnDark.setBackground(SystemColor.activeCaption);
        btnDark.setBounds(95, 140, 120, 30);
        pnBack.add(btnDark);

        // create the combo box
        LookAndFeelInfo[] lafInfos = UIManager.getInstalledLookAndFeels();
        String[] lafNames = new String[lafInfos.length + 2];
        for (int i = 0; i < lafInfos.length; i++) {
            lafNames[i] = lafInfos[i].getName();
        }

        JComboBox cbLookAndFeel = new JComboBox(lafNames);
        cbLookAndFeel.setBounds(95, 80, 120, 30);
        pnBack.add(cbLookAndFeel);
        JFrame frame = this;
        cbLookAndFeel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                // Override
                int index = cbLookAndFeel.getSelectedIndex();
                try {
                    UIManager.setLookAndFeel(lafInfos[index].getClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                SwingUtilities.updateComponentTreeUI(frame);
                setTitle("Algorithm Simulation - " + lafNames[index] + " Look And Feel");
            }
        });

        // pnAlgorithm.setLayout(null);
        pnCode.setLayout(null);
        slSize = new JSlider();
        slSize.setMinimum(10);
        slSize.setMaximum(20);
        slSize.setValue(13);
        slSize.setBounds(50, 820, 350, 30); // default 10, 21, 486, 26
        pnCode.add(slSize);

        pnScroll = new JScrollPane();
        pnScroll.setBounds(15, 30, 420, 800); // default 10, 53, 486, 223
        pnCode.add(pnScroll);

        pnCreateArray = new JPanel();
        pnCreateArray.setBackground(SystemColor.menu);
        pnCreateArray
                .setBorder(new TitledBorder(null, "Array initialization", TitledBorder.LEADING, TitledBorder.TOP, null,
                        null));

        pnSetValueArray = new JPanel();
        pnSetValueArray.setBackground(SystemColor.menu);
        pnSetValueArray.setBorder(
                new TitledBorder(null, "Create data for array", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GroupLayout gl_pnArray = new GroupLayout(pnArray);
        gl_pnArray.setHorizontalGroup(
                gl_pnArray.createParallelGroup(Alignment.LEADING)
                        .addComponent(pnSetValueArray, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                        .addComponent(pnCreateArray, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE));
        gl_pnArray.setVerticalGroup(
                gl_pnArray.createParallelGroup(Alignment.TRAILING)
                        .addGroup(Alignment.LEADING, gl_pnArray.createSequentialGroup()
                                .addComponent(pnCreateArray, GroupLayout.PREFERRED_SIZE, 143,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(pnSetValueArray, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)));

        btnRandom = new JButton("Random");
        btnRandom.setBackground(SystemColor.activeCaption);
        btnRandom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (algorithmName.compareTo("Counting Sort") == 0) {
                    initialElementBoxs.createRandom(10);
                } else {
                    initialElementBoxs.createRandom(101);
                }

                setState(2);
            }
        });
        btnRandom.setBounds(15, 25, 120, 30);

        btnByHand = new JButton("By Hand");
        btnByHand.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                initialElementBoxs.createHand();
                setState(2);
            }
        });
        btnByHand.setBackground(SystemColor.activeCaption);
        btnByHand.setBounds(160, 25, 120, 30);

        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (algorithm != null)
                    algorithm.instruction.model.removeAllElements();
                if (algorithmName.compareTo("Counting Sort") == 0) {
                    algorithm = new CountingSort(elementBoxs, pointRun, pnImitiate);
                    ((CountingSort) algorithm).addCode();
                    algorithm.instruction.lsCode.setSelectedIndex(0);
                } else if (algorithmName.compareTo("Radix Sort") == 0) {
                    algorithm = new RadixSort(elementBoxs, pointRun, pnImitiate);
                    ((RadixSort) algorithm).addCode();
                    algorithm.instruction.lsCode.setSelectedIndex(0);
                } else {
                    algorithm = new MergeSort(elementBoxs, pointRun, pnImitiate);
                    ((MergeSort) algorithm).addCode();
                    algorithm.instruction.lsCode.setSelectedIndex(0);
                }
                pnScroll.setViewportView(algorithm.instruction.lsCode);
                setState(3);
            }
        });
        btnSave.setBackground(SystemColor.activeCaption);
        btnSave.setBounds(87, 65, 120, 30);

        pnSetValueArray.setLayout(null);
        pnSetValueArray.add(btnRandom);
        pnSetValueArray.add(btnByHand);
        pnSetValueArray.add(btnSave);

        lbNum = new JLabel("The number of elements : ");
        lbNum.setBounds(16, 25, 139, 25);

        SpinnerModel sm = new SpinnerNumberModel(2, 2, 15, 1);
        spNum = new JSpinner(sm);
        spNum.setBounds(160, 25, 120, 30);
        JFormattedTextField txt = ((JSpinner.NumberEditor) spNum.getEditor()).getTextField();
        ((NumberFormatter) txt.getFormatter()).setAllowsInvalid(false);

        btnCreateArray = new JButton("Create");
        btnCreateArray.setBackground(SystemColor.activeCaption);
        btnCreateArray.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                pointRun = new PointRun();
                initialElementBoxs = new InitialElementBoxs(pnImitiate, spNum, elementBoxs, pointRun, 100);
                // set elementBoxs --> use it when sorting, animation
                elementBoxs = initialElementBoxs.getElementBoxs();
                setState(1);
            }
        });
        btnCreateArray.setBounds(160, 59, 120, 30);

        btnDeleteArray = new JButton("Delete");
        btnDeleteArray.setBackground(SystemColor.activeCaption);
        btnDeleteArray.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                initialElementBoxs.deleteArray();
                setState(0);
            }
        });
        btnDeleteArray.setBounds(160, 95, 120, 30);

        btnSetZero = new JButton("Set to 0");
        btnSetZero.setBackground(SystemColor.activeCaption);
        btnSetZero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                initialElementBoxs.setZero();
                setState(1);
            }
        });
        btnSetZero.setBounds(15, 95, 120, 30);
        pnCreateArray.setLayout(null);
        pnCreateArray.add(lbNum);
        pnCreateArray.add(btnSetZero);
        pnCreateArray.add(btnCreateArray);
        pnCreateArray.add(spNum);
        pnCreateArray.add(btnDeleteArray);

        lbMaxNum = new JLabel("(Maximum 15)");
        lbMaxNum.setHorizontalAlignment(SwingConstants.CENTER);
        lbMaxNum.setBounds(10, 47, 109, 14);
        pnCreateArray.add(lbMaxNum);
        pnArray.setLayout(gl_pnArray);

        pnImitiate = new JPanel();
        pnImitiate.setBackground(SystemColor.menu);
        pnImitiate.setBorder(
                new TitledBorder(null, "Simulation Frame", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnImitiate.setBounds(500, 20, 1100, 560);
        contentPane.add(pnImitiate);
        pnImitiate.setLayout(null);

        ButtonGroup grDirect = new ButtonGroup();
        grDirect.add(rdDecrease);
        grDirect.add(rdIncrease);
        rdIncrease.setSelected(true);

        eSize = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                algorithm.instruction.lsCode.setFont(new Font("Monospaced", Font.BOLD, slSize.getValue()));
                algorithm.instruction.lsCode.repaint();
            }
        };

        slSize.addChangeListener(eSize);

        eSpeed = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                time = 100 - slSpeed.getValue() * 10;
            }
        };

        slSpeed.addChangeListener(eSpeed);

        eIncrease = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                // set Increase or Decrease
                // isIncrease = true;

                if (algorithmName.compareTo("Counting Sort") == 0) {
                    algorithm.instruction.model.set(7, "        for (int i = 1; i < 10; i++)");
                    algorithm.instruction.model.set(8, "            count[i] += count[i - 1];");
                } else if (algorithmName.compareTo("Radix Sort") == 0) {
                    algorithm.instruction.model.set(12, "        for (i = 1; i < 10; i++)");
                    algorithm.instruction.model.set(13, "            count[i] += count[i - 1];");
                } else if (algorithmName.compareTo("Merge Sort") == 0) {
                    algorithm.instruction.model.set(22, "        if (L[i] <= R[j]) {");
                }
            }
        };

        eDecrease = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                // isIncrease = false;

                if (algorithmName.compareTo("Counting Sort") == 0) {
                    algorithm.instruction.model.set(7, "        for (int i = 8; i >= 0; i--)");
                    algorithm.instruction.model.set(8, "            count[i] += count[i + 1];");
                }
                if (algorithmName.compareTo("Radix Sort") == 0) {
                    algorithm.instruction.model.set(12, "        for (i = 8; i >= 0; i--)");
                    algorithm.instruction.model.set(13, "            count[i] += count[i + 1];");
                } else if (algorithmName.compareTo("Merge Sort") == 0) {
                    algorithm.instruction.model.set(22, "        if (L[i] >= R[j]) {");
                }
            }
        };

        rdIncrease.addActionListener(eIncrease);
        rdDecrease.addActionListener(eDecrease);
        setState(0);
    }

    public void setState(int state) {
        switch (state) {
            case 0: // first state, haven't created arrays.
                btnStop.setText("PAUSE");
                btnCreateArray.setEnabled(true);
                btnDeleteArray.setEnabled(false);
                btnSetZero.setEnabled(false);

                btnRandom.setEnabled(false);
                btnByHand.setEnabled(false);

                rdIncrease.setEnabled(false);
                rdDecrease.setEnabled(false);

                btnSort.setEnabled(false);
                btnStop.setEnabled(false);
                btnSave.setEnabled(false);
                break;
            case 1: // created arrays, be waiting to set value arrays.
                btnStop.setText("PAUSE");
                btnDeleteArray.setEnabled(true);
                btnSetZero.setEnabled(true);

                btnRandom.setEnabled(true);
                btnByHand.setEnabled(true);

                rdIncrease.setEnabled(true);
                rdDecrease.setEnabled(true);
                btnSave.setEnabled(true);
                break;
            case 2: // before saving
                btnDeleteArray.setEnabled(true);
                btnSetZero.setEnabled(true);
                btnRandom.setEnabled(true);

                rdIncrease.setEnabled(true);
                rdDecrease.setEnabled(true);

                btnSort.setEnabled(false);
                btnStop.setEnabled(false);
                btnSave.setEnabled(true);
                break;

            case 3: // be saved, ready to sort
                btnDeleteArray.setEnabled(true);
                btnSetZero.setEnabled(true);
                btnRandom.setEnabled(true);

                rdIncrease.setEnabled(true);
                rdDecrease.setEnabled(true);

                btnSort.setEnabled(true);
                btnStop.setEnabled(false);
                btnSave.setEnabled(true);
                break;
            case 4: // sorting
                btnCreateArray.setEnabled(false);
                btnDeleteArray.setEnabled(true);
                btnSetZero.setEnabled(false);

                btnRandom.setEnabled(false);
                btnByHand.setEnabled(false);

                rdIncrease.setEnabled(false);
                rdDecrease.setEnabled(false);

                btnSort.setEnabled(false);
                btnStop.setEnabled(true);
                btnSave.setEnabled(false);
                break;

            case 5: // sort done
                btnCreateArray.setEnabled(true);
                btnDeleteArray.setEnabled(true);
                btnSetZero.setEnabled(true);

                btnRandom.setEnabled(true);
                btnByHand.setEnabled(true);

                rdIncrease.setEnabled(true);
                rdDecrease.setEnabled(true);

                btnSort.setEnabled(true);
                btnStop.setEnabled(true);
                btnSave.setEnabled(true);
                break;

        }
    }
}
