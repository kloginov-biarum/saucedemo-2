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

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpackAddToCrtButton;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement bikeAddToCartButton;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement tShortAddtoCartButton;
    @FindBy(id = "shopping_cart_container")
    private WebElement cartIcon;

    @FindBy(xpath = "(//div[@class = 'inventory_item_price'])[1]")
    private WebElement backpackCost;
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

    public void clickOnBackpackAddToCart(){
        backpackAddToCrtButton.click();
    }

    public void clickOnBikeAddToCart(){
        bikeAddToCartButton.click();
    }

    public void clickOnTShortAddToCart(){
        tShortAddtoCartButton.click();
    }
    public void clickOnCartIcon(){
        cartIcon.click();
    }

    public String getBackpackCost(){
       return backpackCost.getText();
    }

}
