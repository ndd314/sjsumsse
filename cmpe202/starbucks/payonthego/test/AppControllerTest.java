package payonthego.test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import payonthego.*;

/**
 * The test class AppControllerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AppControllerTest
{
    /**
     * Default constructor for test class AppControllerTest
     */
	
	AppController app = AppController.getInstance();
	
    public AppControllerTest()
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
    	app.destroyInstance();
        app = AppController.getInstance();
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
    public void testAppInitialize()
    {
    	// first screen should be Pin Screen
        assertEquals(app.getScreenTitle(), "Pin Screen");
    }
    
    @Test
    public void testInValidPin()
    {
    	// entering 1 1 1 1
    	app.touch(1,5);
    	app.touch(1,5);
    	app.touch(1,5);
    	app.touch(1,5);
    	assertEquals(app.getScreenTitle(), "Pin Screen");
    }    
    
    @Test
    public void testValidPin()
    {
    	// entering 1 2 3 4
    	app.touch(1,5);
    	app.touch(2,5);
    	app.touch(3,5);
    	app.touch(1,6);
    	assertEquals(app.getScreenTitle(), "Main Screen");
    }
    
    @Test
    public void testAppMenu()
    {
        // entering 1 2 3 4 to authenticate
    	app.touch(1,5);
    	app.touch(2,5);
    	app.touch(3,5);
    	app.touch(1,6);
    	assertEquals(app.getScreenTitle(), "Main Screen");
    	
    	app.menu1();
    	assertEquals(app.getScreenTitle(), "Main Screen");
    	
    	app.menu2();
    	assertEquals(app.getScreenTitle(), "Payment Setup");
    	
    	app.menu3();
    	assertEquals(app.getScreenTitle(), "Rewards Setup");
    	
    	app.menu4();
        assertEquals(app.getScreenTitle(), "Find Starbucks");
        
        app.menu5();
        assertEquals(app.getScreenTitle(), "Settings Screen");
    }
    
    @Test
    public void testCardPayScreen()
    {
        // entering 1 2 3 4
    	app.touch(1,5);
    	app.touch(2,5);
    	app.touch(3,5);
    	app.touch(1,6);
    	assertEquals(app.getScreenTitle(), "Main Screen");
    	
    	app.menu1(); // force main screen
    	app.touch(3,3); // go to card - pay screen
    	assertEquals(app.getScreenTitle(), "My Cards - Pay");
    	
    	app.touch(3,3); // back to main
    	assertEquals(app.getScreenTitle(), "Main Screen");
    	
    	app.touch(3,3); // go to card - pay screen
    	app.touch(1, 2); // paying $1.50
    	assertTrue(User.getInstance().myCard.getCardBalance()==(16.50-1.50));
    	assertEquals(app.getScreenTitle(), "Main Screen");
    	
    	app.touch(3,3); // go to card - pay screen
    	app.touch(2, 2); // paying $1.50
    	assertTrue(User.getInstance().myCard.getCardBalance()==(16.50-1.50*2));
    	assertEquals(app.getScreenTitle(), "Main Screen");
    	
    	app.touch(3,3); // go to card - pay screen
    	app.touch(3, 2); // paying $1.50
    	assertTrue(User.getInstance().myCard.getCardBalance()==(16.50-1.50*3));
    	assertEquals(app.getScreenTitle(), "Main Screen");
    }
    
    @Test
    public void testCardOptionScreen()
    {
        // entering 1 2 3 4
    	app.touch(1,5);
    	app.touch(2,5);
    	app.touch(3,5);
    	app.touch(1,6);
    	assertEquals(app.getScreenTitle(), "Main Screen");
    	
    	app.menu1(); // force main screen
    	
    	app.touch(2, 4); // go to card - option screen
    	assertEquals(app.getScreenTitle(), "My Cards - Options");
    	
    	app.touch(1, 7); // go to card - option screen
    	assertEquals(app.getScreenTitle(), "My Cards More Options");

    	app.topLeftCommand(); // cancel button
    	assertEquals(app.getScreenTitle(), "My Cards - Options");
    	
    	app.touch(2, 7); // go to card - option screen
    	assertEquals(app.getScreenTitle(), "My Cards More Options");
    	
    	app.topLeftCommand(); // cancel button
    	app.touch(3, 7); // go to card - option screen
    	assertEquals(app.getScreenTitle(), "My Cards More Options");
    }
    
    @Test
    public void testCardAddScreen()
    {
        // entering 1 2 3 4
    	app.touch(1,5);
    	app.touch(2,5);
    	app.touch(3,5);
    	app.touch(1,6);
    	assertEquals(app.getScreenTitle(), "Main Screen");
    	
    	app.menu5(); // force settings screen
    	assertEquals(app.getScreenTitle(), "Settings Screen");
    	
    	app.touch(1,2); // go to card - add screen
    	assertEquals(app.getScreenTitle(), "Add Card Screen");
    	
    	app.topLeftCommand(); // cancel back to settings
    	assertEquals(app.getScreenTitle(), "Settings Screen");
    	
    	app.touch(2,2); // go to card - add screen
    	assertEquals(app.getScreenTitle(), "Add Card Screen");
    	
    	app.topLeftCommand(); // cancel back to settings
    	app.touch(3,2); // go to card - add screen
    	assertEquals(app.getScreenTitle(), "Add Card Screen");
    }
    
    @Test
    public void testAddingCard()
    {
        // entering 1 2 3 4
    	app.touch(1,5);
    	app.touch(2,5);
    	app.touch(3,5);
    	app.touch(1,6);
    	assertEquals(app.getScreenTitle(), "Main Screen");
    	
    	app.menu5(); // force settings screen
    	assertEquals(app.getScreenTitle(), "Settings Screen");
    	
    	app.touch(1,2); // go to card - add screen
    	assertEquals(app.getScreenTitle(), "Add Card Screen");
    	
    	app.touch(1, 3); // activate card id input box
    	
    	app.touch(1, 5); // input number 1
    	app.touch(1, 5); // input number 1
    	app.touch(1, 5); // input number 1
    	app.touch(1, 5); // input number 1
    	app.touch(1, 5); // input number 1
    	app.touch(1, 5); // input number 1
    	app.touch(1, 5); // input number 1
    	app.touch(1, 5); // input number 1
    	app.touch(1, 5); // input number 1
    	app.touch(1, 5); // input number 1
    	app.touch(1, 5); // input number 1
    	app.touch(1, 5); // input number 1
    	app.touch(1, 5); // input number 1
    	app.touch(1, 5); // input number 1
    	app.touch(1, 5); // input number 1
    	app.touch(1, 5); // input number 1
    	
    	app.touch(2, 4); // activate card code input box
    	
    	app.touch(2, 5); // input number 1
    	app.touch(2, 5); // input number 1
    	app.touch(2, 5); // input number 1
    	app.touch(2, 5); // input number 1
    	app.touch(2, 5); // input number 1
    	app.touch(2, 5); // input number 1
    	app.touch(2, 5); // input number 1
    	app.touch(2, 5); // input number 1
    	
    	app.topRightCommand();
    	
    	// went back to settings screen after touching add button
    	assertEquals(app.getScreenTitle(), "Settings Screen");
    	
    	// ensure new card was added
    	assertTrue(User.getInstance().myCard.getCardBalance()==16.50);
    	assertEquals(User.getInstance().myCard.getCardID(), "1111111111111111");
    	assertEquals(User.getInstance().myCard.getCardCode(), "22222222");
    	
    	// test back to main navigation
    	app.menu1();
    	assertEquals(app.getScreenTitle(), "Main Screen");
    }
        
    /*
    My Cards More Options .. done
    Add Card Screen .. done
    My Cards - Options .. done
    My Cards - Pay .. done
    Rewards Setup .. done
    Main Screen .. done
    Pin Screen  .. done
    Payment Setup .. done
    Settings Screen .. done
    Find Starbucks .. done
    */
}




