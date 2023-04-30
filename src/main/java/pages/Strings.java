package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.IdentityHashMap;
import java.util.List;

public class Strings {

    //URLS
    public static final String HOME_URL = "https://www.psfashion.com/";
    public static final String HOME_RS_URL = "https://www.psfashion.com/rs/sr/";
    public static final String MOJ_NALOG_URL = "https://www.psfashion.com/rs/sr/customer-area/moj-nalog/";
    public static final String PROIZVOD_URL = "https://www.psfashion.com/rs/sr/artikal/blejzer-15860101/";
    public static final String REGISTRACIJA_URL = "https://www.psfashion.com/rs/sr/registration/registracija/";
    public static final String POTVRDITE_PRIJAVU_URL = "https://www.psfashion.com/rs/sr/registration/potvrdite-prijavu/?no_cache=1&cHash=2657b09de7bb24552a5b5ea309da1cdc";
    public static final String ARTIKAL_URL = "https://www.psfashion.com/rs/sr/artikal/blejzer-14620301/";
    public static final String FB_URL = "https://www.facebook.com/PSfashion";
    public static final String PRIVACY_POLICY_URL = "https://www.psfashion.com/rs/sr/company/uslovi/opsti-uslovi-online-kupovine/";

    //CREDENTIALS
    public static final String VALID_EMAIL = "petrapetrovic@yahoo.com";
    public static final String INVALID_EMAIL = "petarpetrovic@yahoo.com";
    public static final String VALID_LOZINKA = "psfashion325";
    public static final String INVALID_LOZINKA = "psfashion";
    public static final String VALID_PONOVLJENA_LOZINKA = "psfashion325";
    public static final String VALID_IME = "Petra";
    public static final String VALID_PREZIME = "Petrovic";
    public static final String VALID_ADRESA = "Resavska";
    public static final String VALID_POSTANSKI_BROJ = "34000";
    public static final String VALID_GRAD = "Kragujevac";
    public static final String VALID_BROJ_TELEFONA = "060525252";
    public static final String VALID_DATUM_RODJENJA = "18101986";
    public static final String VALID_ZANIMANJE = "Profesor";

    //ERROR MESSAGES
    public static final String ERROR_MESSAGE_REGISTRACIJA = "Ovo polje je obavezno";
    public static final String ERROR_MESSAGE_LOGIN = "Greška pri login-u";
    public static final String ERROR_TEXT_LOGIN = "Došlo je do greške. Najverovatnije ste pogrešno uneli podatke. Upišite Vaše podatke tačno, pripazite na velika i mala slova. Ukoliko ste se upravo registrovali, potvrdite registraciju klikom na link iz e-maila koji Vam je poslat.";

    //HEADER TEXT/TITLE
    public static final String ACCOUNT_HEADER_TEXT = "Poslali smo Vam mail!";

}
