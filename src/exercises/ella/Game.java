package exercises.ella;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game implements MouseListener, ActionListener {

	Timer timer = new Timer(1000, this);
	int time = 0;
	JFrame frame = new JFrame();
	PicturePanel panel = new PicturePanel();
	SideBar bar = new SideBar();
	JPanel mainPanel = new JPanel();
	Emojis emoji = new Emojis();
	int gameNumber = 1;
	boolean checkMe = false;
	boolean checkMe2 = false;
	boolean checkMe3 = false;
	boolean checkMe4 = false;
	boolean checkMe5 = false;
	boolean checkMe6 = false;
	boolean checkMe7 = false;
	boolean checkMeL2 = false;
	boolean checkMeL22 = false;
	boolean checkMeL23 = false;
	boolean checkMeL24 = false;
	boolean checkMeL25 = false;
	boolean checkMeL26 = false;
	boolean checkMeL27 = false;
	JButton balloonButton;
	JButton sparklesButton;
	JButton backpackButton;
	JButton diamondButton;
	JButton pawprintsButton;
	JButton snakeButton;
	JButton ringButton;
	JButton appleButton;
	JButton bowButton;
	JButton keyButton;
	JButton cloudButton;
	JButton chickenButton;
	JButton roseButton;
	JButton earthButton;
	JButton cactusButton;

	public static void main(String[] args) {
		new Game();
	}

	Game() {
		setup();
		timer.start();
	}

	void setup() {
		frame.setSize(1800, 1000);
		frame.setLayout(new BorderLayout());
		mainPanel.add(panel, BorderLayout.WEST);
		mainPanel.add(bar, BorderLayout.EAST);
		frame.add(mainPanel);
		panel.setPreferredSize(new Dimension(1500, 1000));
		frame.setVisible(true);
		frame.addMouseListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createLevelOneButtons();

	}

	private JButton addButton(String fileName, int xPosition, int yPosition) {
		JButton button = new JButton();
		String file = fileName.contains("Ring") ? "ring.png" : fileName.toLowerCase();
		button.setName(file.substring(0, file.length() - 4));
		try {
			Image image = ImageIO.read(getClass().getResource(fileName));
			button.setIcon(new ImageIcon(image));
			panel.setLayout(null);
			panel.add(button);
			button.addMouseListener(this);
			button.setBorder(null);
			button.setBounds(xPosition, yPosition, 30, 30);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return button;
	}

	void createLevelOneButtons() {
		balloonButton = addButton("balloon.png", 698, 336);
		diamondButton = addButton("diamond.png", 315, 900);
		pawprintsButton = addButton("pawprints.png", 1079, 782);
		ringButton = addButton("WeddingRing.png", 1460, 500);
		snakeButton = addButton("Snake.png", 1100, 420);
		backpackButton = addButton("backpack.png", 840, 770);
		sparklesButton = addButton("sparkles.png", 680, 756);
	}

	void createLevelTwoButtons() {
		appleButton = addButton("apple.png", 503, 931);
		bowButton = addButton("bow.png", 953, 903);
		cloudButton = addButton("cloud.png", 460, 529);
		roseButton = addButton("rose.png", 719, 664);
		chickenButton = addButton("chicken.png", 351, 575);
		keyButton = addButton("key2.png", 953, 903);
		earthButton = addButton("earth.png", 1224, 879);
		cactusButton = addButton("cactus.png", 578, 588);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX());
		System.out.println(e.getY());
	}

	boolean foundItem(MouseEvent e, JButton button) {
		if (e.getSource() == button || !button.isVisible()) {
			button.setVisible(false);
			bar.foundItem(button.getName());
			return true;
		}
		return false;
	}

	private boolean isLevelOneClear() {
		return checkMe && checkMe2 && checkMe3 && checkMe4 && checkMe5 && checkMe6 && checkMe7;
	}

	private boolean isLevelTwoClear() {
		return checkMeL2 && checkMeL22 && checkMeL23 && checkMeL24 && checkMeL25 && checkMeL26 && checkMeL27;
	}

	private void playLevelOne(MouseEvent e) {
		checkMe = foundItem(e, balloonButton);
		checkMe2 = foundItem(e, pawprintsButton);
		checkMe3 = foundItem(e, ringButton);
		checkMe4 = foundItem(e, snakeButton);
		checkMe5 = foundItem(e, backpackButton);
		checkMe6 = foundItem(e, sparklesButton);
		checkMe7 = foundItem(e, diamondButton);
	}

	private void playLevelTwo(MouseEvent e) {
		checkMeL2 = foundItem(e, appleButton);
		checkMeL22 = foundItem(e, bowButton);
		checkMeL23 = foundItem(e, roseButton);
		checkMeL24 = foundItem(e, cloudButton);
		checkMeL25 = foundItem(e, chickenButton);
		checkMeL26 = foundItem(e, earthButton);
		checkMeL27 = foundItem(e, cactusButton);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		String message = "Congratulations! You found all the pictures! \n You finished the puzzle in: " + time
				+ " seconds.";
		switch (gameNumber) {
		case 1:
			playLevelOne(e);
			if (isLevelOneClear()) {
				timer.stop();
				JOptionPane.showMessageDialog(null, message + " \n Ready for level 2?");
				panel.getNextLevelPicture();
				bar.nextLevelBar();
				gameNumber += 1;
				createLevelTwoButtons();
				time = 0;
				timer.restart();
			}
			break;
		case 2:
			playLevelTwo(e);
			if (isLevelTwoClear()) {
				timer.stop();
				JOptionPane.showMessageDialog(null, message);
				System.exit(0);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		time += 1;
		bar.showTime(time);
	}
}