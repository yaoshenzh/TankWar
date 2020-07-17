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
	
	static {
		try {
			tankTowardsLeft = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
			tankTowardsRight = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
			tankTowardsUp = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
			tankTowardsDown = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
			
			bulletLeft = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
			bulletRight = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
			bulletUp = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
			bulletDown = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
