package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HomeRsPage;
import pages.ProizvodPage;

public class ShoppingTest extends BaseTest{

    /** Add Blejzer, size 34 to shopping cart
     * Steps:
     * 1. Navigate to https://www.psfashion.com/rs/sr/
     * 2. Click on Item (blejzer)
     * 3. Select size "36" and click to "add to cart" button
     * Expected results:
     * 3. Verify that cart preview is present
     * 3. Verify that number in shopping cart is changed
     */
@Test
    public void testAddOneItemToShoppingCart() {
        ChromeDriver driver = openChromeDriver();
        try {
            //1. Navigate to https://www.psfashion.com/rs/sr/
            HomePage homePage = new HomePage(driver);
            HomeRsPage homeRsPage = new HomeRsPage(driver);

            //2. Click on Item
            homeRsPage.clickOnItemFromProductsShopping("blejzer");
            ProizvodPage proizodPage = new ProizvodPage(driver);
            sleep(5);

            //3. Select size and click to "add to cart" button
            proizodPage.chooseItemSizeAndAddToCartButton("36");
            sleep(5);

            //3. Verify that cart preview is present
            print("Verify that cart preview is present");
            assert proizodPage.isPageLoaded1() : "User is NOT on Search page";

            //3. Verify that number in shopping cart is changed
            print("Verify that number in shopping cart is changed");
            String actualNumberOfItemsInCart = proizodPage.getNumberOfItemsInCart();
            assert actualNumberOfItemsInCart.equals("1") : "Wrong number of items.Expected" +
                    " 1. Actual " + actualNumberOfItemsInCart;
        }finally {
            driver.quit();
        }
    }


}
