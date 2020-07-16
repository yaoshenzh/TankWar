package com.zys.tank;

public class T {

	public static void main(String[] args) {
		TankFrame f = new TankFrame();
		
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
