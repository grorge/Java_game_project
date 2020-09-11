

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

import javax.imageio.ImageIO;


public class ObjectHandler {

	private int nextUID = 0;
	LinkedList<GameObj> objects = new LinkedList<GameObj>();

	LinkedList<ObjPlayer> players = new LinkedList<ObjPlayer>();
	LinkedList<ObjEnemy> enemies = new LinkedList<ObjEnemy>();
	
	GlobalEvents gEvent; 
	
	private HashMap<IMAGENAME, BufferedImage> imgBank = new HashMap<IMAGENAME, BufferedImage>();

	public ObjectHandler(GlobalEvents eve) {
		this.gEvent = eve;
		

		ImageBank temp_bank = new ImageBank();
		this.imgBank = temp_bank.LoadImages();
		
	}
	
	
	
	
	public void tick() {
		for (int i = 0; i < objects.size(); i++) {
			GameObj obj = objects.get(i);
			
			obj.tick();
		}
		
		collisionCheck();
	}

	public void render(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObj obj = objects.get(i);
			
			obj.render(g, imgBank.get(obj.img));
//			obj.render(g, imgBank.get(ImageEnum.WALL));
		}
	}
	
	
	public void addObj(GameObj obj) {
		obj.uID = nextUID++;
		this.objects.add(obj);
		
		if (obj instanceof ObjPlayer) {
			this.players.add((ObjPlayer)obj);
		}
	}
	
	public void addMapObjects(LinkedList<GameObj> mapObjects) {
		objects.clear();
		players.clear();

		this.addObj(new ObjPlayer(516,516,ID.Player));
		
		ObjEnemy enemy = new ObjEnemy(316,316,ID.Enemy);
		enemy.SetTarget(this.players.getFirst());
		this.addObj(enemy);
		enemy = new ObjEnemy(316,816,ID.Enemy);
		enemy.SetTarget(this.players.getFirst());
		this.addObj(enemy);
		
		
		
		
		for (GameObj gameObj : mapObjects) {
			objects.add(gameObj);
		}
		
		
	}
	
	//////////////////////
	//////////////////////
	//////////////////////
	
	private void collisionCheck() {
		// Player collision check with the world
		for (ObjPlayer ori : players) {
			for (GameObj target : objects) {
				if (ori.uID != target.uID) {
					
					if (ori.collidingWith(target)) {
//						System.out.println("COLLISION");
						
						target.playerCollision(ori, this.gEvent);
						
					}
				}
			}
		}
		
		// Emeny collision check
		for (ObjEnemy ori : enemies) {
			for (GameObj target : objects) {
				if (ori.uID != target.uID) {
					
					if (ori.collidingWith(target)) {
//						System.out.println("COLLISION");
						
						ori.TerrainCollision(target);
						
					}
				}
			}
		}
	}
}
