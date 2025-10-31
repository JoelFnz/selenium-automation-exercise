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

    @When("I submit the login form with {userInfo} user data")
    public void iSubmitTheLoginFormWithRegisteredUserData(UserInfo user) {
        getLoginPage().typeLoginEmail(user.getEmail());
        getLoginPage().typeLoginPassword(user.getPassword());
        getLoginPage().submitLogin();
    }

    @Then("the New User Signup! form should be visible")
    public void newUserSignupFormShouldBeVisible() {
        Assert.assertTrue(getLoginPage().isNewUserSignupFormDisplayed(), "New User Signup Form is not visible");
    }

    @Then("an error message should appear")
    public void errorMessageShouldAppear() {
        Assert.assertTrue(getLoginPage().isErrorMessageDisplayed(), "Error message is not displayed");
    }

    @Then("the Login to your account form should be visible")
    public void theLoginToYourAccountFormShouldBeVisible() {
        Assert.assertTrue(getLoginPage().isLoginFormDisplayed(), "Login Form is not displayed");
    }

    @Then("I should be redirected to the signup-login page")
    public void iShouldBeRedirectedToTheSignupLoginPage() {
        Assert.assertTrue(getLoginPage().isLoginFormDisplayed(), "Login form is not displayed");
    }

    private LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(Hooks.getDriver()).get();
        }
        return loginPage;
    }
}
