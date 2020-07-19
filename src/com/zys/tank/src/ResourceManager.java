package com.zys.tank.src;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceManager {
	
	public static BufferedImage goodTankTowardsLeft;
	public static BufferedImage goodTankTowardsRight;
	public static BufferedImage goodTankTowardsUp;
	public static BufferedImage goodTankTowardsDown;
	
	public static BufferedImage badTankTowardsLeft;
	public static BufferedImage badTankTowardsRight;
	public static BufferedImage badTankTowardsUp;
	public static BufferedImage badTankTowardsDown;
	
	public static BufferedImage bulletLeft;
	public static BufferedImage bulletRight;
	public static BufferedImage bulletUp;
	public static BufferedImage bulletDown;
	
	public static BufferedImage[] explosion = new BufferedImage[16];
	
	static {
		try {
			
			goodTankTowardsUp = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
			goodTankTowardsLeft = ImageUtil.rotateImage(goodTankTowardsUp, -90);
			goodTankTowardsRight = ImageUtil.rotateImage(goodTankTowardsUp, 90);
			goodTankTowardsDown = ImageUtil.rotateImage(goodTankTowardsUp, 180);
			
			badTankTowardsUp = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
			badTankTowardsLeft = ImageUtil.rotateImage(badTankTowardsUp, -90);
			badTankTowardsRight = ImageUtil.rotateImage(badTankTowardsUp, 90);
			badTankTowardsDown = ImageUtil.rotateImage(badTankTowardsUp, 180);
			
			
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
