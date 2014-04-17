package autoTests.Pages;

import autoTests.Instruments.Driver;

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
        return driver.findElementByLinkText("logout").getText();
    }

}


