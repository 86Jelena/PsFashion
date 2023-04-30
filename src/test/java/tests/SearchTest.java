package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.*;

public class SearchTest extends BaseTest {

    /** Search Blejzer and navigated to Search page
     * Steps:
     * 1. Navigate to https://www.psfashion.com/rs/sr/
     * 2. Enter text "blejzer" into search bar  and search
     * Expected results:
     * 2. Verify that user is on Search page
     * 2. Verify that first searched item contains relevant text (blejzer)
     */
    @Test
    public void testSearchBlejzer() {
        ChromeDriver driver = openChromeDriver();
        try {
            //1. Navigate to https://www.psfashion.com/rs/sr/
            HomePage homePage = new HomePage(driver);
            HomeRsPage homeRsPage = new HomeRsPage(driver);

            //2. Enter text "blejzer" into search bar and search
            homeRsPage.enterTextAndSearch("blejzer");
            sleep(5);
            SearchPage searchPage = new SearchPage(driver);

            //2. Verify that user is on Search page
            print("Verify that user is on Search page");
            assert searchPage.isPageLoaded() : "User is NOT on Search page";

            //2. Verify that first searched item contains relevant text (blejzer)
            print("Verify that first searched item contains relevant text (blejzer)");
            assert searchPage.verifyFirstItemContainsText("blejzer") : "Wrong item name. Expected: blejzer";
        }finally {
            driver.quit();
            }
        }

    /** Search by text (Blejzer) and choose from dropdown
     * Steps:
     * 1. Navigate to https://www.psfashion.com/rs/sr/
     * 2. Enter text "blejzer" into search field
     * 3. Select from dropdown by text (blejzer)
     * Expected results:
     * 3. Verify that user is on Item page
     */
@Test
    public void testSearchByTextAndChooseFromDropdown() {
        ChromeDriver driver = openChromeDriver();
        try {
            //1. Navigate to https://www.psfashion.com/rs/sr/
            HomePage homePage = new HomePage(driver);
            HomeRsPage homeRsPage = new HomeRsPage(driver);

            //2. Enter text "blejzer" into search field
            homePage.enterTextIntoSearchField("blejzer");

            //3. Select from dropdown by text (blejzer)
            homePage.selectFromDropdown("BLEJZER");

            //3. Verify that user is on Item page
            print("Verify that user is on Item page");
            String actualUrl = driver.getCurrentUrl();
            assert actualUrl.equals(Strings.ARTIKAL_URL) : "User is on search page. Expected: " + Strings.ARTIKAL_URL + "Actual: " + actualUrl;
        }finally {
            driver.quit();
        }
    }

}
