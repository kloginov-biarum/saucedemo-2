import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class SideBar extends BasePage{

    @FindBy(className = "bm-menu-wrap")
    WebElement sideBarMenu;

    @FindBy(id = "react-burger-menu-btn")
    WebElement openSideBarButton;

    @FindBy(id = "inventory_sidebar_link")
    WebElement allItemsLink;

    @FindBy(id = "about_sidebar_link")
    WebElement aboutLink;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutLink;

    @FindBy(id = "reset_sidebar_link")
    WebElement resetAppStateLink;

    @FindBy(id = "react-burger-cross-btn")
    WebElement closeSideBarButton;

    public SideBar(WebDriver driver) {
       super(driver);
    }

    public boolean allItemsLinkIsDisplayed(){

        //WebDriverWait wait = new WebDriverWait();
       // wait.until(ExpectedConditions.visibilityOf(allItemsLink), Duration.ofSeconds(10));
        return allItemsLink.isDisplayed();
    }

    //3 links + close side bar
    public boolean aboutLinkIsDisplayed(){
        return aboutLink.isDisplayed();
    }

    public boolean logoutLinkIsDisplayed(){
        return logoutLink.isDisplayed();
    }

    public boolean resetAppLinkIsDisplayed(){
        return resetAppStateLink.isDisplayed();
    }

    public boolean closeSideBarButtonIsDisplayed(){
        return closeSideBarButton.isDisplayed();
    }

    public void openSideBar(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(openSideBarButton));
        openSideBarButton.click();
       // wait.until(ExpectedConditions.visibilityOf(sideBarMenu));
    }

    public void closeSideBar(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(allItemsLink));
      //  sleep(2000);
        closeSideBarButton.click();
    }


    public void sideBarHasHidden(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.attributeToBe(sideBarMenu, "aria-hidden", "true"));
    }


    public void clickOnResetAppState(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(resetAppStateLink));
        resetAppStateLink.click();
    }
}
