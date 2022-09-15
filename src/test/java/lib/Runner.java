package lib;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = {"StepDefinition"}, publish = true)
public class Runner {

       public static WebDriver driver;
        Scenario scenario;

        @Before("@selenium")
        public void launchBrowser(Scenario scenario) {
            driver = new ChromeDriver();
            this.scenario = scenario;
            System.out.println("Executing scenario " + scenario.getName());
        }

        @After("@selenium")
        public void killBrowser() {
            if (scenario.isFailed()) {
                System.out.println("Scenario failed");
            }
            driver.close();
            driver.quit();
        }

}

