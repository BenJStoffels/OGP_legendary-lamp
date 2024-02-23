package time;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeOfDayTest {

	@Test
	void test() {
		TimeOfDay time = new TimeOfDay(12, 30);
		assertEquals(12, time.getHours());
		assertEquals(30, time.getMinutes());
	}

}
