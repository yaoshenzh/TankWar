package com.zys.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	private static final int SPEED = 5;
	
	private int x;
	private int y;
	private Direction direction = Direction.DOWN;
	private boolean isMoving = false;
	
	// Tank hold the reference of TankFrame
	// Since I want to draw the bullet in tankFrame
	private TankFrame tankFrame;
	
	public Tank(int x, int y, Direction direction, TankFrame tankFrame) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.tankFrame = tankFrame;
	}
	
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

	public void paint(Graphics graph) {
		Color color = graph.getColor();
		graph.setColor(Color.GREEN);
		graph.fillRect(x, y, 50, 50);
		graph.setColor(color);
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

	public void fire() {
		tankFrame.bullet = new Bullet(this.x, this.y, this.direction);
	}
}
