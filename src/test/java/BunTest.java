import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;

    @Before
    public void createTestData() {
        bun = new Bun("red bun", 300);
    }

    @Test
    public void getBunNameTest() {
        String actualBunName = bun.getName();
        String expectedBunName = "red bun";
        assertEquals("Expected bun name is " + expectedBunName + " but found " + actualBunName,
                expectedBunName, actualBunName);
    }

    @Test
    public void getBunPriceTest() {
        float actualBunPrice = bun.getPrice();
        float expectedBunPrice = 300;
        assertEquals("Expected price is " + expectedBunPrice + " but found " + actualBunPrice,
                expectedBunPrice, actualBunPrice, 0);
    }
}
