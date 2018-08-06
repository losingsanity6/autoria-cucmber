package stepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import utils.ConstantVariables;

import java.util.concurrent.TimeUnit;
import static utils.DriverInIt.driver;
import static utils.DriverInIt.getDriver;

public class Hooks{
    @Given("I open home page")
    @Before
    public void setUp() {
        getDriver(ConstantVariables.browser);
        driver.get(ConstantVariables.URL);
        driver.manage().timeouts().implicitlyWait(ConstantVariables.pageWaitTimeout, TimeUnit.SECONDS);

    }
    @After
   public void tearDown(){ driver.close(); }
}
