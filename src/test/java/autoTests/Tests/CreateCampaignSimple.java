package autoTests.Tests;

import autoTests.Instruments.Driver;
import autoTests.Instruments.Generators;
import autoTests.Instruments.LoginToAqua;
import autoTests.Pages.CampaignPage;
import autoTests.Pages.HomePage;

import org.junit.Test;
import org.openqa.selenium.WebElement;

/**
 * Created by dims on 30.04.14.
 */
public class CreateCampaignSimple extends LoginToAqua{
    private Driver driver;
    private String nameOfCampaign = "campaign" + Generators.getRandomText(4);
    private String campaignDescription = "about" + Generators.getRandomText(30);
    private String campaignNotes = "notes" + Generators.getRandomText(15);
    private String pushMessage = "message";


    @Test
    public void testCreateCampaignSimple() throws InterruptedException{
        driver = Driver.getDriver();
        HomePage home = new HomePage(driver);

        home.linkCreateCampaign();

        CampaignPage wizard = new CampaignPage(driver);

        wizard.typeCampaignName(nameOfCampaign);

        wizard.typeCampaignDescription(campaignDescription);

        wizard.clickCampaignStatus();

        wizard.setNotificationCampaign();

        wizard.typeCampaignNotes(campaignNotes);

        wizard.linkToDetails();

        wizard.setPushType();

        wizard.addVariables();

        wizard.addMessage(pushMessage);

        wizard.setSound();
    }
}
