package com.zys.tank.src;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceManager {
	
	public static BufferedImage tankTowardsLeft;
	public static BufferedImage tankTowardsRight;
	public static BufferedImage tankTowardsUp;
	public static BufferedImage tankTowardsDown;
	
	public static BufferedImage bulletLeft;
	public static BufferedImage bulletRight;
	public static BufferedImage bulletUp;
	public static BufferedImage bulletDown;
	
	public static BufferedImage[] explosion = new BufferedImage[16];
	
	static {
		try {
			tankTowardsUp = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
			tankTowardsLeft = ImageUtil.rotateImage(tankTowardsUp, -90);
			tankTowardsRight = ImageUtil.rotateImage(tankTowardsUp, 90);
			tankTowardsDown = ImageUtil.rotateImage(tankTowardsUp, 180);
			
			bulletUp = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
			bulletLeft =  ImageUtil.rotateImage(bulletUp, -90);
			bulletRight = ImageUtil.rotateImage(bulletUp, 90);	
			bulletDown = ImageUtil.rotateImage(bulletUp, 180);
			
			for (int i = 0; i < 16; i++) {
				explosion[i] = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
