package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;

public class DriverInIt {
    public static WebDriver driver = null;

    public DriverInIt() {
    }

    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/browsers/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equals("ff")) {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/browsers/geckodriver.exe");
                driver = new FirefoxDriver();

            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
}

