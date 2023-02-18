package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PO extends Base_PO{
    private @FindBy(id = "text")
    WebElement usermane_TextField;
    private @FindBy(id = "password")
    WebElement password_TextField;
    private @FindBy(id = "login-button")
    WebElement login_button;
    public Login_PO(){
        super();
    }
    public void navigateTo_WebDriverUniversity_LoginPage(){
        navigateTO_URL("https://www.webdriveruniversity.com/Login-Portal/index.html?");
    }
    public void setUsername(String username){
        sendkeys(usermane_TextField,username);
    }
    public void setPassword(String password){
        sendkeys(password_TextField,password);
    }
    public void clickOn_Login_Button(){
        waitForWebElementAndClick(login_button);
    }
}
