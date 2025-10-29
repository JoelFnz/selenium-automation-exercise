package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ResultMessagePage;

public class ResultMessagePageSteps {
    private ResultMessagePage resultMessagePage;

    @Then("a message saying {string} should appear")
    public void successfulRegisterMessageShouldAppear(String message) {
        String resultMessage = getResultMessagePage().getResultMessageText().toLowerCase();
        Assert.assertTrue(resultMessage.contains(message.toLowerCase()), "Expected message is not visible");
    }

    @When("I click the 'Continue' button")
    public void iClickContinueBtn() {
        getResultMessagePage().clickContinueBtn();
    }

    private ResultMessagePage getResultMessagePage() {
        if (resultMessagePage == null) {
            resultMessagePage  = new ResultMessagePage(Hooks.driver).get();
        }
        return resultMessagePage;
    }
}
