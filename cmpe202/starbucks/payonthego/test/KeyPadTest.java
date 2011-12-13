package payonthego.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import payonthego.KeyPad;
import payonthego.KeyPadScreenAdapter;

/**
 * The test class KeyPadTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class KeyPadTest
{
    /**
     * Default constructor for test class KeyPadTest
     */
    public KeyPadTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testKeyPad1()
    {
        KeyPad keyPad1 = new KeyPad();
        assertEquals("1", keyPad1.keyPressed(1, 1));
    }
    
    @Test
    public void testKeyPad2()
    {
        KeyPad keyPad1 = new KeyPad();
        assertEquals("2", keyPad1.keyPressed(2, 1));
    }

    @Test
    public void testKeyPadAdapter()
    {
        KeyPadScreenAdapter keyPadAd1 = new KeyPadScreenAdapter(0, 4);
        assertEquals("1", keyPadAd1.keyPressed(1, 5));
        assertEquals("2", keyPadAd1.keyPressed(2, 5));
        assertEquals("b", keyPadAd1.keyPressed(3, 8));
    }
}



