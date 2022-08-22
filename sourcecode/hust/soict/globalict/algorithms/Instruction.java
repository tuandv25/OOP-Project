package hust.soict.globalict.algorithms;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

import hust.soict.globalict.screen.SortFrame;

public class Instruction {
	public DefaultListModel<String> model = new DefaultListModel<String>(); 
	public JList<String> lsCode = new JList<String>(model);
	
	
	public DefaultListModel<String> getModel() {
		return model;
	}


	public void setModel(DefaultListModel<String> model) {
		this.model = model;
	}


	public JList<String> getLsCode() {
		return lsCode;
	}


	public void setLsCode(JList<String> lsCode) {
		this.lsCode = lsCode;
	}


	public Instruction() {
		lsCode.setBorder(new LineBorder(new Color(0, 0, 0)));
		lsCode.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lsCode.setFont(new Font("Monospaced",Font.BOLD,14));
	}

	
	public void highLight(int line) {
		Sort.curT++;
		int cur = Sort.curT;
		Sort.threads[cur] = new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	try {
		    		if (cur != 0) {
		    			Sort.threads[cur-1].join();
			    	}
		    		lsCode.setSelectedIndex(line);
		    		lsCode.ensureIndexIsVisible(line); // jump to highlight line
		    		Thread.sleep(SortFrame.time);
		    	} catch (Exception e) {
		    		e.printStackTrace();
		    	}
		    }
		});
		Sort.threads[cur].start();
	}
}
