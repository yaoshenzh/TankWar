package com.zys.tank;

import java.awt.Graphics;

public class Tank {
	private static final int SPEED = 10;
	
	private int x;
	private int y;
	private Direction direction;

	
	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Tank(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	public void paint(Graphics graph) {
		graph.fillRect(x, y, 50, 50);
		switch(direction) {
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
