
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ObjDoor extends GameObj{
	
	public String map = "";
	
	ObjDoor(int x, int y, String map) {
		super(x, y, 32, 32, ID.Door);
		// TODO Auto-generated constructor stub
		this.map = map;
	}

	@Override
	protected void SetImage() {
		// TODO Auto-generated method stub
		this.img = IMAGENAME.DOOR;
	}
 
	@Override
	public void tick() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(Graphics g, BufferedImage bi) {
		// TODO Auto-generated method stub

		g.drawImage(bi, this.x, this.y, null);
	}

	@Override
	public void playerCollision(ObjPlayer player, GlobalEvents gEvent) {
		System.out.println("COLLISION: " + this.map + " is loaded");
		gEvent.currEvent = GLOBALEVENTTYPES.LoadMap;
		
		
		gEvent.msg = this.map;
		
	}
}