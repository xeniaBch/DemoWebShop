package webshop_package;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void clickRegistrationLink() {
        click(By.cssSelector(".ico-register"));
    }

    public void clickLogoutLink() {
        click(By.cssSelector(".ico-logout"));
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isLogoutLinkPresent() {
        return isElementPresent(By.cssSelector(".ico-logout"));
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public boolean isRegistrationPagePresent() {
        return isElementPresent(By.cssSelector(".registration-page"));
    }

    public void registration(User user) {
        click(By.cssSelector("#gender-male"));
        type(By.cssSelector("#FirstName"), user.getName());
        type(By.cssSelector("#LastName"), user.getLastname());
        type(By.cssSelector("#Email"), user.getEmail());
        type(By.cssSelector("#Password"), user.getPassword());
        type(By.cssSelector("#ConfirmPassword"), user.getPassword());
        click(By.cssSelector("#register-button"));
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
}
