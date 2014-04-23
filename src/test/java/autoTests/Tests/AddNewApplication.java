package autoTests.Tests;

import autoTests.Instruments.Driver;
import autoTests.Instruments.LoginToAqua;
import autoTests.Pages.AppListPage;
import autoTests.Pages.ApplicationPage;
import autoTests.Pages.HomePage;
import org.junit.Test;

/**
 * Created by dims on 22.04.14.
 */
public class AddNewApplication extends LoginToAqua{

    private String appName;

    @Test
    public void testAddNewApplication() throws InterruptedException
    {
        driver= Driver.getDriver();

        //Login to Aqua and Open Home page
        HomePage home = new HomePage(driver);

        //click on link "Settings" in homePage top menu
        AppListPage appListPage = home.linkSettings();

        // Click Add new application to open Application page
        ApplicationPage appPage = appListPage.clickAddNewApplication();

        //set random App name
        appName = appPage.setAppName();

        //set app description
        appPage.setAppDescription();

        // upload random image for app image
        appPage.UploadAppImage();

        // Save application
        appPage.clickSave();

        // verify that application tabs is appears
        appPage.checkTabs();

        //open application list Appplist
        appPage.clickApplist();

        //save name of added app
        appListPage.getCreatedApp(appName);

        // open created application from table by click
        appListPage.openAppToEdit(appName);

        //open Connections tab
        // verify content on Connectionas tab
        appPage.verifyConnectionsTab();

        //verify AppAnnie tab content
        appPage.verifyAppannieTab();

        //verify Share tab content
        appPage.verifyShareTab();

        //Logout from application
        home.logoutFromAqua();
    }







}
