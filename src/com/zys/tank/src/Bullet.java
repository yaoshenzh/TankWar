package com.zys.tank.src;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {
	private static final int SPEED = 10;
	public static int WIDTH = ResourceManager.bulletUp.getWidth();
	public static int HEIGHT = ResourceManager.bulletUp.getHeight();
	
	private int x;
	private int y;
	private Direction bulletDirection;
	private boolean isAlive = true;
	private Group group = Group.BAD;
	
	private TankFrame tankFrame;
	
	public Bullet(int x, int y, Direction bulletDirection, Group group, TankFrame tankFrame) {
		this.bulletDirection = bulletDirection;
		this.x = x;
		this.y = y;
		this.group = group;
		this.tankFrame = tankFrame;
	}
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public void paint(Graphics graph) {
		if (!isAlive) {
			tankFrame.bullets.remove(this);
		}
		switch (bulletDirection) {
			case LEFT:
				graph.drawImage(ResourceManager.bulletLeft, x, y, null);
				break;
			case RIGHT:
				graph.drawImage(ResourceManager.bulletRight, x, y, null);
				break;	
			case UP:
				graph.drawImage(ResourceManager.bulletUp, x, y, null);
				break;
			case DOWN:
				graph.drawImage(ResourceManager.bulletDown, x, y, null);
				break;
		}
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
	
	public void collideWithTank(Tank tank) {
		if (this.group == tank.getGroup()) {
			return;
		}
		
		//TODO:Use only one Rectangle to record the position of Bullet.
		Rectangle bulletImage = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
		Rectangle tankImage = new Rectangle(tank.getX(), tank.getY(), tank.WIDTH, tank.HEIGHT);
		
		if (bulletImage.intersects(tankImage)) {
			tank.die();
			this.die();
			tankFrame.explosion.add(new Explosion(x, y, tankFrame));
		}
	}

	private void die() {
		this.isAlive = false;
	}
}
