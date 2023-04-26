import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LoginPage extends BasePage{
    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(tagName = "h3")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterValueToUserName(User user){
        enterTextToElement(user.getUsername(), userName);
    }

    public void enterValueToPassword(User user){
        enterTextToElement(user.getPassword(),password);
    }

    public void pushLoginButton(){
        clickOnTheElement(loginButton);
    }

    public void successLogin(User user){
        enterTextToElement(user.getUsername(), userName);
        enterTextToElement(user.getPassword(),password);
        clickOnTheElement(loginButton);
    }

    public void errorMessageTextIsCorrect(String expectedText){
        assertTrue(errorMessage.getText().contains(expectedText));
    }

    public String getErrorMessageText(){
        return getTextOfElement(errorMessage);
    }

}
