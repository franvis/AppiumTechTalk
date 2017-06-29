package Configuration;

import org.openqa.selenium.NoSuchElementException;

import java.util.Stack;

import Configuration.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobilePlatform;
import screen.FormScreen;
import screen.HomeScreen;
import screen.ListScreen;
import screen.ProfileScreen;
import screen.Screen;

/**
 * @author f.visintini on 27/06/17.
 */
public class Navigator {

    private final AppiumDriver driver;
    protected final String platform = Constants.platform;
    private Stack<Screen> navigationStack = new Stack<>();

    public Navigator(AppiumDriver driver) {
        this.driver = driver;
        navigationStack.add(new HomeScreen(driver));
    }

    /**
     * Returns current screen from de navigation stack.
     *
     * @return Current screen.
     */
    public Screen getCurrentScreen() {
        return navigationStack.peek();
    }

    public HomeScreen goToHomeScreen() {
        Screen screen = getCurrentScreen();

        while (!screen.getClass().equals(HomeScreen.class)) {
            screen = goBack();
        }

        return (HomeScreen) screen;
    }

    public FormScreen goToFormScreen() {
        HomeScreen homeScreen = goToHomeScreen();
        homeScreen.formButton.click();
        FormScreen formScreen = new FormScreen(driver);
        navigationStack.add(formScreen);
        return formScreen;
    }

    public ListScreen goToListScreen() {
        HomeScreen homeScreen = goToHomeScreen();
        homeScreen.listButton.click();
        ListScreen listScreen = new ListScreen(driver);
        navigationStack.add(listScreen);
        return listScreen;
    }

    public ProfileScreen goToProfileScreen() {
        HomeScreen homeScreen = goToHomeScreen();
        homeScreen.profileButton.click();
        ProfileScreen profileScreen = new ProfileScreen(driver);
        navigationStack.add(profileScreen);
        return profileScreen;
    }

    /**
     * Navigate to the previous screen and returns current screen.
     *
     * @return The new visible screen.
     */
    public Screen goBack() {
        Screen currentScreen = navigationStack.pop();
        if (MobilePlatform.IOS.equals(Constants.platform)) {
            try {
                currentScreen.backButton.tap(1, 1);
            } catch (NoSuchElementException e) {
                // Not implemented.
            }
        } else {
            driver.navigate().back();
        }
        return navigationStack.peek();
    }
}
