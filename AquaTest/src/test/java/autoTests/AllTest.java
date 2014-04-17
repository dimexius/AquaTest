package autoTests;

import autoTests.Instruments.Driver;
import autoTests.Tests.*;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by dims on 16.04.14.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginToAqua.class,
        LoginFailed.class,
})

public class AllTest {

    @AfterClass
    public static void someAfter() {
        Driver.shutdown();
    }
}
