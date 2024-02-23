package time;

// Hoe ontwikkel ik een data-abstractie?
// 1. De API definiëren: hoe kunnen & moeten klanten de abstractie gebruiken?
//    a. Korte informele documentatie bij klasse zelf: wat slaat een instantie op (mutable abstraction) of stelt een instantie voor (immutable abstraction)?
//    b. De rauwe abstractetoestandsruimte definiëren: de inspectoren (= getters) declareren.
//    c. De geldige abstractetoestandsruimte definiëren: de abstractetoestandsinvarianten definiëren.
//    d. De constructoren en mutatoren declareren
//    e. De constructoren en mutatoren documenteren: precondities en postcondities (resultaat en neveneffecten (= nieuwe toestand gewijzigde objecten))
// 2. De abstractie implementeren in termen van Java-constructies: velden en method/constructor bodies toevoegen.
//    a. Een representatie kiezen.
//       i. Rauwe concretetoestandsruimte definiëren = velden introduceren.
//       ii. Geldige concretetoestandsruimte definiëren = concretetoestandsinvarianten noteren (= @invar-clausules bij de velden).
//       iii. Abstractierelatie definiëren = getters implementeren.
//       Sanity checks:
//       1) De getters mogen voor geen enkele geldige concrete toestand crashen.
//       2) De getters moeten elke geldige concrete toestand afbeelden op een geldige abstracte toestand.
//    b. Implementeren van (= code schrijven voor) de constructoren en mutatoren.


/**
 * Elke instantie van deze klasse slaat een tijdstip op, gegeven door een aantal uren sinds middernacht en aantal minuten binnen het uur.
 * 
 * @invar Het uur is tussen 0 en 24.
 *    | 0 <= getHours() && getHours() < 24
 * @invar De minutes zijn tussen 0 en 60.
 *    | 0 <= getMinutes() && getMinutes() < 60
 * @invar De minuten sinds middernacht zijn tussen 0 en 60 * 24
 *    | 0 <= getMinutesSinceMidnight() && getMinutesSinceMidnight() < 60 * 24
 * @invar 60 keer het uur plus de minuten is gelijk aan de minuten sinds middernacht.
 *    | getMinutesSinceMidnight() == getHours() * 60 + getMinutes()
 */
public class TimeOfDay {
	/**
	 * @invar hour is tussen 0 en 24.
	 *    | 0 <= hours && hours < 24
	 * @invar minutes is tussen 0 en 60.
	 *    | 0 <= minutes && minutes < 60
	 */
	private int hours;
	private int minutes;
	
	public int getHours() {
		return hours;
	}
	
	public int getMinutes() {
		return minutes;
	}
	
	public int getMinutesSinceMidnight() {
		return 60 * hours + minutes;
	}
	
	/**
	 * Initialiseert het nieuwe object met de gegeven uren en minuten.
	 * 
	 * @pre uren zijn tussen 0 en 24.
	 *    | 0 <= initialHours && initialHours < 24
	 * @pre minuten zijn tussen 0 en 60.
	 *    | 0 <= initialMinutes && initialMinutes < 60
	 * @post het uur van het nieuwe object is het gegeven uur.
	 *    | getHours() == initialHours
	 * @post de minuten van het nieuwe object zijn de gegeven minuten.
	 *    | getMinutes() == initialMinutes
	 */
	public TimeOfDay(int initialHours, int initialMinutes) {
		hours = initialHours;
		minutes = initialMinutes;
	}
	
	/**
	 * Stelt het uur van het object op het gegeven uur.
	 * 
	 * @pre uur is tussen 0 en 24.
	 *    | 0 <= newHours && newHours < 24
	 * @mutates | this
	 * @post het uur van het object is het gegeven uur.
	 *    | getHours() == newHours
	 * @post de minuten van het object blijven onveranderd.
	 *    | getMinutes() == old(getMinutes())
	 */
	public void setHours(int newHours) {
		hours = newHours;
	}
	
	/**
	 * Stelt de minuten van het object op de gegeven minuten.
	 * 
	 * @pre minuten zijn tussen 0 en 60.
	 *    | 0 <= newMinutes && newMinutes < 60
	 * @mutates | this
	 * @post het uur van het object blijft onveranderd.
	 *    | getHours() == old(getHours())
	 * @post de minuten van het object zijn de gegeven minuten.
	 *    | getMinutes() == newMinutes
	 */
	public void setMinutes(int newMinutes) {
		minutes = newMinutes;
	}
	
	/**
	 * Stelt de tijd van het object op de gegeven minuten sinds middernacht.
	 * 
	 * @pre minuten sinds middernacht zijn tussen 0 en 60 * 24.
	 *    | 0 <= newMinutesSinceMidnight && newMinutesSinceMidnight < 60 * 24
	 * @mutates | this
	 * @post de minutesSinceMidnight van het nieuwe object is de gegeven minutesSinceMidnight.
	 *    | getMinutesSinceMidnight() == newMinutesSinceMidnight
	 */
	public void setMinutesSinceMidnight(int newMinutesSinceMidnight) {
		hours = newMinutesSinceMidnight / 60;
		minutes = newMinutesSinceMidnight % 60;
	}
}
