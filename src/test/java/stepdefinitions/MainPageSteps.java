package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.MainPage;

public class MainPageSteps {
    private MainPage mainPage;

    @Given("I am on the main page")
    public void iAmOnMainPage() {
        getMainPage();
    }

    @When("I click the Signup-Login button")
    public void iClickTheSignupLoginButton() {
        getMainPage().clickLoginLink();
    }

    @When("I click the 'Delete account' button")
    public void iClickDeleteAccount(){
        getMainPage().clickDeleteAccountLink();
    }

    @Then("a caption saying 'Logged in as username' should be visible")
    public void loggedInAsUsernameShouldBeVisible() {
        Assert.assertTrue(getMainPage().isLoggedInAsUsernameVisible(), "Logged in as username is not visible");
    }

    private MainPage getMainPage() {
        if (mainPage == null) {
            mainPage = new MainPage(Hooks.driver).get();
        }
        return mainPage;
    }
}
