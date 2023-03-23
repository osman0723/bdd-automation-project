package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.sql.Timestamp;
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
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String  timeMilliseconds = Long.toString(timestamp.getTime());
        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", timeMilliseconds);
        }
    }

    @After
    public void tearDown() {
        cleanupDriver();
    }
}
