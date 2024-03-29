package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Contact_Us_PO;


public class Contact_Us_Steps{
    private Contact_Us_PO contactUsPo = new Contact_Us_PO();

    @Given("I access the webdriver university contact us page")
    public void ı_access_the_webdriver_university_contact_us_page() {
        contactUsPo.navigateTo_WebDriverUniversity_Contact_Us_Page();
    }

    @When("I enter a unique first name")
    public void ı_enter_a_unique_first_name() {

        contactUsPo.setUnique_FirstName();
    }

    @And("I enter a unique last name")
    public void ı_enter_a_unique_last_name() {

        contactUsPo.setUnique_LastName();
    }

    @And("I enter a unique email address")
    public void ı_enter_a_unique_email_address() {

        contactUsPo.setUnique_EmailAddress();
    }

    @And("I enter a unique comment")
    public void ı_enter_a_unique_comment() {

        contactUsPo.setUnique_Comment();
    }

    /* ------Scenario 2-------- */
    @When("I enter a specific first name {word}")
    public void ı_enter_a_specific_first_name(String firstName) {

        contactUsPo.setSpecific_FirstName(firstName);
    }

    @When("I enter a specific last name {word}")
    public void ı_enter_a_specific_last_name(String lastName) {

        contactUsPo.setSpecific_LastName(lastName);
    }

    @When("I enter a specific email address {word}")
    public void ı_enter_a_specific_email_address(String email) {

        contactUsPo.setSpecific_EmailAddress(email);
    }

    @When("I enter a specific comment {string}")
    public void ı_enter_a_unique_comment(String comment) {

        contactUsPo.setSpecific_Comment(comment);
    }

    @And("I click on the submit button")
    public void ı_click_on_the_submit_button() {

        contactUsPo.clickOn_Submit_Button();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void ı_should_be_presented_with_a_successful_contact_us_submission_message() {
      contactUsPo.validate_Successful_SubmissionMessage_Text();
    }
}
