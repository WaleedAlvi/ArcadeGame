import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormFrame extends JPanel implements ActionListener {
	JLabel unLabel = new JLabel("User Name:    ");
	JLabel psLabel = new JLabel("Password:    ");
	JLabel repsLabel = new JLabel("Retype Password:    ");
	JButton enter = new JButton("Enter");
	JTextField unField = new JTextField(15);
	JPasswordField psField = new JPasswordField(15);
	JPasswordField repsField = new JPasswordField(15);

	FormFrame() {

		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();

		p1.setLayout(new GridLayout(3, 2));

		GridLayout f1 = new GridLayout(2, 1, 10, 10);
		setLayout(f1);
		p1.add(unLabel);
		p1.add(unField);
		p1.add(psLabel);
		p1.add(psField);
		p1.add(repsLabel);
		p1.add(repsField);
		p2.add(enter);
		this.add(p1);
		this.add(p2);
		this.setVisible(true);
		enter.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(unField.getText());
		System.out.println(psField.getPassword());
		System.out.println(repsField.getPassword());

	}
}