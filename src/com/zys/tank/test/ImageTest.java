package com.zys.tank.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ImageTest {

	@Test
	void test() {
		// fail("Not yet implemented");
		try {
			BufferedImage image = ImageIO.read(new File("/home/zys/Documents/images/GoodTank1.png"));
			Assertions.assertNotNull(image);
			
			BufferedImage image1 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
			//this.getClass();
			Assertions.assertNotNull(image1);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
