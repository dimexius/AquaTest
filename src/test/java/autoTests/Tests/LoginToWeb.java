package autoTests.Tests;

import autoTests.Instruments.Driver;
import autoTests.Instruments.TestProperties;
import autoTests.Pages.LoginPage;
import org.junit.Test;

/**
 * Created by dims on 17.04.14.
 */
public class LoginToWeb {
    private Driver driver;

    @Test
    public void testLogintoWeb() throws InterruptedException {
        driver = Driver.getDriver();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginTo(TestProperties.get("userLogin"), TestProperties.get("userPassword"));

    }
}


