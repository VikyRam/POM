package com.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    //locators
    private By txt_searchbar= By.xpath("//input[@aria-label='Search for anything']");
    private By btn_search= By.xpath("//input[@type='submit']");
    private By lst_bike=By.xpath("//li[contains(.,\"Speed Bicycle\")]");
    private By lbl_firstBike=By.xpath("//img[@alt='NORFLEX 26\" Mountain Bike Shimano Full suspension Fat Tire 7 Speed Bicycle Black']");

    private By btn_addToCart=By.xpath("//a[@id='isCartBtn_btn']");
    private By btn_NoThanks=By.xpath("//button[contains(text(),'No thanks')]");

    private By lbl_MyEbay=By.xpath("//a[@title='My eBay']");

    private By lbl_MyEbaySummary=By.xpath("//a[contains(text(),' My eBay Summary')]");

    private By btn_Continue=By.xpath("//button[@id='signin-continue-btn']");

    private By lbl_AlertText=By.xpath("//p[@id='errormsg']");

    //String verification
    private String lbl_Alert="Oops, that's not a match.";




    //constructor of the page class
    public HomePage(WebDriver driver)
    {
        this.driver=driver;

    }

    //page actions: features(behaviour) of the page the form of the method
    public String getHomePageTitle(){
        return driver.getTitle();
    }

    public boolean searchButtonIsDisplayed()
    {
        return driver.findElement(btn_search).isDisplayed();
    }

    public void enterValueinSearchBar(Object itemToSearch)
    {

        driver.findElement(txt_searchbar).sendKeys((String) itemToSearch);
        waitforElement(btn_search);
        driver.findElement(btn_search).click();

    }

    public void addItemstoCart()
    {
        switchToNewTab();
        try {
            driver.findElement(btn_addToCart).click();
            waitforElement(btn_NoThanks);
            driver.findElement(btn_NoThanks).click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void waitforElement(By bylocator){
        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(bylocator));
        element.isDisplayed();
    }

    public void clickOnTheSpecificitemFromList(String itemnotoclick)
    {
        List<WebElement> allInputElements = driver.findElements(lst_bike);
        for (WebElement productToSelect:allInputElements)
        {
            if(productToSelect.getText().contains(itemnotoclick))
            {

                try {
                    driver.findElement(lbl_firstBike).click();
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public void clickContinue()
    {
        selectElement(btn_Continue);
        try {
            selectElement(btn_Continue);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void verifyAlert()
    {
        String actualalerttext=driver.findElement(lbl_AlertText).getText();
        Assert.assertEquals("Alert not displayed",lbl_Alert,actualalerttext);
    }

    public void switchToNewTab()
    {
        for (String handle1 : driver.getWindowHandles()) {
            System.out.println(handle1);
            driver.switchTo().window(handle1);
        }
    }

    public void mouseHoverAndSelect(By elementToHover, By elementToClick)
    {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(elementToHover)).perform();
        waitforElement(elementToClick);
        driver.findElement(elementToClick).click();
    }


    public void mouseHoverAndSelectTheOption()
    {
        try {
            mouseHoverAndSelect(lbl_MyEbay,lbl_MyEbaySummary);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public  void selectElement(By elementXpath)
    {
        driver.findElement(elementXpath).click();
    }

}
