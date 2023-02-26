@login @regression

Feature: WebDriver University - Login Portal Page

  Background:
    Given I access the webdriver university login portal page

  Scenario: Validate Successful Login
    When I enter username webdriver
    And I enter password webdriver123
    And I click on the login button
    Then I should be presented with a successful login message

  Scenario: Validate Unsuccessful Login
    When I enter username webdriver
    And I enter password password000
    And I click on the login button
    Then I should be presented with a unsuccessful login message

    @smoke @ignore
  Scenario Outline: Validate Successful & Unsuccessful Login
    When I enter username <username>
    And I enter password <password>
    And I click on the login button
    Then I should be presented with the following login validation message <loginValidationMessage>

    Examples:
      | username    | password     | loginValidationMessage  |
      | webdriver   | webdriver123 | validation succeeded   |
      | webdriver   | password000  | validation failed |
      | sarah_jones | web321       | validation failed |
