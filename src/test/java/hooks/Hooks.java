package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.files.EnvReader;

import java.time.Duration;

public class Hooks {
    @Getter
    public static WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(EnvReader.getEnvConfig().getImplicitWait()));
        driver.get(EnvReader.getEnvConfig().getHost());
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
