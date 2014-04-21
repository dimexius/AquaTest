package autoTests.Tests;

import autoTests.Instruments.Driver;
import autoTests.Instruments.LoginToAqua;
import autoTests.Instruments.TestProperties;
import autoTests.Pages.HomePage;
import autoTests.Pages.LoginPage;
import autoTests.Pages.SegmentCreatePage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


/**
 * Created by dims on 18.04.14.
 */
public class CreateSegment extends LoginToAqua{

    @BeforeClass
    public static void setUp() throws InterruptedException{
        driver = Driver.getDriver();
        driver.getFromBase("/login");
        LoginPage login = new LoginPage(driver);
        HomePage home = login.loginTo(TestProperties.get("userLogin"), TestProperties.get("userPassword"));
        assertTrue(home.getLogoutText().contains("Logout"));
    }


    @Test
    public void testCreateSegment() throws InterruptedException{


        //Login to Aqua and Open Home page
        HomePage home = new HomePage(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SegmentCreatePage segmentPage = home.linkCreatesegment();

        segmentPage.setSegmentName("testname");

    }

}
