package autoTests.Pages;

import autoTests.Instruments.Driver;

/**
 * Created by dims on 22.04.14.
 */
public class AppListPage {

    private Driver driver;


    public AppListPage(Driver driver) {
        this.driver = driver;
    }


    public ApplicationPage clickAddNewApplication() {
        driver.findElementByXPath(".//a[@href='/settings/projects/new' and contains(.,'Add new application')]").click();
        return new ApplicationPage(driver);

    }


    public void getCreatedApp(String appName) {
        driver.findElementByXPath(".//td/a[contains(.,'"+appName+"')]").isDisplayed();

    }

    public ApplicationPage openAppToEdit(String appName) {
        driver.findElementByXPath(".//td/a[contains(.,'"+appName+"')]").click();
        return new ApplicationPage(driver);
    }
}
