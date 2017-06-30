package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.remote.MobilePlatform;

/**
 * @author Francisco Visintini.
 */
public class ProfileScreen extends Screen {

    public ProfileScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "error")
    public MobileElement errorLabel;

    @AndroidFindBy(id = "name")
    public MobileElement nameLabel;

    @AndroidFindBy(id = "last_name")
    public MobileElement lastNameLabel;

    @iOSFindBy(id = "profileFullNameLabel")
    public MobileElement fullNameLabel;

    @AndroidFindBy(id = "gender")
    @iOSFindBy(id = "profileGenderLabel")
    public MobileElement genderLabel;

    @AndroidFindBy(id = "eye_color")
    @iOSFindBy(id = "profileEyeColorLabel")
    public MobileElement eyeColorLabel;

    public String getMissingProfileText() {
        if (platform.equals(MobilePlatform.ANDROID)) {
            return errorLabel.getText();
        } else {
            return fullNameLabel.getText();
        }
    }

    public String getName() {
        if (platform.equals(MobilePlatform.ANDROID)) {
            return nameLabel.getText();
        } else {
            return fullNameLabel.getText().split(" ")[0];
        }
    }

    public String getLastName() {
        if (platform.equals(MobilePlatform.ANDROID)) {
            return lastNameLabel.getText();
        } else {
            return fullNameLabel.getText().split(" ")[1];
        }
    }

    public String getGender() {
        if (platform.equals(MobilePlatform.ANDROID)) {
            return genderLabel.getText();
        } else {
            return genderLabel.getText().split(" ")[1];
        }
    }

    public String getEyeColor() {
        if (platform.equals(MobilePlatform.ANDROID)) {
            return eyeColorLabel.getText();
        } else {
            return eyeColorLabel.getText().split(" ")[2];
        }
    }
}
