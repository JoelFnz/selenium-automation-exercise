package pages.components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.constants.SignupCountry;
import utils.PageUtils;

public class AddressInfoForm extends LoadableComponent<AddressInfoForm> {
    @FindBy(id = "first_name")
    private WebElement firstNameTxb;

    @FindBy(id = "last_name")
    private WebElement lastNameTxb;

    @FindBy(id = "company")
    private WebElement companyTxb;

    @FindBy(id = "address1")
    private WebElement addressTxb;

    @FindBy(id = "state")
    private WebElement stateTxb;

    @FindBy(id = "city")
    private WebElement cityTxb;

    @FindBy(id = "zipcode")
    private WebElement zipcodeTxb;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberTxb;

    @FindBy(id = "country")
    private WebElement countrySelect;

    public AddressInfoForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Step("Clear and type first name")
    public void typeFirstName(String firstName) {
        PageUtils.clearAndType(firstNameTxb, firstName);
    }

    @Step("Clear and type last name")
    public void typeLastName(String lastName) {
        PageUtils.clearAndType(lastNameTxb, lastName);
    }

    @Step("Clear and type company")
    public void typeCompany(String companyName) {
        PageUtils.clearAndType(companyTxb, companyName);
    }

    @Step("Clear and type address")
    public void typeAddress(String address) {
        PageUtils.clearAndType(addressTxb, address);
    }

    @Step("Clear and type state")
    public void typeState(String stateName) {
        PageUtils.clearAndType(stateTxb, stateName);
    }

    @Step("Clear and type city")
    public void typeCity(String cityName) {
        PageUtils.clearAndType(cityTxb, cityName);
    }

    @Step("Clear and type zipcode")
    public void typeZipcode(String zipcode) {
        PageUtils.clearAndType(zipcodeTxb, zipcode);
    }

    @Step("Clear and type mobile number")
    public void typeMobileNumber(String mobileNumber) {
        PageUtils.clearAndType(mobileNumberTxb, mobileNumber);
    }

    @Step("Select country")
    public void selectCountry(SignupCountry country) {
        new Select(countrySelect).selectByValue(country.getValue());
    }

    public boolean isFormVisible() {
        return addressTxb.isDisplayed();
    }

    @Override
    protected void load() {
    }

    @Override
    public void isLoaded() throws Error {
        Assert.assertTrue(addressTxb.isDisplayed(), "Address textbox is not visible");
    }
}
