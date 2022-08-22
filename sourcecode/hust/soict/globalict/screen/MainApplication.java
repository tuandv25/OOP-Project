package hust.soict.globalict.screen;

import java.awt.EventQueue;

import hust.soict.globalict.screen.MainFrame;

public class MainApplication {

	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

   

}
