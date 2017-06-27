import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import page.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Juan Zarza on 10/7/16.
 */
public class LoginTest {

    private AppiumDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setupTests() throws Exception {
        driver = createAndroidDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @AfterMethod(alwaysRun = true)
    public void finishTests() {
        driver.quit();
    }

    @Test
    public void validLoginWithNoPageObject() {

        driver.findElementById("wdpro.disney.com.sample_login:id/email").sendKeys("juan@test.com");
        driver.findElementById("wdpro.disney.com.sample_login:id/password").sendKeys("password");
        driver.findElementById("wdpro.disney.com.sample_login:id/email_sign_in_button").click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));

        assertTrue("Done message should be displayed", driver.findElementById("android:id/message").getText().equals("Done"));
    }

    @Test
    public void validLoginWithPageObject() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("juan@test.com", "password");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));

        assertTrue("Done message should be displayed", driver.findElementById("android:id/message").getText().equals("Done"));
    }

    private AppiumDriver createAndroidDriver() throws MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "wdpro.disney.com.sample_login");
        capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "wdpro.disney.com.sample_login.LoginActivity");
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
