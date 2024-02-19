package mymath;

public class Interval {
	private int ondergrens;
	private int lengte;
	
	public static int getLengte(Interval interval) {
		return interval.lengte;
	}
	
	public static void setOndergrens(Interval interval, int nieuweOndergrens) {
		interval.ondergrens = nieuweOndergrens;
	}
	
	public static void setBovengrens(Interval interval, int nieuweBovengrens) {
		interval.lengte = nieuweBovengrens - interval.ondergrens;
	}
}
