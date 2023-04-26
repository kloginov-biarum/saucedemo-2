import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutTest extends BaseTest{

    @Test
    public void checkTotalItem(){
        LoginPage loginPage = new LoginPage(driver);
        User validUser  = new User(validUserName,validPassword);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryContainerIsDisplayed());
        inventoryPage.clickOnBackpackAddToCart();
        inventoryPage.clickOnBikeAddToCart();
        inventoryPage.clickOnCartIcon();
        CartPage cartPage = new CartPage(driver);
        //item total from cart page
        double totalFromCart = cartPage.getTotalPriceOfItems();
        //checkout steps
        cartPage.clickOnCheckoutButton();
        CheckoutStepOne checkoutStepOne = new CheckoutStepOne(driver);
        checkoutStepOne.inputAllFields();
        checkoutStepOne.clickOnContinueButton();
        CheckoutStepTwo checkoutStepTwo = new CheckoutStepTwo(driver);
        //checkout-step-two
        //assert item total from cart page == item total from checkout-step-two
        assertEquals(totalFromCart,checkoutStepTwo.getTotal(),0);
        //assert
    }



}
