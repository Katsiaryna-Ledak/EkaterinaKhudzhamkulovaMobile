package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
    private static Properties testNativeDataProperties;
    private static Properties testWebDataProperties;
    private static String NativeDataPropsPath = "src/main/resources/testnative.properties";
    private static String WebDataPropsPath = "src/main/resources/testweb.properties";

    static {
        testNativeDataProperties = new Properties();
        testWebDataProperties = new Properties();
        try (InputStream in = new FileInputStream(NativeDataPropsPath);
             InputStream in2 = new FileInputStream(WebDataPropsPath)){
            testNativeDataProperties.load(in);
            testWebDataProperties.load(in2);
        }catch (IOException ex){
            System.out.println("Can not load properties file");
            ex.printStackTrace();
        }
    }

    public static Properties getTestNativeDataProperties() {
        return testNativeDataProperties;
    }

    public static Properties getTestWebDataProperties() {
        return testWebDataProperties;
    }
}
