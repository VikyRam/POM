package com.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver init_driver(String browser) {
        System.out.println(browser + "launching chrome driver");

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());

        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            ;
            tlDriver.set(new FirefoxDriver());
        } else {
            System.out.println("Please pass the correct browser vale" + browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }


    /*
    This is used to get the driver with Threadlocal
    @return
     */
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
