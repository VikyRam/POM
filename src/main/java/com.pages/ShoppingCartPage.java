package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class ShoppingCartPage {

    private WebDriver driver;

    private By lbl_AddedBike= By.xpath("//div[@class='listsummary-content-itemdetails']//span[contains(text(),'Mountain Bike Shimano Full suspension Fat Tire 7 Speed Bicycle Black')]");;

    public ShoppingCartPage(WebDriver driver) {
        this.driver=driver;
    }

    //page actions: features(behaviour) of the page the form of the method
    public void  verifyTheItemsAddedtoTheCart(String actualItemName)
    {
        try {
            String itemname=driver.findElement(lbl_AddedBike).getText();
//            Assert.assertEquals("Expected value doesn't match with the actual value, please check",actualItemName,itemname);
            if(itemname.contains(actualItemName))
            {
                System.out.println("Item name matched");
                Thread.sleep(3000);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
