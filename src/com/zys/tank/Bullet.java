package com.zys.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	private static final int SPEED = 1;
	private static int WIDTH =30;
	private static int HEIGHT = 30;
	private int x;
	private int y;
	
	private Direction bulletDirection;
	
	public Bullet(int x, int y, Direction bulletDirection) {
		this.bulletDirection = bulletDirection;
		this.x = x;
		this.y = y;
	}
	
	public void paint(Graphics graph) {
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
	}

}
