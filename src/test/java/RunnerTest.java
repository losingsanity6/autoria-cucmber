import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions
        (
                features = {"src\\test\\resources\\features"},
                glue = {"stepDefs"},
                plugin ={ "json:target/cucumber.json","html:target/site/cucumber-pretty"}
        )
public class RunnerTest extends AbstractTestNGCucumberTests {

}





