package mymath;

import java.util.stream.IntStream;

public class MyMath {
	/** 
	 * Returns the square root (rounded down) of the given nonnegative number.
	 * 
	 * @pre The given number must be nonnegative.
	 *    | 0 <= x
	 * @post The result is the smallest nonnegative integer whose square is not greater than the given number.
	 *    | 0 <= result &&
	 *    | result * result <= x &&
	 *    | x < (result + 1) * (result + 1)
	 */
	static int sqrt(int x) {
		int result = 1;
		  while (result * result <= x) {
		    result++;
		  }
		  return --result;
	}
	
	/**
	 * Returns the maximum of three integers.
	 * 
	 * @post The result is larger than the three integers.
	 *    | x <= result &&
	 *    | y <= result &&
	 *    | z <= result
	 * @post The result is equal to at least one of the three integers.
	 *    | (x == result) || (y == result) || (z == result)
	 */
	static int max3(int x, int y, int z) {
		return x > y ? (x > z? x : z) : (y > z? y : z);
	}
	
	/**
	 * Geeft de mediaan van de drie gegeven getallen terug.
	 * 
	 * @post The result is larger than or equal to at least two of the integers.
	 *    | ((x <= result) && (y <= result || z <= result)) ||
	 *    | (y <= result && z <= result)
	 * @post The result is smaller than or equal to at least two of the integers.
	 *    | ((result <= x) && (result <= y || z <= result)) ||
	 *    | (result <= y && result <= z)
	 * @post The result is equal to one of the integers. (Probably not necessary since previous conditions.)
	 *    | (x == result) || (y == result) || (z == result)
	 */
	static int mediaan(int x, int y, int z) {
		int[] values = new int[] { x, y, z };
		sort(values);
		return values[1];
	}
	
	/**
	 * Geeft het aantal voorkomens van 'waarde' in 'getallen' terug.
	 * @pre Het argument `getallen` wijst naar een array; het is geen null-verwijzing.
	 *    | getallen != null
	 * @post Het resultaat is gelijk aan het aantal indices in `getallen` waarop `waarde` voorkomt.
	 *    | result == IntStream.range(0, getallen.length).filter(i -> getallen[i] == waarde).count()
	 */
	static int tel(int[] getallen, int waarde) {
		int result = 0;
		for (int i = 0; i < getallen.length; i++)
			if (getallen[i] == waarde)
				result++;
		return result;
	}
	
	/**
	 * Verhoogt het element op index `index` in array `array` met `bedrag`.
	 * 
	 * @pre Het argument `array` wijst naar een array.
	 *     | array != null
	 * @mutates | array
	 * @pre De gegeven index is een geldige index voor `array`.
	 *     | 0 <= index && index < array.length
	 * @post De waarde in `array` op de gegeven index is gelijk aan de oude waarde plus het gegeven bedrag.
	 *     | array[index] == old(array[index]) + bedrag
	 * @post De waarden in `array` niet op de gegeven index blijven onveranderd.
	 *     | IntStream.range(0, array.length).allMatch(i -> i == index || array[i] == old(array.clone())[i])
	 */
	static void verhoogElement(int[] array, int index, int bedrag) {
		array[index] += bedrag;
	}
	
	/**
	 * Verwisselt de elementen op de gegeven indices in de gegeven array met elkaar.
	 * 
	 * @pre Het argument `getallen` wijst naar een array.
	 *    | getallen != null
	 * @pre De gegeven indices zijn gelidge indices voor `getallen`.
	 *    | 0 <= index1 && 0 <= index2 &&
	 *    | index1 < getallen.length && index2 < getallen.length
	 * @mutates | getallen
	 * @post De waarden in `getallen` op de gegeven indices zijn verwisseld.
	 *    | getallen[index1] == old(getallen[index2]) &&
	 *    | getallen[index2] == old(getallen[index1])
	 * @post | IntStream.range(0, getallen.length).allMatch(i -> i == index1 || i == index2 || getallen[i] == old(getallen.clone())[i])
	 */
	static void verwissel(int[] getallen, int index1, int index2) {
		int temp = getallen[index1];
		getallen[index1] = getallen[index2];
		getallen[index2] = temp;
	}
	
	/**
	 * Vervangt elk getal in de gegeven array door zijn negatie.
	 * @pre Het argument `getallen` wijst naar een array.
	 *     | getallen != null
	 * @mutates | getallen
	 * @post Voor elke positie in `getallen` geldt dat de nieuwe waarde op die positie gelijk is aan de negatie van de oude waarde op die positie.
	 *     | IntStream.range(0, getallen.length).allMatch(i -> getallen[i] == -old(getallen.clone())[i]) 
	 */
	// voeg bovenaan (tussen de package-regel en de class-regel) 'import java.util.stream.IntStream;' toe als Eclipse dit niet zelf doet.
	static void negatie(int[] getallen) {
		for (int i = 0; i < getallen.length; i++)
			getallen[i] = -getallen[i];
	}
	
	/**
	 * Geeft de index terug van het eerste voorkomen van `needle` in `haystack`, of -1 als `needle` niet voorkomt in `haystack`.
	 * 
	 * @pre | haystack != null
	 * @inspects | haystack
	 * @post The result is the index van het eerste voorkomen van `needle`...
	 *    | (result == -1 && IntStream.range(0, haystack.length).allMatch(i -> haystack[i] != needle)) ||
	 *    | (0 <= result && result < haystack.length && 
	 *    | haystack[result] == needle && 
	 *    | IntStream.range(0, result).allMatch(i -> haystack[i] != needle))
	 */
	static int find(int[] haystack, int needle) {
		for (int i = 0; i < haystack.length; i++) {
			if (haystack[i] == needle)
				return i;
		}
		return -1;
	}
	
	/**
	 * Sorteert de getallen in de gegeven array van klein naar groot.
	 * 
	 * @pre | values != null
	 * @mutates | values
	 * @post De lijst maar dan in gesorteerde volgorde.
	 *    | IntStream.range(0, values.length-1).allMatch(i -> values[i] <= values[i+1]) &&
	 *    | IntStream.range(0, values.length).allMatch(i -> tel(values, values[i]) == tel(old(values.clone()), values[i])) &&
	 *    | values.length == old(values.clone()).length
	 */
	static void sort(int[] values) {
		for (int i = 1; i <= values.length; i++) {
			for (int j = 0; j < values.length - i; j++) {
				if (values[j] > values[j+1])
					verwissel(values, j, j+1);
			}
		}
	}
}
