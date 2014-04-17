package autoTests.Tests;

import autoTests.Instruments.Driver;
import autoTests.Pages.LoginPage;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by dims on 16.04.14.
 */
public class LoginFailed {
    private Driver driver;

    @Test
    public void testLoginFailed() throws InterruptedException {
        driver = Driver.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.failLogin();
        assertNotNull(driver.findElementByXPath(".//div/div[contains(.,'Username or password wrong')]"));

    }
}
