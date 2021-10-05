package pageObjects;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebPageObject {

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    @FindBy(css = "div[id='rso'] div[role='heading'][aria-level='3']")
    private List<WebElement> searchResults;

    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public List<WebElement> getSearchList() {
        return searchResults;
    }

    public Boolean checkIfSearchResultContainsText(String searchTeem) {
        for (WebElement searchItem : getSearchList()) {
            if (searchItem.getText().contains(searchTeem)) {
                return true;
            }
        }
        return false;
    }
}
