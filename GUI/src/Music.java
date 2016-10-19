import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Toolkit;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Music extends JPanel {
	JLabel songName;
	JLabel timeLeft;
	JProgressBar playBar;
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	AudioInputStream stream;
	AudioFormat format;
	DataLine.Info info;
	Clip clip;
	int num = 0;
	FileDialog fd;
	File fr;
	int seconds;
	int minutes;

	public Music(File musicFile) throws Exception {
		fr = musicFile;
		try {
			stream = AudioSystem.getAudioInputStream(fr);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip) AudioSystem.getLine(info);
			long duration = 1000 * stream.getFrameLength() / (long) stream.getFormat().getFrameRate();
			seconds = (int) duration / 1000;
			do {
				if (seconds > 60) {
					minutes++;
					seconds -= 60;
				}
			} while (seconds > 60);
		} catch (Exception e) {
			e.printStackTrace();
		}
		playBar = new JProgressBar(0, (int) fr.length());
		playBar.setValue(0);
		playBar.setStringPainted(true);
		timeLeft = new JLabel("Song Length: " + this.minutes + ":" + this.seconds);
		playBar.setValue(0);
		playBar.setStringPainted(true);
		p2.add(playBar);
		p2.add(timeLeft);
		p3.setLayout(new BorderLayout());
		p3.add(p1, BorderLayout.NORTH);
		p3.add(p2, BorderLayout.SOUTH);
		this.add(p2);
		this.setSize(50, 200);
		this.setVisible(true);
	}// constructor

	public void restart() throws Exception {
		clip = (Clip) AudioSystem.getLine(info);
		this.iterate(false);
	}

	public void stopSong() throws Exception {
		clip.stop();
		clip.drain();
		clip.close();
		playBar = new JProgressBar(0, (int) fr.length());
	}

	public void iterate(boolean stop2) throws Exception {
		boolean stop = stop2;
		clip.open(stream);
		clip.start();
		long duration = 1000 * stream.getFrameLength() / (long) stream.getFormat().getFrameRate();

		playBar.setMaximum((int) duration);
		while (stop == false) {
			while (num <= duration) {
				try {
					Thread.sleep(500);
					num += 500;
					playBar.setValue(num);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			playBar.setValue(0);
			num = 0;
			clip.loop(1);
		}
	}// iterate
}// PlayMusicProgressBar