package com.zys.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	
	private int x = 200;
	private int y = 200;
	
	public TankFrame() {
		this.setSize(800, 600);
		this.setVisible(true);
		this.setTitle("tank war");
		this.setResizable(false);
		
		this.addKeyListener(new MyKeyListener());
		
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		System.out.println("paint");
		g.fillRect(x, y, 50, 50);
		x += 10;
		y += 10;
	}
	
	class MyKeyListener extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.print("keyPressed\n");
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.print("keyReleased\n");
		}
		
	}
	
}
