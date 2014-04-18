package autoTests.Pages;

import autoTests.Instruments.Driver;
import autotests.Pages.SegmentCreatePage;

/**
 * Created by dims on 16.04.14.
 */
public class HomePage {
    private Driver driver;

    public HomePage(Driver driver) {
        this.driver = driver;
    }

    // Check top section with link Logout after success login
    public String getLogoutText() {
        return driver.findElementByXPath("//a[contains(.,'Logout')]").getText();
    }


    public SegmentCreatePage linkCreatesegment() {
        driver.findElementByXPath(".//li[contains(.,\"+ Create a segment\")]").click();
        return new SegmentCreatePage();
    }
}


