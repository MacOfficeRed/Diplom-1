import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;
    private Ingredient ingredient;

    public IngredientTest(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Before
    public void createTestData() {
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }

    @Parameterized.Parameters(name = "Ingredients with type _{0}_ and name _{1}_ and price _{2}_")
    public static Object[][] getIngredientsParams() {
        return new Object[][]{
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300},
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
        };
    }

    @Test
    public void getIngredientTypeTest() {
        IngredientType actualIngredientType = ingredient.getType();
        assertEquals("Expected ingredient type is " + ingredientType + " but found " + actualIngredientType,
                ingredientType, actualIngredientType);
    }

    @Test
    public void getIngredientNameTest() {
        String actualIngredientName = ingredient.getName();
        assertEquals("Expected ingredient name is " + ingredientName + " but found " + actualIngredientName,
                ingredientName, actualIngredientName);
    }

    @Test
    public void getIngredientPriceTest() {
        float actualIngredientPrice = ingredient.getPrice();
        assertEquals("Expected ingredient price is " + ingredientPrice + " but found " + actualIngredientPrice,
                ingredientPrice, actualIngredientPrice, 0.0);
    }
}
