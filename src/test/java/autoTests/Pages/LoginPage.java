package autoTests.Pages;

import autoTests.Instruments.Driver;
import autoTests.Instruments.TestProperties;
import org.openqa.selenium.By;

/**
 * Created by dims on 16.04.14.
 */

    public class LoginPage {
        private Driver driver;

        public LoginPage(Driver driver) {
            this.driver = driver;
        }

        public HomePage loginTo(String userName, String userPassword){
            enterCredentials(userName, userPassword);
            return new HomePage(driver);

        }

        public void enterCredentials(String username, String userPassword) {
            driver.findElement(By.xpath(".//input[@id='username']")).sendKeys(username);
            driver.findElement(By.xpath(".//input[@id='password']")).sendKeys(userPassword);
            driver.findElement(By.xpath(".//button[contains(.,'LOGIN')]")).click();
        }

        public String getLoginText(){
            return driver.findElement(By.xpath("//button[contains(.,'Login')]")).getText();
        }


        // Unused method --  Login with incorrect username and userpassword
        public void failLogin() throws InterruptedException {
            LoginPage login = new LoginPage(driver);
            login.enterCredentials(TestProperties.get("userIncorrectLogin"), TestProperties.get("userIncorrectPassword"));
            driver.findElement(By.xpath(".//button[contains(.,'LOGIN')]")).click();

        }


        public void checkFooterLinks(){
            driver.findElementByXPath(".//a[@href='http://developers.oysterlabs.com/terms' and contains(.,'Terms')]").isDisplayed();
            driver.findElementByXPath(".//a[@href='http://developers.oysterlabs.com/privacy' and contains(.,'Privacy policy')]").isDisplayed();
            driver.findElementByXPath(".//a[@href='mailto:feedback@oysterlabs.com' and contains(.,'Feedback')]").isDisplayed();
            driver.findElementByXPath(".//a[@href='http://oysterlabs.com/#contact' and contains(.,'Contact us')]").isDisplayed();

        }


}

