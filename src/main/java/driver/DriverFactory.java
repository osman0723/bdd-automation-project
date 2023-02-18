package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    private static ThreadLocal<WebDriver> webdriver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        if(webdriver.get() == null){
            webdriver.set(createDriver());
        }
        return webdriver.get();
    }


    private static WebDriver createDriver(){
         WebDriver driver = null;

         switch (getBrowserType()){
             case "chrome" : {
                 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/main/java/driver/drivers/chromedriver.exe");
                 ChromeOptions chromeOptions = new ChromeOptions();
                 chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                 driver = new ChromeDriver(chromeOptions);
                 break;
             }
             case "firefox" : {
                 System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/src/main/java/driver/drivers/geckodriver.exe");
                 FirefoxOptions firefoxOptions = new FirefoxOptions();
                 firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                 driver = new FirefoxDriver(firefoxOptions);
                 break;
             }
         }
         driver.manage().window().maximize();
         return driver;
    }

    private static String getBrowserType(){
        String browserType = null;


        try {
            Properties properties = new Properties();
            FileInputStream file = null;
            file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
            properties.load(file);
            browserType= properties.getProperty("browser").toLowerCase().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return browserType;
    }
    public static void cleanupDriver(){
        webdriver.get().quit();
        webdriver.remove();
    }

}
