package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Global_Vars;

public class Login_PO extends Base_PO{
    public Login_PO() {
        super();
    }

    private @FindBy(id = "text")
    WebElement usermane_TextField;
    private @FindBy(id = "password")
    WebElement password_TextField;
    private @FindBy(id = "login-button")
    WebElement login_button;

    public void navigateTo_WebDriverUniversity_LoginPage(){
        navigateTO_URL(Global_Vars.WEBDRIVER_UNIVERSITY_HOMEPAGE_URL +"/Login-Portal/index.html?");
    }
    public void setUsername(String username){

        sendKeys(usermane_TextField,username);
    }
    public void setPassword(String password){

        sendKeys(password_TextField,password);
    }
    public void clickOn_Login_Button(){

        waitForWebElementAndClick(login_button);
    }
    public void validate_SuccessfulLogin_Message() {
        waitForAlert_And_ValidateText("validation succeeded");
    }

    public void validate_UnsuccessfulLogin_Message() {
        waitForAlert_And_ValidateText("validation failed");
    }
}
