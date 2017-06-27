package test;

import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import screen.HomeScreen;


/**
 * @author f.visintini on 27/06/17.
 */
public class HomeTest extends BaseTest{

    private AppiumDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setupTests() throws Exception {
        driver = createAndroidDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void validLoginWithNoPageObject() {
        HomeScreen homeScreen = new HomeScreen(driver);
        Assert.assertTrue("Form button should be displayed", homeScreen.isFormButtonDisplayed());
        Assert.assertTrue("List button should be displayed", homeScreen.isListButtonDisplayed());
        Assert.assertTrue("Profile button should be displayed", homeScreen.isProfileButtonDisplayed());
        Assert.assertTrue("Reset button should be displayed", homeScreen.isResetButtonDisplayed());
    }
}
