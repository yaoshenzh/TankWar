package com.zys.tank.src;

import java.awt.Graphics;

public class Tank {
	private static final int SPEED = 5;
	public static int WIDTH = ResourceManager.tankTowardsDown.getWidth();
	public static int HEIGHT = ResourceManager.tankTowardsDown.getHeight();
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	private int x;
	private int y;
	private Direction direction = Direction.DOWN;
	private boolean isMoving = false;
	private boolean isAlive = true;
	
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
		if (!isAlive) {
//			return;
			tankFrame.enemies.remove(this);
		}
		switch (direction) {
			case LEFT:
				graph.drawImage(ResourceManager.tankTowardsLeft, x, y, null);
				break;
			case RIGHT:
				graph.drawImage(ResourceManager.tankTowardsRight, x, y, null);
				break;	
			case UP:
				graph.drawImage(ResourceManager.tankTowardsUp, x, y, null);
				break;
			case DOWN:
				graph.drawImage(ResourceManager.tankTowardsDown, x, y, null);
				break;
		}
			
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
		int bulletX =  this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
		int bulletY =  this.y + Tank.HEIGHT/2 - Bullet.WIDTH/2;
		
		tankFrame.bullets.add(new Bullet(bulletX, bulletY, this.direction, this.tankFrame));
	}

	public void die() {
		isAlive = false;
	} 
}
