package com.zys.tank.src;

public class Main {

	public static void main(String[] args) {
		TankFrame f = new TankFrame();
		
		int initTankCount = Integer.parseInt((String)PropertyManager.get("initTankCount"));
		
		for (int i = 0; i < initTankCount; i++) {
			f.enemies.add(new Tank(50 + i*80, 200, Direction.DOWN, Group.BAD, f));
		}
		
		while(true) {
			try {
				Thread.sleep(50);
				f.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
