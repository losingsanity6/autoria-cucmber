package pages;

import org.openqa.selenium.By;
import utils.DriverInIt;

public class LoggedInPage extends DriverInIt {

    private final By loggedInUserLocator = By.xpath("//*[@id='headerLinkToMyMenu']");


    public String getTextFromLoggedUser() {
        return driver.findElement(loggedInUserLocator).getAttribute("innerHTML");
    }
    // public String getCurrentUrl(){return getCurrentUrl(); }
}
