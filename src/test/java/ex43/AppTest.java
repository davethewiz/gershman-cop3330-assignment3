package ex43;

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
    public void TestingWebsiteGenerator()
    {
        WebsiteGenerator websiteGen = new WebsiteGenerator("Dave", "Gershman");
        String html = websiteGen.GetFormattedHTMLTag("testTag", "", "", false);

        assertEquals("<testTag >\n", html);
    }
}
