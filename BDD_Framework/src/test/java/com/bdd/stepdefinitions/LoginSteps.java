package com.bdd.stepdefinitions;

import com.bdd.pageobjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.bdd.reusablecomponents.Utils.getDriver;

public class LoginSteps {
    LoginPage login = new LoginPage(getDriver());

    @Given("User should be able to see the main page once the URL Launched")
    public void user_should_be_able_to_see_the_main_page_once_the_url_launched() {
        login.mainPageIdentifier();
    }

    @When("User clicks on the {string} link and User should see the {string} page")
    public void user_clicks_on_the_link_and_User_should_see_the_page(String string, String string1) {
        login.clicksOnTheCreateAnAccountLink();
    }

    @Then("User enters the value for {string}, {string}, {string}, {string}, {string}, {string}")
    public void user_enters_the_value_for(String firstName, String lastName, String signUpForNewsLetter, String email, String password, String confirmPassword) {
        login.enterAccountCreationDetails(firstName, lastName, signUpForNewsLetter, email, password, confirmPassword);
    }

    @When("User clicks on the {string} button")
    public void user_clicks_on_the_button(String elementName) {
        login.clickCreateAnAccountButton("Create An Account Button");
    }

    @Then("User should get navigated to {string} page and see the page title as {string}")
    public void user_should_get_navigated_to_page_and_see_the_page_title_as(String string, String string2) {
        login.myAccountPageIdentifier();
    }
}