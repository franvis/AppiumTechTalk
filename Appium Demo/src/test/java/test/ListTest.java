package test;

import org.testng.annotations.Test;

import Configuration.Copy;
import io.appium.java_client.MobileElement;
import screen.HomeScreen;
import screen.ListScreen;

/**
 * Created by emiliano.alvarez on 6/29/17.
 */
public class ListTest extends BaseTest {

    @Test
    public void testUserCanSeeOrderedListCorrectly() throws Exception {
        int elementIndex = 11;
        ListScreen listScreen = navigator.goToListScreen();
        MobileElement titleElement = listScreen.getTitleElement(elementIndex);
        MobileElement descriptionElement = listScreen.getDescriptionElement(elementIndex);
        assertEquals("Title label is as expected.", String.format(Copy.LIST_TITLE, elementIndex + 1), titleElement.getText());
        assertEquals("Description label is as expected.", String.format(Copy.LIST_DESCRIPTION, elementIndex + 1), descriptionElement.getText());
    }
}