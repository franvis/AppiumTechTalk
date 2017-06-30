package screen;

import org.openqa.selenium.NoSuchElementException;

import configuration.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.remote.MobilePlatform;

import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * @author Francisco Visintini.
 */
public abstract class Screen {

    @iOSFindBy(xpath = "//UIAButton[@name='Back' and @visible='true']")
    public MobileElement backButton;

    protected final AppiumDriver driver;
    protected final String platform = Constants.platform;

    public Screen(AppiumDriver driver) {
        this.driver = driver;

        initElements(new AppiumFieldDecorator(driver), this);
    }

    protected boolean isElementDisplayed(MobileElement element) {
        try {
            if (MobilePlatform.ANDROID.equals(platform)) {
                return element.isDisplayed();
            } else {
                return element.getId() != null;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
