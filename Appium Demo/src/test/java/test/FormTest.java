package test;

import org.testng.annotations.Test;

import configuration.Copy;
import screen.FormScreen;

/**
 * @author Emiliano Alvarez.
 */
public class FormTest extends BaseTest {

    @Test
    public void validateMissingNameError() throws Exception {
        FormScreen formScreen = navigator.goToFormScreen();
        formScreen.submitButton.click();

        assertEquals("Missing name label is correct.", Copy.MISSING_NAME, formScreen.errorLabel.getText());
    }

    @Test
    public void validateMissingLastNameError() throws Exception {
        FormScreen formScreen = navigator.goToFormScreen();
        formScreen.nameTextField.sendKeys("Francisco");
        formScreen.submitButton.click();

        assertEquals("Missing last name label is correct.", Copy.MISSING_LASTNAME, formScreen.errorLabel.getText());
    }
}
