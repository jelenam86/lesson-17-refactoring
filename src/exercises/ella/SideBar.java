package exercises.ella;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Field;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SideBar extends JPanel implements ActionListener, KeyListener {

	JLabel barTitle = new JLabel("FIND:");
	JLabel snakeName = new JLabel("snake");
	JLabel ringName = new JLabel("ring");
	JLabel backpackName = new JLabel("backpack");
	JLabel sparklesName = new JLabel("sparkles");
	JLabel pawprintsName = new JLabel("pawprints");
	JLabel diamondName = new JLabel("diamond");
	JLabel balloonName = new JLabel("balloon");
	JLabel appleName = new JLabel("apple");
	JLabel bowName = new JLabel("bow");
	JLabel roseName = new JLabel("rose");
	JLabel cloudName = new JLabel("cloud");
	JLabel chickenName = new JLabel("chicken");
	JLabel earthName = new JLabel("earth");
	JLabel cactusName = new JLabel("cactus");
	JLabel timeName = new JLabel("Time: 0");

	int foundMeX = 76;
	int foundMeWidth = 275;
	int foundMeHeight = 75;
	int findMeY = 90;
	int findMeY2 = findMeY + 40;
	int findMeY3 = findMeY + 80;
	int findMeY4 = findMeY + 120;
	int findMeY5 = findMeY + 160;
	int findMeY6 = findMeY + 200;
	int findMeY7 = findMeY + 240;
	final int BAR1 = 0;
	final int BAR2 = 1;
	int currentBar = BAR1;

	SideBar() {
		setPreferredSize(new Dimension(285, 1000));
		add(barTitle);
		barTitle.setFont(new Font("Serif", Font.PLAIN, 45));
		setLayout(null);
		barTitle.setBounds(84, 20, 200, 100);
		showLevelOneNames();
		setOpaque(true);
		setBackground(Color.PINK);
		repaint();
	}

	private void addObjectName(JLabel label, int xBound, int yBound, int width) {
		add(label);
		label.setFont(new Font("Serif", Font.PLAIN, 30));
		label.setBounds(xBound, yBound, width, 75);
	}

	void showLevelOneNames() {
		addObjectName(snakeName, 102, findMeY, 100);
		addObjectName(ringName, 113, findMeY2, 100);
		addObjectName(backpackName, 83, findMeY3, 275);
		addObjectName(sparklesName, 90, findMeY4, 250);
		addObjectName(pawprintsName, 83, findMeY5, 275);
		addObjectName(diamondName, 87, findMeY6, 250);
		addObjectName(balloonName, 95, findMeY7, 250);
		addObjectName(timeName, 95, 850, 250);
	}

	void showLevelTwoNames() {
		addObjectName(appleName, 102, findMeY, 100);
		addObjectName(bowName, 109, findMeY2, 90);
		addObjectName(roseName, 110, findMeY3, 100);
		addObjectName(cloudName, 101, findMeY4, 100);
		addObjectName(chickenName, 92, findMeY5, 250);
		addObjectName(earthName, 101, findMeY6, 100);
		addObjectName(cactusName, 101, findMeY7, 100);
	}

	void nextLevelBar() {
		currentBar += 1;
		if (currentBar > BAR2)
			currentBar = BAR1;
		if (currentBar == BAR1)
			setBackground(Color.PINK);
		System.out.println(currentBar);
		if (currentBar == 1) {
			setBackground(Color.BLUE);
			showLevelTwoNames();
		}
		repaint();
	}

	void foundItem(String itemButton) {
		for (Field f : getClass().getDeclaredFields())
			if (f.getType() == JLabel.class && f.getName().substring(0, f.getName().length() - 4).equals(itemButton))
				try {
					JLabel item = (JLabel) f.get(this);
					item.setVisible(false);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
	}

	void showTime(int time) {
		timeName.setText("Time: " + time);
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