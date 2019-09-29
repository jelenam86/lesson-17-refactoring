package exercises.ella;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PicturePanel extends JPanel implements ActionListener, KeyListener {

	final int PUZZLE1_STATE = 0;
	final int PUZZLE2_STATE = 1;
	public static BufferedImage backgroundImg;
	public static BufferedImage backgroundImg2;
	int currentState = PUZZLE1_STATE;

	PicturePanel() {
		try {
			backgroundImg = ImageIO.read(this.getClass().getResourceAsStream("Umbrellas.jpg"));
			backgroundImg2 = ImageIO.read(this.getClass().getResourceAsStream("tokyo2.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void getNextLevelPicture() {
		currentState += 1;
		if (currentState > PUZZLE2_STATE)
			currentState = PUZZLE1_STATE;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (currentState == PUZZLE1_STATE)
			g.drawImage(backgroundImg, 0, 0, null);
		else if (currentState == PUZZLE2_STATE)
			g.drawImage(backgroundImg2, 0, 0, null);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}