package autoTests.Tests;

import autoTests.Instruments.Driver;
import autoTests.Instruments.Generators;
import autoTests.Instruments.LoginToAqua;
import autoTests.Pages.CampaignPage;
import autoTests.Pages.HomePage;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

/**
 * Created by dims on 30.04.14.
 */
public class CreateCampaignSimple extends LoginToAqua{
    private Driver driver;
    private String nameOfCampaign = "campaign" + Generators.getRandomText(4);
    private String campaignDescription = "about" + Generators.getRandomText(30);
    private String campaignNotes = "notes" + Generators.getRandomText(15);
    private String pushMessage = "message";
    private String pushUrl = "http://google.com";
    private String location = "Simferopol";
    private Integer radius = 15;
    private String deviceId = "123-456-789-BBHQ";


    @Test
    public void testCreateCampaignSimple() throws InterruptedException{
        driver = Driver.getDriver();
        HomePage home = new HomePage(driver);

    // Step 1 - The Basics
        // click on link "Create Campaign"
        home.linkCreateCampaign();
        // Campaign wizard should open on step1
        CampaignPage wizard = new CampaignPage(driver);
        // type Campaign name
        wizard.typeCampaignName(nameOfCampaign);
        // type Campaign Description
        wizard.typeCampaignDescription(campaignDescription);
        // set Campaign status "Active"
        wizard.clickCampaignStatus();
        // set Campaign type: Notification
        wizard.setNotificationCampaign();
        // type Campaign notes text/ Notes was reduced
        //wizard.typeCampaignNotes(campaignNotes);

        // click on link "Details" to open step 2
        wizard.linkToStep2();

    // Step2 - "Details"
        // Set Campaign type : push
        wizard.setPushType();
        // click on example variables to add first_name&last_name
        wizard.addVariables();
        // add push message
        wizard.addMessage(pushMessage);
        // set push target
        wizard.setPushTarget(pushUrl);

        // click on link The people to open step 3
        wizard.linkToStep3();

     //Step 3 - "The People"
        //Set Birthday filter
        wizard.setBirthdayFilter();

        //Set Language filter
        wizard.setLanguageFilter();

        //add  Device Id to clear search results
        wizard.addDeviceId(deviceId);
        //check if results is empty for entered device id
        driver.findElementByXPath(".//*[@id='users-amount-wrapper']//span[contains(.,'0')]").isDisplayed();

        // click on link Their Properties to open step 4
        wizard.linkToStep4();

        //Step 4 - Their Properties

        // Add methods to add properties

        // click on link "The last step" to open step 5
        wizard.linkToStep5();

        //Step 5 - The last step
       wizard.addLocation(location,radius);

       wizard.setCampaignDates();

       wizard.setTimeZone();

       wizard.clickSaveCampaign();

       WebElement message = driver.findElementByXPath(".//li[contains(.,'Campaign \""+nameOfCampaign+"\" saved.')]");
       message.isDisplayed();
       String text = message.getText();
       assertEquals(text,"Campaign \""+nameOfCampaign+"\" saved.");


    }
}
