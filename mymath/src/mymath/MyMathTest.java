package mymath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {

	@Test
	void testSqrt() {
		assertEquals(3, MyMath.sqrt(9));
		assertEquals(0, MyMath.sqrt(0));
		assertEquals(3, MyMath.sqrt(15));
		assertEquals(4, MyMath.sqrt(16));
	}
	
	@Test
	void testMax3() {
		assertEquals(30, MyMath.max3(10, 20, 30));
		assertEquals(30, MyMath.max3(20, 10, 30));
		assertEquals(30, MyMath.max3(10, 30, 20));
		assertEquals(30, MyMath.max3(20, 30, 10));
		assertEquals(30, MyMath.max3(30, 10, 20));
		assertEquals(30, MyMath.max3(30, 20, 10));
	}
	
	@Test
	void testMediaan() {
		assertEquals(0, MyMath.mediaan(-1, 0, 1));
		assertEquals(1, MyMath.mediaan(-1, 1, 1));
		assertEquals(-1, MyMath.mediaan(-1, -1, 1));
		assertEquals(0, MyMath.mediaan(0, 0, 0));
	}
	
	@Test
	void testVerwissel() {
		int[] values = new int[] { 1, 5, 3, 4, 7 };
		MyMath.verwissel(values, 1, 3);
		assertArrayEquals(new int[] { 1, 4, 3, 5, 7 }, values);
	}
	
	@Test
	void testFind() {
		int[] values = new int[] { 1, 5, 3, 4, 7, 3 };
		assertEquals(2, MyMath.find(values, 3));
		assertEquals(-1, MyMath.find(values, 2));
	}
	
	@Test
	void testSort() {
		int[] values = new int[] { 1, 5, 3, 4, 7, 3 };
		MyMath.sort(values);
		assertArrayEquals(new int[] { 1, 3, 3, 4, 5, 7 }, values);
	}
	
	@Test
	void testTel() {
		assertEquals(0, MyMath.tel(new int[] {10, 20, 30}, 15));
		assertEquals(1, MyMath.tel(new int[] {10, 20, 30}, 20));
		assertEquals(2, MyMath.tel(new int[] {10, 20, 30, 20}, 20));
		assertEquals(3, MyMath.tel(new int[] {10, 20, 10, 30, 10}, 10));
	}
	
	@Test
	void testVerhoogElement() {
		int[] mijnArray = {10, 20, 30};
		MyMath.verhoogElement(mijnArray, 1, 5);
		assertArrayEquals(new int[] {10, 25, 30}, mijnArray);
	}
	
	@Test
	void testNegatie() {
		int[] mijnArray = {10, -20, 30};
		MyMath.negatie(mijnArray);
		assertArrayEquals(new int[] {-10, 20, -30}, mijnArray);
	}

}
