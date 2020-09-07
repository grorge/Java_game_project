

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ObjPlayer extends UnitObj{

	
	public ObjPlayer(int x, int y, ID id) {
		super(x, y, 32, 32, id);
	}

	@Override
	public void tick() {
		ApplyMovement();
		// TODO Auto-generated method stub
	}

	public void setVelX(float inp) { this.moveVector.x = inp;};
	public void setVelY(float inp) { this.moveVector.y = inp;};

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
