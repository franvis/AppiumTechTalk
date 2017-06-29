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
        formScreen.nameTextField.sendKeys(expectedName);
        formScreen.lastNameTextField.sendKeys(expectedLastName);
        formScreen.genderMaleButton.click();
        formScreen.selectEyeColor(expectedEyeColor);
        formScreen.submitButton.click();
        ProfileScreen profileScreen = navigator.goToProfileScreen();
        assertEquals("Name is as expected.", expectedName, profileScreen.nameLabel.getText());
        assertEquals("Last Name is as expected.", expectedLastName, profileScreen.lastNameLabel.getText());
        assertEquals("Gender is as expected.", expectedGender, profileScreen.genderLabel.getText());
        assertEquals("Eye Color is as expected.", expectedEyeColor, profileScreen.eyeColorLabel.getText());
    }
}
