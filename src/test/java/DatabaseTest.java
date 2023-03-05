import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    private Database database;

    @Before
    public void createTestData() {
        database = new Database();
    }

    @Test
    public void checkSizeOfBunsListTest() {
        int expectedSize = 3;
        List<Bun> buns = database.availableBuns();
        assertEquals(expectedSize, buns.size());
    }

    @Test
    public void checkSizeOfIngredientsListTest() {
        int expectedSize = 6;
        List<Ingredient> ingredients = database.availableIngredients();
        assertEquals(expectedSize, ingredients.size());
    }
}
