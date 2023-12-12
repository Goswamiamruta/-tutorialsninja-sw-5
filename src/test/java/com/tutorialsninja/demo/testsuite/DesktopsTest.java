package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.DesktopsPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class DesktopsTest extends BaseTest {
    DesktopsPage desktopsPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        desktopsPage = new DesktopsPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductArrangeInAlphabeticalOrder() {
        //1.1 Mouse hover on Desktops Tab. and click
        desktopsPage.mouseHoverOnDesktopLinkAndClick();
        //1.2 Click on “Show All Desktops”
        desktopsPage.clickOnShowAllDesktops();
        //1.3 Select Sort By position "Name: Z to A"
        desktopsPage.selectPositionByZtoA();
        //1.4 Verify the Product will arrange in Descending order.
        String expectedErrorMessage = "Product will arrange Descending order";
        String actualErrorMessage = desktopsPage.getAllProductNameText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, " ProductDescendingOrder");

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully(String product, String qty, String successMessage, String productName, String model, String total) {
        //2.1 Mouse hover on Currency Dropdown and click
        desktopsPage.MouseHoverOnCurrencyDropdownAndClick();
        // 2.2 Mouse hover on £Pound Sterling and click
        desktopsPage.MouseHoverOnCurrencyDropdownAndClick();
        //2.3 Mouse hover on Desktops Tab.
        desktopsPage.mouseHoverOnDesktopLinkAndClick();
        //2.4 Click on “Show All Desktops”
        desktopsPage.clickOnShowAllDesktops();
        //2.5 Select Sort By position "Name: A to Z"
        desktopsPage.selectPositionByAtoZ();
        //2.6 Select product <product>
        desktopsPage.clickOnShowAllDesktops();
        //2.7 Enter Qty <qty> using Select class.
        desktopsPage.enterQuantity();
        //2.8 Click on “Add to Cart” button
       desktopsPage.clickOnAddToCart();
        //2.9 Verify the Message <successMessage>
        String expectedErrorMessage1 = "successMessage";
        String actualErrorMessage1 = desktopsPage.getSuccessText();
        Assert.assertEquals(expectedErrorMessage1, actualErrorMessage1, " successMessage");

        //2.10 Click on link “shopping cart” display into success message
        desktopsPage.clickOnShoppingCart1();
        //2.11 Verify the text "Shopping Cart"
        String expectedErrorMessage2 = "Shopping Cart";
        String actualErrorMessage2 = desktopsPage.clickOnShoppingCart();
        Assert.assertEquals(expectedErrorMessage2, actualErrorMessage2, " Shopping Cart");

        //2.12 Verify the Product name <productName>
        String expectedErrorMessage3 = "Product name";
        String actualErrorMessage3 = desktopsPage.verifyProductName();
        Assert.assertEquals(expectedErrorMessage3, actualErrorMessage3, " Product name");


        //2.13 Verify the Model <model>
        String expectedErrorMessage4 = "model";
        String actualErrorMessage4 = desktopsPage.verifyModel();
        Assert.assertEquals(expectedErrorMessage4, actualErrorMessage4, " Model");


        //2.14 Verify the Total <total>
        String expectedErrorMessage5 = "total";
        String actualErrorMessage5 = desktopsPage.verifyTotal();
        Assert.assertEquals(expectedErrorMessage5, actualErrorMessage5, " Total");


    }
}