package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.security.Timestamp;
import java.util.Date;

import static driver.DriverFactory.cleanupDriver;
import static driver.DriverFactory.getDriver;


public class Hooks {
    @Before
    public void setup() {
        getDriver();
    }

    @AfterStep
    public void captureExceptionImage(Scenario scenario) {
        Date date = new Date();


        if (scenario.isFailed()) {

            Long timeMilliseconds = date.getTime();
            String time = timeMilliseconds.toString();

            date.getTime();
            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", time);
        }
    }

    @After
    public void tearDown() {
        cleanupDriver();
    }
}
