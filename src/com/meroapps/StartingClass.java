package com.meroapps;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

public class StartingClass extends Applet implements Runnable, KeyListener {

	private Robot robot;
	private Image image, character;
	private URL base;
	private Graphics second;

	@Override
	public void init() {
		setSize(800, 480);
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Robot Game");
		
		try {
			base = getDocumentBase();
		} catch (Exception e) {
			// TODO: handle exception
		}


		// Image Setups
		character = getImage(base, "data/character.png");
	}

	@Override
	public void start() {
		robot = new Robot();
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void stop() {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void run() {
		while (true) {
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Graphics g) {
		if (image == null) {
			image = createImage(this.getWidth(), this.getHeight());
			second = image.getGraphics();
		}

		second.setColor(getBackground());
		second.fillRect(0, 0, getWidth(), getHeight());
		second.setColor(getForeground());
		paint(second);

		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(character, Robot.getCenterX() - 61, Robot.getCenterY() - 63, this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			System.out.println("Moving Up");
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("Moving Down");
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("Moving Left");
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("Moving Right");
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("Jumping");
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			System.out.println("Stop Moving Up");
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("Stop Moving Down");
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("Stop Moving Left");
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("Stop Moving Right");
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("Stop Jumping");
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}
