package autotests.Pages;

import autoTests.Instruments.Driver;

/**
 * Created by dims on 18.04.14.
 */
public class SegmentCreatePage {
    private Driver driver;


    public void  setSegmentName(String name) {
        driver.findElementByXPath(".//input[@id='users_group_form_title']").sendKeys("name");

    }
}
