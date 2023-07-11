package com.bdd.reusablecomponents;

import io.cucumber.java.en.Then;

public class PredefinedStepDefinitions extends GenericMethods {

    @Then("I navigate forward")
    public void navigate_forward() {
        getDriver().navigate().forward();
    }

    @Then("I navigate back")
    public void navigate_back() {
        getDriver().navigate().back();
    }

    @Then("I refresh page")
    public void I_refresh_page() {
        getDriver().navigate().refresh();
    }
}