package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.UserInfo;
import org.testng.Assert;
import pages.LoginPage;

public class LoginPageSteps {
    private LoginPage loginPage;

    @When("I submit the New User Signup! form with {userInfo} user data")
    public void iSubmitTheNewUserSignupFormWithUnregisteredUserData(UserInfo user) {
        getLoginPage().typeSignupName(user.getUsername());
        getLoginPage().typeSignupEmail(user.getEmail());
        getLoginPage().submitSignup();
    }

    @Then("the New User Signup! form should be visible")
    public void newUserSignupFormShouldBeVisible() {
        Assert.assertTrue(getLoginPage().isNewUserSignupFormDisplayed(), "New User Signup Form is not visible");
    }

    @Then("an error message should appear")
    public void errorMessageShouldAppear() {
        Assert.assertTrue(getLoginPage().isErrorMessageDisplayed(), "Error message is not displayed");
        boolean isCorrectError = getLoginPage().getErrorMessageText().toLowerCase()
                                    .contains("email address already exist");
        Assert.assertTrue(isCorrectError, "Error message doesn't contains the expected error");
    }

    private LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(Hooks.getDriver()).get();
        }
        return loginPage;
    }
}
