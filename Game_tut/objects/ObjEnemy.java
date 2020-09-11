import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Vector;

// Object handling enemy logic - will be expanded to subclasses
public class ObjEnemy extends UnitObj {

	GameObj targetObj;

	public ObjEnemy(int x, int y, ID id) {
		super(x, y, 32, 32, id);
	}

	@Override
	public void tick() {
		ApplyMovement();
		
		MovementVector target_pos = new MovementVector(targetObj.x, targetObj.y);

		MovementVector dir = target_pos.GetSubtractedVector(new MovementVector(this.x,this.y));
		
		dir.SnapToAxis();
		
		this.moveVector = dir;
		
//		System.out.println(dir.x + "," + dir.y);
		
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
		
		this.moveVector.x *= -1.0f;
		this.moveVector.y *= -1.0f;
	}
	
	
	public void TerrainCollision(GameObj object) {
		this.moveVector.x *= -1.0f;
		this.moveVector.y *= -1.0f;
	}
}
