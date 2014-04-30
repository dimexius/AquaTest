package autoTests.Pages;

import autoTests.Instruments.Driver;
import autoTests.Instruments.Generators;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.net.URISyntaxException;


/**
 * Created by dims on 22.04.14.
 */
public class ApplicationPage {

    private Driver driver;
    private String appDescription = "app_info:"+Generators.getRandomText(30);
    private String appUserName = Generators.getRandomText(6);
    private String appUserMail = ""+appUserName+Math.nextAfter(5,1000) +"@mailmemore.com";
    private String appProperty = "autotestCharacteristic_";
    private String appAction = "autotestAction";
    private String appBannerScreen = "autotestBannerScreen";
    private String appDestScreen = "autotestDestinationScreen";
    private String propDescription = "prop:"+Generators.getRandomText(30);



    public ApplicationPage(Driver driver) {
        this.driver = driver;
    }

    //Set random application name and get it
    public String setAppName() {
        WebElement inputName = driver.findElementByXPath(".//input[@placeholder ='Application name' and @id='project_name']");
        String applicationName = ("app_" + Generators.getRandomText(5)+"dron");
        inputName.sendKeys(""+applicationName+"");
        return applicationName;
    }

    public void setAppDescription() {
        driver.findElementByXPath(".//textarea[@id='project_description']").sendKeys(appDescription);
    }

    public void UploadAppImage() {

        WebElement uploadAppImage = driver.findElementByXPath(".//input[@id='project_file']");
        try{
            String path = new File(ClassLoader.getSystemResource("app_image.png").toURI()).getAbsolutePath();
            uploadAppImage.sendKeys(path);

        } catch (URISyntaxException e){
            e.printStackTrace();
        }

    }

    public void clickSave() {
        driver.findElementByXPath(".//button[@type='submit' and contains(.,'SAVE')]").click();
        driver.findElementByXPath(".//li[contains(.,'Application successfully saved')]").isDisplayed();
    }

    public void checkTabs() {
        driver.findElementByXPath(".//a[contains(.,'Connections')]").isDisplayed();
        driver.findElementByXPath(".//a[contains(.,'AppAnnie')]").isDisplayed();
        driver.findElementByXPath(".//a[contains(.,'Share')]").isDisplayed();

    }

    public AppListPage clickApplist() {
        driver.findElementByXPath(".//a[@href='/settings/projects' and contains(.,'Apps list')]").click();
        return new AppListPage(driver);
    }

    public void verifyConnectionsTab() {
        driver.findElementByXPath(".//a[contains(.,'Connections')]").click();
        driver.findElementByXPath(".//*[@id='project_configuration_app_key']").isDisplayed();
    }

    public void verifyAppannieTab() {
        driver.findElementByXPath(".//a[contains(.,'AppAnnie')]").click();

    }

    public void verifyShareTab() {
        driver.findElementByXPath(".//a[contains(.,'Share')]").click();
        driver.findElementByXPath(".//div/h3[contains(.,'App users')]").isDisplayed();
        driver.findElementByXPath(".//a[contains(.,'Add new user')]").isDisplayed();
    }

    // Add new user to created application

    public void addNewUser() {

        //click button Add new User
        driver.findElementByXPath(".//a[contains(.,'Add new user')]").click();

        //Set random username
        driver.findElementByXPath(".//input[@id='user_full_name']").sendKeys(""+appUserName+"");

        //Set random user email
        driver.findElementByXPath(".//input[@id='user_email']").sendKeys(""+appUserMail+"");

        //click Save without choosed role
        driver.findElementByXPath(".//button[@id='user_save_and_close' and contains(.,'Save & close')]").click();

        // If warning text about CSRF token is appears then re-submit form happens

        if (driver.findElementByXPath(".//li[contains(.,'The CSRF token is invalid. Please try to resubmit the form.')]").isDisplayed()){
            driver.findElementByXPath(".//button[@id='user_save_and_close' and contains(.,'Save & close')]").click();
        }

        //Message about at least one role for user should opens
        driver.findElementByXPath(".//li[contains(.,'Please select at least one role for user')]").isDisplayed();

        // Choose Role for created User
        WebElement role = driver.findElementByXPath(".//select[contains(.,'Viewer')]//following-sibling::div[contains(.,'None')]");
        role.click();
        driver.findElementByXPath(".//ul/li[contains(.,'Contributor')]").click();

        // Upload user image
        WebElement uploadAppImage = driver.findElementByXPath(".//input[@id='user_file']");
        try{
            String path = new File(ClassLoader.getSystemResource("app_image.png").toURI()).getAbsolutePath();
            uploadAppImage.sendKeys(path);

        } catch (URISyntaxException e){
            e.printStackTrace();
        }

        // Save user
        driver.findElementByXPath(".//button[@id='user_save_and_close' and contains(.,'Save & close')]").click();

        // Verify that message about user creation is appears
        driver.findElementByXPath(".//li[contains(.,'This user has been created. Temporary password and other login details have been sent to the specified email.')]").isDisplayed();

    }


    // Create Three types of Characteristic
    public void createCharacteristic(String characteristicType) {


            driver.findElementByXPath(".//a[@role='button' and contains(.,'Create new')]").click();
            driver.findElementByXPath(".//input[@id='account_setup_name']").sendKeys("" + appProperty + characteristicType+"");

            driver.findElementByXPath(".//*[@id='account_setup_description']").sendKeys("" + propDescription + "");


        WebElement type = driver.findElementByXPath(".//div[@class='combo-selected' and contains(.,'Numeric')]");
        type.click();
        driver.findElementByXPath(".//ul/li[contains(.,'"+characteristicType+"')]").click();

        driver.findElementByXPath(".//label[contains(.,'For all projects')]").click();

        //Save Characteristic
        driver.findElementByXPath(".//button[contains(.,'SAVE')]").click();

        }

    public void deleteTestCharacteristics(String characteristicType) {
        driver.findElementByXPath(".//tr[contains(.,'"+ appProperty + characteristicType+"')]/td//a[contains(.,'Remove')]").click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


    public void linkToActions() {
        driver.findElementByXPath(".//a[contains(.,'Actions')]").click();
        driver.findElementByXPath(".//li[@class='active']/a[contains(.,'Actions')]").isDisplayed();
    }

    public void linkToBannerScreens() {
        driver.findElementByXPath(".//a[contains(.,'Banner screens')]").click();
        driver.findElementByXPath(".//li[@class='active']/a[contains(.,'Banner screens')]").isDisplayed();
    }

    public void linkToDestinationScreens() {
        driver.findElementByXPath(".//a[contains(.,'Destination screens')]").click();
        driver.findElementByXPath(".//li[@class='active']/a[contains(.,'Destination screens')]").isDisplayed();
    }


    public void createAction() {
        driver.findElementByXPath(".//a[@role='button' and contains(.,'Create new')]").click();
        driver.findElementByXPath(".//input[@id='account_setup_name']").sendKeys("" + appAction + "");
        driver.findElementByXPath(".//*[@id='account_setup_description']").sendKeys("" + propDescription + "");
        driver.findElementByXPath(".//label[contains(.,'For all projects')]").click();
        driver.findElementByXPath(".//button[contains(.,'SAVE')]").click();
    }

    public void deleteAction() {
        driver.findElementByXPath(".//tr[contains(.,'"+ appAction +"')]/td//a[contains(.,'Remove')]").click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


    public void createBannerScreen() {
        driver.findElementByXPath(".//a[@role='button' and contains(.,'Create new')]").click();
        driver.findElementByXPath(".//input[@id='account_setup_name']").sendKeys("" + appBannerScreen + "");
        driver.findElementByXPath(".//*[@id='account_setup_description']").sendKeys("" + propDescription + "");
        driver.findElementByXPath(".//label[contains(.,'For all projects')]").click();
        driver.findElementByXPath(".//button[contains(.,'SAVE')]").click();

    }

    public void deleteBannerScreen() {
        driver.findElementByXPath(".//tr[contains(.,'"+ appBannerScreen +"')]/td//a[contains(.,'Remove')]").click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void createDestinationScreen() {
        driver.findElementByXPath(".//a[@role='button' and contains(.,'Create new')]").click();
        driver.findElementByXPath(".//input[@id='account_setup_name']").sendKeys("" + appDestScreen + "");
        driver.findElementByXPath(".//*[@id='account_setup_description']").sendKeys("" + propDescription + "");
        driver.findElementByXPath(".//label[contains(.,'For all projects')]").click();
        driver.findElementByXPath(".//button[contains(.,'SAVE')]").click();

    }

    public void deleteDestinationScreen() {
        driver.findElementByXPath(".//tr[contains(.,'"+ appDestScreen +"')]/td//a[contains(.,'Remove')]").click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

}
