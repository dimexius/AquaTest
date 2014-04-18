package autoTests.Instruments;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by dims on 16.04.14.
 */
public class TestProperties {
    protected static Properties properties;

    protected static void loadProperties() {
        properties = new Properties();

        try {
            try (
                    FileInputStream inputStream = new FileInputStream("test.properties")
            ){
                properties.load(inputStream);
            } catch (IOException e) {
                throw new RuntimeException("Can't load test properties. Don't know what to test.", e);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        properties.putAll(System.getProperties());
    }



    public static String get(String key) {
        if (properties == null) {
            loadProperties();
        }
        return properties.getProperty(key);
    }
}
