package optional;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FoodTest {

	@Test
	void testIsHealthy() {
		Food chocolate = new Food("chocolate", true, true);
		Food avocado = new Food("avocado", false, true);
		Food zucchini = new Food("zucchini", false, false);
		Food cerealBars = new Food("cerealBars", true, false);

		assertTrue(zucchini.isHealthy());
		assertFalse(chocolate.isHealthy());
		assertFalse(avocado.isHealthy());
		assertFalse(cerealBars.isHealthy());
	}

}
