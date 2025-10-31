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
    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement loginEmail;
    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement loginPassword;
    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement loginBtn;

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

    @Step("Clear and type login email")
    public void typeLoginEmail(String email) {
        PageUtils.clearAndType(loginEmail, email);
    }

    @Step("Clear and type login password")
    public void typeLoginPassword(String password) {
        PageUtils.clearAndType(loginPassword, password);
    }

    @Step("Click submit signup button")
    public void submitSignup() {
        PageUtils.scrollAndClick(signupBtn, driver);
    }

    @Step("Click submit login button")
    public void submitLogin() {
        PageUtils.scrollAndClick(loginBtn, driver);
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public boolean isNewUserSignupFormDisplayed() {
        return signupBtn.isDisplayed();
    }

    public boolean isLoginFormDisplayed() {
        return loginBtn.isDisplayed();
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(signupBtn.isDisplayed(), "Submit signup button is not visible");
    }
}
