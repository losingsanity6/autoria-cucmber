package stepDefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.it.Ma;
import org.testng.Assert;
import pages.ExtendedSearchPage;
import pages.MainPage;
import pages.NewCarsPage;
import pages.ResultPage;
import utils.ConstantVariables;
import utils.DriverInIt;
import utils.Helpers;

import static utils.DriverInIt.getDriver;
import static utils.DriverInIt.openPage;

public class MainPageFilters extends DriverInIt {
    @Given("I open homepage")
    public void openHomePage() {
        openPage(ConstantVariables.URL);
    }

    @When("^I click search button")
    public void clickSearchButton() {
        MainPage mainPage = new MainPage();
        mainPage.clickSearchButton();

    }

    @Then("^I see in header \"([^\"]*)\"$")
    public void headerContains(String carBrand) {
        ResultPage resultPage = new ResultPage();
        System.out.println(resultPage.headerText());
        Assert.assertTrue(resultPage.headerText().contains(carBrand), "Assertation failed");
    }

    @Given("^I enter \"([^\"]*)\" to priceFrom field and \"([^\"]*)\" to priceTo field")
    public void enterPrice(String priceFrom, String priceTo) {
        MainPage mainPage = new MainPage();
        mainPage.enterPriceToPriceField(priceFrom, priceTo);
    }

    @Then("^I see on Result page in price filter \"([^\"]*)\"$")
    public void getPriceFromPriceFilter(String priceFrom) {
        ResultPage resultPage = new ResultPage();
        Assert.assertEquals(priceFrom, resultPage.getTextFromPriceInputFrom());
    }

    @Given("^I click extended search button$")
    public void clickExtendedSearch() {
        MainPage mainPage = new MainPage();
        mainPage.clickExtendedSearchButton();
    }

    @When("^I choose checkbox \"([^\"]*)\"$")
    public void chooseCheckBoxCarType(String cartype) {
        ExtendedSearchPage extendedSearchPage = new ExtendedSearchPage();
        extendedSearchPage.clickCheckboxes(cartype);
    }

    @And("^I click origin \"([^\"]*)\"$")
    public void clickOrigin(String origin) {
        ExtendedSearchPage extendedSearchPage = new ExtendedSearchPage();
        extendedSearchPage.ckickOrigin(origin);
    }

    @And("^I click Show button$")
    public void clickShowButton() {
        ExtendedSearchPage extendedSearchPage = new ExtendedSearchPage();
        extendedSearchPage.clickShowButton();
    }

    @When("^I click on link that has a name \"([^\"]*)\"$")
    public void clickOnLinkText(String linkName) {
        MainPage mainPage = new MainPage();
        mainPage.clickOnElementByLinkText(linkName);
    }

    @Then("^I see in url \"([^\"]*)\"$")
    public void checkUrl(String linkName) {
        NewCarsPage newCarsPage = new NewCarsPage();
        Assert.assertTrue(newCarsPage.getUrl().contains(linkName.toLowerCase()), "Assertation failed");
    }

    @Then("^I see no results message \"([^\"]*)\"$")
    public void iSeeNoResultsMessage(String message) {
        ResultPage resultPage = new ResultPage();
        Assert.assertEquals(resultPage.getTextFromNoResultsMessage().toLowerCase(), message.toLowerCase(), "Assertation failed");
    }

    @When("^I change language to \"([^\"]*)\"$")
    public void iChangeLanguageTo(String languageLink) {
        MainPage mainPage = new MainPage();
        mainPage.clickOnElementByLinkText(languageLink);
    }

    @Then("^I see in title \"([^\"]*)\" and in url \"([^\"]*)\"$")
    public void iSeeInTitleAndInUrl(String title, String url) {
        Assert.assertTrue(driver.getCurrentUrl().equals(url) && driver.getTitle().equals(title));

    }

    @When("^i click on link of other ria service in header \"([^\"]*)\"$")
    public void iClickOnLinkOfOtherRiaServiceInHeader(String serviceName) {
        MainPage mainPage = new MainPage();
        mainPage.clickOnElementByLinkText(serviceName);
    }

    @Then("^i see new tab opened and check url \"([^\"]*)\" and i see in title \"([^\"]*)\"$")
    public void iSeeNewTabOpenedAndCheckUrlAndISeeInTitle(String url, String title) {
        Helpers helpers = new Helpers();
        helpers.switchBetweenWindows(1);
        Assert.assertTrue(driver.getCurrentUrl().equals(url) && driver.getTitle().equals(title));
    }

    @When("^I enter to filter dropdown named - \"([^\"]*)\" data - \"([^\"]*)\"$")
            public void iEnterData(String parameterName, String data){
        MainPage mainPage = new MainPage();
        mainPage.inputDataToFilter(parameterName, data);

    }
}

