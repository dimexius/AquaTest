package autoTests.Instruments;

import com.google.common.base.Function;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dims on 16.04.14.
 */
public class JSWait extends WebDriverWait implements Function<WebDriver, Boolean> {
    protected String code;
    protected RemoteWebDriver driver;


    public JSWait(RemoteWebDriver driver, long timeOutInSeconds, long sleepInMillis) {
        super(driver, timeOutInSeconds, sleepInMillis);
        this.driver = driver;
    }

    /**
     * @param driver to wait for.
     * @param timeOutInSeconds how long wait until give up.
     */
    public JSWait(RemoteWebDriver driver, long timeOutInSeconds) {
        super(driver, timeOutInSeconds);
        this.driver = driver;
    }

    @Override
    public Boolean apply(WebDriver input) {
        return (Boolean) driver.executeScript(code);
    }

    /**
     * @param code that is used for checking status. Should contain <tt>return &lt;Boolean&gt;;</tt> at the end. true means end.
     */
    public void doWait(String code) {
        this.code = code;
        until(this);
    }

    @Override
    public String toString() {
        return code != null ? code : super.toString() + code;
    }




}