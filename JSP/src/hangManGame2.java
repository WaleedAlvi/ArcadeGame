import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;

import javax.swing.*;

public class hangManGame2 extends JFrame implements ActionListener, Runnable {
	JPanel gridPanel, drawPanel;
	ArrayList<JButton> list = new ArrayList<JButton>();
	JButton throwAway;
	hangManPen drawPen = new hangManPen();
	int chances = 10;
	int chosenNum;
	Thread testThread;
	Music newBar;
	File fr2 = null;
	int rerun;

	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();

	public hangManGame2() throws Exception {

		fr2 = new File("/Users/kimmontes/Documents/Docs/Sheridan/Year Two/Java/microProj6/8bitish_Done.wav");
		testThread = new Thread(this, "test");
		testThread.start();
		chosenNum = 1 + (int) (Math.random() * 100);
		System.out.println("Chosen Number: " + chosenNum);
		gridPanel = new JPanel();
		drawPanel = new JPanel();
		drawPanel.setBackground(Color.GRAY);
		drawPanel.add(drawPen);
		drawPanel.setVisible(true);
		gridPanel.setLayout(new GridLayout(10, 10));
		gridPanel.setSize(800, 800);
		for (int i = 1; i <= 100; i++) {
			throwAway = new JButton(Integer.toString(i));
			throwAway.setOpaque(true);
			list.add(throwAway);
			gridPanel.add(throwAway);
			throwAway.addActionListener(this);
		}
		this.setLayout(new GridLayout(2, 2));
		this.add(gridPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (Integer.parseInt(e.getActionCommand()) == chosenNum) {
			list.get(Integer.parseInt(e.getActionCommand()) - 1).setBackground(Color.green);
			try {
				newBar.stopSong();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "You Win!");
			this.setVisible(false);
		} else {
			chances--;
			if (chances != 0) {
				drawPen = new hangManPen();
				this.add(drawPen);
				System.out.println("Chances left: " + chances);
				if (Integer.parseInt(e.getActionCommand()) < chosenNum) {
					list.get(Integer.parseInt(e.getActionCommand()) - 1).setBackground(Color.yellow);
				} else if (Integer.parseInt(e.getActionCommand()) > chosenNum) {
					list.get(Integer.parseInt(e.getActionCommand()) - 1).setBackground(Color.red);
				}
				repaint();
			} else {
				rerun++;
				drawPen = new hangManPen();
				this.add(drawPen);
				repaint();
				try {
					newBar.stopSong();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Game over");
				this.setVisible(false);
			}
		}
	}// actionPerformed

	@Override
	public void run() {
		try {
			Thread.sleep(500);

			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			System.out.println("After draw panel");
			this.add(drawPen);
			this.repaint();
			System.out.println("After draw pen");
			newBar = new Music(fr2);
			this.add(newBar);
			this.setSize((int) d.getWidth(), (int) d.getHeight());
			this.setVisible(true);
			newBar.iterate(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
