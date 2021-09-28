package scenarios;

import dataProviders.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.NativePageObject;
import setup.BaseTest;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "This simple test just click on the Sign In button")
    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        getPo().getWelement("signInBtn").click();
        System.out.println("Simplest Android native test done");
    }

    @Test(groups = {"native"}, description = "Register a new account and sign in test",
          dataProviderClass = DataProviders.class, dataProvider = "nativeTestData")
    public void testRegisterAccount(String userEmail, String userName, String userPassword)
        throws NoSuchFieldException, IllegalAccessException, InstantiationException {

        NativePageObject nativePageObject = new NativePageObject(getDriver());

        //register new account
        nativePageObject.getRegisterBtn().click();
        nativePageObject.getMailField().sendKeys(userEmail);
        nativePageObject.getUserNameField().sendKeys(userName);
        nativePageObject.getPasswordForNewAccountField().sendKeys(userPassword);
        nativePageObject.getConfirmPasswordField().sendKeys(userPassword);
        nativePageObject.getRegisterNewAccountBtn().click();

        //login to account
        nativePageObject.getLoginField().sendKeys(userEmail);
        nativePageObject.getPasswordField().sendKeys(userPassword);
        nativePageObject.getSignInBtn().click();

        String actualBudgetPageName = getPo().getWelement("budgetPageName").getText();
        String expectedBudgetPageName = "BudgetActivity";

        Assert.assertEquals(actualBudgetPageName, expectedBudgetPageName);
        System.out.println("Registration was successful");
    }

    @Test(groups = {"native"}, description = "Login with wrong credentials",
          dataProviderClass = DataProviders.class, dataProvider = "wrongLoginTestData")
    public void testLoginWithWrongData(String wrongUserEmail, String wrongUserPassword, String correctEmail,
                                       String correctPassword, String correctName)
        throws NoSuchFieldException, IllegalAccessException, InstantiationException {

        NativePageObject nativePageObject = new NativePageObject(getDriver());

        // register new account
        nativePageObject.getRegisterBtn().click();
        nativePageObject.getMailField().sendKeys(correctEmail);
        nativePageObject.getUserNameField().sendKeys(correctName);
        nativePageObject.getPasswordForNewAccountField().sendKeys(correctPassword);
        nativePageObject.getConfirmPasswordField().sendKeys(correctPassword);
        nativePageObject.getRegisterNewAccountBtn().click();

        // provided wrong info for login
        nativePageObject.getLoginField().sendKeys(wrongUserEmail);
        nativePageObject.getPasswordField().sendKeys(wrongUserPassword);
        nativePageObject.getSignInBtn().click();

        // if error message is displayed, clear the fields
        if (nativePageObject.isSuggestionContainerShown() == true) {
            nativePageObject.getMailField().clear();
            nativePageObject.getPasswordField().clear();
        }

        // try to log in with correct data provided
        nativePageObject.getLoginField().sendKeys(correctEmail);
        nativePageObject.getPasswordField().sendKeys(correctPassword);
        nativePageObject.getSignInBtn().click();

        String actualBudgetPageName = getPo().getWelement("budgetPageName").getText();
        String expectedBudgetPageName = "BudgetActivity";

        Assert.assertEquals(actualBudgetPageName, expectedBudgetPageName);
        System.out.println("Registration was successful");
    }
}
