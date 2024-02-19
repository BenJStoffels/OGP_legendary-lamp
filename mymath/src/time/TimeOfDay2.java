package time;

/**
 * Elke instantie van deze klasse slaat een uur van de dag op.
 * 
 * @invar Het uur is tussen 0 en 24.
 *    | 0 <= getHour() && getHour() < 24
 * @invar De minutes zijn tussen 0 en 60.
 *    | 0 <= getMinutes() && getMinutes() < 60
 * @invar De minuten sinds middernacht zijn tussen 0 en 60 * 24
 *    | 0 <= getMinutesSinceMidnight() && getMinutesSinceMidnight() < 60 * 24
 * @invar 60 keer het uur plus de minuten is gelijk aan de minuten sinds middernacht.
 *    | getMinutesSinceMidnight() == getHour() * 24 + getMinutes()
 */
public class TimeOfDay2 {
	/**
	 * @invar minuten sinds middernacht liggen tussen 0 en 60 * 24
	 *    | 0 <= minutesSinceMidnight && minutesSinceMidnight < 60 * 24
	 */
	private int minutesSinceMidnight;
	
	/**
	 * Initialiseert het object met de gegeven uur en minuten.
	 * 
	 * @pre uur is tussen 0 en 24.
	 *    | 0 <= hour && hour < 24
	 * @pre minuten zijn tussen 0 en 60.
	 *    | 0 <= minutes && minutes < 60
	 * @post het uur van het nieuwe object is het gegeven uur.
	 *    | getHour() == hour
	 * @post de minuten van het nieuwe object zijn de gegeven minuten.
	 *    | getMinutes() == minutes
	 */
	public TimeOfDay2(int hour, int minutes) {
		this.minutesSinceMidnight = hour * 60 + minutes;
	}
	
	/**
	 * Initialiseert het object met de gegeven uur en minuten.
	 * 
	 * @pre minuten sinds middernacht zijn tussen 0 en 60 * 24.
	 *    | 0 <= minutesSinceMidnight && minutesSinceMidnight < 60 * 24
	 * @post de minutesSinceMidnight van het nieuwe object is de gegeven minutesSinceMidnight.
	 *    | getMinutesSinceMidnight() == minutesSinceMidnight 
	 */
	public TimeOfDay2(int minutesSinceMidnight) {
		this.minutesSinceMidnight = minutesSinceMidnight;
	}
	
	public int getHour() {
		return minutesSinceMidnight / 60;
	}
	
	public int getMinutes() {
		return minutesSinceMidnight % 60;
	}
	
	public int getMinutesSinceMidnight() {
		return minutesSinceMidnight;
	}
	
	/**
	 * Stelt de tijd van het object op de gegeven minuten sinds middernacht.
	 * 
	 * @pre minuten sinds middernacht zijn tussen 0 en 60 * 24.
	 *    | 0 <= minutesSinceMidnight && minutesSinceMidnight < 60 * 24
	 * @post de minutesSinceMidnight van het nieuwe object is de gegeven minutesSinceMidnight.
	 *    | getMinutesSinceMidnight() == minutesSinceMidnight 
	 */
	public void setTime(int minutesSinceMidnight) {
		this.minutesSinceMidnight = minutesSinceMidnight;
	}
	
	/**
	 * Stelt de tijd van het object op de gegeven uur en minuten.
	 * 
	 * @pre uur is tussen 0 en 24.
	 *    | 0 <= hour && hour < 24
	 * @pre minuten zijn tussen 0 en 60.
	 *    | 0 <= minutes && minutes < 60
	 * @post het uur van het nieuwe object is het gegeven uur.
	 *    | getHour() == hour
	 * @post de minuten van het nieuwe object zijn de gegeven minuten.
	 *    | getMinutes() == minutes
	 */
	public void setTime(int hour, int minutes) {
		this.minutesSinceMidnight = hour * 60 + minutes;
	}
	
	/**
	 * Stelt het uur van het object op het gegeven uur.
	 * 
	 * @pre uur is tussen 0 en 24.
	 *    | 0 <= hour && hour < 24
	 * @post het uur van het object is het gegeven uur.
	 *    | getHour() == hour
	 * @post de minuten van het object blijven onveranderd.
	 *    | getMinutes() == old(getMinutes())
	 */
	public void setHour(int hour) {
		this.minutesSinceMidnight = hour * 60 + getMinutes();
	}
	
	/**
	 * Stelt de minuten van het object op de gegeven minuten.
	 * 
	 * @pre minuten zijn tussen 0 en 60.
	 *    | 0 <= minutes && minutes < 60
	 * @post het uur van het object blijft onveranderd.
	 *    | getHour() == old(getHour())
	 * @post de minuten van het object zijn de gegeven minuten.
	 *    | getMinutes() == minutes
	 */
	public void setMinutes(int minutes) {
		this.minutesSinceMidnight = getHour() * 60 + minutes;
	}
}
