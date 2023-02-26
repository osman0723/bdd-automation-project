package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.Base_PO;
import pageObjects.Contact_Us_PO;


public class Contact_Us_Steps extends Base_PO {
    private Contact_Us_PO contactUsPo;

    public Contact_Us_Steps(Contact_Us_PO contactUsPo) {
        this.contactUsPo = contactUsPo;
    }


    @Given("I access the webdriver university contact us page")
    public void ı_access_the_webdriver_university_contact_us_page() {
        contactUsPo.navigate_Webdriver_University_Contact_Us_Page();
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
        contactUsPo.setUnique_comment();
    }

    /* -------------- */
    @When("I enter a specific first name {word}")
    public void ı_enter_a_specific_first_name(String firstName) {
        contactUsPo.set_SpecificFirstName(firstName);
    }

    @When("I enter a specific last name {word}")
    public void ı_enter_a_specific_last_name(String lastName) {
        contactUsPo.set_SpecificLastName(lastName);
    }

    @When("I enter a specific email address {word}")
    public void ı_enter_a_specific_email_address(String email) {
        contactUsPo.set_SpecificEmailAddress(email);
    }

    @When("I enter a specific comment {string}")
    public void ı_enter_a_unique_comment(String comment) {
        contactUsPo.set_SpecificComment(comment);
    }

    @And("I click on the submit button")
    public void ı_click_on_the_submit_button() {
        contactUsPo.clickOnSubmitButton();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void ı_should_be_presented_with_a_successful_contact_us_submission_message() {
      contactUsPo.validate_Successful_SubmissionMessage_Text();
    }
}
