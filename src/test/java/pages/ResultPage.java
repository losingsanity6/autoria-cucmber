package pages;

import org.apache.log4j.Logger;
import utils.Helpers;
import org.openqa.selenium.By;

import static utils.DriverInIt.driver;

public class ResultPage {

    private final By h1 = By.xpath("//*[@id='headerPage']/h1/span[@data-name]");
    private final By dropdownCar = By.xpath("//*[@id='autoCmplt']/label");
    private final By priceInputFrom = By.name("price.USD.gte");
    private final By priceInputTo = By.name("price.USD.lte");
    private final By noAdsMessage = By.id("emptyResultsNotFoundBlock");
    private final By newCarsMessage = By.xpath("//*[@id='searchResult']/div[@class='warning middle']/h2");
    private final By header = By.xpath("//*[@id=\"headerPage\"]/h1");
    private final Logger log = Logger.getLogger(ResultPage.class);

    public String getTitle() {
        return driver.getTitle();
    }


    public String getH1Text() {
        Helpers utils = new Helpers();
        utils.waitTimeout(h1);
        log.info("Obtaining text from h1");
        return driver.findElement(h1).getAttribute("innerHTML");
    }


    public String findCarDropdown() {
        return driver.findElement(dropdownCar).getAttribute("data-text");
    }


    public String getTextFromPriceInputFrom() {
        Helpers utils = new Helpers();
        utils.ScrollWindow(priceInputFrom);
        log.info("Obraining text from price from filter");
        return driver.findElement(priceInputFrom).getAttribute("value");
    }


    public String getInputFromPriceFieldTo() {
        Helpers utils = new Helpers();
        utils.ScrollWindow(priceInputTo);
        log.info("Obtaining text from price To filter");
        return driver.findElement(priceInputTo).getAttribute("value");
    }


    public String getTextFromNoResultsMessage() {
        log.info("Obtaining text from no results message");
        return driver.findElement(noAdsMessage).getText();
    }

    public String getTextFromNewCarsMessge() {
        return driver.findElement(newCarsMessage).getText();
    }

    public String headerText() {
        log.info("Obtaining text from header");
        return driver.findElement(header).getAttribute("innerHTML");
    }
}
