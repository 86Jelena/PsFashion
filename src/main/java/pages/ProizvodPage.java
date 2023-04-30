package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProizvodPage extends BasePage {
    //WEBELEMENTS

    @FindBy(xpath = "//span[@class = 'product-btn-cart addProductToCart ajaxCartAction displayInlineBlock']")
    WebElement addToCartButton;
    @FindBy (xpath = "//label[@class = 'product-sizeselect']")
    WebElement productSizeButton;
    @FindBy (xpath = "//*[@id = 'cart-preview']")
    WebElement cartPreview;

    //CONSTRUCTOR
    public ProizvodPage(ChromeDriver driver) {
        super(driver);
        driver.get(Strings.PROIZVOD_URL);
        print("ProizvodPage");
    }

    //METHODS

    /**
     * Method describe how to choose item size from has stock list and add to cart button.
     */
    public void chooseItemSizeAndAddToCartButton(String text) {
        waitForElement(addToCartButton);

        List<WebElement> hasStockSizes = driver.findElements(By.xpath("//label[@class = 'product-sizeselect']"));
        for (int i = 0; i < hasStockSizes.size(); i++) {
            String itemSize = hasStockSizes.get(i).getText();
            if(itemSize.equals("34")) {
                clickProductSize();
            }else if(itemSize.equals("36")) {
                clickProductSize();
            }else if(itemSize.equals("38")) {
                clickProductSize();
            }else if(itemSize.equals("40")) {
                clickProductSize();
            }else if(itemSize.equals("42")) {
                clickProductSize();
                break;
        }
            addToCartButton.click();
        }
    }

    /**
     * Click on a item size.
     */
    public void clickProductSize() {
        waitForElement(productSizeButton);
        productSizeButton.click();
    }

    /**
     * Method for loading all searched web elements.
     */
    public boolean isPageLoaded1() {
        waitForElement(cartPreview);
        return isElementPresent(cartPreview);
    }
}



