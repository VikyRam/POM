package parallel;

import com.factory.DriverFactory;
import com.pages.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class HomePageSteps {
    private  static  String title;
    private HomePage homepage =new HomePage(DriverFactory.getDriver());


    @Given("I open the home page")
    public void i_Open_The_Home_Page() {
    DriverFactory.getDriver().get("https://www.ebay.com.au/");
    }


    @When("User gets the title {string} of the page")
    public void userGetsTheTitleOfThePage(String expectedTitleName) {
        title= homepage.getHomePageTitle();
        System.out.println("Home Page Title is this"+ title);
        Assert.assertTrue(title.contains(expectedTitleName));
    }

    @Then("User search the following item")
    public void userSearchTheFollowingItem(DataTable itemtosearch) throws Throwable {

        for (Map<Object, Object> data : itemtosearch.asMaps(String.class, String.class)) {
            homepage.enterValueinSearchBar(data.get("ItemToSearch"));


        }
    }

    @Then("User click the {string} item from the search result")
    public void userClickTheItemFromTheSearchResult(String itemnotoclick) {
        homepage.clickOnTheSpecificitemFromList(itemnotoclick);


    }

    @Then("I add Item to the cart")
    public void iAddItemToTheCart() {
        homepage.addItemstoCart();

    }

    @Then("I mousehover on the {string} option and select {string}")
    public void iMousehoverOnTheOptionAndSelect(String arg0, String arg1) {
        homepage.mouseHoverAndSelectTheOption();

    }

    @Then("I select {string} Button")
    public void iSelectButton(String arg0)
    {
        homepage.clickContinue();
    }

    @Then("I verify the error message")
    public void iVerifyTheErrorMessage() {
        homepage.verifyAlert();
    }
}
