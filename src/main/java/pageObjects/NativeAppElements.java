package pageObjects;

public enum NativeAppElements {
    SIGN_IN_BTN("signInBtn"),
    LOGIN_FIELD("loginField"),
    PASSWORD_FIELD("passwordField"),
    REGISTER_BTN("registerBtn"),
    REGISTER_MAIL_FIELD("mailField"),
    REGISTER_NAME_FIELD("userNameField"),
    REGISTER_PASSWORD_FIELD("passwordForNewAccountField"),
    REGISTER_CONFIRM_PASSWORD_FIELD("confirmPasswordField"),
    REGISTER_ACC_BTN("registerNewAccountBtn");

    String elementName;

    public String getElementName() {
        return elementName;
    }

    NativeAppElements(String elementName) {
        this.elementName = elementName;
    }
}
