Feature: Ebay

  Scenario: Scenario_01_Verify item added to cart is displayed in the cart
    Given I open the home page
    When User gets the title "Electronics, Cars, Fashion, Collectibles & More | eBay" of the page
    Then User search the following item
      | ItemToSearch |
      | bike         |
    Then User click the "Mountain Bike Shimano Full suspension Fat Tire 7 Speed Bicycle Black" item from the search result
    Then I add Item to the cart
    Then I verify the "Mountain Bike Shimano Full suspension Fat Tire 7 Speed Bicycle Black" item added to the cart

  Scenario: Scenario_02_Verify error messages when logging in without username or password
    Given I open the home page
    Then I mousehover on the "My Ebay" option and select "My Ebay summary"
    Then I select "Continue" Button
    Then I verify the error message







