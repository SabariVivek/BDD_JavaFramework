@Regression
Feature: Login functionality of the application

  Scenario Outline: Login functionality
    Given User should be able to see the main page once the URL Launched
    When User clicks on the "Create an Account" link and User should see the "Create New Customer Account" page
    And User enters the value for "<FirstName>", "<LastName>", "<SignUpForNewsLetter>", "<Email>", "<Password>", "<ConfirmPassword>"
    When User clicks on the "Create an Account" button
    Then User should get navigated to "My Account" page and see the page title as "My Account"

    Examples:
      | FirstName | LastName | SignUpForNewsLetter | Email  | Password   | ConfirmPassword |
      | Sabari    | Vivek    | Yes                 | random | Sabari@123 | Sabari@123      |