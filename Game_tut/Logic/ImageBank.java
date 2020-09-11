import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ImageBank {
	
	private HashMap<IMAGENAME, BufferedImage> imgBank = new HashMap<IMAGENAME, BufferedImage>();
	
	public HashMap<IMAGENAME, BufferedImage> LoadImages() {
		
		// Load the images into the image bank
		try {
			this.imgBank.put(IMAGENAME.FIELD, ImageIO.read(new File("img/grass32.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("ERROR LOADING IMAGE");
		}
		try {
			this.imgBank.put(IMAGENAME.WALL, ImageIO.read(new File("img/wall32.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("ERROR LOADING IMAGE");
		}
		try {
			this.imgBank.put(IMAGENAME.EMPTY, ImageIO.read(new File("img/empty32.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("ERROR LOADING IMAGE");
		}
		try {
			this.imgBank.put(IMAGENAME.WATER, ImageIO.read(new File("img/water32.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("ERROR LOADING IMAGE");
		}
		try {
			this.imgBank.put(IMAGENAME.WOODFLOOR, ImageIO.read(new File("img/woodFloor32.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("ERROR LOADING IMAGE");
		}
		try {
			this.imgBank.put(IMAGENAME.MUSHROOM, ImageIO.read(new File("img/mushroom32.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("ERROR LOADING IMAGE");
		}
		try {
			this.imgBank.put(IMAGENAME.TREE, ImageIO.read(new File("img/tree.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("ERROR LOADING IMAGE");
		}
		try {
			this.imgBank.put(IMAGENAME.DOOR, ImageIO.read(new File("img/door32.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("ERROR LOADING IMAGE");
		}
				
		return this.imgBank;
	}
}
