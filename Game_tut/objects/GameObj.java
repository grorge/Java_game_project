
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class GameObj {
	
	protected ID id;
	public IMAGENAME img;
	
	protected int uID = -1;
	protected int x, y, w, h;
	protected float velX, velY;
	
	protected int cx, cy;
	
	public GameObj(int x, int y, int w, int h, ID id) {
		this.x = x;
		this.y = y; 
		this.w = w;
		this.h = h;
		this.id = id;
		
		cx = this.x + (w/2);
		cy = this.y + (h/2);
		
		
		this.SetImage();
	}
	protected abstract void SetImage();
	
	public abstract void tick();
	public abstract void render(Graphics g, BufferedImage bi);

	
	
	// Set/Get
	public void setX(int x) { this.x = x;};
	public void setY(int y) { this.y = y;};
	public int getX(int x) { return x;};
	public int getY(int y) { return y;};

	public void setVelX(float inp) { this.velX = inp;};
	public void setVelY(float inp) { this.velY = inp;};
	
	
	// Physix
	public boolean collidingWith(GameObj target) {
		
		// Simple collision
		if (this.x < target.x + target.w)
			if(this.x + this.w > target.x) 
				if (this.y < target.y + target.h)
					if(this.y + this.h > target.y) {
						return true;
					}
		
		return false; 
	}
	public abstract void playerCollision(ObjPlayer player, GlobalEvents gEvent);
	
}
