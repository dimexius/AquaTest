package autoTests.Pages;

import autoTests.Instruments.Driver;
import org.openqa.selenium.WebElement;

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

    public void setPushType() {
        driver.findElementByXPath(".//label[@aria-pressed='true' and contains(.,'Push')]").click();
    }

    public void addVariables() {
        driver.findElementByXPath(".//a[contains(.,'First name')]").click();
        driver.findElementByXPath(".//a[contains(.,'Last name')]").click();

    }

    public void addMessage(String message) {
        driver.findElementByXPath(".//textarea[@id='campaign_messages_push']").sendKeys(message);
    }

    public void setSound() {
        WebElement sound =  driver.findElementByXPath(".//*[@id='sound_player']/div[2]/div[1]");
        sound.click();
        driver.findElementByXPath(".//span[contains(.,'Door Bell')]").click();
    }
}
