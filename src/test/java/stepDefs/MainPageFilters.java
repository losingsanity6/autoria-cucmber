package stepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.ExtendedSearchPage;
import pages.MainPage;
import pages.ResultPage;

public class MainPageFilters extends RunnerTest{

    @When("^I enter car brand \"([^\"]*)\"$")
    public void carBrandFilter(String carBrand) {
        MainPage mainPage = new MainPage();
        mainPage.chooseCarBrand(carBrand);
    }

    @And("^I enter car model \"([^\"]*)\"$")
    public void carModel(String carModel) {
        MainPage mainPage = new MainPage();
        mainPage.clickModel(carModel);
    }

    @And("^I click search button")
    public void clickSearchButton() {
        MainPage mainPage = new MainPage();
        mainPage.clickSearchButton();

    }
    @Then("^I see in header \"([^\"]*)\"$")
    public void headerContains(String carBrand){
        ResultPage resultPage = new ResultPage();
        System.out.println(resultPage.headerText());
        Assert.assertTrue(resultPage.headerText().contains(carBrand));
    }
    @When("^I enter \"([^\"]*)\" to priceFrom field and \"([^\"]*)\" to priceTo field")
    public void enterPrice(String priceFrom, String priceTo){
        MainPage mainPage = new MainPage();
        mainPage.enterPriceToPriceField(priceFrom, priceTo);
    }
    @Then("^I see on Result page in price filter \"([^\"]*)\"$")
    public void getPriceFromPriceFilter(String priceFrom){
        ResultPage resultPage = new ResultPage();
        Assert.assertEquals(priceFrom,  resultPage.getTextFromPriceInputFrom());
    }
    @When("^I click extended search button")
    public void clickExtendedSearch(){
        MainPage mainPage = new MainPage();
        mainPage.clickExtendedSearchButton();
    }
    @And("^I choose checkbox \"([^\"]*)\"$")
    public void chooseCheckBoxCarType(String cartype){
        ExtendedSearchPage extendedSearchPage = new ExtendedSearchPage();
        extendedSearchPage.clickCheckboxes(cartype);
    }
    @And("^I click origin \"([^\"]*)\"$")
    public void clickOrigin(String origin){
        ExtendedSearchPage extendedSearchPage = new ExtendedSearchPage();
        extendedSearchPage.ckickOrigin(origin);
    }
    @And("^I click Show button")
    public  void clickShowButton(){
        ExtendedSearchPage extendedSearchPage = new ExtendedSearchPage();
        extendedSearchPage.clickShowButton();
    }

}
