package m;

public class RunWalk extends Exercise{
	float  distance;
	float duration;

	
	public RunWalk(float distance, float duration) {
		setDistance(distance);
		setDuration(duration);
		setCalories(distance, duration);
	}
	
	
	
	
	public void setCalories(float distance, float duration) {
		super.setCalories((distance/duration) * 900);
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}
		
}

