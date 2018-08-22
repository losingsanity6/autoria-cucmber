package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import utils.Helpers;

import java.util.List;
import static utils.DriverInIt.driver;

public class ExtendedSearchPage {
   // private WebDriver driver;

    private final By carCheckbox = By.xpath("//*[@id='bodies']/ul/li[@class='item-checkbox']/label/span[@class='name']");
    private final By originCheckbox = By.xpath("//*[@class='result-section mhide']//ul/li[@class='rubric']/label");
    private final By showButton = By.xpath("//*[@id='results']/div/a[@class='button large indent_fes']");

    private final Logger log = Logger.getLogger(ExtendedSearchPage.class);
   // Helpers utils = new Helpers(driver);




    public void clickShowButton() {

        driver.findElement(showButton).click();
        log.info("Click on show button was perfomed");


    }

    public void clickCheckboxes(String carType) {
        Helpers helpers = new Helpers();
        helpers.methodToChooseCheckboxes(carCheckbox, carType);
        log.info("click on car type checkbox was perfomed");



    }

    public void ckickOrigin(String country) {
        Helpers helpers = new Helpers();
        helpers.ScrollWindow(originCheckbox);
        helpers.methodToChooseCheckboxes(originCheckbox, country);
        log.info("click on country check box was perfomed");

    }


}