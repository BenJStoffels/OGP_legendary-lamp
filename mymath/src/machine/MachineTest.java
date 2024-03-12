package machine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MachineTest {

	@Test
	void test() {
		assertEquals(1, power(1, 1));
		assertEquals(8, power(2, 3));
		assertEquals(9, power(3, 2));
	}

	int power(int x, int y) {
		int[] register = new int[] {x, y, 0};
		Instruction[] instructions = new Instruction[] {
				new LoadConstant(2, 1),
				new JumpZero(1, 5),
				new Multiply(2, 0),
				new Decrement(1),
				new Jump(1),
				new Halt()
		};
		Machine.execute(register, instructions);
		return register[2];
	}
}
