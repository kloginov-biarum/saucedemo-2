import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class InventoryTests extends BaseTest{

    @Test
    public void visibilityOfProductCards(){
        LoginPage loginPage = new LoginPage(driver);
        User validUser  = new User(validUserName,validPassword);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.allProductCardsAreVisible();

    }

    //


}
