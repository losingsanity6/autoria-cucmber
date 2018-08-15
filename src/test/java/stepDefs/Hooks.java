package stepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import utils.ConstantVariables;

import java.util.concurrent.TimeUnit;

import static utils.DriverInIt.*;

public class Hooks {

    @Before
    public void setUp() {
        getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(ConstantVariables.pageWaitTimeout, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() {
        closeWebBrowser();
    }
}
