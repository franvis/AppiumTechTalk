package test;

import org.testng.annotations.Test;

import configuration.Copy;
import screen.FormScreen;
import screen.ProfileScreen;

/**
 * @author Emiliano Alvarez.
 */
public class ProfileTest extends BaseTest {

    @Test
    public void testUserWithoutProfileShouldSeeMissingProfile() throws Exception {
        ProfileScreen profileScreen = navigator.goToProfileScreen();
        assertEquals("Missing Profile is as expected.", Copy.MISSING_PROFILE, profileScreen.getMissingProfileText());
    }

    @Test
    public void testUserWithFilledProfileShouldSeeCorrectProfile() throws Exception {
        String expectedName = "Francisco";
        String expectedLastName = "Visintini";
        String expectedGender = "Male";
        String expectedEyeColor = "Green";

        FormScreen formScreen = navigator.goToFormScreen();
        formScreen.nameTextField.setValue(expectedName);
        formScreen.lastNameTextField.setValue(expectedLastName);
        formScreen.selectMaleGender();
        formScreen.selectEyeColor(expectedEyeColor);

        formScreen.submitButton.click();
        ProfileScreen profileScreen = navigator.goToProfileScreen();
        assertEquals("Name is as expected.", expectedName, profileScreen.getName());
        assertEquals("Last Name is as expected.", expectedLastName, profileScreen.getLastName());
        assertEquals("Gender is as expected.", expectedGender, profileScreen.getGender());
        assertEquals("Eye Color is as expected.", expectedEyeColor, profileScreen.getEyeColor());
    }
}
