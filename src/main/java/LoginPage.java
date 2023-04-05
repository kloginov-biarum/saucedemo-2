import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        userName.sendKeys(user.getUsername());
    }

    public void enterValueToPassword(User user){
        password.sendKeys(user.getPassword());
    }

    public void pushLoginButton(){
        loginButton.click();
    }

    public void successLogin(User user){
        userName.sendKeys(user.getUsername());
        password.sendKeys(user.getPassword());
        loginButton.click();
    }

    public void errorMessageTextIsCorrect(String expectedText){
        assertTrue(errorMessage.getText().contains(expectedText));
    }

    public String getErrorMessageText(){
        return errorMessage.getText();
    }

}
