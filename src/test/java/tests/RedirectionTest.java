package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.Set;

public class RedirectionTest extends BaseTest {

    /** Redirection to fb page
     * Steps:
     * 1. Navigate to https://www.psfashion.com/rs/sr/
     * 2. Click on a fb Button
     * 3. Navigated to new tab (fb page)
     * Expected results:
     * 3. Verify that user is on navigated to Facebook page
     */
    @Test
    public void termsRedirectionTest() {
        ChromeDriver driver = openChromeDriver();
        try {
            //1. Navigate to https://www.psfashion.com/rs/sr/
            HomePage homePage = new HomePage(driver);
            sleep(2);
            HomeRsPage homeRsPage = new HomeRsPage(driver);

            //2. Click on a fb Button
            homeRsPage.clickOnFbButton();
            sleep(5);

            //3. Navigated to new tab (fb page)
            homePage.handleWindows();
            sleep(5);

            //3. Verify that user is on navigated to Facebook page
            print("Verify that user is on navigated to Facebook page");
            String actualUrl = driver.getCurrentUrl();
            assert  actualUrl.equals(Strings.FB_URL) : "User is NOT on Facebook page. Expected: " + Strings.FB_URL+ "Actual: " + actualUrl;
        } finally {
            driver.quit();
        }
    }

    /** Redirection to the Privacy policy from Registration page
     * Steps:
     * 1. Navigate to https://www.psfashion.com/rs/sr/
     * 2. Click on an Account Button
     * 3. Click Nalog Button
     * 4. Click on a Privacy policy link
     * 5. Navigated to the Privacy policy page
     * Expected results:
     * 5. Verify that user is on navigated to Privacy policy page
     * 5. Verify that relevant text is shown.
     */
    @Test
    public void testPrivacyPolicyRedirection() {
        ChromeDriver driver = openChromeDriver();
        try {
            //1. Navigate to https://www.psfashion.com/rs/sr/
            HomePage homePage = new HomePage(driver);
            HomeRsPage homeRsPage = new HomeRsPage(driver);

            //2. Click on an Account Button
            homeRsPage.clickAccount();
            MojNalogPage mojNalogPage = new MojNalogPage(driver);

            //3. Click Nalog Button
            mojNalogPage.clickNalog();
            RegistracijaPage registracijaPage = new RegistracijaPage(driver);

            //4. Click on a Privacy policy link
            registracijaPage.clickPrivacyPolicyLink();

            //5. Navigated to the Privacy policy page
            homePage.handleWindows();
            sleep(5);

            //5. Verify that user is on navigated to Privacy policy page
            print("Verify that user is on navigated to Privacy policy page");
            String actualUrl = driver.getCurrentUrl();
            assert  actualUrl.equals(Strings.PRIVACY_POLICY_URL) : "User is NOT Facebook page. Expected: " + Strings.PRIVACY_POLICY_URL+ "Actual: " + actualUrl;

            //5. Verify that relevant text is shown
            print("Verify that relevant text is shown");
    	    String expectedTitle = "Opšti uslovi online kupovine – P....S....fashion";
    	    String actualTitle = driver.getTitle();
    	    Assert.assertEquals(actualTitle, expectedTitle);
    }finally {
            driver.quit();
        }
    }
}
