package com.bdd.reusablecomponents;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

import static com.bdd.hooks.MyHooks.fail;
import static com.bdd.hooks.MyHooks.pass;

public class GenericMethods extends Utils {

    public void typeInto(WebElement element, String fieldName, String value) {
        element.sendKeys(value);
        pass("Successfully entered the value (" + value + ") in " + fieldName + " field");
    }

    public void clickElement(WebElement element, String elementName) {
        element.click();
        pass("Successfully clicked on the \"" + elementName + "\" field");
    }

    public void pageIdentifier(WebElement element, String pageName) {
        if (element.isDisplayed()) {
            pass("User is in " + pageName + " name");
        } else {
            pass("User is not in " + pageName + " name");
        }
    }

    public String getPageTitle() {
        return getDriver().getTitle();
    }

    public void verifyTitle(String title) {
        if (title.trim().equalsIgnoreCase("")) {
            pass("Successfully verified the title : MATCHED");
        } else {
            fail("Successfully verified the title : NOT MATCHED");
        }
    }

    public String getWebElementText(WebElement element) {
        return element.getText();
    }

    public String getWebElementText(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    public boolean isElementEnabled(WebElement element) {
        return element.isEnabled();
    }

    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public boolean isElementSelected(WebElement element) {
        return element.isSelected();
    }

    public String getAlertText() {
        Alert alert = getDriver().switchTo().alert();
        return alert.getText();
    }
}