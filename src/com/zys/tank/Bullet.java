package com.zys.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	private static final int SPEED = 10;
	private static int WIDTH =30;
	private static int HEIGHT = 30;
	
	private int x;
	private int y;
	private Direction bulletDirection;
	private boolean isAlive = true;
	
	private TankFrame tankFrame;
	
	public Bullet(int x, int y, Direction bulletDirection, TankFrame tankFrame) {
		this.bulletDirection = bulletDirection;
		this.x = x;
		this.y = y;
		this.tankFrame = tankFrame;
	}
	
	public void paint(Graphics graph) {
		if (!isAlive) {
			tankFrame.bullets.remove(this);
		}
		Color color = graph.getColor();
		graph.setColor(Color.RED);
		graph.fillOval(x, y, WIDTH, HEIGHT);
		graph.setColor(color);
		move();
	}

	private void move() {

		switch(bulletDirection) {
		
		case LEFT:
			x -= SPEED;
			break;
		case RIGHT:
			x += SPEED;
			break;
		case UP:
			y -= SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;
		};
		
		if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
			isAlive = false;
		}
	}

}
