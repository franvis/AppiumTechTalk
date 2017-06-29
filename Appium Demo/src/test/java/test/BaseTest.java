package test;

import junit.framework.TestCase;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import Configuration.Constants;
import Configuration.Navigator;

/**
 * @author f.visintini on 27/06/17.
 */
public abstract class BaseTest {

    protected AppiumDriver driver;
    protected Navigator navigator;

    @BeforeClass
    public void classSetup() throws MalformedURLException {
        if (MobilePlatform.ANDROID.equals(Constants.platform)) {
            this.driver = createAndroidDriver();
        } else {
            this.driver = createiOSDriver();
        }
        navigator = new Navigator(driver);
    }

    @AfterSuite
    public void suiteTearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    protected AppiumDriver createAndroidDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.example.fran.appiumtechtalk");
        capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.example.fran.appiumtechtalk.activities.HomeActivity");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");

        return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    protected AppiumDriver createiOSDriver() throws MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("bundleId", "wdpro.disney.com.sample_login");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.3");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");

        return new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    protected void assertTrue(String message, Boolean condition) throws Exception {
        System.out.print("Validating " + message);
        try {
            TestCase.assertTrue(message, condition);
        } catch (Exception e) {
            System.out.println(": Failed");

            throw e;
        }
        System.out.println(": Succeed");
    }

    protected void assertFalse(String message, Boolean condition) throws Exception {
        System.out.print("Validating " + message);
        try {
            TestCase.assertFalse(message, condition);
        } catch (Exception e) {
            System.out.println(": Failed");

            throw e;
        }
        System.out.println(": Succeed");
    }

    protected void assertEquals(String message, String expected, String actual) {
        System.out.print("Validating " + message);
        try {
            AssertJUnit.assertEquals(message, expected, actual);
        } catch (Exception e) {
            System.out.println(": Failed");

            throw e;
        }
        System.out.println(": Succeed");
    }
}
