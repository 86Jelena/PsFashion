package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PotvrditePrijavuPage extends BasePage{
    //WEB ELEMENT
    @FindBy (xpath = "//h4[text() = 'Poslali smo Vam mail!']")
    WebElement potvrdaPrijaveMessage;

    //CONSTRUCTOR
    public PotvrditePrijavuPage(ChromeDriver driver) {
        super(driver);
        driver.get(Strings.POTVRDITE_PRIJAVU_URL);
        PageFactory.initElements(driver, this);
        print("PotvrditePrijavuPage");
    }

    //METHOD

    /**
     * Shows message for success registration and other steps to confirm the same one.
     */
    public String getCompleteHeaderText() {
        return potvrdaPrijaveMessage.getText();
    }
}
