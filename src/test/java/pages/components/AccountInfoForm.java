package pages.components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.constants.GenderTitle;
import utils.PageUtils;

import java.time.LocalDate;
import java.util.List;

public class AccountInfoForm extends LoadableComponent<AccountInfoForm> {
    @FindBy(name = "title")
    private List<WebElement> genderTitles;
    @FindBy(id = "name")
    private WebElement nameTxb;
    @FindBy(id = "email")
    private WebElement emailTxb;
    @FindBy(id = "password")
    private WebElement passwordTxb;
    @FindBy(id = "newsletter")
    private WebElement newsletterChb;
    @FindBy(id = "optin")
    private WebElement specialOffersChb;
    @FindBy(id = "days")
    private WebElement dayOfBirth;
    @FindBy(id = "months")
    private WebElement monthOfBirth;
    @FindBy(id = "years")
    private WebElement yearOfBirth;

    public AccountInfoForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Step("Select gender title")
    public void selectGenderTitle(GenderTitle title) {
        genderTitles.stream()
                .findAny()
                .filter((d) -> d.getCssValue("value").equals(title.getValue()))
                .ifPresent(WebElement::click);
    }

    @Step("Select checkbox to signup in the newsletter")
    public void clickNewsletterChb() {
        newsletterChb.click();
    }

    @Step("Select checkbox to receive offers from partners")
    public void clickSpecialOffersChb() {
        specialOffersChb.click();
    }

    @Step("Clear and type name")
    public void typeName(String name) {
        PageUtils.clearAndType(nameTxb, name);
    }

    @Step("Clear and type email")
    public void typeEmail(String email) {
        PageUtils.clearAndType(emailTxb, email);
    }

    @Step("Clear and type password")
    public void typePassword(String password) {
        PageUtils.clearAndType(passwordTxb, password);
    }

    @Step("Select date of birth")
    public void selectDateOfBirth(LocalDate dateOfBirth) {
        new Select(dayOfBirth).selectByValue(dateOfBirth.getDayOfMonth() + "");
        new Select(monthOfBirth).selectByValue(dateOfBirth.getMonthValue() + "");
        new Select(yearOfBirth).selectByValue(dateOfBirth.getYear() + "");
    }

    public boolean isFormVisible() {
        return !genderTitles.isEmpty();
    }

    @Override
    protected void load() {
    }

    @Override
    public void isLoaded() throws Error {
        Assert.assertTrue(newsletterChb.isDisplayed(), "Newsletter checkbox is not visible");
    }
}
