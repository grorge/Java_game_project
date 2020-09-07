import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class UnitObj extends GameObj {

	public UnitObj(int x, int y, int w, int h, ID id) {
		super(x, y, w, h, id);
		// TODO Auto-generated constructor stub
	}

//	@Override
//	protected void SetImage() {
//		// TODO Auto-generated method stub
//		
//	}

	//@Override
	//public abstract void tick();
	
	public void ApplyMovement() {
		this.x += velX;
		this.y += velY;

		this.cx = this.x + (this.w/2);
		this.cy = this.y + (this.h/2);
	}

	@Override
	public void render(Graphics g, BufferedImage bi) {
		// TODO Auto-generated method stub
		g.drawImage(bi, this.x, this.y, this.w, this.h, null);
		
	}

//	@Override
//	public void playerCollision(ObjPlayer player, GlobalEvents gEvent) {
//		// TODO Auto-generated method stub
//		
//	}

}
