package scenarios;

import dataProviders.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.BaseTest;

public class NativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "Register a new account and sign in test",
          dataProviderClass = DataProviders.class, dataProvider = "nativeTestData")
    public void testRegisterAccount(String userEmail, String userName, String userPassword, String keyWord) throws NoSuchFieldException, IllegalAccessException, InstantiationException {

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

        Assert.assertTrue(actualBudgetPageName.startsWith(keyWord));
        System.out.println("Registration was successful");
    }
}
