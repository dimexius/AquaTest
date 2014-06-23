package autoTests.Instruments;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/**
 * Created by dims on 16.04.14.
 */
public class Driver extends RemoteWebDriver {
    protected static Driver driver;

    protected static RemoteWebDriver getPhantomJSDriver(){
        return new PhantomJSDriver(new DesiredCapabilities());
    }

    protected static RemoteWebDriver getFirefoxDriver(){
        // For Windows :
        System.setProperty("webdriver.firefox.bin","C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
        // Or add its *.exe to %path%.
        //
        ProfilesIni allProfiles = new ProfilesIni();
        // PROFILE_NAME - имя профиля без указания пути, например, "default"
        FirefoxProfile profile = allProfiles.getProfile("default");
        return new FirefoxDriver(profile);
    }

    protected static RemoteWebDriver getChromeDriver(){
        System.setProperty("webdriver.chrome.driver", "/usr/bin/google-chrome");
        return new ChromeDriver(new DesiredCapabilities());

    }

    /**
     * Intended for use with suites - should be called after all are passed.
     * Separate tests should not call this, because they are launched for debugging needs only.
     */
    public static void shutdown() {
        // driver.manage().deleteAllCookies();
        driver.quit();
        driver = null;
    }
    protected static void createDriver() {
        RemoteWebDriver forWrap;
        switch (TestProperties.get("driverClass")) {
            case "PhantomJSDriver":
                forWrap = getPhantomJSDriver();
                break;
            case "FirefoxDriver":
                forWrap = getFirefoxDriver();
                break;
            case "ChromeDriver":
                forWrap = getChromeDriver();
                break;
            default:
                throw new RuntimeException("I don't know the driver you've specified.");
        }
        driver = new Driver(forWrap, TestProperties.get("appPath"));
        WebDriver.Options options = driver.manage();
        options.deleteAllCookies();
        //This is wait for element to appear on a page.
        options.timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(TestProperties.get("appPath"));
        //If Cookie is needed then uncomment ths row :  options.addCookie(new Cookie("Aqua_Cookie", TestProperties.get("cookieValue"), TestProperties.get("appPath")));
    }

    public static Driver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }


    protected final RemoteWebDriver wrapped;
    protected final JSWait waiter;
    protected final String baseUrl;

    protected Driver(RemoteWebDriver toWrapp, String baseUrl) {
        wrapped = toWrapp;
        waiter = new JSWait(toWrapp, 20, 200);
        this.baseUrl = baseUrl;
    }

    public void waitForAllRequests() {
        waiter.doWait("return window.!(Ext.Ajax.latestId in Ext.Ajax.requests);");
    }

    /**
     * Uses embedded waiter to wait until js code returns true.
     * Any errors in JS will propogate further.
     */
    public void waitByJS(String code) {
        waiter.doWait(code);
    }

    public void waitByJS(String code, long timeOutInSeconds) {
        waiter.withTimeout(timeOutInSeconds, TimeUnit.SECONDS);
        waiter.doWait(code);
    }

    public void getFromBase(String url) {wrapped.get(baseUrl + url);}

    @Override
    public void setFileDetector(FileDetector detector) {
        wrapped.setFileDetector(detector);
    }

    @Override
    public SessionId getSessionId() {
        return wrapped.getSessionId();
    }

    @Override
    public ErrorHandler getErrorHandler() {
        return wrapped.getErrorHandler();
    }

    @Override
    public CommandExecutor getCommandExecutor() {
        return wrapped.getCommandExecutor();
    }

    @Override
    public Capabilities getCapabilities() {
        return wrapped.getCapabilities();
    }

    @Override
    public void get(String url) {
        wrapped.get(url);
    }

    @Override
    public RemoteStatus getRemoteStatus() {
        return wrapped.getRemoteStatus();
    }

    @Override
    public String getTitle() {
        return wrapped.getTitle();
    }

    @Override
    public String getCurrentUrl() {
        return wrapped.getCurrentUrl();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return wrapped.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return wrapped.findElement(by);
    }

    @Override
    public WebElement findElementById(String using) {
        return wrapped.findElementById(using);
    }

    @Override
    public List<WebElement> findElementsById(String using) {
        return wrapped.findElementsById(using);
    }

    @Override
    public WebElement findElementByLinkText(String using) {
        return wrapped.findElementByLinkText(using);
    }

    @Override
    public List<WebElement> findElementsByLinkText(String using) {
        return wrapped.findElementsByLinkText(using);
    }

    @Override
    public WebElement findElementByPartialLinkText(String using) {
        return wrapped.findElementByPartialLinkText(using);
    }

    @Override
    public List<WebElement> findElementsByPartialLinkText(String using) {
        return wrapped.findElementsByPartialLinkText(using);
    }

    @Override
    public WebElement findElementByTagName(String using) {
        return wrapped.findElementByTagName(using);
    }

    @Override
    public List<WebElement> findElementsByTagName(String using) {
        return wrapped.findElementsByTagName(using);
    }

    @Override
    public WebElement findElementByName(String using) {
        return wrapped.findElementByName(using);
    }

    @Override
    public List<WebElement> findElementsByName(String using) {
        return wrapped.findElementsByName(using);
    }

    @Override
    public WebElement findElementByClassName(String using) {
        return wrapped.findElementByClassName(using);
    }

    @Override
    public List<WebElement> findElementsByClassName(String using) {
        return wrapped.findElementsByClassName(using);
    }

    @Override
    public WebElement findElementByCssSelector(String using) {
        return wrapped.findElementByCssSelector(using);
    }

    @Override
    public List<WebElement> findElementsByCssSelector(String using) {
        return wrapped.findElementsByCssSelector(using);
    }

    @Override
    public WebElement findElementByXPath(String using) {
        return wrapped.findElementByXPath(using);
    }

    @Override
    public List<WebElement> findElementsByXPath(String using) {
        return wrapped.findElementsByXPath(using);
    }

    @Override
    public String getPageSource() {
        return wrapped.getPageSource();
    }

    @Override
    public void close() {
        wrapped.close();
    }

    @Override
    public void quit() {
        wrapped.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return wrapped.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return wrapped.getWindowHandle();
    }

    @Override
    public Object executeScript(String script, Object... args) {
        return wrapped.executeScript(script, args);
    }

    @Override
    public Object executeAsyncScript(String script, Object... args) {
        return wrapped.executeAsyncScript(script, args);
    }

    @Override
    public TargetLocator switchTo() {
        return wrapped.switchTo();
    }

    @Override
    public Navigation navigate() {
        return wrapped.navigate();
    }

    @Override
    public Options manage() {
        return wrapped.manage();
    }

    @Override
    public void setLogLevel(Level level) {
        wrapped.setLogLevel(level);
    }

    @Override
    public Mouse getMouse() {
        return wrapped.getMouse();
    }

    @Override
    public FileDetector getFileDetector() {
        return wrapped.getFileDetector();
    }

    @Override
    public String toString() {
        return wrapped.toString();
    }

    @Override
    public Keyboard getKeyboard() {
        return wrapped.getKeyboard();
    }
}


