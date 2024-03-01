package matrix;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Elke instantie slaat een matrix van kommagetallen op.
 * 
 * @invar | getElementsByRow().length == getNumberRows() * getNumberCols()
 * @invar | getElementsByCol().length == getNumberRows() * getNumberCols()
 * @invar | getElements().length == getNumberRows()
 * @invar | IntStream.range(0, getNumberRows()).allMatch(i -> getElements()[i].length == getNumberCols())
 */
public class Matrix {
	/**
	 * @invar | numRows >= 0
	 * @invar | numCols >= 0
	 * @invar | numbers.length == numRows
	 * @invar | Arrays.stream(numbers).allMatch(arr -> arr.length == numCols)
	 */
	private int numRows;
	private int numCols;
	/**
	 * @representationObject
	 * @representationObjects
	 */
	private double[][] numbers;
		
	public int getNumberRows() { throw new RuntimeException("Not yet implemented"); }
	
	public int getNumberCols() { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * @pre | 0 <= row && row < getNumberRows()
	 * @pre | 0 <= col && col < getNumberCols()
	 * 
	 * @post | result == getElements()[row][col]
	 * @post | result == getElementsByRow()[row * getNumberCols() + col]
	 * @post | result == getElementsByCol()[col * getNumberRows() + row]
	 */
	public double getElementAt(int row, int col) { throw new RuntimeException("Not yet implemented"); }
	
	public double[] getElementsByRow() { throw new RuntimeException("Not yet implemented"); }
	
	public double[] getElementsByCol() { throw new RuntimeException("Not yet implemented"); }
	
	public double[][] getElements() { throw new RuntimeException("Not yet implemented"); }

	/**
	 * @throws IllegalArgumentException | numRows < 0
	 * @throws IllegalArgumentException | numCols < 0
	 * @throws IllegalArgumentException | numbers.length == numRows * numCols
	 * 
	 * @creates | this
	 * @inspects | numbers
	 * 
	 * @post | getNumberRows() == numRows
	 * @post | getNumberCols() == numCols
	 * @post | IntStream.range(0, numbers.length).allMatch(i -> numbers[i] == getElementsByRow()[i])
	 */
	public Matrix(int numRows, int numCols, double[] numbers) { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * @mutates | this
	 * 
	 * @post | getNumberRows() == old(getNumberRows())
	 * @post | getNumberCols() == old(getNumberCols())
	 * @post | IntStream.range(0, getNumberRows() * getNumberCols()).allMatch(i -> getElementsByRow()[i] == scalar * old(getElementsByRow())[i])
	 */
	public void scale(double scalar) { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * @throws IllegalArgumentException | mat.getNumberRows() !=  getNumberRows()
	 * @throws IllegalArgumentException | mat.getNumberCols() != getNumberCols()
	 * 
	 * @mutates | this
	 * @inspects | mat
	 * 
	 * @post | getNumberRows() == old(getNumberRows())
	 * @post | getNumberCols() == old(getNumberCols())
	 * @post | IntStream.range(0, getNumberRows() * getNumberCols()).allMatch(i -> getElementsByRow()[i] == old(mat.getElementsByRow())[i] + old(getElementsByRow())[i])
	 */
	public void add(Matrix mat) { throw new RuntimeException("Not yet implemented"); }
}
