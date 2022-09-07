package webshop_package;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (isLogoutLinkPresent()) {
            clickLogoutLink();
        } else {
            clickRegistrationLink();
        }
    }

    @Test
    public void registrationPositiveTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        Assert.assertTrue(isElementPresent(By.cssSelector(".registration-page")));
        registration(i);
        Assert.assertTrue(isLogoutLinkPresent());
    }

}
