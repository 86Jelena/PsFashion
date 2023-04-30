package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BasePage {

    //WEB ELEMENTS

    @FindBy(xpath = "//div[@class = 'edrone-onsite-popup-content__content-wrapper']/div/div[2]")
    WebElement closeButtonPopup;
    @FindBy(xpath = "//iframe[@id = 'edrone-onsite-popup-iframe']")
    WebElement iframe;
    @FindBy(xpath = "//*[@id = 'cookiescript_accept']")
    WebElement cookieAcceptButton;
    @FindBy(xpath = "//*[@id = 'alert_box_btn_close']")
    WebElement alertCloseButton;
    @FindBy(xpath = "//*[text() = 'Srbija']")
    WebElement countryAcceptButton;
    @FindBy(xpath = "//*[@class = 'icon ic-account-top']")
    WebElement accountButton;
    @FindBy(xpath = "//input[@class = 'header-search-desktop-input autocomplete']")
    WebElement searchField;
    @FindBy(xpath = "//button[@class = 'ic-search-top-btn']")
    WebElement searchButton;
    @FindBy(xpath = "//div[@class = 'search-autocomplete-box']")
    WebElement searchSuggestionDropdown;
    @FindBy (xpath = "//span[text() = ' Korpa ']")
    WebElement shoppingCart;
    @FindBy (xpath = "//*[@class ='prod-counter']//parent::a//parent::li//parent::ul")
    WebElement cartNumberOfItems;
    @FindBy (xpath = "//a[@class = 'wishlist-toggle ']/span[@class = 'prod-counter']")
    WebElement cartNumberOfHearts;
    ChromeDriver driver;

    //CONSTRUCTORS
    public BasePage() {
    }
    public BasePage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //METHODS

    /**
     * Enter text into search field.
     */
    public void enterTextIntoSearchField(String text) {
        print("TextIntoSearchField");
        searchField.click();
        searchField.sendKeys(text);
    }

    /**
     * Click on a search button.
     */
    public void clickSearchButton() {
        print("SearchButton");
        searchButton.click();
    }

    /**
     * Enter text and search.
     */
    public void enterTextAndSearch(String text) {
        print("TextAndSearch");
        enterTextIntoSearchField(text);
        clickSearchButton();
    }

    /**
     * Click on a cookie button "Prihvati sve".
     */
    public void clickCookie () {
        print("Cookie");
        waitForElement(cookieAcceptButton);
        cookieAcceptButton.click();
    }

    /**
     * Click on an alert button "NO".
     */
    public void clickAlert () {
        print("Alert");
        waitForElement(alertCloseButton);
        alertCloseButton.click();
    }

    /**
     * Click on a close Popup button.
     */
    public void clickPopup() {
        print("Popup");
        waitForElement(iframe);
        driver.switchTo().frame(iframe);
        closeButtonPopup.click();
        driver.switchTo().defaultContent();
    }

    /**
     * Click on a relevant country etc. "Srbija".
     */
    public void clickCountry () {
        print("Country");
        waitForElement(countryAcceptButton);
        countryAcceptButton.click();
    }

    /**
     * Shows number of items in shopping cart.
     */
    public String getNumberOfItemsInCart() {
        print("GetNumberOfItemsInCart");
        assert isElementPresent(cartNumberOfItems) : "Cart Number is NOT present";
        scrollIntoView(cartNumberOfItems);
        waitForElement(cartNumberOfItems);
        return cartNumberOfItems.getText();
    }

    /**
     * Method select from dropdown List of WebElements "blejzer" and redirect to the product page.
     */
    public void selectFromDropdown(String text) {
        print("SelectFromDropdown");
        waitForElement(searchSuggestionDropdown);
        List<WebElement> listOfSearchSuggestions = searchSuggestionDropdown.findElements(By.xpath("//div[@class = 'search-autocomplete-box']/div/div/div/div/div/div/h3/a"));
        for (WebElement suggestion : listOfSearchSuggestions) {
            String suggestionText = suggestion.getText();
            if (suggestionText.equals(text)) {
                hoverOverElement(suggestion);
                suggestion.click();
                break;
            }
        }
    }

    /**
     * Click on an account button.
     */
    public void clickAccount () {
        print("Account");
        accountButton.click();
    }

    /**
     * Shows number of hearts in Wishlist.
     */
    public String getNumberOfHeartsInWishlist() {
        print("GetNumberOfHeartsInWishlist");
        assert isElementPresent(cartNumberOfHearts) : "Hearts number is NOT present";
        scrollIntoView(cartNumberOfHearts);
        waitForElement(cartNumberOfHearts);
        return cartNumberOfHearts.getText();
    }

    /**
     * Method performs the mouse hover action on the target element.
     */
    public void hoverOverElement(WebElement element) {
        print("HoverOverElement");
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(element).perform();
    }

    /**
     * Method checks if relevant web element is present.
     */
    public boolean isElementPresent(WebElement element) {
        try {
            print("IsElementPresent()");
            boolean isPresent = element.isDisplayed();
            return isPresent;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method for scrolling up or down.
     */
    public void scrollIntoView(WebElement element) {
        print("ScrollIntoView");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Method checks the visibility of an element in a page.
     */
    public void waitForElement(WebElement element) {
        print("WaitForElement");
        WebDriverWait wait = new WebDriverWait(driver, 70);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Method for handling Windows.
     */
    public void handleWindows() {
        Set<String> allWindows = driver.getWindowHandles();

        for (String handle : allWindows) {
            driver.switchTo().window(handle);
        }
    }

    /**
     * Method suspends the code for a specific amount of time.
     */
    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            print(e.getMessage());
        }
    }
    /**
     * Method checks if relevant web element is enabled.
     */
    public boolean isElementEnabled(WebElement element) {
        try {
            print("isElementEnabled()");
            boolean isEnabled = element.isEnabled();
            return isEnabled;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method for handling Tabs.
     */
    public void handleTabs() {
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        driver.switchTo().window(tabs.get(0));
    }

    /**
     * Print.
     */
        public static void print (String s){System.out.println(s);
        }
}

