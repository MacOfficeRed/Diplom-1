import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient mainIngredient, additionalIngredient;

    @Mock
    Ingredient ingredient;

    @Before
    public void createTestData() {
        burger = new Burger();
    }

    @Test
    public void setBunsBurgerTest() {
        burger.setBuns(bun);
        assertEquals("An error occurred while comparing objects " + burger.bun + " and " + bun,
                burger.bun, bun);
    }

    @Test
    public void addIngredientBurgerTest() {
        burger.addIngredient(mainIngredient);
        assertTrue("Error! Burger does not contain this ingredient: " + mainIngredient.getName(),
                burger.ingredients.contains(mainIngredient));
    }

    @Test
    public void removeIngredientBurgerTest() {
        burger.addIngredient(mainIngredient);
        burger.removeIngredient(0);
        assertTrue("Error. Burger still contains ingredients " + burger.ingredients.size(),
                burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientBurgerTest() {
        burger.addIngredient(mainIngredient);
        burger.addIngredient(additionalIngredient);
        burger.moveIngredient(0, 1);
        assertEquals("Expected bun name is " + additionalIngredient.getName() + " but found " + burger.ingredients.get(0).getName(),
                additionalIngredient, burger.ingredients.get(0));
    }

    @Test
    public void getPriceBurgerTest() {
        burger.setBuns(bun);
        burger.ingredients.add(mainIngredient);
        Mockito.when(bun.getPrice()).thenReturn(300F);
        Mockito.when(mainIngredient.getPrice()).thenReturn(100F);
        float actualPrice = burger.getPrice();
        float expectedPrice = 700;
        assertEquals("Expected price is " + expectedPrice + " but found " + actualPrice,
                expectedPrice, actualPrice, 0.0);
    }

    @Test
    public void getReceiptBurgerTest() {
        burger.setBuns(bun);
        Ingredient ingredientSauce = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(200f);
        Mockito.when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientSauce.getName()).thenReturn("chili sauce");
        Mockito.when(ingredientSauce.getPrice()).thenReturn(300f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("sausage");
        Mockito.when(ingredient.getPrice()).thenReturn(300f);

        StringBuilder expectedReceipt = new StringBuilder();
        expectedReceipt.append(String.format("(==== %s ====)%n", bun.getName()));
        burger.ingredients.forEach(ingredient -> expectedReceipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                ingredient.getName())));
        expectedReceipt.append(String.format("(==== %s ====)%n", bun.getName()));
        expectedReceipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        assertEquals("An error occurred while comparing receipts ",
                expectedReceipt.toString(), burger.getReceipt());
    }
}
