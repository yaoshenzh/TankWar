package com.zys.tank.src;

import java.awt.Graphics;

public class Explosion {
	
	public static int WIDTH = ResourceManager.bulletUp.getWidth();
	public static int HEIGHT = ResourceManager.bulletUp.getHeight();
	
	private int x;
	private int y;
	private int step = 0;
	private TankFrame tankFrame;
	
	public Explosion(int x, int y, TankFrame tankFrame) {
		this.x = x;
		this.y = y;
		this.tankFrame = tankFrame;
	}
	

	public void paint(Graphics graph) {
		graph.drawImage(ResourceManager.explosion[step++], x, y, null);
		if (step >= ResourceManager.explosion.length) {
			tankFrame.explosion.remove(this);
		}
	}

}
