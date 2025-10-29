package pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;
import pages.components.AccountInfoForm;
import pages.components.AddressInfoForm;
import utils.PageUtils;

public class SignupPage extends LoadableComponent<SignupPage> {
    private final WebDriver driver;
    @Getter
    private final AddressInfoForm addressForm;
    @Getter
    private final AccountInfoForm accountForm;
    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccountBtn;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        addressForm = new AddressInfoForm(driver);
        accountForm = new AccountInfoForm(driver);
    }

    @Step("Click create account button")
    public void clickCreateAccountBtn() {
        PageUtils.scrollAndClick(createAccountBtn, driver);
    }

    @Override
    protected void load() {
        addressForm.get();
        accountForm.get();
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(createAccountBtn.isDisplayed(), "Create account button is not visible");
        addressForm.isLoaded();
        accountForm.isLoaded();
    }
}
