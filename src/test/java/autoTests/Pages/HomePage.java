package autoTests.Pages;

import autoTests.Instruments.Driver;

import java.util.concurrent.TimeUnit;

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


    public SegmentCreatePage linkCreateSegment() {
        driver.findElementByXPath(" .//a[contains(.,'+ Create a segment')]").click();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        return new SegmentCreatePage(driver);
    }

    public AppListPage linkSettings() {
        driver.findElementByXPath(".//a[@href='/settings/projects' and contains(.,'settings')]").click();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        return new AppListPage(driver);
    }
}


