package pages;

import utils.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static utils.DriverInIt.driver;

public class MainPage {
    private final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(MainPage.class);
    private final By usedCarDropdown = By.id("brandTooltipBrandAutocomplete-brand");
    private final By usedCarInput = By.id("brandTooltipBrandAutocompleteInput-brand");
    private final By newCarDropdown = By.name("marka_id");
    private final By searchButton = By.xpath("//*[@id='mainSearchForm']/div[@class='footer-form']/button");
    private final By priceFieldFrom = By.id("priceFrom");
    private final By priceFieldTo = By.id("priceTo");
    private final By extendedSeachButton = By.xpath("//*[@id='mainSearchForm']/div[@class='footer-form']/a");
    private final By newCarsRadioButton = By.xpath("//*[@id='mainSearchForm']/div[@class='nav']/label[@for='naRadioType']");
    private final By autocompletedMarkField = By.xpath("//*[@id='brandTooltipBrandAutocomplete-brand']/ul/li/a");
    private final By model = By.id("brandTooltipBrandAutocomplete-model");
    private final By modelInput = By.id("brandTooltipBrandAutocompleteInput-model");
    private final By modelAutocompleted = By.xpath("//*[@id='brandTooltipBrandAutocomplete-model']/ul/li/a");
    private final By region = By.id("regionAutocompleteAutocomplete-1");
    private final By regionInput = By.id("regionAutocompleteAutocompleteInput-1");
    private final By regionAutocomplete = By.xpath("//*[@id='regionAutocompleteAutocomplete-1']/ul/li/a");
    private final By loginLocator = By.linkText("Вход в кабинет");
    private final By regionLocator = By.xpath("//*[@id='regionCenters']");
    private final By allForAutoDropdown = By.id("AllForAuto");

    public void clickExtendedSearchButton() {
        driver.findElement(extendedSeachButton)
                .click();

    }

    public void clickOnElementByLinkText(String linktext) {
        driver.findElement(By.linkText(linktext))
                .click();

    }

    public void chooseCarBrand(String carBrand) {

        driver.findElement(usedCarDropdown).click();
        log.info("Click on car brand dropdown");
        driver.findElement(usedCarInput).sendKeys(carBrand);
        Helpers utils = new Helpers(driver);
        utils.waitTimeout(autocompletedMarkField);
        log.info("input data to car brand dropdown");
        driver.findElement(autocompletedMarkField).click();
        log.info("car brand was chosen");
    }


    public void clickModel(String modelInp) {
        Helpers utils = new Helpers(driver);
        driver.findElement(model)
                .click();
        driver.findElement(modelInput)
                .sendKeys(modelInp);
        utils.waitTimeout(modelAutocompleted);
        driver.findElement(modelAutocompleted)
                .click();
        log.info("Car model was chosen");
    }


    public void clickRegion(String regionName) {
        driver.findElement(region).click();
        driver.findElement(regionInput).sendKeys(regionName);
        driver.findElement(regionAutocomplete).click();
        log.info("Region was chosen");
    }

    public void selectRegion(String regionName) {
        Select region = new Select(driver.findElement(regionLocator));
        region.selectByVisibleText(regionName);
    }


    public void selectYearFrom(String yearFromInput, String yearToInput) {
        Select yearFrom = new Select(driver.findElement(By.id("yearFrom")));
        log.info("Year from dropdown was found");
        Select yearTo = new Select(driver.findElement(By.id("yearTo")));
        log.info("Year to dropdown was found");
        yearFrom.selectByVisibleText(yearFromInput);
        log.info("Year from was selected");
        yearTo.selectByVisibleText(yearToInput);
        log.info("Year to was selected");
    }


    public void clickSearchButton() {
        Helpers utils = new Helpers(driver);
        utils.waitTimeout(searchButton);
        driver.findElement(searchButton)
                .click();
        log.info("Click on search button was perfomed");
    }


    public void enterPriceToPriceField(String priceTo, String priceFrom) {
        driver.findElement(priceFieldFrom).sendKeys(priceTo);
        log.info("Data to price field was inputted");
        driver.findElement(priceFieldTo).sendKeys(priceFrom);
        log.info("Data to price field was inputted");
    }


    public void clickLoginButton() {
        driver.findElement(loginLocator).click();
        log.info("Click on login button was perfomed");
    }

    public void clickOnradioButton() {
        driver.findElement(newCarsRadioButton).click();


    }

    public void clickAllForAutoDropdown() {
        driver.findElement(allForAutoDropdown).click();
    }

}