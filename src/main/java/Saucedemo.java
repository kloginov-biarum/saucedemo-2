import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Saucedemo {
    ChromeDriver driver;
    String BASE_URL = "https://www.saucedemo.com/";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/ergrevegvrg/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--window-size=100,200");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(BASE_URL);
    }

    @Test
    public void loginWithValidData() throws InterruptedException {
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        System.out.println(driver.getCurrentUrl());
        assertTrue(driver.getCurrentUrl().contains("inventory"));
        WebElement inventoryContainer = driver.findElements(By.id("inventory_container")).get(0);
        assertTrue(inventoryContainer.isDisplayed());
    }

    @Test
    public void loginWithLockedOutUser(){
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("locked_out_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement errorMessage = driver.findElement(By.tagName("h3"));
        assertTrue(errorMessage.getText().contains("Sorry, this user has been locked out"));
    }


    @After
    public void tearDown(){
        driver.quit();
    }

}
