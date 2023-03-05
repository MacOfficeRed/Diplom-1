import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {

    @Test
    public void getFillingIngredientTypeTest() {
        assertEquals("Expected ingredient type is 'FILLING' but found " + FILLING.name(),
                "FILLING", FILLING.name());
    }

    @Test
    public void getSauceIngredientTypeTest() {
        assertEquals("Expected ingredient type is 'SAUCE' but found " + SAUCE.name(),
                "SAUCE", SAUCE.name());
    }
}
