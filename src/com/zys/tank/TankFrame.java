package com.zys.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

	private int x = 200;
	private int y = 200;
	private Direction direction = Direction.DOWN;
	private final int speed = 10;

	public TankFrame() {
		// Set Game Window
		this.setSize(800, 600);
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
		graph.fillRect(x, y, 50, 50);
		switch(direction) {
			case LEFT:
				x -= speed;
				break;
			case RIGHT:
				x += speed;
				break;
			case UP:
				y -= speed;
				break;
			case DOWN:
				y += speed;
				break;
		};
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
			if (left) {
				direction = Direction.LEFT;
			}
			
			if (right) {
				direction = Direction.RIGHT;
			}
			
			if (up) {
				direction = Direction.UP;
			}
			
			if (down) {
				direction = Direction.DOWN;
			}
		}
	}
	
}
