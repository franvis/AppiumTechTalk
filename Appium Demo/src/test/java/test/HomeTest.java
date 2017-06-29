package test;

import org.testng.annotations.Test;
import screen.HomeScreen;


/**
 * @author Francisco Visintini.
 */
public class HomeTest extends BaseTest {

    @Test
    public void validLoginWithNoPageObject() throws Exception {
        HomeScreen homeScreen = navigator.goToHomeScreen();
        assertTrue("Form button should be displayed", homeScreen.isFormButtonDisplayed());
        assertTrue("List button should be displayed", homeScreen.isListButtonDisplayed());
        assertTrue("Profile button should be displayed", homeScreen.isProfileButtonDisplayed());
        assertTrue("Reset button should be displayed", homeScreen.isResetButtonDisplayed());
    }
}
