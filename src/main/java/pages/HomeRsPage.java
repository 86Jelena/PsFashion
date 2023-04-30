package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HomeRsPage extends BasePage {
    //WEB ELEMENTS
    @FindBy(xpath = "//div[@class = 'product-list-base--item-block']/parent::div//parent::div/parent::div[@class = 'slick-track']")
    WebElement productsList;
    @FindBy (xpath = "//*[@class = 'icon ic-Facebook']")
    WebElement fbButton;
    ChromeDriver driver;

    //CONSTRUCTOR
    public HomeRsPage(ChromeDriver driver) {
        super(driver);
        driver.get(Strings.HOME_RS_URL);
        PageFactory.initElements(driver, this);
        print("HomeRsPage");
    }

    //METHODS

    /**
     * Method clicks on item "blejzer" from product Wishlist.
     */
    public void clickOnItemFromProductsWishlist(String itemName) {
        print("clickOnItemFromProductsWishlist ( " + itemName + " )");
        waitForElement(productsList);
        scrollIntoView(productsList);
        List<WebElement> itemArray = productsList.findElements(By.xpath(".//a[@title = 'BLEJZER']"));
        for (int i = 0; i < itemArray.size(); i++) {
            WebElement item = itemArray.get(i);
            String itemTitle = item.getAttribute("title");
            if (itemTitle.equals(itemTitle)) {
                item.click();
                break;
            }
        }
    }

    /**
     * Method clicks on item "blejzer" from product shopping.
     */
    public void clickOnItemFromProductsShopping(String itemName) {
        print("clickOnItemFromProducts ( " + itemName + " )");
        waitForElement(productsList);
        scrollIntoView(productsList);
        List<WebElement> itemArray = productsList.findElements(By.xpath(".//a[@title = 'BLEJZER']//following-sibling::h3"));
        for (int i = 0; i < itemArray.size(); i++) {
            WebElement item = itemArray.get(i);
            String itemTitle = item.getAttribute("title");
            if (itemTitle.equals(itemTitle)) {
                item.click();
                break;
            }
        }
    }

    /**
     * Click on a Facebook button.
     */
    public void clickOnFbButton () {
        print("FbButton");
        waitForElement(fbButton);
        fbButton.click();
    }
}
