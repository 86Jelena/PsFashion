package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HomeRsPage;
import pages.ProizvodPage;

public class WishlistTest extends BaseTest{

    /** Add Blejzer to Wishlist
     * Steps:
     * 1. Navigate to  https://www.psfashion.com/rs/sr/
     * 2. Click on "wishlist button" to add blejzer
     * Expected results:
     * 2. Verify that number in Wishlist is changed
     */
    @Test
    public void testAddOneItemToWishlist() {
        ChromeDriver driver = openChromeDriver();
        try {

            //1. Navigate to  https://www.psfashion.com/rs/sr/
            HomePage homePage = new HomePage(driver);
            sleep(2);
            HomeRsPage homeRsPage = new HomeRsPage(driver);

            //2. Click on "wishlist button" to add blejzer
            homeRsPage.clickOnItemFromProductsWishlist("blejzer");

            //2. Verify that number in Wishlist is changed.
            print("Verify that number in Wishlist is changed");
            sleep(5);
            String actualNumberOfItemsInWishlist = homePage.getNumberOfHeartsInWishlist();
            assert actualNumberOfItemsInWishlist.equals("1") : "Wrong number of items.Expected: 1. Actual: " + actualNumberOfItemsInWishlist;
        }finally {
            driver.quit();
        }
    }
}
