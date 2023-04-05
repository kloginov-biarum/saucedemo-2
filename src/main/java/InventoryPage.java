import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class InventoryPage extends BasePage{
    @FindBy(xpath = "(//div[@id='inventory_container'])[1]")
    private WebElement inventoryContainer;

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<WebElement> productCards;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean inventoryContainerIsDisplayed(){
        return inventoryContainer.isDisplayed();
    }

    public void allProductCardsAreVisible(){
        //check all cards are displayed
        for (WebElement card:
             productCards) {
            assertTrue(card.isDisplayed());
        }
    }

}
