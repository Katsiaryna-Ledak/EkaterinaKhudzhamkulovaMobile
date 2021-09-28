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

    public static Properties getTestNativeDataProperties() {
        testNativeDataProperties = new Properties();
        try (InputStream in = new FileInputStream(NativeDataPropsPath)){
            testNativeDataProperties.load(in);
        }catch (IOException ex){
            System.out.println("Can not load properties file");
            ex.printStackTrace();
        }
        return testNativeDataProperties;
    }

    public static Properties getTestWebDataProperties() {
        testWebDataProperties = new Properties();
        try (InputStream in = new FileInputStream(WebDataPropsPath)){
            testWebDataProperties.load(in);
        }catch (IOException ex){
            System.out.println("Can not load properties file");
            ex.printStackTrace();
        }
        return testWebDataProperties;
    }
}
