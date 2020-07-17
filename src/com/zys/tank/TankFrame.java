package com.zys.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	
	Image offScreenImage = null;
	private static final int GAME_WIDTH = 800;
	private static final int GAME_HEIGHT = 600;
	
	Tank myTank = new Tank(200, 200, Direction.DOWN);
	Bullet bullet = new Bullet(300, 300, Direction.DOWN);
	
	public TankFrame() {
		// Set Game Window
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		this.setVisible(true);
		this.setTitle("Tank War");
		this.setResizable(false);

		// Listen key activity
		this.addKeyListener(new MyKeyListener());

		// Listen window activity :
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	// move tank according to the it's direction.
	public void paint(Graphics graph) {
		// give the paint to myTank.
		// Think why the code like this?
		myTank.paint(graph);
		bullet.paint(graph);
	}

	class MyKeyListener extends KeyAdapter {

		boolean left = false;
		boolean up = false;
		boolean right = false;
		boolean down = false; 

		@Override
		//set direction according to the key.
		public void keyPressed(KeyEvent e) {
			// which key is pressed？
			int keyCode = e.getKeyCode();
			switch (keyCode) {
		
				case KeyEvent.VK_LEFT:
					left = true;
					break;
				case KeyEvent.VK_UP:
					up = true;
					break;
				case KeyEvent.VK_RIGHT:
					right = true;
					break;
				case KeyEvent.VK_DOWN:
					down = true;
					break;
	
				default:
					break;
			};
			
			setMainTankDirection();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// which key is pressed？
			int keyCode = e.getKeyCode();
			switch (keyCode) {
			case KeyEvent.VK_LEFT:
				left = false;
				break;
			case KeyEvent.VK_UP:
				up = false;
				break;
			case KeyEvent.VK_RIGHT:
				right = false;
				break;
			case KeyEvent.VK_DOWN:
				down = false;
				break;

			default:
				break;
			};
			setMainTankDirection();
		}
		
		// set direction.
		private void setMainTankDirection() {
			if (!left && !right && !up && !down) {
				myTank.setMoving(false);
			} else  {
				myTank.setMoving(true);
				if (left) {
					myTank.setDirection(Direction.LEFT);
				}
				
				if (right) {
					myTank.setDirection(Direction.RIGHT);
				}
				
				if (up) {
					myTank.setDirection(Direction.UP);
				}
				
				if (down) {
					myTank.setDirection(Direction.DOWN);
				}
			}
		}
	}
	
	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
}
