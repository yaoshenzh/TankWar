package com.zys.tank.src;

public class T {

	public static void main(String[] args) {
		TankFrame f = new TankFrame();
		
		for (int i = 0; i < 5; i++) {
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
