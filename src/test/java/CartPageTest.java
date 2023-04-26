import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartPageTest extends BaseTest{

    @Test
    public void successAdding1Item(){
        LoginPage loginPage = new LoginPage(driver);
        User validUser  = new User(validUserName,validPassword);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryContainerIsDisplayed());
        String costFromInventory = inventoryPage.getBackpackCost();
        inventoryPage.clickOnBackpackAddToCart();
        inventoryPage.clickOnCartIcon();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.firstItemIsDisplayed());
        assertEquals(1, cartPage.getItemsQuantity());
        assertEquals(costFromInventory, cartPage.getPriceOfFirstItem());

        //assert cost chec

    }

    //add 3 items
    public void successAdding3Items(){
        LoginPage loginPage = new LoginPage(driver);
        User validUser  = new User(validUserName,validPassword);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryContainerIsDisplayed());
        inventoryPage.clickOnBackpackAddToCart();
        //+ 2 items
        inventoryPage.clickOnBikeAddToCart();
        inventoryPage.clickOnTShortAddToCart();
        inventoryPage.clickOnCartIcon();
        CartPage cartPage = new CartPage(driver);
        //assert 3 items are displayed
        //assert items colletion has size 3
        assertEquals(3, cartPage.getItemsQuantity());
        assertTrue(cartPage.allItemsAreDisplayed());
    }

    //Empty cart
    public void emptyCart(){
        LoginPage loginPage = new LoginPage(driver);
        User validUser  = new User(validUserName,validPassword);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnCartIcon();
        CartPage cartPage = new CartPage(driver);
        //assert empty cart
        assertTrue(cartPage.cartIsEmpty());
    }







}
