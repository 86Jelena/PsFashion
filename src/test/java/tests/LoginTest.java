package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HomeRsPage;
import pages.MojNalogPage;
import pages.Strings;

public class LoginTest extends BaseTest{

    /** Login with Invalid Credentials
     * Steps:
     * 1. Navigate to https://www.psfashion.com/rs/sr/
     * 2. Click on an Account Button
     * 3. Enter text into Email Field
     * 4. Enter text into Lozinka Field
     * 5. Click on a Login Button
     * Expected results:
     * 5. Verify that user is still on Moj Nalog page
     * 5. Verify that relevant error message is shown
     */
    @Test
    public void testLoginWithInvalidCredentials() {
        ChromeDriver driver = openChromeDriver();

        try {
            //1. Navigate to https://www.psfashion.com/rs/sr/
            HomePage homePage = new HomePage(driver);
            HomeRsPage homeRsPage = new HomeRsPage(driver);

            //2. Click on an Account Button
            homeRsPage.clickAccount();
            MojNalogPage mojNalogPage = new MojNalogPage(driver);

            //3. Enter text into Email Field
            mojNalogPage.enterTextEmailLoginField(Strings.INVALID_EMAIL);

            //4. Enter text into Lozinka Field
            mojNalogPage.enterTextLozinkaLoginField(Strings.INVALID_LOZINKA);

            //5.Click on a Login Button
            mojNalogPage.clickLoginButton();

            //5. Verify that user is still on Moj Nalog page
            print("Verify that user is still on MojNalog page");
            String actualUrl = driver.getCurrentUrl();
            assert actualUrl.equals(Strings.MOJ_NALOG_URL) : "User is navigated to home page. Expected: " + Strings.MOJ_NALOG_URL + " Actual: " + actualUrl;

            //5. Verify that relevant error message is shown
            print("Verify that relevant error message is shown");

            sleep(5);
            String actualErrorMessage = mojNalogPage.getLoginErrorMessageTitle();
            assert actualErrorMessage.equals(Strings.ERROR_MESSAGE_LOGIN) : "Wrong error message. Expected: " + Strings.ERROR_MESSAGE_LOGIN + " Actual: " + actualErrorMessage;

            String actualErrorMessageText = mojNalogPage.getLoginErrorMessageText();
            assert actualErrorMessageText.equals(Strings.ERROR_TEXT_LOGIN) : "Wrong error message. Expected: " + Strings.ERROR_TEXT_LOGIN + " Actual: " + actualErrorMessageText;

        }finally {
            driver.quit();
        }
    }
}
