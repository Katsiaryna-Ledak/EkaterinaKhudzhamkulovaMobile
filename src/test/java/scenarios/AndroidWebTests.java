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

public class AndroidWebTests extends BaseTest {

    @Test(groups = {"web"}, description = "Make sure receiving relevant results by search in Google search page",
          dataProviderClass = DataProviders.class, dataProvider = "webTestData")
    public void testValidateSearchResults(String searchTerm, String site)
        throws NoSuchFieldException, IllegalAccessException, InstantiationException {

        // go to google page
        getDriver().get(site);

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

        // get list of the search results and check if it contains  our search term
        for (int i = 0; i < searchResults.size(); i++) {
            Assert.assertTrue(webPageObject.checkIfSearchResultContainsText(searchTerm),
                "Search results are not relevant");
        }
    }
}
