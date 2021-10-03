package dataProviders;

import org.testng.annotations.DataProvider;
import utils.TestProperties;

public class DataProviders {

    @DataProvider(name = "nativeTestData")
    public static Object[][] nativeTestData(){
        return new Object[][]{{
            TestProperties.getTestNativeDataProperties().getProperty("USER_EMAIL"),
            TestProperties.getTestNativeDataProperties().getProperty("USER_NAME"),
            TestProperties.getTestNativeDataProperties().getProperty("USER_PASSWORD")}};
    }

    @DataProvider(name = "webTestData")
    public static Object[][] webTestTerm(){
        return new Object[][]{{
            TestProperties.getTestWebDataProperties().getProperty("KEY_WORD"),
            TestProperties.getTestWebDataProperties().getProperty("GOOGLE_URL")}};
    }

}
