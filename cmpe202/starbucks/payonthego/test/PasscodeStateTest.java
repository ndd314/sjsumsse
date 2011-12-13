package payonthego.test;



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import payonthego.*;

/**
 * The test class PasscodeStateTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PasscodeStateTest
{
    /**
     * Default constructor for test class PasscodeStateTest
     */
    public PasscodeStateTest()
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
        AppController app = AppController.getInstance();
        System.out.println(app.getScreenTitle()); 
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
    public void testTransitionState()
    {    	
        PasscodeWidget passcodeWidget = new PasscodeWidget();
        
        // initial state is 0
        assertTrue(passcodeWidget.getPasscodeState()==0);
        
        // enter b at 0 will remain at 0
        passcodeWidget.touch(3, 8); // keypad backspace
        assertTrue(passcodeWidget.getPasscodeState()==0);

        // entering 1 1 1
        
        passcodeWidget.touch(1, 5); // keypad number 1
        assertTrue(passcodeWidget.getPasscodeState()==1);
        
        passcodeWidget.touch(1, 5); // keypad number 1
        assertTrue(passcodeWidget.getPasscodeState()==2);
        
        passcodeWidget.touch(1, 5); // keypad number 1
        assertTrue(passcodeWidget.getPasscodeState()==3);
        
        // entering b b b
        
        passcodeWidget.touch(3, 8); // keypad backspace
        assertTrue(passcodeWidget.getPasscodeState()==2);
        
        passcodeWidget.touch(3, 8); // keypad backspace
        assertTrue(passcodeWidget.getPasscodeState()==1);
        
        passcodeWidget.touch(3, 8); // keypad backspace
        assertTrue(passcodeWidget.getPasscodeState()==0);
    }
    
    @Test
    public void testInvalidPinState()
    {
        PasscodeWidget passcodeWidget = new PasscodeWidget();
        
        // entering 1 1 1 1 invalid pin will go back to 0
        
        passcodeWidget.touch(1, 5); // keypad number 1
        assertTrue(passcodeWidget.getPasscodeState()==1);
        
        passcodeWidget.touch(1, 5); // keypad number 1
        assertTrue(passcodeWidget.getPasscodeState()==2);
        
        passcodeWidget.touch(1, 5); // keypad number 1
        assertTrue(passcodeWidget.getPasscodeState()==3);
        
        passcodeWidget.touch(1, 5); // keypad number 1
        assertTrue(passcodeWidget.getPasscodeState()==0);
    }

    @Test
    public void testValidPinState()
    {
        PasscodeWidget passcodeWidget = new PasscodeWidget();
        // entering 1 2 3 4 valid pin
        
        passcodeWidget.touch(1, 5); // keypad number 1
        assertTrue(passcodeWidget.getPasscodeState()==1);
        
        passcodeWidget.touch(2, 5); // keypad number 2
        assertTrue(passcodeWidget.getPasscodeState()==2);
        
        passcodeWidget.touch(3, 5); // keypad number 3
        assertTrue(passcodeWidget.getPasscodeState()==3);
        
        passcodeWidget.touch(1, 6); // keypad number 4
        assertTrue(passcodeWidget.getPasscodeState()==4);
        
        // ensure authenticated state
        assertTrue(passcodeWidget.getAuthenticatedState());
    }
}

