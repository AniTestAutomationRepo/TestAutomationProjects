package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Region page factory variables
    @FindBy(id="contact-seller-button")
    WebElement buttonSignInToMessage;

    @FindBy(id="input-reply-widget-form-message")
    WebElement textMessageSection;

    @FindBy(id="contact-seller-button")
    WebElement buttonSendMessage;

    @FindBy(id="reply-widget-success-modal__title")
    WebElement textMessageSent;

    @FindBy(css = "#MY_GUMTREE_MENU_BUTTON>span.my-gumtree-menu-button__text")
    List<WebElement> buttonMenu;
    //end region

    public boolean verifyGumTreeHomePageTitle(String pageTitle) {
        if(driver.getTitle().equals(pageTitle))
            return  true;
        return false;
    }

    public void clickSignInToMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(buttonSignInToMessage));
        buttonSignInToMessage.click();
    }

    public Boolean verifyUserSignedInSuccessfully(String buyerName) {
//        List <WebElement> options = driver.findElements(By.cssSelector("#MY_GUMTREE_MENU_BUTTON>span.my-gumtree-menu-button__text"));
        for (WebElement option : buttonMenu) {
            if (buyerName.equals(option.getText())) {
                return true;
            }
        }
        return false;
    }

    public void enterMessageToSend(String messageToSend) {
        textMessageSection.click();
        textMessageSection.clear();
        textMessageSection.sendKeys(messageToSend);
    }

    public void clickSendMessageButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(buttonSendMessage));
        buttonSendMessage.click();
    }

    public boolean verifyMessageSentDisplayed(String messageSent) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(textMessageSent));
        if(textMessageSent.getText().equalsIgnoreCase(messageSent))
            return true;
        return false;
    }

}
