package br.com.neon.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class driverFactory {

    private static WebDriver driver;

    private driverFactory() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (proparties.browsers) {
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", "C:\\Developer\\Drivers\\chromedriver\\chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    System.setProperty("webdriver.chrome.driver", "C:\\drivers\\geckodriver\\geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                case INTERNETEXPLORER:
                    System.setProperty("webdriver.ie.driver", "C:\\drivers\\IEDriverServer\\IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                    break;
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
