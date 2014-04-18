package autoTests.Instruments;

import autoTests.Instruments.Driver;
import autoTests.Instruments.TestProperties;
import autoTests.Pages.HomePage;
import autoTests.Pages.LoginPage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

/**
 * Created by dims on 16.04.14.
 */
public abstract class LoginToAqua {
    public static Driver driver;

    @BeforeClass   // initiation of driver and go to base URL from test.properties file
    public static void setUp() throws InterruptedException{
        driver = Driver.getDriver();
        driver.getFromBase("/login");
        LoginPage login = new LoginPage(driver);
        HomePage home = login.loginTo(TestProperties.get("userLogin"), TestProperties.get("userPassword"));
        assertTrue(home.getLogoutText().contains("Logout"));
    }

    @AfterClass
    public static void tearDown() {
        driver.findElement(By.xpath("//a[contains(.,'Logout')]")).click();
        driver.findElement(By.xpath("//span[contains(.,'Login')]")).getText();
    }

}

