import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class SimonFrame implements ActionListener, MouseListener {
	SimonPaint rend = new SimonPaint();
	int dark, nextLevel;
	boolean creatingPattern = true;
	Random random;

	public SimonFrame() {
		JFrame frame = new JFrame("Simon");
		Timer timer = new Timer(10, this);

		frame.setSize(rend.WIDTH + 8, rend.HEIGHT + 30);
		frame.setVisible(true);
		frame.addMouseListener(this);
		frame.setResizable(false);
		frame.add(rend);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		start();

		timer.start();
	}

	public void start() {
		random = new Random();
		rend.pattern = new ArrayList<Integer>();
		rend.score = 0;
		dark = 2;
		rend.butFlash = 0;
		nextLevel = 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		nextLevel++;
		if (nextLevel % 20 == 0) {
			rend.butFlash = 0;

			if (dark >= 0) {
				dark--;
			}
		}

		if (creatingPattern) {
			if (dark <= 0) {
				if (rend.score >= rend.pattern.size()) {
					rend.butFlash = random.nextInt(40) % 4 + 1;
					rend.pattern.add(rend.butFlash);
					rend.score = 0;
					creatingPattern = false;
				} else {
					rend.butFlash = rend.pattern.get(rend.score);
					rend.score++;
				}

				dark = 2;
			}
		} else if (rend.score == rend.pattern.size()) {
			creatingPattern = true;
			rend.score = 0;
			dark = 2;
		}

		rend.repaint();
	}


	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX(), y = e.getY();

		if (!creatingPattern && !rend.gameOver) {
			if (x > 0 && x < rend.WIDTH / 2 && y > 0 && y < rend.HEIGHT / 2) {
				rend.butFlash = 1;
				nextLevel = 1;
			} else if (x > rend.WIDTH / 2 && x < rend.WIDTH && y > 0 && y < rend.HEIGHT / 2) {
				rend.butFlash = 2;
				nextLevel = 1;
			} else if (x > 0 && x < rend.WIDTH / 2 && y > rend.HEIGHT / 2 && y < rend.HEIGHT) {
				rend.butFlash = 3;
				nextLevel = 1;
			} else if (x > rend.WIDTH / 2 && x < rend.WIDTH && y > rend.HEIGHT / 2 && y < rend.HEIGHT) {
				rend.butFlash = 4;
				nextLevel = 1;
			}

			if (rend.butFlash != 0) {
				if (rend.pattern.get(rend.score) == rend.butFlash) {
					rend.score++;
				} else {
					JOptionPane.showMessageDialog(null, "Game Over! Score: "+rend.score);
					System.exit(0);
					rend.gameOver = true;
					
				}
			}
		} else if (rend.gameOver) {
			start();
			rend.gameOver = false;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}