package autoTests.Tests;

import autoTests.Instruments.Driver;
import autoTests.Instruments.LoginToAqua;
import autoTests.Pages.HomePage;
import autotests.Pages.SegmentCreatePage;
import org.junit.Test;


/**
 * Created by dims on 18.04.14.
 */
public class CreateSegment extends LoginToAqua{

    @Test
    public void testCreateSegment() throws InterruptedException{

        //Login to Aqua and Open Home page
        HomePage home = new HomePage(driver);


        SegmentCreatePage segmentPage = home.linkCreatesegment();

        segmentPage.setSegmentName("Testname");

    }

}
