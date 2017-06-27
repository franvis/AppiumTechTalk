package screen;

import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobilePlatform;

/**
 * @author f.visintini on 27/06/17.
 */
public abstract class Screen {

    protected final String platform = "Android";
//    public static final String platform = "iOS";

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
