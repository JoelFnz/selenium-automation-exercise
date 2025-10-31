package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

public class MainPage extends LoadableComponent<MainPage> {
    private final WebDriver driver;
    @FindBy(id = "slider-carousel")
    private WebElement carousel;
    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginLink;
    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logoutLink;
    @FindBy(xpath = "//a[@href='/delete_account']")
    private WebElement deleteAccountLink;
    @FindBy(xpath = "//a[contains(text(), 'Logged in as')]")
    private WebElement loggedInAsUsernameLbl;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Click the login link")
    public void clickLoginLink() {
        loginLink.click();
    }

    @Step("Click the delete account link")
    public void clickDeleteAccountLink() {
        deleteAccountLink.click();
    }

    @Step("Click the logout link")
    public void clickLogoutLink() {
        logoutLink.click();
    }

    public boolean isLoggedInAsUsernameVisible() {
        return loggedInAsUsernameLbl.isDisplayed();
    }

    public boolean isLogoutLinkDisplayed() {
        return logoutLink.isDisplayed();
    }

    public boolean isCarouselDisplayed() {
        return carousel.isDisplayed();
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(isCarouselDisplayed(), "Carousel is not displayed");
    }
}
