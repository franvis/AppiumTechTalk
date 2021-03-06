package screen;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.remote.HideKeyboardStrategy;
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
    @iOSFindBy(id = "errorLabel")
    public MobileElement errorLabel;

    @AndroidFindBy(id = "name")
    @iOSFindBy(id = "nameTextField")
    public MobileElement nameTextField;

    @AndroidFindBy(id = "last_name")
    @iOSFindBy(id = "lastNameTextField")
    public MobileElement lastNameTextField;

    @AndroidFindBy(id = "gender_label")
    @iOSFindBy(id = "genderLabel")
    public MobileElement genderLabel;

    @AndroidFindBy(id = "gender_male")
    public MobileElement genderMaleButton;

    @AndroidFindBy(id = "gender_female")
    public MobileElement genderFemaleButton;

    @iOSFindBy(id = "genderButton")
    public MobileElement genderButton;

    @AndroidFindBy(id = "eye_color_label")
    @iOSFindBy(id = "eyeColorLabel")
    public MobileElement eyeColorLabel;

    @AndroidFindBy(id = "eye_color_picker")
    @iOSFindBy(xpath = "//UIAPicker/UIAPickerWheel")
    public MobileElement eyeColorPicker;

    @AndroidFindBy(id = "success")
    @iOSFindBy(id = "successLabel")
    public MobileElement successLabel;

    @AndroidFindBy(id = "submit")
    @iOSFindBy(id = "submitButton")
    public MobileElement submitButton;

    public void selectEyeColor(String eyeColor) {
        if (platform.equals(MobilePlatform.ANDROID)) {
            driver.findElement(MobileBy.AndroidUIAutomator(String.format(EYE_COLOR_FINDER, eyeColor)));
        } else {
            ((IOSDriver) driver).hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Done");
            //MobileElement pickerWheel = eyeColorPicker.findElement(By.className("UIAPickerWheel"));
            iOSPickerWheelGoTo(eyeColorPicker, 2, 0, 50);//;eyeColorPicker.sendKeys("Brown");
        }
    }

    public void selectFemaleGender() {
        if (platform.equals(MobilePlatform.ANDROID)) {
            genderFemaleButton.click();
        } else {
            TouchAction touchAction = new TouchAction(driver);
            touchAction.tap(genderButton.getCenter().getX() - 10, genderButton.getCenter().getY()).perform();
        }
    }

    public void selectMaleGender() {
        if (platform.equals(MobilePlatform.ANDROID)) {
            genderMaleButton.click();
        } else {
            TouchAction touchAction = new TouchAction(driver);
            touchAction.tap(genderButton.getCenter().getX() + 10, genderButton.getCenter().getY()).perform();
        }
    }

    private void iOSPickerWheelGoTo(MobileElement pickerWheel, int index, int fromIndex, int wheelHeight) {
        if (index == fromIndex || index < 0) {
            return;
        } else {
            int swipeTimes = 0;
            if (index > fromIndex) {
                swipeTimes = index - fromIndex;
                wheelHeight = -wheelHeight;
            } else {
                swipeTimes = fromIndex - index;
            }
            Point centerPoint = pickerWheel.getCenter();

            // This is performed to swipe 3 times faster.
            for (int i = 0; i < swipeTimes / 3; i++) {
                driver.swipe(centerPoint.getX(), centerPoint.getY(), centerPoint.getX(), centerPoint.getY() + (wheelHeight * 3), 1000);
            }

            // These are the remaining swipes < 3.
            for (int i = 0; i < swipeTimes % 3; i++) {
                driver.swipe(centerPoint.getX(), centerPoint.getY(), centerPoint.getX(), centerPoint.getY() + wheelHeight, 1000);
            }
        }
    }
}
