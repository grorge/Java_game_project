

public class Tile {
	
	TILETYPE type = TILETYPE.Undefined;
	IMAGENAME img = IMAGENAME.TREE;
	
	int x,y,z;
	
	
	Tile(TILETYPE type, int x, int y, int z){
		
		this.type = type;
		
		switch (type) {
		case Filed:
			img = IMAGENAME.FIELD;
			break;
		case WFloor:
			img = IMAGENAME.WOODFLOOR;
			break;
		case Tree: 
			img = IMAGENAME.TREE;
			break;
		case Wall:
			img = IMAGENAME.WALL;
			
			break;

		default:
			img = IMAGENAME.TREE;
			
			break;
		}
		
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
