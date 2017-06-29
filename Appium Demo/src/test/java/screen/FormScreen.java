package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.remote.MobilePlatform;

/**
 * @author Francisco Visintini.
 */
public class FormScreen extends Screen {

    public FormScreen(AppiumDriver driver) {
        super(driver);
    }

    private static final String EYE_COLOR_FINDER = "new UiScrollable(.className(\"android.widget.NumberPicker\").scrollable(true))" +
            ".setAsVerticalList().setSwipeDeadZonePercentage(0.9).scrollIntoView(.textContains(\"%s\"))";

    @AndroidFindBy(id = "error")
    @iOSFindBy(id = "")
    public MobileElement errorLabel;

    @AndroidFindBy(id = "name")
    @iOSFindBy(id = "")
    public MobileElement nameTextField;

    @AndroidFindBy(id = "last_name")
    @iOSFindBy(id = "")
    public MobileElement lastNameTextField;

    @AndroidFindBy(id = "gender_label")
    @iOSFindBy(id = "")
    public MobileElement genderLabel;

    @AndroidFindBy(id = "gender_male")
    @iOSFindBy(id = "")
    public MobileElement genderMaleButton;

    @AndroidFindBy(id = "gender_female")
    @iOSFindBy(id = "")
    public MobileElement genderFemaleButton;

    @AndroidFindBy(id = "eye_color_label")
    @iOSFindBy(id = "")
    public MobileElement eyeColorLabel;

    @AndroidFindBy(id = "eye_color_picker")
    @iOSFindBy(id = "")
    public MobileElement eyeColorPicker;

    @AndroidFindBy(id = "success")
    @iOSFindBy(id = "")
    public MobileElement successLabel;

    @AndroidFindBy(id = "submit")
    @iOSFindBy(id = "")
    public MobileElement submitButton;

    public void selectEyeColor(String eyeColor) {
        if (platform.equals(MobilePlatform.ANDROID)) {
            driver.findElement(MobileBy.AndroidUIAutomator(String.format(EYE_COLOR_FINDER, eyeColor)));
        } else {

        }
    }
}
