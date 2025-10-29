package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

public class ResultMessagePage extends LoadableComponent<ResultMessagePage> {
    private final WebDriver driver;
    @FindBy(xpath = "//h2[contains(@class,'title') and contains(@style,'green')]")
    private WebElement resultMessageLbl;
    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueBtn;

    public ResultMessagePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Click continue button")
    public void clickContinueBtn() {
        continueBtn.click();
    }

    public String getResultMessageText() {
        return resultMessageLbl.getText();
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(resultMessageLbl.isDisplayed(), "Result Message is not visible");
    }
}
