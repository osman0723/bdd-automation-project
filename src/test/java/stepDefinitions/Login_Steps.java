package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.Base_PO;
import pageObjects.Login_PO;


public class Login_Steps extends Base_PO {

    private WebDriver driver = getDriver();

    private Login_PO loginPo;

    public Login_Steps(Login_PO loginPo) {
        this.loginPo = loginPo;
    }

    @Given("I access the webdriver university login portal page")
    public void ı_access_the_webdriver_university_login_portal_page() {
        loginPo.navigateTo_WebDriverUniversity_LoginPage();
    }

    @When("I enter username {}")
    public void ı_enter_username(String username) {
        //  driver.findElement(By.xpath("//input[@id=\"text\"]")).sendKeys(username);
       // sendkeys(By.xpath("//input[@id=\"text\"]"), username);
        loginPo.setUsername(username);
    }

    @And("I enter password {}")
    public void ı_enter_password(String password) {
loginPo.setPassword(password);
    }

    @And("I click on the login button")
    public void ı_click_on_the_login_button() {
    loginPo.clickOn_Login_Button();
    }

    @Then("I should be presented with a successful login message")
    public void ı_should_be_presented_with_a_successful_login_message() {
        String login_message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_message, "validation succeeded");
    }

    @Then("I should be presented with a unsuccessful login message")
    public void ı_should_be_presented_with_an_unsuccessful_login_message() {
        String login_message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_message, "validation failed");
    }

    @Then("I should be presented with the following login validation message {}")
    public void ı_should_be_presented_with_the_following_login_validation_message(String validateMessage) {
        String login_message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_message, validateMessage);
    }
}
