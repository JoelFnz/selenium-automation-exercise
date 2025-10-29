package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;
import utils.PageUtils;

public class LoginPage extends LoadableComponent<LoginPage> {
    private final WebDriver driver;
    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement signupName;
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement signupEmail;
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signupBtn;
    @FindBy(xpath = "//p[contains(@style,'color: red')]")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Clear and type signup name")
    public void typeSignupName(String name) {
        PageUtils.clearAndType(signupName, name);
    }

    @Step("Clear and type signup email")
    public void typeSignupEmail(String email) {
        PageUtils.clearAndType(signupEmail, email);
    }

    @Step("Click submit signup button")
    public void submitSignup() {
        PageUtils.scrollAndClick(signupBtn, driver);
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public boolean isNewUserSignupFormDisplayed() {
        return signupBtn.isDisplayed();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(signupBtn.isDisplayed(), "Submit signup button is not visible");
    }
}
