package m;

import java.util.Date;

public class RunWalk extends Exercise {
	private double distance;

	public RunWalk(String name, Date date, double duration, String comment, double distance) {
		super(name, date, duration, comment);
		setDistance(distance);
	}
	
	public double getDistance() {
		return this.distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toStringCustomInfo() {
		return getDistance()+"";
	}

	@Override
	public String getType() {
		return "Run Walk";
	}

	@Override
	public double getCaloriesBurned() {
		return (getDistance() / super.getDuration()) * 9000;
	}

}
