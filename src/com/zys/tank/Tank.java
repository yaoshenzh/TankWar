package com.zys.tank;

import java.awt.Graphics;

public class Tank {
	private static final int SPEED = 5;
	
	private int x;
	private int y;
	private Direction direction;
	private boolean isMoving = false;
	
	public boolean isMoving() {
		return isMoving;
	}

	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}

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
		move(direction);
	}

	private void move(Direction direction) {
		if (!isMoving) {
			return;
		}
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
