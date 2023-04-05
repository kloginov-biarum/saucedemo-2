import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class LoginTests extends BaseTest{
    @Test
    public void loginWithValidData() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        User validUser  = new User(validUserName,validPassword);
        loginPage.enterValueToUserName(validUser);
        loginPage.enterValueToPassword(validUser);
        loginPage.pushLoginButton();
        assertTrue(driver.getCurrentUrl().contains("inventory"));
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryContainerIsDisplayed());
    }

    @Test
    public void loginWithLockedOutUser() {
        LoginPage loginPage = new LoginPage(driver);
        User lockOutUser = new User(lockedOutUserName,validPassword);
        loginPage.enterValueToUserName(lockOutUser);
        loginPage.enterValueToPassword(lockOutUser);
        loginPage.pushLoginButton();
        loginPage.errorMessageTextIsCorrect("Sorry, this user has been locked out.");
    }

    @Test
    public void invalidUser(){
        LoginPage loginPage = new LoginPage(driver);
        User invalidUser = new User(invalidUserName, invalidUserPassword);
        loginPage.enterValueToUserName(invalidUser);
        loginPage.enterValueToPassword(invalidUser);
        loginPage.pushLoginButton();
        assertTrue(loginPage.getErrorMessageText()
                .contains("Username and password do not match any user in this service"));
    }





}
