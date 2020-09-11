import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

import javax.imageio.ImageIO;



public class MapLoader {

	static int TILESIZE = 32;
	MapData mapData;

	LinkedList<Tile> tiles = new LinkedList<Tile>();
	LinkedList<GameObj> mapObjects = new LinkedList<GameObj>();

	private HashMap<IMAGENAME, BufferedImage> imgBank = new HashMap<IMAGENAME, BufferedImage>();
	

	public MapLoader() {
		//int size = (int)Math.sqrt(numbTiles);
//		mapData.mapWidth = size;
//		mapData.mapHeigth = size;
		
//		this.loadMap(new MapDataHome());
		
		ImageBank temp_bank = new ImageBank();
		this.imgBank = temp_bank.LoadImages();
		
//		try {
//			this.imgBank.put(IMAGENAME.FIELD, ImageIO.read(new File("img/grass32.png")));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("ERROR LOADING IMAGE");
//		}
//		try {
//			this.imgBank.put(IMAGENAME.WALL, ImageIO.read(new File("img/wall32.png")));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("ERROR LOADING IMAGE");
//		}
//		try {
//			this.imgBank.put(IMAGENAME.TREE, ImageIO.read(new File("img/tree.png")));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("ERROR LOADING IMAGE");
//		}
//		try {
//			this.imgBank.put(IMAGENAME.WOODFLOOR, ImageIO.read(new File("img/woodfloor32.png")));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("ERROR LOADING IMAGE");
//		}
		
	}
	
	public void loadMap(MapData new_map){
		mapData = new_map;
		
		// Clear out last map
		this.mapObjects.clear();
		this.tiles.clear();
		 
		
		
		int currX = 0, currY = 0;
//		int totalTiles = mapWidth * mapHeigth;
		
		for (int y = 0; y < new_map.mapHeigth; y++) {
			for (int x = 0; x < new_map.mapWidth; x++) {
				
				currX = x*TILESIZE;
				currY = y*TILESIZE;
//				System.out.println(new_map.map_array);
				char tile = new_map.map_array.get(y).charAt(x); 

//				System.out.print(tile);
				
				TILETYPE type = TILETYPE.Undefined;
				switch (tile) {
				case 'f': 
					type = TILETYPE.Filed;
//					this.addTile(new Tile(TileType.Filed, currX, currY, 0));
					break;
				case 'w': 

					type = TILETYPE.Wall;
//					this.addTile(new Tile(TileType.Wall, currX, currY, 0));
					break;
				case 't': 

					type = TILETYPE.Tree;
//					this.addTile(new Tile(TileType.Tree, currX, currY, 0));

					break;
				case 'v': 

					type = TILETYPE.WFloor;
//					this.addTile(new Tile(TileType.Tree, currX, currY, 0));

					break;
				case 'd': 

					type = TILETYPE.Door;
					
//					this.addTile(new Tile(TileType.Tree, currX, currY, 0));

					break;
				default:
//					throw new IllegalArgumentException("Unexpected vaaalue: " + new_map.map_array.get(y).charAt(x));
					break;
				}
				

				this.addTile(new Tile(type, currX, currY, 0));
			}
		}
	}
	
	
	public boolean addTile(Tile tile) {

		
		GameObj obj;
		switch (tile.type) {
		case Filed:
			tiles.add(tile);
			break;
		case WFloor:
			tiles.add(tile); 
			break;

		case Wall : 
			obj = new ObjTerrain(tile.x, tile.y, 32,32);
			
			this.mapObjects.add(obj);
//			yield type;
			break;
		case Door : 
			if (this.mapData.doorArray.isEmpty()) {
				System.out.println("Door array was called when empty");
				break;
			}
			else {
				obj = new ObjDoor(tile.x, tile.y, this.mapData.doorArray.get(0));
				this.mapData.doorArray.remove(0);	
				
				this.mapObjects.add(obj);
			}
			
//			yield type;
			break;
		default:
			// Dont create any objects if not any of the defined classes
//			throw new IllegalArgumentException("Unexpected value: " + tile.type);
		}
		
		
		return true;
	}
	
	
	///////////////////////
	///////////////////////
	///////////////////////
	///////////////////////
	
	
	
	public void render(Graphics g) {
		for (Tile tile : tiles) {
			g.drawImage(imgBank.get(tile.img), tile.x, tile.y, null);
		}
	}
	
	
}
