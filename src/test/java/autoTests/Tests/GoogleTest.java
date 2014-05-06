package autoTests.Tests;

import autoTests.Instruments.Driver;
import org.junit.Test;
import org.openqa.selenium.Keys;

/**
 * Created by dims on 06.05.14.
 */
public class GoogleTest {
    private Driver driver;

    @Test
    public void testGoogle() throws InterruptedException {

        driver = Driver.getDriver();

        driver.get("http://google.com");

        driver.findElementByXPath(".//input[@name='q']").sendKeys("Selenium Documentation — Selenium Documentation");
        driver.findElementByXPath(".//button[@name='btnG']").click();
        driver.findElementByXPath(".//li[@class='g'][1]/div/h3/a").click();
        String url = driver.getCurrentUrl().toString();
        System.out.print(url);
        driver.findElementByXPath(".//*[@id='side']/div[3]/form/input[3]").click();
        driver.findElementByXPath(".//*[@id='amount']").sendKeys("55");
        driver.findElementByXPath(".//*[@id='amount']").sendKeys(Keys.ENTER);



               // driver.shutdown();
    }




}
