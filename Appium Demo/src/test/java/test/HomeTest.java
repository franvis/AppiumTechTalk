package test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import screen.FormScreen;
import screen.HomeScreen;


/**
 * @author f.visintini on 27/06/17.
 */
public class HomeTest extends BaseTest {

    @Test
    public void validLoginWithNoPageObject() throws Exception {
        HomeScreen homeScreen = navigator.goToHomeScreen();
        assertTrue("Form button should be displayed", homeScreen.isFormButtonDisplayed());
        assertTrue("List button should be displayed", homeScreen.isListButtonDisplayed());
        assertTrue("Profile button should be displayed", homeScreen.isProfileButtonDisplayed());
        assertTrue("Reset button should be displayed", homeScreen.isResetButtonDisplayed());
    }
}
