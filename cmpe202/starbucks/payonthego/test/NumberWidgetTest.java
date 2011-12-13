package payonthego.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import payonthego.*;

/**
 * The test class NumberWidgetTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NumberWidgetTest
{
    /**
     * Default constructor for test class KeyPadTest
     */
    public NumberWidgetTest()
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
    public void testNumberInputWidget()
    {
        NumberInputWidget niw = new NumberInputWidget();
        niw.setMaxLength(8);
        niw.touch(1, 5); // input 1
        assertEquals("1", niw.getInput());
        
        niw.touch(1, 5); // input 1
        assertEquals("11", niw.getInput());
        
        niw.touch(3, 8); // backspace
        assertEquals("1", niw.getInput());
        
        niw.touch(3, 8); // backspace
        assertEquals("", niw.getInput());
        
        niw.touch(1, 5); // input 1
        niw.touch(1, 5); // input 1
        niw.touch(1, 5); // input 1
        niw.touch(1, 5); // input 1
        niw.touch(1, 5); // input 1
        niw.touch(1, 5); // input 1
        niw.touch(1, 5); // input 1
        niw.touch(1, 5); // input 1
        assertEquals("11111111", niw.getInput());
        
        niw.touch(1, 5); // input 1 - still max 8
        assertEquals("11111111", niw.getInput());
    }
}



