package com.bdd.pageobjects;

import com.bdd.reusablecomponents.GenericMethods;
import com.bdd.utilities.FakerClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends GenericMethods {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//a[text()='Create an Account'])[1]")
    protected WebElement createAnAccountLink;

    @FindBy(id = "firstname")
    protected WebElement firstName;

    @FindBy(id = "lastname")
    protected WebElement lastName;

    @FindBy(id = "is_subscribed")
    protected WebElement signUpForNewsLetter;

    @FindBy(id = "email_address")
    protected WebElement email;

    @FindBy(id = "password")
    protected WebElement password;

    @FindBy(id = "password-confirmation")
    protected WebElement confirmPassword;

    @FindBy(xpath = "//button/*[text()='Create an Account']")
    protected WebElement createAnAccountButton;

    @FindBy(xpath = "//h1/*[text()='My Account']")
    protected WebElement positiveLoginIdentifier;

    public void mainPageIdentifier() {
        pageIdentifier(createAnAccountLink, "Main Page");
    }

    public void clicksOnTheCreateAnAccountLink() {
        createAnAccountLink.click();
        pageIdentifier(firstName, "Login Page");
    }

    public void myAccountPageIdentifier() {
        pageIdentifier(positiveLoginIdentifier, "My Account Page");
    }

    public void enterAccountCreationDetails(String firstName, String lastName, String signUpForNewsLetter, String email, String password, String confirmPassword) {
        typeInto(this.firstName, "First Name", firstName);
        typeInto(this.lastName, "Last Name", lastName);

        if (signUpForNewsLetter.equalsIgnoreCase("yes")) {
            clickElement(this.signUpForNewsLetter, "Sign Up for News Letter");
        }

        if (email.equalsIgnoreCase("random")) {
            typeInto(this.email, "Email", FakerClass.randomEmail());
        } else {
            typeInto(this.email, "Email", email);
        }

        typeInto(this.password, "Password", password);
        typeInto(this.confirmPassword, "Confirm Password", confirmPassword);
    }

    public void clickCreateAnAccountButton(String elementName) {
        clickElement(createAnAccountButton, elementName);
    }
}