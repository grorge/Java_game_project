
// Handels vector logic for movement of objects
public class MovementVector {
	float x;
	float y;
	
	float length;
	
	// A factor to lower the spped and power of the movement by
	float reductionSpeed;

	
	public MovementVector(float x, float y) {
		this.x = x;
		this.y = y;
		this.reductionSpeed = 1;
	}
	
	// init with all elements as zero
	public MovementVector() {
		x = 0;
		y = 0;
		this.reductionSpeed = 1;
	}
	
	// Reduces the movement by its factor
	public void tick() {
		this.x *= this.reductionSpeed;
		this.y *= this.reductionSpeed;
	}
	
	// Multiply both axis with parameter
	public void ChangeSpeed(float inp) {
		this.x *= inp;
		this.y *= inp; 
	}
	
	// Normalize and saves the vector
	public void NormalizeVector() {
		this.length = GetLength();
		
		this.x /= this.length;
		this.y /= this.length;
	}
	
	// Floors the elements to 1
	public void SnapToAxis() {
		if (this.x > 0) {
			this.x = 1.0f;
		}
		else if (this.x < 0) {
			this.x = -1.0f;
		}
		if (this.y > 0) {
			this.y = 1.0f;
		}
		else if (this.y < 0) {
			this.y = -1.0f;
		}
	}
	
	// Returns the normalized direction of the vector
	public MovementVector GetDirectionVector() {
		this.length = GetLength();
		
		MovementVector ret_vector = new MovementVector(x/length,y/length);
		
		return ret_vector;
	}

	// Returns the length of the vector
	public float GetLength() {
		return (float) Math.sqrt((double)(x*x + y*y));
	}
	
	// Returns the combined vector
	public MovementVector GetCombinedVector(MovementVector target) {
		MovementVector ret_vec = new MovementVector(this.x + target.x, this.y + target.y);
		
		return ret_vec;
	}
	
	// Returns this vector with the parameter subtracted from this vector. 
	public MovementVector GetSubtractedVector(MovementVector target) {
		MovementVector ret_vec = new MovementVector(this.x - target.x, this.y - target.y);
		
		return ret_vec;
	}
	
}
