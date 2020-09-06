

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ObjPlayer extends GameObj{

	
	public ObjPlayer(int x, int y, ID id) {
		super(x, y, 32, 32, id);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		this.x += velX;
		this.y += velY;

		this.cx = this.x + (this.w/2);
		this.cy = this.y + (this.h/2);
	}
 
	@Override
	public void render(Graphics g, BufferedImage bi) {
		g.setColor(Color.red);
		g.fillRect(this.x, this.y, w, h);
	}

	@Override
	protected void SetImage() {
		// TODO Auto-generated method stub
		this.img = IMAGENAME.TREE;
		
	}

	@Override
	public void playerCollision(ObjPlayer player, GlobalEvents gEvent) {
		// TODO Auto-generated method stub
		
	}
}
