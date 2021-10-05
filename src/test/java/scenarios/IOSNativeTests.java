package scenarios;

import dataProviders.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.BaseTest;

public class IOSNativeTests extends BaseTest {

    @Test(description = "Register a new account and sign in test in IOS device in EPAM cloud",
          dataProvider = "nativeTestData",
          dataProviderClass = DataProviders.class)
    public void simpleNativeTest(String userEmail, String userName, String userPassword) throws
        IllegalAccessException, NoSuchFieldException, InstantiationException {

        getPo().getWelement("registerBtn").click();
        getPo().getWelement("mailField").sendKeys(userEmail);
        getPo().getWelement("userNameField").sendKeys(userName);
        getPo().getWelement("passwordForNewAccountField").sendKeys(userPassword);
        getPo().getWelement("confirmPasswordField").sendKeys(userPassword);
        getPo().getWelement("registerNewAccountBtn").click();
        getPo().getWelement("loginEmailField").sendKeys(userEmail);
        getPo().getWelement("passwordField").sendKeys(userPassword);
        getPo().getWelement("signInBtn").click();

        String actualBudgetPageName = getPo().getWelement("budgetPageName").getText();
        String expectedBudgetPageName = "Budget";

        Assert.assertEquals(actualBudgetPageName, expectedBudgetPageName);
        System.out.println("Registration was successful");
    }
}
