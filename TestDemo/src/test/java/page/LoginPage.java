package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Juan Zarza on 10/7/16.
 */
public class LoginPage {

    private static final String ANDROID_PREFIX = "wdpro.disney.com.sample_login:id/";

    public LoginPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = ANDROID_PREFIX + "email")
    @iOSFindBy(id = "txtUsername")
    public MobileElement txtUsername;

    @AndroidFindBy(id = ANDROID_PREFIX + "password")
    @iOSFindBy(id = "txtPassword")
    public MobileElement txtPassword;

    @AndroidFindBy(id = ANDROID_PREFIX + "email_sign_in_button")
    @iOSFindBy(id = "btnLogin")
    public MobileElement btnLogin;


    /**
     * Perform the login action for a specific username and password.
     *
     * @param username
     * @param password
     */
    public void loginUser(String username, String password) {
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();
    }
}
