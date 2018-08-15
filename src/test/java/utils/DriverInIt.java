package utils;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;

public class DriverInIt {
    public static WebDriver driver;

    public DriverInIt()

    {
    }


    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", ConstantVariables.driverPathChrome);
                driver = new ChromeDriver();
            } else if (browser.equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", ConstantVariables.driverPathFirefox);
                driver = new FirefoxDriver();

            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
    public static void closeWebBrowser(){
        if (null != driver){
            driver.quit();
        }
        driver = null;
    }
public static void openPage(String url){
        driver.get(url);
}

}

