package autoTests.Tests;

import autoTests.Instruments.Driver;
import autoTests.Instruments.LoginToAqua;
import autoTests.Pages.HomePage;
import autoTests.Pages.LoginPage;
import org.junit.Test;

/**
 * Created by dims on 23.04.14.
 */
public class CheckFooterLinks extends LoginToAqua {
    private Driver driver;

    @Test
    public void testCheckFooterLinks() throws  InterruptedException{

        driver = Driver.getDriver();
        LoginPage login = new LoginPage(driver);
        login.checkFooterLinks();

        HomePage home = new HomePage(driver);
        login.checkFooterLinks();

        home.logoutFromAqua();

    }
}
