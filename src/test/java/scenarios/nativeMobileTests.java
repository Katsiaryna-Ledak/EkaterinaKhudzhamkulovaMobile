package scenarios;

import dataProviders.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.NativeAppActions;
import setup.BaseTest;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "This simple test just click on the Sign In button")
    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        getPo().getWelement("signInBtn").click();
        System.out.println("Simplest Android native test done");
    }

    @Test(groups = {"native"}, description = "Register a new account and sign in test",
          dataProviderClass = DataProviders.class, dataProvider = "nativeTestData")
    public void testRegisterAccount(String userEmail, String userName, String userPassword) throws NoSuchFieldException, IllegalAccessException, InstantiationException {

        NativeAppActions.registerAccount(getPo(), userEmail, userName, userPassword);
        NativeAppActions.loginAccount(getPo(), userEmail, userPassword);

        String actualBudgetPageName = getPo().getWelement("budgetPageName").getText();
        String expectedBudgetPageName = "BudgetActivity";

        Assert.assertEquals(actualBudgetPageName, expectedBudgetPageName);
        System.out.println("Registration was successful");

    }
}
