package m;

import java.util.Date;

public class RockClimbing extends Exercise {
	private double height;
	private int timesScaled;

	public RockClimbing(String name, Date date, double duration, String comment, double height, int tmiesScaled) {
		super(name, date, duration, comment);
		setHeight(height);
		setTimesScaled(timesScaled);
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getTimesScaled() {
		return timesScaled;
	}

	public void setTimesScaled(int timesScaled) {
		this.timesScaled = timesScaled;
	}

	@Override
	public String toStringCustomInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Rock Climbing";
	}

	@Override
	public double getCaloriesBurned() {
		return (getHeight() * getTimesScaled() / super.getDuration()) * 100;
	}

}
