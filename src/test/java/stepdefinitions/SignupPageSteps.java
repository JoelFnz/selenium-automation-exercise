package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.UserInfo;
import org.testng.Assert;
import pages.SignupPage;

public class SignupPageSteps {
    private SignupPage signupPage;

    @When("I submit the Enter Account Information form with {userInfo} user data")
    public void iFillEnterAccountInfoForm(UserInfo user) {
        getSignupPage().getAccountForm().typePassword(user.getPassword());
        getSignupPage().getAccountForm().selectGenderTitle(user.getSignupInfo().getGenderTitle());
        getSignupPage().getAccountForm().selectDateOfBirth(user.getSignupInfo().getDateOfBirth());
        getSignupPage().getAccountForm().clickNewsletterChb();
        getSignupPage().getAccountForm().clickSpecialOffersChb();

        getSignupPage().getAddressForm().typeFirstName(user.getSignupInfo().getFirstName());
        getSignupPage().getAddressForm().typeLastName(user.getSignupInfo().getLastName());
        getSignupPage().getAddressForm().typeAddress(user.getSignupInfo().getAddress());
        getSignupPage().getAddressForm().typeCompany(user.getSignupInfo().getCompany());
        getSignupPage().getAddressForm().typeCity(user.getSignupInfo().getCity());
        getSignupPage().getAddressForm().typeState(user.getSignupInfo().getState());
        getSignupPage().getAddressForm().typeMobileNumber(user.getSignupInfo().getPhoneNumber());
        getSignupPage().getAddressForm().typeZipcode(user.getSignupInfo().getZipcode());
        getSignupPage().getAddressForm().selectCountry(user.getSignupInfo().getCountry());

        getSignupPage().clickCreateAccountBtn();
    }

    @Then("the Enter Account Information form should be visible")
    public void theEnterAccountInformationFormShouldBeVisible() {
        Assert.assertTrue(getSignupPage().getAccountForm().isFormVisible(), "Account Information form is not visible");
        Assert.assertTrue(getSignupPage().getAddressForm().isFormVisible(), "Address Information form is not visible");
    }

    private SignupPage getSignupPage() {
        if (signupPage == null) {
            signupPage = new SignupPage(Hooks.driver).get();
        }
        return signupPage;
    }
}
