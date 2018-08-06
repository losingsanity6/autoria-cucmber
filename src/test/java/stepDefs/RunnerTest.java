package stepDefs;

import cucumber.api.CucumberOptions;
import utils.DriverInIt;

@CucumberOptions
        (features ={"src/main/resources/features"},
                glue = {"stepDefs"})
public class RunnerTest extends DriverInIt {

    }





