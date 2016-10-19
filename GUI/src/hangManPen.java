import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class hangManPen extends JPanel {
	int count = 0;
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();

	public void paintComponent(Graphics comp) {
		Graphics2D comp2D = (Graphics2D) comp;
		count++;
		if (count >= 1) {
			// box
			comp2D.setColor(Color.black);
			comp2D.fillRect(d.width / 4 - 20, 300, 100, 99);
		}
		if (count >= 2) {
			System.out.println("1: head");
			// head
			comp2D.fillOval(d.width / 4, 60, 65, 65);
			comp2D.setColor(Color.white);
		}
		if (count >= 3) {
			System.out.println("2: eyes");
			comp2D.setColor(Color.white);
			// the eyes
			comp2D.fillOval(d.width / 4 + 6, 80, 15, 10);
			comp2D.fillOval(d.width / 4 + 45, 80, 15, 10);
		}
		if (count >= 4) {
			System.out.println("3: Mouth");
			// the mouth
			comp2D.fillOval(d.width / 4 + 23, 107, 20, 10);
		}
		if (count >= 5) {
			System.out.println("4: nose");
			// the nose
			comp2D.fillOval(d.width / 4 + 28, 91, 10, 10);
		}
		if (count >= 6) {
			System.out.println("5: ears");
			// the ears
			comp2D.setColor(Color.black);
			comp2D.fillOval(d.width / 4 - 8, 80, 10, 20);
			comp2D.fillOval(d.width / 4 + 63, 80, 10, 20);
		}
		if (count >= 7) {
			System.out.println("6: neck");
			// the neck
			BasicStroke bsNeck = new BasicStroke(5F, BasicStroke.JOIN_ROUND, BasicStroke.CAP_BUTT);
			comp2D.setStroke(bsNeck);
			comp2D.drawLine(d.width / 4 + 30, 125, d.width / 4 + 30, 140);
		}
		if (count >= 8) {
			System.out.println("7: chest");
			// the body
			BasicStroke bsBody = new BasicStroke(20F, BasicStroke.JOIN_ROUND, BasicStroke.CAP_BUTT);
			comp2D.setStroke(bsBody);
			comp2D.drawLine(d.width / 4 + 30, 145, d.width / 4 + 30, 250);
		}
		if (count >= 9) {
			System.out.println("8: arms");
			// the hands
			BasicStroke bsHandL = new BasicStroke(5F, BasicStroke.JOIN_ROUND, BasicStroke.CAP_BUTT);
			comp2D.setStroke(bsHandL);
			comp2D.drawLine(d.width / 4 + 30, 160, d.width / 4 - 18, 200);
			BasicStroke bsHandR = new BasicStroke(5F, BasicStroke.JOIN_ROUND, BasicStroke.CAP_BUTT);
			comp2D.setStroke(bsHandR);
			comp2D.drawLine(d.width / 4 + 30, 160, d.width / 4 + 78, 200);
		}
		if (count >= 10) {
			System.out.println("9: legs");
			// the legs
			BasicStroke bsLegL = new BasicStroke(5F, BasicStroke.JOIN_ROUND, BasicStroke.CAP_BUTT);
			comp2D.setStroke(bsLegL);
			comp2D.drawLine(d.width / 4 + 30, 250, d.width / 4 - 18, 300);
			BasicStroke bsLegR = new BasicStroke(5F, BasicStroke.JOIN_ROUND, BasicStroke.CAP_BUTT);
			comp2D.setStroke(bsLegR);
			comp2D.drawLine(d.width / 4 + 30, 250, d.width / 4 + 78, 300);
		}
		if (count == 11) {
			// The Rope
			comp2D.setColor(Color.red);
			BasicStroke bsRope = new BasicStroke(4F, BasicStroke.JOIN_ROUND, BasicStroke.CAP_BUTT);
			comp2D.setStroke(bsRope);
			comp2D.drawArc(d.width / 4 - 55, -100, 170, 230, 180, 180);
		}
	}// constructor
}// hangManPen