package matrix;

import java.util.stream.IntStream;

/**
 * Elke instantie stelt een matrix van kommagetallen voor.
 * 
 * @immutable
 * @invar | getElementsByRow().length == getNumberRows() * getNumberCols()
 * @invar | getElementsByCol().length == getNumberRows() * getNumberCols()
 * @invar | getElements().length == getNumberRows()
 * @invar | IntStream.range(0, getNumberRows()).allMatch(i -> getElements()[i].length == getNumberCols())
 */
public class Matrix {
		
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
	 * @creates | result
	 * @inspects | this
	 * 
	 * @post | getNumberRows() == result.getNumberRows()
	 * @post | getNumberCols() == result.getNumberCols()
	 * @post | IntStream.range(0, getNumberRows() * getNumberCols()).allMatch(i -> result.getElementsByRow()[i] == scalar * getElementsByRow()[i])
	 */
	public Matrix scaled(double scalar) { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * @throws IllegalArgumentException | mat.getNumberRows() !=  getNumberRows()
	 * @throws IllegalArgumentException | mat.getNumberCols() != getNumberCols()
	 * 
	 * @creates | result
	 * @inspects | this, mat
	 * 
	 * @post | getNumberRows() == result.getNumberRows()
	 * @post | getNumberCols() == result.getNumberCols()
	 * @post | IntStream.range(0, getNumberRows() * getNumberCols()).allMatch(i -> result.getElementsByRow()[i] == mat.getElementsByRow()[i] + getElementsByRow()[i])
	 */
	public Matrix plus(Matrix mat) { throw new RuntimeException("Not yet implemented"); }
}
