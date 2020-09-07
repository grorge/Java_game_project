
public class MovementVector {
	float x;
	float y;
	
	float length;
	
	float reductionSpeed;

	public MovementVector(float x, float y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.reductionSpeed = 1;
	}
	public MovementVector() {
		// TODO Auto-generated constructor stub
		x = 0;
		y = 0;
		this.reductionSpeed = 1;
	}
	
	public void tick() {
		this.x *= this.reductionSpeed;
		this.y *= this.reductionSpeed;
	}
	
	public void ChangeSpeed(float inp) {
		this.x *= inp;
		this.y *= inp; 
	}
	
	public void NormalizeVector() {
		this.length = GetLength();
		
		this.x /= this.length;
		this.y /= this.length;
	}
	
	public MovementVector GetNormalizedVector() {
		this.length = GetLength();
		
		MovementVector ret_vector = new MovementVector(x/length,y/length);
		
		return ret_vector;
	}
	
	public float GetLength() {
		return (float) Math.sqrt((double)(x*x + y*y));
	}
}
