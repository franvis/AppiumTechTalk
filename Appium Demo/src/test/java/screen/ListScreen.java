package screen;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.remote.MobilePlatform;

/**
 * @author f.visintini on 27/06/17.
 */
public class ListScreen extends Screen {

    public static final String LIST_ITEMS = "new UiScrollable(.resourceIdMatches(\".*:id/recycler\").scrollable(true)).scrollIntoView(.description" +
            "(\"List Item %1$d\").childSelector(.resourceIdMatches(\".*:id/%2$s\")))";

    public ListScreen(AppiumDriver driver) {
        super(driver);
    }


    public MobileElement getTitleElement(int index) {
        if (platform.equals(MobilePlatform.ANDROID)) {
            return (MobileElement) driver.findElement(
                    MobileBy.AndroidUIAutomator(String.format(LIST_ITEMS, index, "title")));
        } else {
            return (MobileElement) driver.findElementsById("entitlementTitle").get(0);
        }
    }

    public MobileElement getDescriptionElement(int index) {
        if (platform.equals(MobilePlatform.ANDROID)) {
            return (MobileElement) driver.findElement(
                    MobileBy.AndroidUIAutomator(String.format(LIST_ITEMS, index, "description")));
        } else {
            return (MobileElement) driver.findElementsById("entitlementTitle").get(0);
        }
    }
}
