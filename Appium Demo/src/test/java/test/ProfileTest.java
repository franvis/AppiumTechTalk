package test;

import org.testng.annotations.Test;

import Configuration.Copy;
import io.appium.java_client.MobileElement;
import screen.ListScreen;
import screen.ProfileScreen;

/**
 * Created by emiliano.alvarez on 6/29/17.
 */
public class ProfileTest extends BaseTest {

    @Test
    public void testUserWithoutProfileShouldSeeMissingProfile() throws Exception {
        ProfileScreen profileScreen = navigator.goToProfileScreen();
        assertEquals("Missing Profile is as expected.", String.format(Copy.MISSING_PROFILE), profileScreen.getMissingProfileText());
    }
}
