package pages;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class
HomePage extends BasePage {
    //WEB ELEMENT
    ChromeDriver driver;

    //CONSTRUCTOR
    public HomePage(ChromeDriver driver) {
        super(driver);
        driver.get(Strings.HOME_URL);
        PageFactory.initElements(driver, this);
        print("HomePage");
        this.clickCookie();
        this.clickAlert();
        sleep(10);
        this.clickPopup();
        this.clickCountry();
    }

}
