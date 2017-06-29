package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.remote.MobilePlatform;

/**
 * @author f.visintini on 27/06/17.
 */
public class ProfileScreen extends Screen {

    public ProfileScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "error")
    @iOSFindBy(id = "")
    public MobileElement errorLabel;

    @AndroidFindBy(id = "name")
    @iOSFindBy(id = "")
    public MobileElement nameLabel;

    @AndroidFindBy(id = "last_name")
    @iOSFindBy(id = "")
    public MobileElement lastNameLabel;

    @AndroidFindBy(id = "gender_label")
    @iOSFindBy(id = "")
    public MobileElement genderTitleLabel;

    @AndroidFindBy(id = "gender")
    @iOSFindBy(id = "")
    public MobileElement genderLabel;

    @AndroidFindBy(id = "eye_color_label")
    @iOSFindBy(id = "")
    public MobileElement eyeColorTitleLabel;

    @AndroidFindBy(id = "eye_color")
    @iOSFindBy(id = "")
    public MobileElement eyeColorLabel;

    public String getMissingProfileText() {
        if (platform.equals(MobilePlatform.ANDROID)) {
            return errorLabel.getText();
        } else {
            return "";
        }
    }
}
