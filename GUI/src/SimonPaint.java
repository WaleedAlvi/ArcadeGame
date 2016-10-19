import java.awt.*;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SimonPaint extends JPanel {
	int WIDTH = 800, HEIGHT = 800, butFlash = 0, score;
	boolean gameOver;
	ArrayList<Integer> pattern;
	
	@Override
	public void paintComponent(Graphics comp) {
		Graphics2D g = (Graphics2D) comp;

		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (butFlash == 1) {
			g.setColor(Color.GREEN);
		} else {
			g.setColor(Color.GREEN.darker());
		}

		g.fillRect(0, 0, WIDTH / 2, HEIGHT / 2);

		if (butFlash == 2) {
			g.setColor(Color.RED);
		} else {
			g.setColor(Color.RED.darker());
		}

		g.fillRect(WIDTH / 2, 0, WIDTH / 2, HEIGHT / 2);

		if (butFlash == 3) {
			g.setColor(Color.ORANGE);
		} else {
			g.setColor(Color.ORANGE.darker());
		}

		g.fillRect(0, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);

		if (butFlash == 4) {
			g.setColor(Color.BLUE);
		} else {
			g.setColor(Color.BLUE.darker());
		}

		g.fillRect(WIDTH / 2, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);

		g.setColor(Color.BLACK);
		g.fillRoundRect(220, 220, 350, 350, 300, 300);
		g.fillRect(WIDTH / 2 - WIDTH / 12, 0, WIDTH / 7, HEIGHT);
		g.fillRect(0, WIDTH / 2 - WIDTH / 12, WIDTH, HEIGHT / 7);

		g.setColor(Color.GRAY);
		((Graphics2D) g).setStroke(new BasicStroke(200));
		g.drawOval(-100, -100, WIDTH + 200, HEIGHT + 200);

		g.setColor(Color.BLACK);
		((Graphics2D) g).setStroke(new BasicStroke(10));
		g.drawOval(0, 0, WIDTH, HEIGHT);

		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", 1, 142));

		if (gameOver) {
			g.setFont(new Font("Arial", 1, 75));
			g.drawString("Game Over", WIDTH / 2 - 100, HEIGHT / 2 + 42);
		} else {
			g.drawString(score + "/" + pattern.size(), WIDTH / 2 - 100, HEIGHT / 2 + 42);
		}

	}

}