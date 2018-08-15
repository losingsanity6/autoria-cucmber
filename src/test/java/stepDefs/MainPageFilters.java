package stepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.ExtendedSearchPage;
import pages.MainPage;
import pages.NewCarsPage;
import pages.ResultPage;
import utils.ConstantVariables;

import static utils.DriverInIt.getDriver;
import static utils.DriverInIt.openPage;

public class MainPageFilters {
    @Given("I open homepage")
    public void openHomePage() {
        openPage(ConstantVariables.URL);
    }

    @When("^I enter car brand \"([^\"]*)\"$")
    public void carBrandFilter(String carBrand) {
        MainPage mainPage = new MainPage();
        mainPage.chooseCarBrand(carBrand);
    }

    @When("^I enter car model \"([^\"]*)\"$")
    public void carModel(String carModel) {
        MainPage mainPage = new MainPage();
        mainPage.clickModel(carModel);
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
        Assert.assertTrue(resultPage.headerText().contains(carBrand));
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
        Assert.assertTrue(newCarsPage.getUrl().contains(linkName.toLowerCase()));
    }
    @And("^I enter region \"([^\"]*)\"$")
    public void enterRegion(String region){
        MainPage mainPage = new MainPage();
        mainPage.clickRegion(region);
    }
    @Then("^I see message \"([^\"]*)\"$")
    public void assertMessage(String message){
        ResultPage resultPage = new ResultPage();
        Assert.assertTrue(resultPage.getTextFromNoResultsMessage().contains(message));
    }
}


