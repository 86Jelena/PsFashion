package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistracijaPage extends BasePage{
    //WEB ELEMENTS
    @FindBy(xpath = "//input[@name = 'tx_intregister_registerform[newUser][email]']")
    WebElement emailField;
    @FindBy (xpath = "//input[@id = 'registerPasswordRepeat']")
    WebElement lozinkaField;
    @FindBy (xpath = "//input[@name = 'tx_intregister_registerform[newUser][passwordRepeat]']")
    WebElement ponoviLozinkuField;
    @FindBy (xpath = "//input[@name = 'tx_intregister_registerform[newUser][firstName]']")
    WebElement imeFiled;
    @FindBy (xpath = "//input[@name = 'tx_intregister_registerform[newUser][lastName]']")
    WebElement prezimeField;
    @FindBy (xpath = "//span[text() = 'ženski']")
    WebElement zenskiPolRadioButton;
    @FindBy (xpath = "//input[@name = 'tx_intregister_registerform[newUser][address]']")
    WebElement adresaField;
    @FindBy (xpath = "//input[@name = 'tx_intregister_registerform[newUser][zip]']")
    WebElement postanskiBrojField;
    @FindBy (xpath = "//input[@name = 'tx_intregister_registerform[newUser][city]']")
    WebElement gradField;
    @FindBy (xpath = "//span[text() = 'Srbija']")
    WebElement drzavaSrbijaRadioButton;
    @FindBy (xpath = "//input[@name = 'tx_intregister_registerform[newUser][telephone]']")
    WebElement brojTelefonaField;
    @FindBy (xpath = "//input[@name = 'tx_intregister_registerform[newUser][birthdate]']")
    WebElement datumRodjenjaField;
    @FindBy (xpath = "//input[@name = 'tx_intregister_registerform[newUser][occupation]']")
    WebElement zanimanjeField;
    @FindBy (xpath = "//span[text() = 'Informišite me putem SMS-a']")
    WebElement smsCheckBox;
    @FindBy (xpath = "//input[@name = 'tx_intregister_registerform[newUser][tocaccepted]']//following-sibling::span[1]")
    WebElement usloviKoriscenjaCheckBox;
    @FindBy (xpath = "//input[@class = 'btn-middle']")
    WebElement registrujSeButton;
    @FindBy (xpath = "//p[@id = 'tx_intregister_registerform[newUser][firstName]-error']")
    WebElement errorMessageFirstName;
    @FindBy (xpath = "//*[text() = 'ovde']")
    WebElement privacyPolicyLink;
    ChromeDriver driver;

    //CONSTRUCTOR

    public RegistracijaPage(ChromeDriver driver) {
        super(driver);
        driver.get(Strings.REGISTRACIJA_URL);
        PageFactory.initElements(driver, this);
        print("RegistracijaPage");
    }

    //METHODS

    /**
     * Enter text into Email Field.
     */
    public void enterTextEmailField(String text) {
        print("enterTextEmailField");
        emailField.click();
        emailField.sendKeys(text);
    }

    /**
     * Enter text into Lozinka Field.
     */
    public void enterTextLozinkaField(String text) {
        print("enterTextLozinkaField");
        lozinkaField.click();
        lozinkaField.sendKeys(text);
    }

    /**
     * Enter text into Ponovi Lozinka Field.
     */
    public void enterTextPonoviLozinkuField(String text) {
        print("enterTextPonoviLozinkuField");
        ponoviLozinkuField.click();
        ponoviLozinkuField.sendKeys(text);
    }

    /**
     * Enter text into Ime Field.
     */
    public void enterTextImeField(String text) {
        print("enterTextImeField");
        imeFiled.click();
        imeFiled.sendKeys(text);
    }

    /**
     * Enter text into Prezime Field.
     */
    public void enterTextPrezimeField(String text) {
        print("enterTextPrezimeField");
        prezimeField.click();
        prezimeField.sendKeys(text);
    }

    /**
     * Select Zenski.
     */
    public void chooseZenskiPol() {
        print("chooseZenskiPol");
        zenskiPolRadioButton.click();
    }

    /**
     * Enter text into Adresa Field.
     */
    public void enterTextAdresaField(String text) {
        print("enterTextAdresaField");
        adresaField.click();
        adresaField.sendKeys(text);
    }

    /**
     * Enter text into Postanski broj Field.
     */
    public void enterTextPostanskiBrojField(String text) {
        print("enterTextPostanskiBrojField");
        postanskiBrojField.click();
        postanskiBrojField.sendKeys(text);
    }

    /**
     * Enter text into Grad Field.
     */
    public void enterTextGradField(String text) {
        print("enterTextGradField");
        gradField.click();
        gradField.sendKeys(text);
    }

    /**
     * Select Srbija.
     */
    public void chooseDrzavu() {
        print("chooseDrzavu");
        waitForElement(drzavaSrbijaRadioButton);
        scrollIntoView(drzavaSrbijaRadioButton);
        drzavaSrbijaRadioButton.click();
    }

    /**
     * Enter text into Broj telefona Field.
     */
    public void enterTextBrojTelefonaField(String text) {
        print("enterTextBrojTelefonaField");
        waitForElement(brojTelefonaField);
        scrollIntoView(brojTelefonaField);
        brojTelefonaField.click();
        brojTelefonaField.sendKeys(text);
    }

    /**
     * Enter text into Datum rodjenja Field.
     */
    public void enterTextDatumRodjenjaField(String text) {
        print("enterTextDatumRodjenjaField");
        waitForElement(datumRodjenjaField);
        scrollIntoView(datumRodjenjaField);
        datumRodjenjaField.click();
        datumRodjenjaField.sendKeys(text);
    }

    /**
     * Enter text into Zanimanje Field.
     */
    public void enterTextZanimanjeField(String text) {
        print("enterTextZanimanjeField");
        waitForElement(zanimanjeField);
        scrollIntoView(zanimanjeField);
        zanimanjeField.click();
        zanimanjeField.sendKeys(text);
    }

    /**
     * Select SMS.
     */
    public void chooseSms() {
        print("chooseSms");
        waitForElement(smsCheckBox);
        scrollIntoView(smsCheckBox);
        smsCheckBox.click();
    }

    /**
     * Select Uslovi koriscenja..
     */
    public void checkUsloviKoriscenja() {
        print("checkUsloviKoriscenja");
        waitForElement(usloviKoriscenjaCheckBox);
        scrollIntoView(usloviKoriscenjaCheckBox);
        usloviKoriscenjaCheckBox.click();
    }

    /**
     * Click on a Registruj se Button.
     */
    public void clickRegistrujSeButton() {
        print("enterTextEmailField");
        waitForElement(registrujSeButton);
        scrollIntoView(registrujSeButton);
        registrujSeButton.click();
    }

    /**
     * Shows First name error message.
     */
    public String getErrorMessageFirstName() {
        print("getErrorMessageFirstName");
        return errorMessageFirstName.getText();
    }

    /**
     * Click on a Privacy policy link.
     */
    public void clickPrivacyPolicyLink() {
        print("clickPrivacyPolicyLink");
        waitForElement(privacyPolicyLink);
        scrollIntoView(privacyPolicyLink);
        privacyPolicyLink.click();
    }

}
