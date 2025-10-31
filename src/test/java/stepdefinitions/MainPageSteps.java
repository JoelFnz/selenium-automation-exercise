package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.MainPage;

public class MainPageSteps {
    private MainPage mainPage;

    @When("I click the Signup-Login button")
    public void iClickTheSignupLoginButton() {
        getMainPage().clickLoginLink();
    }

    @When("I click the 'Delete account' button")
    public void iClickDeleteAccount(){
        getMainPage().clickDeleteAccountLink();
    }

    @When("I click the Logout button")
    public void iClickTheLogoutButton() {
        getMainPage().clickLogoutLink();
    }

    @Then("a caption saying 'Logged in as username' should be visible")
    public void loggedInAsUsernameShouldBeVisible() {
        Assert.assertTrue(getMainPage().isLoggedInAsUsernameVisible(), "Logged in as username is not visible");
    }

    @Then("the Logout button should be displayed")
    public void theLogoutButtonShouldBeDisplayed() {
        Assert.assertTrue(getMainPage().isLogoutLinkDisplayed(), "Logout link is not displayed");
    }

    private MainPage getMainPage() {
        if (mainPage == null) {
            mainPage = new MainPage(Hooks.driver).get();
        }
        return mainPage;
    }
}
