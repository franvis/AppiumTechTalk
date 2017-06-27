package test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import screen.HomeScreen;

import static junit.framework.Assert.assertTrue;

/**
 * @author f.visintini on 27/06/17.
 */
public class HomeTest {

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

    private AppiumDriver createAndroidDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.example.fran.appiumtechtalk");
        capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.example.fran.appiumtechtalk.activities.HomeActivity");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");

        return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    private AppiumDriver createiOSDriver() throws MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("bundleId", "wdpro.disney.com.sample_login");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.3");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");

        return new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
