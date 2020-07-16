package com.zys.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	
	public TankFrame() {
		this.setSize(1600, 600);
		this.setVisible(true);
		this.setTitle("tank war");
		this.setResizable(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
	
	@Override
	public void paint(Graphics g) {
		g.fillRect(200, 200, 50, 50);
	}
	
}
