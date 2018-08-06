package stepDefs;

import cucumber.api.CucumberOptions;
import utils.DriverInIt;

@CucumberOptions
        (features ={"src/test/resources/features"},
                glue = {"stepDefs"})
public class RunnerTest extends DriverInIt {

    }





