package autoTests.Pages;

import autoTests.Instruments.Driver;
import autoTests.Instruments.Generators;
import org.openqa.selenium.By;


/**
 * Created by dims on 18.04.14.
 */
public class SegmentCreatePage {

    private Driver driver;
    private String segmentName = "segment_" + Generators.getRandomText(4);
    private String segmentDescription = "description_" + Generators.getRandomText(48);//max 60 symbols= desc+ 48
    private String ageFrom = "5";
    private String ageTo = "85";
    private String usedFrom = "2";
    private String usedTo = "5";
    private String udid = Generators.getRandomText(4)+ Math.random() + Generators.getRandomText(4);


    public SegmentCreatePage(Driver driver) {
        this.driver = driver;
    }

    // set random Segment name
    public void  setSegmentName() {
        driver.findElementByXPath(".//input[@placeholder = 'Name your segment']").click();
        driver.findElementByXPath(".//input[@id='users_group_form_title']").sendKeys(segmentName);
    }

    // Segment random Description
    public void setSegmentDescription() {
        driver.findElementByXPath(".//textarea[@placeholder = 'Describe your segment']").click();
        driver.findElementByXPath(".//textarea[@placeholder = 'Describe your segment']").sendKeys(segmentDescription);
    }

    //Age range
    public void setAgeRange() {
        driver.findElementByXPath(".//input[@id='users_group_form_age_from']").sendKeys(ageFrom);
        driver.findElementByXPath(".//input[@id='users_group_form_age_to']").sendKeys(ageTo);

    }

    public void clickCreateSegment() {
        driver.findElement(By.xpath(".//button[contains(.,'Create')]")).click();

    }

    public void setBirthday() {
        //date from locator:   driver.findElementByXPath(".//input[@id='users_group_form_birthday_from']/following-sibling::button").click();
        //date to locator:   driver.findElementByXPath(".//input[@id='users_group_form_birthday_to']/following-sibling::button").click();
        driver.findElementByXPath(".//*[@id='users_group_form_birthday_unknown']").click();
    }


    public void setGender() {
        driver.findElementByXPath(".//span[contains(.,'Female')]").click();
    }

    public void chooseLanguage() {
        driver.findElementByXPath(".//select/following-sibling::div[contains(.,'Choose a language')]").click();
        driver.findElementByXPath(".//li[contains(.,'Malay')]").click();
    }

    public void setNumberUsed() {
        driver.findElementByXPath(".//*[@id='users_group_form_activity_from']").sendKeys(usedFrom);
        driver.findElementByXPath(".//*[@id='users_group_form_activity_to']").sendKeys(usedTo);
    }

    public void chooseOs() {
        driver.findElementByXPath(".//span[contains(.,'iOS')]").click();

    }

    public void chooseDevice() {
        driver.findElementByXPath(".//span[contains(.,'Smartphone')]").click();
    }

    public void addDeviceId() {
        driver.findElementByXPath(".//*[@id='users_group_form_udid_input']").sendKeys(udid);
    }

    public void defineGeoArea() {
        driver.findElementByXPath(".//select/following-sibling::div[contains(.,'Choose country')]").click();
        driver.findElementByXPath(".//li[contains(.,'Ukraine')]");
        driver.findElementByXPath(".//li[contains(.,'Ukraine')]").click();
        driver.findElementByXPath(".//select/following-sibling::div[contains(.,'Choose region')]").click();
        driver.findElementByXPath(".//li[contains(.,'Krym')]");
        driver.findElementByXPath(".//li[contains(.,'Krym')]").click();
        driver.findElementByXPath(".//select/following-sibling::div[contains(.,'Choose city')]").click();
        driver.findElementByXPath(".//li[contains(.,'Simferopol\'')]");
        driver.findElementByXPath(".//li[contains(.,'Simferopol'')]").click();
    }

    public void sortByCreation() {
        driver.findElementByXPath(".//th/a[contains(.,'Created on')]").click();
        driver.findElementByXPath(".//th/a[contains(.,'Created on')]").click();
        //sort by creation
        driver.findElementByXPath(".//a[@class='asc']").isDisplayed();
        driver.findElementByXPath(".//tr/td[contains(.,'segmentName')]").isDisplayed();

    }
}
