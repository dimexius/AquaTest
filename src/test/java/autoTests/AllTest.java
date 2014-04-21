package autoTests;

/**
 * Created by dims on 18.04.14.
 */

import autoTests.Instruments.Driver;
import autoTests.Instruments.LoginToAqua;
import autoTests.Tests.*;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


    @RunWith(Suite.class)
    @Suite.SuiteClasses({
            //LoginFailed.class,
            CreateSegment.class,

    })


    public class AllTest {

        @AfterClass
        public static void someAfter() {
         Driver.shutdown();
        }
    }

