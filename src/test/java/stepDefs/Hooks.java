package stepDefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.log4testng.Logger;
import pages.MainPage;
import utils.ConstantVariables;
import utils.DriverInIt;

import java.util.concurrent.TimeUnit;

import static utils.DriverInIt.*;

public class Hooks extends DriverInIt {
private final Logger log = Logger.getLogger(Hooks.class);
    @Before
    public void setUp() {
        getDriver("chrome");
        log.info("browser has started");
        driver.manage().timeouts().implicitlyWait(ConstantVariables.pageWaitTimeout, TimeUnit.SECONDS);
log.info("Page timeout initialized");
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()){
           byte[] screenshot = ((TakesScreenshot) getDriver("chrome")).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }

        closeWebBrowser();
        log.info("Browser closed");
    }


}
