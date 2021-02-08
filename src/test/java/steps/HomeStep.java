package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import steps.base.BaseTest;
import support.ConfigHelper;
import testdata.HomePageTestData;

public class HomeStep extends BaseTest {
    private HomePage homepage;

    public HomeStep() {
        homepage = new HomePage(driver);
    }

    @Given("I am on the seller ad page")
    public void iAmOnTheSellerAdPage() {
        boolean check = homepage.verifyGumTreeHomePageTitle(HomePageTestData.PAGETITLE);
        if(check)
            System.out.println("Logg");
    }

    @When("I click sign in to message")
    public void iClickSignInToMessage() {
        homepage.clickSignInToMessage();
    }

    @When("I enter message in the message section")
    public void iEnterMessageInTheMessageSection() {
        String messageToSend = HomePageTestData.MESSAGETOSEND;
        homepage.enterMessageToSend(messageToSend);
        homepage.clickSendMessageButton();
    }

    @Then("I verify your message has been sent displayed")
    public void iVerifyYourMessageHasBeenSentDisplayed() {
        String messageSent = HomePageTestData.MESSAGESENT;
        boolean check = homepage.verifyMessageSentDisplayed(messageSent);
        Assert.assertTrue(check,"Not displayed the message sent message");
    }

    @Then("I verify buyer signed in")
    public void iVerifyBuyerSignedIn() {
        boolean check = homepage.verifyUserSignedInSuccessfully(ConfigHelper.getConfigProperties("buyer_username"));
        Assert.assertTrue(check, "Buyer not signed in successfully");
    }

}
