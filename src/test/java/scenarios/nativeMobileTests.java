package scenarios;

import dataProviders.DataProviders;
import java.io.File;
import java.io.IOException;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.NativePageObject;
import setup.BaseTest;
import utils.ScreenshotMaker;

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
    public void testLoginWithWrongData(String wrongUserEmail, String wrongUserPassword, String toastMessage, String pathToScreenshot)
        throws IOException, TesseractException {

        NativePageObject nativePageObject = new NativePageObject(getDriver());

        System.out.println("Starting test with wrong data");
        // provided wrong info for login
        nativePageObject.getLoginField().sendKeys(wrongUserEmail);
        nativePageObject.getPasswordField().sendKeys(wrongUserPassword);
        nativePageObject.getSignInBtn().click();

        System.out.println("Making a screenshot");
        // make the screenshot and search for toast message
        ScreenshotMaker sm = new ScreenshotMaker();
        boolean isToastMessageDisplayed = sm.verifyToastMessage(toastMessage, pathToScreenshot);

        if (isToastMessageDisplayed == true) {
            nativePageObject.getMailField().clear();
            nativePageObject.getPasswordField().clear();
        }

    }
}
