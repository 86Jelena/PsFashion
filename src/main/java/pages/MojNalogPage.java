package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MojNalogPage extends BasePage{
    //WEB ELEMENTS
    @FindBy (xpath = "//a[@class = 'btn login-create-acc-button']")
    WebElement kreirajteNalogButton;
    @FindBy (xpath = "//input[@id = 'user']")
    WebElement emailLoginField;
    @FindBy (xpath = "//input[@id = 'pass']")
    WebElement lozinkaLoginField;
    @FindBy (xpath = "//input[@name = 'submit']")
    WebElement loginButton;
    @FindBy (xpath = "//h3[text() = 'Greška pri login-u']")
    WebElement errorMessageTittleLogin;
    @FindBy (xpath = "//div[@class = 'felogin-message error-message']")
    WebElement errorMessageTextLogin;
    ChromeDriver driver;

    //CONSTRUCTOR

    public MojNalogPage(ChromeDriver driver) {
        super(driver);
        driver.get(Strings.MOJ_NALOG_URL);
        PageFactory.initElements(driver, this);
        print("MojNalogPage");
    }

    //METHODS

    /**
     * Click on a Nalog button.
     */
    public void clickNalog() {
        print("clickNalog");
        kreirajteNalogButton.click();
    }

    /**
     * Enter text into Email Field.
     */
    public void enterTextEmailLoginField(String text) {
        print("enterTextEmailLoginField");
        emailLoginField.click();
        emailLoginField.sendKeys(text);
    }

    /**
     * Enter text into Lozinka Field.
     */
    public void enterTextLozinkaLoginField(String text) {
        print("enterTextLozinkaLoginField");
        lozinkaLoginField.click();
        lozinkaLoginField.sendKeys(text);
    }

    /**
     * Click on a Login button.
     */
    public void clickLoginButton() {
        print("clickLoginButton");
        loginButton.click();
    }

    /**
     * Shows relevant Login error message.
     */
    public String getLoginErrorMessageTitle() {
        print("getLoginErrorMessageTitle");
        return errorMessageTittleLogin.getText();
    }

    /**
     * Shows relevant Login error text.
     */
    public String getLoginErrorMessageText() {
        print("getLoginErrorMessageText");
        return errorMessageTextLogin.getText();
    }
}
