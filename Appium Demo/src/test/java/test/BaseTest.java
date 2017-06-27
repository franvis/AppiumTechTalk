package test;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author f.visintini on 27/06/17.
 */
public abstract class BaseTest {


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

}
