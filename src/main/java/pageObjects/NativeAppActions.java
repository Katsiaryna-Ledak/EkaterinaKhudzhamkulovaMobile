package pageObjects;

import setup.IPageObject;

public class NativeAppActions {
    public static void registerAccount(IPageObject po, String userMail, String userName, String userPassword)
        throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        po.getWelement(NativeAppElements.REGISTER_BTN.getElementName()).click();
        po.getWelement(NativeAppElements.REGISTER_MAIL_FIELD.getElementName()).sendKeys(userMail);
        po.getWelement(NativeAppElements.REGISTER_NAME_FIELD.getElementName()).sendKeys(userName);
        po.getWelement(NativeAppElements.REGISTER_PASSWORD_FIELD.getElementName()).sendKeys(userPassword);
        po.getWelement(NativeAppElements.REGISTER_CONFIRM_PASSWORD_FIELD.getElementName()).sendKeys(userPassword);
        po.getWelement(NativeAppElements.REGISTER_ACC_BTN.getElementName()).click();
    }

    public static void loginAccount(IPageObject po, String userMail, String userPassword)
        throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        po.getWelement(NativeAppElements.LOGIN_FIELD.getElementName()).sendKeys(userMail);
        po.getWelement(NativeAppElements.PASSWORD_FIELD.getElementName()).sendKeys(userPassword);
        po.getWelement(NativeAppElements.SIGN_IN_BTN.getElementName()).click();
    }
}
