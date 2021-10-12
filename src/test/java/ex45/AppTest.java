package ex45;

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
    public void StringFileProcessTest() {
        String[] lines = new String[]{"every time I say you it should say me", "this is who you are"};
        StringFileProcessor sfp = new StringFileProcessor(lines);

        assertEquals("every time I say me it should say me\nthis is who me are\n", sfp.ReplaceAll("you", "me"));
    }
}
