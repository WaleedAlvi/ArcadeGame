import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

public class mainPage extends JFrame implements ActionListener, Runnable {
	boolean currentlyPlaying = false;
	File fr2 = null;
	Music newBar;
	Thread testThread;
	String enteredPass = "";
	int numChar = 0;
	JButton placeHolder1 = new JButton("Sign In PLACEHOLDER");
	JButton placeHolder2 = new JButton("Sign up PLACEHOLDER");
	JButton placeHolder4 = new JButton("See Score PLACEHOLDER");
	JButton simonSays = new JButton(new ImageIcon(
			((new ImageIcon("/Users/WaleedAlvi/Desktop/WorkPlace/MicroProject6/src/Images/Simon.jpg"))
					.getImage()).getScaledInstance(220, 220, java.awt.Image.SCALE_SMOOTH)));
	JButton musicButton;
	JButton guessGameButton;
	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;

	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel login = new JPanel();
	JPanel passButtons = new JPanel();

	JTextField loginName = new JTextField(10);

	public mainPage() {
		p2.setLayout(new GridLayout(1, 2));
		p3.setLayout(new GridLayout(1, 4));
		login.setLayout(new GridLayout(2, 1));
		passButtons.setLayout(new GridLayout(2, 5));
		slotsPic slots = new slotsPic(); // WORKS
		makerPic maker = new makerPic(); // WORKS

		musicButton = new JButton(new ImageIcon(((new ImageIcon(
				"/Users/WaleedAlvi/Desktop/WorkPlace/MicroProject6/src/Images/mixtape.jpg")).getImage())
						.getScaledInstance(162, 162, java.awt.Image.SCALE_SMOOTH)));
		fr2 = new File("/Users/WaleedAlvi/Desktop/WorkPlace/MicroProject6/src/8bitish.wav");
		guessGameButton = new JButton(new ImageIcon(((new ImageIcon(
				"/Users/WaleedAlvi/Desktop/WorkPlace/MicroProject6/src/Images/guessGame.jpg")).getImage())
						.getScaledInstance(210, 210, java.awt.Image.SCALE_SMOOTH)));

		this.setLayout(new GridLayout(3, 1));
		FormFrame fp = new FormFrame();

		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		btn7 = new JButton("7");
		btn8 = new JButton("8");
		btn9 = new JButton("9");
		btn10 = new JButton("0");
		ArrayList<JButton> list = new ArrayList<JButton>();
		list.add(btn1);
		list.add(btn2);
		list.add(btn3);
		list.add(btn4);
		list.add(btn5);
		list.add(btn6);
		list.add(btn7);
		list.add(btn8);
		list.add(btn9);
		list.add(btn10);
		Collections.shuffle(list);
		for (int i = 0; i < 10; i++) {
			passButtons.add(list.get(i));
		}

		loginName.setText("Username here");
		login.add(loginName);
		login.add(passButtons);

		p1.add(slots);
		p1.add(maker);
		p2.add(login);
		p2.add(fp);
		p3.add(guessGameButton);
		p3.add(musicButton);
		p3.add(placeHolder4);
		p3.add(simonSays);

		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setSize(650, 500);
		this.pack();
		this.setVisible(true);

		guessGameButton.addActionListener(this);
		musicButton.addActionListener(this);
		simonSays.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btn10.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == musicButton) {
			System.out.println("Current status for stopMusic:" + currentlyPlaying);
			if (currentlyPlaying == false) {
				currentlyPlaying = true;
			} else if (currentlyPlaying == true) {
				currentlyPlaying = false;
			}

			if (currentlyPlaying == true) {
				System.out.println("Playing Music");
				testThread = new Thread(this, "test");
				testThread.start();
			} else {
				System.out.println("Stopped Music");
				try {
					newBar.stopSong();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		} else if (e.getSource() == guessGameButton) {
			System.out.println("GUESS");
			if (currentlyPlaying == true) {
				try {
					newBar.stopSong();
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
			try {
				hangManGame2 test = new hangManGame2();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == simonSays) {
			SimonFrame frame = new SimonFrame();

		}

		if (e.getSource() == btn1) {
			enteredPass += "1";
		} else if (e.getSource() == btn2) {
			enteredPass += "2";
		} else if (e.getSource() == btn3) {
			enteredPass += "3";
		} else if (e.getSource() == btn4) {
			enteredPass += "4";
		} else if (e.getSource() == btn5) {
			enteredPass += "5";
		} else if (e.getSource() == btn6) {
			enteredPass += "6";
		} else if (e.getSource() == btn7) {
			enteredPass += "7";
		} else if (e.getSource() == btn8) {
			enteredPass += "8";
		} else if (e.getSource() == btn9) {
			enteredPass += "9";
		} else if (e.getSource() == btn10) {
			enteredPass += "0";
		}
		numChar++;
		if (numChar >= 6) {
			System.out.println(loginName.getText());
			System.out.println(enteredPass);
			numChar = 0;
			enteredPass = "";
		}
	}

	@Override
	public void run() {
		try {
			newBar = new Music(fr2);
			newBar.iterate(false);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}