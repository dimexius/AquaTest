package autoTests.Pages;

import autoTests.Instruments.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    public void linkToStep2() {
        driver.findElementByXPath(".//a[@href='#2' and contains(.,'The details')]").click();
    }

    public void setPushType() {
        driver.findElementByXPath(".//label[@for='campaign_push_type_0']/span[@class='ui-button-text' and contains(text(),'Push')]").click();
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

    public void setPushTarget(String url) {
        WebElement targetList = driver.findElementByXPath(".//div[@class='combo-wrapper form-select push-local-link']");
        targetList.click();
        targetList.sendKeys(Keys.DOWN);
        driver.findElementByXPath(".//*[@id='campaign_push_href']").click();
        driver.findElementByXPath(".//*[@id='campaign_push_href']").sendKeys(url);
    }

    public void linkToStep3() {
        driver.findElementByXPath(".//a[@href='#3' and contains(.,'The people')]").click();
    }

    public void setBirthdayFilter() {
        WebElement from = driver.findElementByXPath(".//*[@placeholder='From']/following-sibling::button");
        from.click();
        from.sendKeys(Keys.ENTER);
        WebElement to = driver.findElementByXPath(".//*[@placeholder='To']/following-sibling::button");
        to.click();
        to.sendKeys(Keys.ENTER);
    }

    public void setLanguageFilter() {
        WebElement langList = driver.findElementByXPath(".//div[@class='combo-wrapper form-select']");
        langList.click();
        driver.findElementByXPath(".//ul[@class='combo-list combo-list-long']/li[contains(.,'English')]").click();
    }

    public void linkToStep4() {
        driver.findElementByXPath(".//a[@href='#4' and contains(.,'Their properties')]").click();
    }

    public void linkToStep5() {
        driver.findElementByXPath(".//a[@href='#5' and contains(.,'The last step')]").click();
    }

    public void addLocation(String location,Integer radius) {
       WebElement geoMap= driver.findElementByXPath(".//*[@id='geoLocationPopupButton']");
       geoMap.click();
       driver.findElementByXPath(".//*[@id='geolocation-address']").sendKeys(location);
       driver.findElementByXPath(".//*[@id='geolocation-search']").click();
       driver.findElementByXPath(".//input[@placeholder='Enter radius value in feet']").sendKeys("" + radius + "");
       driver.findElementByXPath(".//*[@id='geo-location-save-button']").click();
    }

    public void setCampaignDates() {
        WebElement dateOfPush = driver.findElementByXPath(".//input[@id='campaign_time_fantom_date_from']/following-sibling::a");
        dateOfPush.click();
        driver.findElementByXPath(".//*[@id='datepicker-fancybox']/div[2]//button[contains(text(),Select)]").click();

    }

    public void setTimeZone() {
        WebElement timePopup = driver.findElementByXPath(".//*[@id='timezone-popup']");
        timePopup.click();
        driver.findElementByXPath(".//*[@id='timezone-map']/area[383]").click();
        driver.findElementByXPath(".//*[@id='timezone-popup-close']").click();
    }

    public void clickSaveCampaign() {
        driver.findElementByXPath(".//a[@href='#4']/following-sibling::button").click();

    }

    public void addDeviceId(String deviceId) {
        driver.findElementByXPath(".//*[@id='campaign_users_group_udid_input']").click();
        driver.findElementByXPath(".//*[@id='campaign_users_group_udid_input']").sendKeys(deviceId);
        driver.findElementByXPath(".//*[@id='add_udid']").click();
        driver.findElementByXPath(".//div[@id='udids-wrapper']/div[contains(.,'"+deviceId+"')]");
    }
}
