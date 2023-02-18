@contact-us @regression

Feature: WebDriver University - Contact Us Page

  Background:
    Given I access the webdriver university contact us page

  Scenario: Validate Successful Submission - Unique Data
    When I enter a unique first name
    And I enter a unique last name
    And I enter a unique email address
    And I enter a unique comment
    And I click on the submit button
    Then I should be presented with a successful contact us submission message

  Scenario: Validate Successful Submission - Specific Data
    When I enter a specific first name Mehmet
    And I enter a specific last name Cilgin
    And I enter a specific email address Mehmet@mail.com
    And I enter a specific comment "How are you dear?"
    And I click on the submit button
    Then I should be presented with a successful contact us submission message