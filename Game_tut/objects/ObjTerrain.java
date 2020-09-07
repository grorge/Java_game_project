
import java.awt.Color;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ObjTerrain extends GameObj
{

	public ObjTerrain(int x, int y, int w, int h) {
		super(x, y, w, h, ID.Terrain);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g, BufferedImage bi) {
		// TODO Auto-generated method stub
		//g.setColor(Color.darkGray);
		//g.fillRect(this.x, this.y, w, h);

		g.drawImage(bi, this.x, this.y, null);
		
	}

	@Override
	protected void SetImage() {
		// TODO Auto-generated method stub
		this.img = IMAGENAME.WALL;
	}

	@Override
	public void playerCollision(ObjPlayer player, GlobalEvents gEvent) {

		// Simple collision handling
		player.x += player.moveVector.x * -1.0f;
		player.y += player.moveVector.y * -1.0f; 
		
		
	}

}
