package ex44;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void TestingWebsiteGenerator()
    {
        Product[] products = new Product[] {new Product("Thing", 21.69, 5)};
        Inventory inventory = new Inventory(products);

        assertEquals(products[0], inventory.FindByName("Thing"));
        assertNull(inventory.FindByName("Other Thing"));
    }
}
