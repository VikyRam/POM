package parallel;

import com.factory.DriverFactory;
import com.pages.HomePage;
import com.pages.ShoppingCartPage;
import io.cucumber.java.en.Then;

public class ShoppinhCartPageSteps {

    private ShoppingCartPage shoppingcartpage =new ShoppingCartPage(DriverFactory.getDriver());


    @Then("I verify the {string} item added to the cart")
    public void iVerifyTheItemAddedToTheCart(String itemNameToVerify) {
        shoppingcartpage.verifyTheItemsAddedtoTheCart(itemNameToVerify);
    }


}

