package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.*;


public class RegistrationTest extends BaseTest{

    /** Registered with all data
     * Steps:
     * 1. Navigate to https://www.psfashion.com/rs/sr/
     * 2. Click on an Account Button
     * 3. Click Nalog Button
     * 4. Registration user method - fill all field
     * Expected results:
     * 4. Verify that user is navigated to Potvrdite prijavu page
     * 4. Verify that relevant success message is shown
     */
@Test
    public void testSuccessRegistered() {
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

            //4. Registration user method - fill all field
            registrationUser(driver);
            PotvrditePrijavuPage potvrditePrijavuPage = new PotvrditePrijavuPage(driver);

            //4. Verify that user is navigated to Potvrdite prijavu page
            print("Verify that user is navigated to Potvrdite prijavu page");
            String actualUrl = driver.getCurrentUrl();
            assert  actualUrl.equals(Strings.POTVRDITE_PRIJAVU_URL) : "User is NOT Potvrdite prijavu page. Expected: " + Strings.POTVRDITE_PRIJAVU_URL+ "Actual: " + actualUrl;
            sleep(5);

            //4. Verify that relevant success message is shown
            print("Verify that relevant success message is shown");
            String actualMessageTitle = potvrditePrijavuPage.getCompleteHeaderText();
            assert actualMessageTitle.equals(Strings.ACCOUNT_HEADER_TEXT) : "Wrong message. Expected: " + Strings.ACCOUNT_HEADER_TEXT + " Actual: " + actualMessageTitle;
        }finally {
            driver.quit();
        }
    }

    /** Registered without First name
     * Steps:
     * 1. Navigate to https://www.psfashion.com/rs/sr/
     * 2. Click on an Account Button
     * 3. Click Nalog Button
     * 4. Fill all field except First name field
     * Expected results:
     * 4. Verify that user is NOT navigated to Potvrdite prijavu page
     * 4. Verify that relevant error message is shown
     */
    @Test
    public void testRegisteredWithoutName() {
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

            //4. Fill all field except First name field
            registracijaPage.enterTextEmailField(Strings.VALID_EMAIL);
            registracijaPage.enterTextLozinkaField(Strings.VALID_LOZINKA);
            registracijaPage.enterTextPonoviLozinkuField(Strings.VALID_PONOVLJENA_LOZINKA);
            registracijaPage.enterTextImeField("");
            registracijaPage.enterTextPrezimeField(Strings.VALID_PREZIME);
            registracijaPage.chooseZenskiPol();
            registracijaPage.enterTextAdresaField(Strings.VALID_ADRESA);
            registracijaPage.enterTextPostanskiBrojField(Strings.VALID_POSTANSKI_BROJ);
            registracijaPage.enterTextGradField(Strings.VALID_GRAD);
            registracijaPage.chooseDrzavu();
            registracijaPage.enterTextBrojTelefonaField(Strings.VALID_BROJ_TELEFONA);
            registracijaPage.enterTextDatumRodjenjaField(Strings.VALID_DATUM_RODJENJA);
            registracijaPage.enterTextZanimanjeField(Strings.VALID_ZANIMANJE);
            registracijaPage.chooseSms();
            registracijaPage.checkUsloviKoriscenja();
            registracijaPage.clickRegistrujSeButton();

            //4. Verify that user is NOT navigated to Potvrdite prijavu page
            print("Verify that user is NOT navigated to Potvrdite prijavu page");
            String actualUrl = driver.getCurrentUrl();
            assert  actualUrl.equals(Strings.REGISTRACIJA_URL) : "User is on Potvrdite prijavu page. Expected: " + Strings.REGISTRACIJA_URL + "Actual: " + actualUrl;

            //4. Verify that relevant error message is shown
            print("Verify that relevant error message is shown");
            sleep(5);
            String actualError = registracijaPage.getErrorMessageFirstName();
            assert actualError.contains(Strings.ERROR_MESSAGE_REGISTRACIJA) : "Wrong header. Expected: " + Strings.ERROR_MESSAGE_REGISTRACIJA + " Actual: " + actualError;
        }finally {
            driver.quit();
        }
    }

}
