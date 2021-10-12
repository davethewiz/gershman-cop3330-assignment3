package ex46;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

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
    public void WordProcessTest()
    {
        List<String> words = new ArrayList<>();
        words.add("this");
        words.add("this");
        words.add("may");
        words.add("be");
        words.add("very");
        words.add("interesting");

        WordsProcessor wp = new WordsProcessor(words);

        Map<String, Integer> occDict = wp.CreateOccurencesDictionary();

        Map<String, Integer> compMap = new Hashtable<>();
        compMap.put("this", 2);
        compMap.put("may", 1);
        compMap.put("be", 1);
        compMap.put("very", 1);
        compMap.put("interesting", 1);

        assertEquals(compMap, occDict);
    }
}
