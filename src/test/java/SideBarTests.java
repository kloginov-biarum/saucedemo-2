import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SideBarTests extends BaseTest {
   @Test
    public void linksAreDisplayed(){
       LoginPage loginPage = new LoginPage(driver);
       User validUser  = new User(validUserName,validPassword);
       loginPage.successLogin(validUser);
       SideBar sideBar = new SideBar(driver);
       sideBar.openSideBar();
       assertTrue(sideBar.allItemsLinkIsDisplayed());
       assertTrue(sideBar.aboutLinkIsDisplayed());
       assertTrue(sideBar.logoutLinkIsDisplayed());
       assertTrue(sideBar.resetAppLinkIsDisplayed());
       assertTrue(sideBar.closeSideBarButtonIsDisplayed());
    }
    @Test
    public void closeSideBar() throws InterruptedException {
       LoginPage loginPage = new LoginPage(driver);
       User validUser  = new User(validUserName,validPassword);
       loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryContainerIsDisplayed());
       SideBar sideBar = new SideBar(driver);
       sideBar.openSideBar();
       sideBar.closeSideBar();
        sideBar.sideBarHasHidden();
        sleep(1000);
        assertFalse(sideBar.allItemsLinkIsDisplayed());
        assertFalse(sideBar.aboutLinkIsDisplayed());
        assertFalse(sideBar.logoutLinkIsDisplayed());
        assertFalse(sideBar.resetAppLinkIsDisplayed());


    }



}
