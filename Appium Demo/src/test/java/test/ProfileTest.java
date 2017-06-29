package test;

import org.testng.annotations.Test;

import configuration.Copy;
import screen.ProfileScreen;

/**
 * @author Emiliano Alvarez.
 */
public class ProfileTest extends BaseTest {

    @Test
    public void testUserWithoutProfileShouldSeeMissingProfile() throws Exception {
        ProfileScreen profileScreen = navigator.goToProfileScreen();
        assertEquals("Missing Profile is as expected.", String.format(Copy.MISSING_PROFILE), profileScreen.getMissingProfileText());
    }
}
