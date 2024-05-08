package m;

import java.util.Date;

public class Weightlifting extends Exercise {
	private double weightLifted;

	public Weightlifting(String name, Date date, double duration, String comment, double weightLifted) {
		super(name, date, duration, comment);
		setDuration(duration);
	}

	public double getWeightLifted() {
		return weightLifted;
	}

	public void setWeightLifted(double weightLifted) {
		this.weightLifted = weightLifted;
	}

	@Override
	public String toStringCustomInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() {
		return "Weightlifting";
	}

	@Override
	public double getCaloriesBurned() {
		return (getWeightLifted() / super.getDuration()) * 50;
	}

}
