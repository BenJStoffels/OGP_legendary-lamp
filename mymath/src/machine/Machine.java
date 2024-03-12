package machine;

abstract class Instruction {
	abstract public int execute(int [] register, int pc);
}

class LoadConstant extends Instruction {
	int r, c;
	public LoadConstant(int r, int c) { this.r = r; this.c = c; }
	
	public int execute(int[] register, int pc) {
		register[r] = c;
		return pc + 1;
	}
}
class Decrement extends Instruction {
	int r;
	public Decrement(int r) { this.r = r; }
	
	public int execute(int[] register, int pc) {
		register[r]--;
		return pc + 1;
	}
}
class Multiply extends Instruction {
	int r1, r2;
	public Multiply(int r1, int r2) { this.r1 = r1; this.r2 = r2; }
	
	public int execute(int[] register, int pc) {
		register[r1] *= register[r2];
		return pc + 1;
	}
}
class JumpZero extends Instruction {
	int r, a;
	public JumpZero(int r, int a) { this.r = r; this.a = a; }
	
	public int execute(int[] register, int pc) {
		if (register[r] == 0)
			return a;
		return pc + 1;
	}
}
class Jump extends Instruction {
	int a;
	public Jump(int a) { this.a = a; }
	
	public int execute(int[] register, int pc) {
		return a;
	}
}
class Halt extends Instruction {
	public int execute(int[] register, int pc) {
		return -1;
	}
}

public class Machine {
	static void execute(int[] register, Instruction[] instructions) {
		int pc = 0;
		while (0 <= pc) {
			pc = instructions[pc].execute(register, pc);
		}
	}
}
