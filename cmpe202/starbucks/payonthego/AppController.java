package payonthego;

/**
 * Write a description of class AppController here.
 * 
 * @author Duy Nguyen 
 * @version (a version number or a date)
 */
public class AppController implements MenuBar, Screen, TouchHandler
{
    // instance variables - replace the example below with your own
    private static AppController instance;
    private Screen currentScreen;
    
    // Screens
    private PinScreen pinScreen;
    private MainScreen mainScreen;
    private StoreScreen storeScreen;
    private RewardScreen rewardScreen;
    private PaymentSetupScreen paymentSetupScreen;
    private CardOptionScreen cardOptionScreen;
    private CardMoreOptionScreen cardMoreOptionScreen;
    private CardPayScreen cardPayScreen;
    private CardAddScreen cardAddScreen;
    private SettingScreen settingScreen;
    
    // display screen commands
    private DisplayScreenCmd displayPinScreen;
    private DisplayScreenCmd displayMainScreen;
    private DisplayScreenCmd displayStoreScreen;
    private DisplayScreenCmd displayRewardScreen;
    private DisplayScreenCmd displayPaymentSetupScreen;
    private DisplayScreenCmd displayCardOptionScreen;
    private DisplayScreenCmd displayCardMoreOptionScreen;
    private DisplayScreenCmd displayCardPayScreen;
    private DisplayScreenCmd displayCardAddScreen;
    private DisplayScreenCmd displaySettingScreen;

    /**
     * Constructor for objects of class AppController
     */
    private AppController()
    {
        // Initialize instance variables
        initialize();
    }
    
    private void initialize() {
    	// init screens
        pinScreen = new PinScreen();
        mainScreen = new MainScreen();
        storeScreen = new StoreScreen();
        rewardScreen = new RewardScreen();
        paymentSetupScreen = new PaymentSetupScreen();
        cardOptionScreen = new CardOptionScreen();
        cardMoreOptionScreen = new CardMoreOptionScreen();
        cardPayScreen = new CardPayScreen();
        cardAddScreen = new CardAddScreen();
        settingScreen = new SettingScreen();
        
        // init DisplayScreenCmd objects
        displayPinScreen = new DisplayScreenCmd(pinScreen);
        displayMainScreen = new DisplayScreenCmd(mainScreen);
        displayStoreScreen = new DisplayScreenCmd(storeScreen);
        displayRewardScreen = new DisplayScreenCmd(rewardScreen);
        displayPaymentSetupScreen = new DisplayScreenCmd(paymentSetupScreen);
        displayCardOptionScreen = new DisplayScreenCmd(cardOptionScreen);
        displayCardMoreOptionScreen = new DisplayScreenCmd(cardMoreOptionScreen);
        displayCardPayScreen = new DisplayScreenCmd(cardPayScreen);
        displayCardAddScreen = new DisplayScreenCmd(cardAddScreen);
        displaySettingScreen = new DisplayScreenCmd(settingScreen);
        
        User user = User.getInstance();
        user.setUserPasscode("1234");
        user.myCard.setCardBalance(16.50);
        
        // display Pin Screen upon init
        currentScreen = displayPinScreen.getScreen();
        displayPinScreen.execute();
    }
    
    public static AppController getInstance() {     
        if (null==instance)
            instance = new AppController();
        return instance;
    }

    
    public void menu1() {
        // TODO Auto-generated method stub
    	if (pinScreen.getAuthenticatedState()==true) {
    		currentScreen = displayMainScreen.getScreen();
    		displayMainScreen.execute();
    	} else {
    		currentScreen = displayPinScreen.getScreen();
            displayPinScreen.execute();
    	}
    }

    
    public void menu2() {
        // TODO Auto-generated method stub
    	if (pinScreen.getAuthenticatedState()==true) {
    		currentScreen = displayPaymentSetupScreen.getScreen();
        	displayPaymentSetupScreen.execute();
    	} else {
    		currentScreen = displayPinScreen.getScreen();
            displayPinScreen.execute();
    	}
    }

    
    public void menu3() {
        // TODO Auto-generated method stub
    	if (pinScreen.getAuthenticatedState()==true) {
    		currentScreen = displayRewardScreen.getScreen();
        	displayRewardScreen.execute();
    	} else {
    		currentScreen = displayPinScreen.getScreen();
            displayPinScreen.execute();
    	}    	
    }

    
    public void menu4() {
    	if (pinScreen.getAuthenticatedState()==true) {
        	currentScreen = displayStoreScreen.getScreen();
        	displayStoreScreen.execute();
    	} else {
    		currentScreen = displayPinScreen.getScreen();
            displayPinScreen.execute();
    	}
        // TODO Auto-generated method stub
    }

    
    public void menu5() {
    	if (pinScreen.getAuthenticatedState()==true) {
    		currentScreen = displaySettingScreen.getScreen();
        	displaySettingScreen.execute();
    	} else {
    		currentScreen = displayPinScreen.getScreen();
            displayPinScreen.execute();
    	}
        // TODO Auto-generated method stub
    }

    
    public String display() {
        // TODO Auto-generated method stub        
        return currentScreen.display();
    }

    
    public void topLeftCommand() {
        // TODO Auto-generated method stub
    	if (null!=currentScreen)
    		currentScreen.topLeftCommand();
    }

    
    public void topRightCommand() {
        // TODO Auto-generated method stub
    	if (null!=currentScreen)
    		currentScreen.topRightCommand();
    }

    
    public void touch(int x, int y) {
        // passing touch event down the chain to current screen
    	if (null!=currentScreen) {
    		currentScreen.touch(x, y);
    		
    		if(currentScreen.getScreenTitle().equals("Pin Screen") && pinScreen.getAuthenticatedState()==true) {
    			// change screen display to main screen
    			menu1();
    		}
    	}
    }
    
    public String displayCardOptionScreen() {
    	if (pinScreen.getAuthenticatedState()==true) {
    		currentScreen = displayCardOptionScreen.getScreen();
            return displayCardOptionScreen.execute();
    	} else {
    		currentScreen = displayPinScreen.getScreen();
            return displayPinScreen.execute();
    	}
    }
    
    public String displayCardMoreOptionScreen() {
    	if (pinScreen.getAuthenticatedState()==true) {
    		currentScreen = displayCardMoreOptionScreen.getScreen();
            return displayCardMoreOptionScreen.execute();
    	} else {
    		currentScreen = displayPinScreen.getScreen();
            return displayPinScreen.execute();
    	}        
    }
    
    public String displayCardPayScreen() {
    	if (pinScreen.getAuthenticatedState()==true) {
    		currentScreen = displayCardPayScreen.getScreen();
            return displayCardPayScreen.execute();
    	} else {
    		currentScreen = displayPinScreen.getScreen();
            return displayPinScreen.execute();
    	}        
    }
    
    public String displayCardAddScreen() {
    	if (pinScreen.getAuthenticatedState()==true) {
    		currentScreen = displayCardAddScreen.getScreen();
            return displayCardAddScreen.execute();
    	} else {
    		currentScreen = displayPinScreen.getScreen();
            return displayPinScreen.execute();
    	}
    }
    
    
    public String getScreenTitle() {
    	return currentScreen.getScreenTitle();
    }
    
    public void destroyInstance() {
    	instance = null;
    }
}
