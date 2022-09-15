package steps.common;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lib.Runner;

public class BrowserSteps extends Runner {

    public BrowserSteps() {

    }


    @Given("I open {string} browser")
    public void i_open_browser(String browsername) {
        System.out.println(browsername+"launching chrome driver");
        driver.get("https://" + "www.ebay.com.au/");
    }


//    @Given("^I open \"([^\"]*)\" browser$")
//    public void iOpenUsernameBrowser(String browsername) {
//        System.out.println(browsername+"launching chrome driver");
//    }
}
