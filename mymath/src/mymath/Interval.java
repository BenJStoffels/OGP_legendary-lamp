package mymath;


/**
 * Elke instantie van deze klasse slaat een interval op de gehele as op.
 * 
 * @invar De lengte is niet negatief. (Abstractetoestandsinvariant)
 *    | 0 <= getLengte()
 * @invar De bovengrens is gelijk aan de ondergrens plus de lengte.
 *    | getBovengrens() == getOndergrens() + getLengte()
 */
public class Interval {
	/**
	 * @invar De lengte is niet negatief. (Concretetoestandsinvariant)
	 *     | 0 <= lengte
	 */
	private int ondergrens;
	private int lengte;
	
	public int getOndergrens() {
		return ondergrens;
	}
	
	public int getBovengrens() {
		return ondergrens + lengte;
	}
	
	public int getLengte() {
		return lengte;
	}
	
	/**
	 * Initialiseert dit object met de gegeven onder- en bovengrens.
	 * 
	 * @pre De gegeven bovengrens is niet kleiner dan de gegeven ondergrens.
	 *    | ondergrens <= bovengrens
	 * @post De ondergrens van het nieuwe object is gelijk aan de gegeven ondergrens.
	 *    | getOndergrens() == ondergrens
	 * @post De bovengrens van het nieuwe object is gelijk aan de gegeven bovengrens.
	 *    | getBovengrens() == bovengrens
	 */
	public Interval(int ondergrens, int bovengrens) {
		this.ondergrens = ondergrens;
		this.lengte = bovengrens - ondergrens;
	}
	
	/**
	 * Stelt de ondergrens van dit object in op de gegeven waarde.
	 * 
	 * @pre De gegeven ondergrens is niet groter dan de bovengrens van dit object.
	 *    | nieuweOndergrens <= getBovengrens()
	 * @mutates | this
	 * @post De ondergrens van dit object is gelijk aan de gegeven ondergrens.
	 *    | this.getOndergrens() == nieuweOndergrens
	 * @post De lengte blijft ongewijzigd.
	 *    | getLengte() == old(getLengte())
	 */
	public void setOndergrens(int nieuweOndergrens) {
		this.ondergrens = nieuweOndergrens;
	}
	
	
	/**
	 * Stelt de bovengrens van dit object in op de gegeven waarde.
	 * 
	 * @pre De gegeven bovengrens is niet kleiner dan de ondergrens van dit object.
	 *    | getOndergrens() <= nieuweBovengrens
	 * @mutates | this
	 * @post De bovengrens van dit object is gelijk aan de gegeven bovengrens.
	 *    | this.getBovengrens() == nieuweBovengrens
	 * @post De ondergrens blijft ongewijzigd.
	 *    | getOndergrens() == old(getOndergrens())
	 */
	public void setBovengrens(int nieuweBovengrens) {
		this.lengte = nieuweBovengrens - this.ondergrens;
	}
}
