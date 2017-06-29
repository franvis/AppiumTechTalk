package test;

import org.testng.annotations.Test;

import Configuration.Copy;
import screen.FormScreen;

/**
 * Created by emiliano.alvarez on 6/28/17.
 */
public class FormTest extends BaseTest {

    @Test
    public void validateMissingNameError() {
        FormScreen formScreen = navigator.goToFormScreen();
        formScreen.submitButton.click();

        assertEquals("Missing name label is correct.", Copy.MISSING_NAME, formScreen.errorLabel.getText());
    }

    @Test
    public void validateMissingLastNameError() {
        FormScreen formScreen = navigator.goToFormScreen();
        formScreen.nameTextField.sendKeys("Francisco");
        formScreen.submitButton.click();

        assertEquals("Missing last name label is correct.", Copy.MISSING_LASTNAME, formScreen.errorLabel.getText());
    }
}
