import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class ObjEnemy extends UnitObj {

	GameObj targetObj;

	public ObjEnemy(int x, int y, ID id) {
		super(x, y, 32, 32, id);
	}

	@Override
	public void tick() {
		ApplyMovement();

		Vector dir = new Vector();
		dir.add(this.targetObj.x - this.x);
		
		
	}
	
	public void SetTarget(GameObj target) {
		this.targetObj = target;
	}

	@Override
	protected void SetImage() {
		// TODO Auto-generated method stub
		this.img = IMAGENAME.TREE;
		
	}

	@Override
	public void playerCollision(ObjPlayer player, GlobalEvents gEvent) {
		// TODO Auto-generated method stub
		player.w = 64;
		
	}
}
