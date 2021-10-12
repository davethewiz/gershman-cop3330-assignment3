package ex41;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void TestingNameProcessor()
    {
        NameProcessor nameProcessor = new NameProcessor(new String[]{"Johnny", "Jimmy", "James"});
        String divider = nameProcessor.GetDividerLine(3);

        assertEquals("---", divider);
        assertEquals(6, nameProcessor.GetLongestNameLength());
    }
}
