package webshop_package;

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

    public void registration(String name, String lastname, String email, String password) {
        click(By.cssSelector("#gender-male"));
        type(By.cssSelector("#FirstName"),name);
        type(By.cssSelector("#LastName"), lastname);
        type(By.cssSelector("#Email"), email);
        type(By.cssSelector("#Password"), password);
        type(By.cssSelector("#ConfirmPassword"), password);
        click(By.cssSelector("#register-button"));
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
}
