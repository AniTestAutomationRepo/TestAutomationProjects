package steps;

import cucumber.api.java.en.When;
import pages.SignInPage;
import steps.base.BaseTest;
import support.ConfigHelper;

public class SignInStep extends BaseTest {
    private SignInPage signInPage;

    public SignInStep() {
        signInPage = new SignInPage(driver);
    }

    @When("I sign in to gumtree")
    public void iSignInToGumTree() {
        String buyerEmail = ConfigHelper.getConfigProperties("buyer_email");
        String buyerPassword = ConfigHelper.getConfigProperties("buyer_password");
        signInPage.signInToGumTree(buyerEmail,buyerPassword);
    }

}
