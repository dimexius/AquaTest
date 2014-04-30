package autoTests.Tests;

import autoTests.Instruments.Driver;
import autoTests.Instruments.LoginToAqua;
import autoTests.Pages.ApplicationPage;
import autoTests.Pages.CharacteristicsPage;
import autoTests.Pages.HomePage;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by dims on 24.04.14.
 */
public class CreateCustomEvents extends LoginToAqua{

    private Driver driver;
    private String[] characteristicType = {"Numeric","String", "Boolean",};

    @Test
    public void testCreateCustomEvents() throws InterruptedException{

        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        HomePage home = new HomePage(driver);

        home.linkCreateCustomEvent();

        ApplicationPage appPage = new ApplicationPage(driver);


        //click Button Create new
        //appPage.clickCreateNewCharacteristic();


        //Set Characteristic data
        appPage.createCharacteristic(characteristicType[0]);

        appPage.createCharacteristic(characteristicType[1]);

        appPage.createCharacteristic(characteristicType[2]);

        appPage.deleteTestCharacteristics(characteristicType[0]);
        appPage.deleteTestCharacteristics(characteristicType[1]);
        appPage.deleteTestCharacteristics(characteristicType[2]);


        appPage.linkToActions();

        appPage.createAction();

        appPage.deleteAction();

        appPage.linkToBannerScreens();

        appPage.createBannerScreen();

        appPage.deleteBannerScreen();

        appPage.linkToDestinationScreens();

        appPage.createDestinationScreen();

        appPage.deleteDestinationScreen();

    }

}
