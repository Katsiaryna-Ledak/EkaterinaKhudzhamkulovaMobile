package scenarios;

import dataProviders.DataProviders;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.WebPageObject;
import setup.BaseTest;
import utils.TestProperties;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Make sure receiving relevant results by search in Google search page",
          dataProviderClass = DataProviders.class, dataProvider = "webTestData")
    public void testValidateSearchResults(String searchTerm) throws NoSuchFieldException, IllegalAccessException, InstantiationException {

        // go to google page
        getDriver().get(TestProperties.getTestWebDataProperties().getProperty("GOOGLE_URL"));

        new WebDriverWait(getDriver(), 20).until(
            wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        WebPageObject webPageObject = new WebPageObject(getDriver());
        WebElement searchField = webPageObject.getSearchField();
        searchField.click();
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);

        // get list of search result
        List<WebElement> searchResults = webPageObject.getSearchList();
        Assert.assertFalse(searchResults.isEmpty());

        // get the first result in the result and check if it's relevant to our search term
        String firstResultInSearchBunch = searchResults.get(0).getText();
        Assert.assertTrue(firstResultInSearchBunch.contains(searchTerm));

    }
}
