package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    //Region page factory variables
    @FindBy(id="input-gumtree-sign-in-email-field")
    WebElement textboxEmail;

    @FindBy(id="input-gumtree-sign-in-password-field")
    WebElement textboxPassword;

    @FindBy(css="#react-root > div > div.modal.modal--backdrop > div > div > div.sign-in-and-register-form__body > div.sign-in-and-register-form__gumtree > form > button")
    WebElement buttonSignIn;
    //end region

    public void signInToGumTree(String email,String password) {
        textboxEmail.click();
        textboxEmail.clear();
        textboxEmail.sendKeys(email);
        textboxPassword.click();
        textboxPassword.clear();
        textboxPassword.sendKeys(password);
        buttonSignIn.click();
    }

}
