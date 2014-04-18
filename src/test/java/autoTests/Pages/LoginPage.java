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

        public HomePage loginTo(String username, String userPassword){
            enterCredentials(username, userPassword);
            return new HomePage(driver);


        }

        private void enterCredentials(String username, String userPassword) {
            driver.findElement(By.xpath(".//input[@id='username']")).sendKeys(username);
            driver.findElement(By.xpath(".//input[@id='password']")).sendKeys(userPassword);
            driver.findElement(By.xpath(".//button[contains(.,'LOGIN')]")).click();
        }

        public String getLoginText(){
            return driver.findElement(By.xpath("//button[contains(.,'Login')]")).getText();
        }


        // Login with incorrect username and userpassword
        public void failLogin() throws InterruptedException {
            //driver.getFromBase("login");
            LoginPage login = new LoginPage(driver);

            login.enterCredentials(TestProperties.get("userIncorrectLogin"), TestProperties.get("userIncorrectPassword"));



        }

    }

