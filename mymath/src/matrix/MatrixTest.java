package matrix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatrixTest {

	@Test
	void test() {
		double[] numbers = new double[] { 1,2,3,4.5,6.7,8.9 };
		Matrix myMatrix = new Matrix(2, 3, numbers);
		assertEquals(2, myMatrix.getNumberRows());
		assertEquals(3, myMatrix.getNumberCols());
		assertEquals(8.9, myMatrix.getElementAt(1, 2));
		assertArrayEquals(new double[] { 1, 2, 3, 4.5, 6.7, 8.9 }, myMatrix.getElementsByRow());
		numbers[0] = 10;
		assertEquals(1, myMatrix.getElementAt(0, 0));
		assertArrayEquals(new double[] { 1, 2, 3, 4.5, 6.7, 8.9 }, myMatrix.getElementsByRow());
		double[] numbersByCol = myMatrix.getElementsByCol();
		assertArrayEquals(new double[] { 1, 4.5, 2, 6.7, 3, 8.9 }, numbersByCol);
		numbersByCol[0] = 10;
		assertEquals(1, myMatrix.getElementAt(0, 0));
		assertArrayEquals(new double[] { 1, 4.5, 2, 6.7, 3, 8.9 }, myMatrix.getElementsByCol());
		
		double[] numbersByRow = myMatrix.getElementsByRow();
		assertArrayEquals(new double[] { 1, 2, 3, 4.5, 6.7, 8.9 }, numbersByRow);
		numbersByRow[0] = 10;
		assertArrayEquals(new double[] { 1, 2, 3, 4.5, 6.7, 8.9 }, myMatrix.getElementsByRow());
		
		double[][] elements = myMatrix.getElements();
		assertArrayEquals(new double[][] { {1, 2, 3}, { 4.5, 6.7, 8.9} }, elements);
		elements[0][0] = 10;
		assertArrayEquals(new double[][] { {1, 2, 3}, { 4.5, 6.7, 8.9} }, myMatrix.getElements());
	}
	
	@Test
	void testScale() {
		double[] numbers = new double[] { 1, 2, 3, 4.5, 6.7, 8.9 };
		Matrix myMatrix = new Matrix(2, 3, numbers);
		myMatrix.scale(2);
		assertArrayEquals(new double[] { 2, 4, 6, 9, 13.4, 17.8 }, myMatrix.getElementsByRow());
	}
	
	@Test
	void testAdd() {
		double[] numbers1 = new double[] { 1, 2, 3, 4.5, 6.7, 8.9 };
		Matrix myMatrix1 = new Matrix(3, 2, numbers1);
		double[] numbers2 = new double[] { 1.2, 3.4, 5.6, 7, 8, 9 };
		Matrix myMatrix2 = new Matrix(3, 2, numbers2);
		myMatrix1.add(myMatrix2);
		assertArrayEquals(new double[][] {{2.2, 5.4}, {8.6, 11.5}, {14.7, 17.9}}, myMatrix1.getElements());
	}

}
