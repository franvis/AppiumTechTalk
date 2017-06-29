package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

/**
 * @author Francisco Visintini.
 */
public class HomeScreen extends Screen {

    public HomeScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "form")
    @iOSFindBy(id = "")
    public MobileElement formButton;

    @AndroidFindBy(id = "list")
    @iOSFindBy(id = "")
    public MobileElement listButton;

    @AndroidFindBy(id = "profile")
    @iOSFindBy(id = "")
    public MobileElement profileButton;

    @AndroidFindBy(id = "reset")
    @iOSFindBy(id = "")
    public MobileElement resetButton;

    public boolean isFormButtonDisplayed(){
        return isElementDisplayed(formButton);
    }

    public boolean isProfileButtonDisplayed(){
        return isElementDisplayed(profileButton);
    }

    public boolean isListButtonDisplayed(){
        return isElementDisplayed(listButton);
    }

    public boolean isResetButtonDisplayed(){
        return isElementDisplayed(resetButton);
    }

}
