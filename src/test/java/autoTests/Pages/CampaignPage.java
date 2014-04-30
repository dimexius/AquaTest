package autoTests.Pages;

import autoTests.Instruments.Driver;

/**
 * Created by dims on 30.04.14.
 */
public class CampaignPage {
    private Driver driver;


    public CampaignPage(Driver driver) {
        this.driver=driver;

    }

    public void typeCampaignName(String nameOfCampaign) {
        driver.findElementByXPath(".//input[@id='campaign_name']").sendKeys(nameOfCampaign);
    }

    public void typeCampaignDescription(String campaignDescription) {
        driver.findElementByXPath(".//textarea[@id='campaign_description']").sendKeys(campaignDescription);
    }

    public void clickCampaignStatus() {
        driver.findElementByXPath(".//p/span[contains(.,'Live')]").click();
    }

    public void setNotificationCampaign() {
        driver.findElementByXPath(".//label/span[contains(.,'Notification')]").click();
    }

    public void typeCampaignNotes(String campaignNotes) {
        driver.findElementByXPath(".//textarea[@id='campaign_notes']").sendKeys(campaignNotes);
    }

    public void linkToDetails() {
        driver.findElementByXPath(".//a[@href='#2' and contains(.,'The details')]").click();
    }
}
