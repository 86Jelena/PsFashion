package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistracijaPage;
import pages.Strings;

public class BaseTest {
    public ChromeDriver openChromeDriver () {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--start-maximized"});
        options.addArguments(new String[]{"--ignore-certificate-errors"});
        options.addArguments(new String[]{"--disable-popup-blocking"});
        options.addArguments(new String[]{"--incognito"});
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        ChromeDriver driver = new ChromeDriver(options);
        driver.get(Strings.HOME_URL);
        return driver;
    }

    /**
     * Method suspends the code for a specific amount of time.
     */
    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds*3000);
        }catch (Exception e) {
            print(e.getMessage());
        }
    }

    /**
     * Method for registration.
     */
    public void registrationUser(ChromeDriver driver) {
        RegistracijaPage registracijaPage = new RegistracijaPage(driver);
        registracijaPage.enterTextEmailField(Strings.VALID_EMAIL);
        registracijaPage.enterTextLozinkaField(Strings.VALID_LOZINKA);
        registracijaPage.enterTextPonoviLozinkuField(Strings.VALID_PONOVLJENA_LOZINKA);
        registracijaPage.enterTextImeField(Strings.VALID_IME);
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

        assert driver.getCurrentUrl().equals(Strings.POTVRDITE_PRIJAVU_URL) : "User is NOT logged in" +
                ". Current url : " + driver.getCurrentUrl() + " . Expected: " + Strings.POTVRDITE_PRIJAVU_URL;
    }

    /**
     * Print.
     */
    public static void print(String s) {
        System.out.println(s);
    }
}
