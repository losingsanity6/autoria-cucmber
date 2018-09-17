package stepDefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import utils.ConstantVariables;
import utils.Helpers;

import static utils.DriverInIt.openPage;

public class LoginTest {
    @Given("^I open login Page$")
    public void iOpenLoginPage() {
        openPage(ConstantVariables.loginPage);
    }

    @When("^I click facebook login button$")
    public void iClickFacebookLoginButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.switchBetweenFrame();
        loginPage.loginViaFacebook();

    }

    @And("^I enter facebook credentials \"([^\"]*)\", \"([^\"]*)\"$")
    public void iEnterFacebookCredentials(String email, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.LoginFacebook(email, password);
    }


    @Then("^I see message \"([^\"]*)\" on login page$")
    public void iSeeMessageMessageOnLoginPage(String message) {
        LoginPage loginPage = new LoginPage();
        loginPage.switchBetweenFrame();
        Assert.assertTrue(loginPage.Message().contains(message));

    }


}
