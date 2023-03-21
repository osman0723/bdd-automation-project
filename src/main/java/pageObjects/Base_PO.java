package pageObjects;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base_PO {


    public Base_PO() {
        PageFactory.initElements(getDriver(),this);
    }
        public WebDriver getDriver(){
            return DriverFactory.getDriver();
        }

        public void navigateTO_URL(String url){
        getDriver().get(url);
        }
    public String generateRandomNumber(int lenght){
        return RandomStringUtils.randomNumeric(lenght);
    }
    public String generateRandomString(int lenght){
        return RandomStringUtils.randomAlphabetic(lenght);
    }

    public void sendkeys(By by, String textToType){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);

    }
    public void sendkeys(WebElement webElement, String textToType){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(textToType);

    }
    public void waitForWebElementAndClick(By by){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }
    public void waitForWebElementAndClick(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

}

