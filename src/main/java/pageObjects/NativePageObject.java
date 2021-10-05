package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NativePageObject {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Sign In']")
    WebElement signInBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    WebElement loginEmailField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    WebElement passwordField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Register new account']")
    WebElement registerBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    WebElement mailField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='TimApple']")
    WebElement userNameField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    WebElement passwordForNewAccountField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Repeat please']")
    WebElement confirmPasswordField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Register new account']")
    WebElement registerNewAccountBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/" +
        "android.widget.LinearLayout/android.widget.FrameLayout/android." +
        "view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/" +
        "android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Budget']")
    WebElement budgetPageName;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/TextInputLayout[1]/android.widget.FrameLayout/android.widget.EditText")
    WebElement suggestionContainer;

    public NativePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public WebElement getRegisterBtn() {
        return registerBtn;
    }

    public WebElement getMailField() {
        return mailField;
    }

    public WebElement getUserNameField() {
        return userNameField;
    }

    public WebElement getPasswordForNewAccountField() {
        return passwordForNewAccountField;
    }

    public WebElement getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public WebElement getRegisterNewAccountBtn() {
        return registerNewAccountBtn;
    }

    public WebElement getLoginEmailField() {
        return loginEmailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getSignInBtn() {
        return signInBtn;
    }
}
