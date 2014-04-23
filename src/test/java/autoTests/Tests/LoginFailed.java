package autoTests.Tests;

import autoTests.Instruments.Driver;
import autoTests.Instruments.LoginToAqua;
import autoTests.Instruments.TestProperties;
import autoTests.Pages.HomePage;
import autoTests.Pages.LoginPage;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;

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


        boolean logged = driver.findElementsByXPath("//a[contains(.,'Logout')]").size() != 0;

        if (logged) {

            HomePage home = new HomePage (driver);
            home.logoutFromAqua();
        }
        else {
            loginPage.failLogin();
        }

        //loginPage.enterCredentials(TestProperties.get("userIncorrectLogin"), TestProperties.get("userIncorrectPassword"));

        //driver.findElement(By.xpath(".//button[contains(.,'LOGIN')]")).click();

        assertNotNull(driver.findElementByXPath(".//li[contains(.,'Invalid email or password')]"));

        driver.shutdown();
    }


}
