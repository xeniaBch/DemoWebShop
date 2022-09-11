package webshop_package;

import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DataProviders;

public class RegistrationTest extends TestBase {

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
        Assert.assertTrue(isRegistrationPagePresent());
        registration(new User().setName("Harry").setLastname("Potter").setEmail("harrypotter" + i + "@hogwards.com").setPassword("1q2w3e4r5t"));
        Assert.assertTrue(isLogoutLinkPresent());
    }


    @Test(dataProvider = "RegistrationWithCsv" , dataProviderClass = DataProviders.class)
    public void registrationPositiveTestFromDataProviderWithCsv(User user) {
        Assert.assertTrue(isRegistrationPagePresent());
        registration(user);
        Assert.assertTrue(isLogoutLinkPresent());
    }
}

