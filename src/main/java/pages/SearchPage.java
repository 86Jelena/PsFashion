package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends BasePage{
    //WEB ELEMENTS

    @FindBy (xpath = "//ul[@class = 'tx-indexedsearch-browsebox']")
    WebElement productCategory;
    @FindBy (xpath = "//div[@class = 'c-2-1-inner ']")
    WebElement listOfProductTiles;
    ChromeDriver driver;

    //CONSTRUCTOR

    public SearchPage(ChromeDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        print("SearchPage");
    }

    //METHODS

    /**
     * Method for loading all searched web elements.
     */
    public boolean isPageLoaded() {
        waitForElement(productCategory);
        return isElementPresent(productCategory);
    }

    /**
     * List of all searched products.
     */
    public List<WebElement> getAllProducts() {
        return listOfProductTiles.findElements(By.xpath(".//div[@class = 'product-list-base--item view-in']"));
    }

    /**
     * Verify that first product from searched list contains text that is searching for.
     */
    public boolean verifyFirstItemContainsText(String text) {
        List<WebElement> itemList = getAllProducts();
        WebElement firstItem = itemList.get(0);
        String itemName = firstItem.findElement(By.xpath(".//a[@data-product = '114370']//following::h3")).getText().toLowerCase();
        return itemName.contains(text);
    }

}
