package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Set;

public class SearchResultsPage {
    WebDriver driver;

    // Locator for the first product in the search results
    @FindBy(xpath = "//*[@id=\"item5786d204fd\"]/div/div[2]/a/div/span")
    WebElement firstProduct;

    @FindBy(xpath = "//*[@id=\"item5786d204fd\"]/div/div[2]/div[3]/div[1]/div[1]")
    WebElement itemPrice;

    @FindBy(xpath = "//a[@id=\"atcBtn_btn_1\"]")
    WebElement addtocart;




    // Constructor to initialize elements
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method Used In Products Page
    public void selectFirstProduct() {

        String mainWindowHandle = driver.getWindowHandle();
        firstProduct.click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }
    public double assertPrice (){
        String priceText = itemPrice.getText();
        System.out.println("Price of the first item: " + priceText);
        double actualPrice = Double.parseDouble(priceText.replace("$", "").replace(",", ""));
        System.out.println("Parsed Price: " + actualPrice);
        return actualPrice;
        }
    public void addtoCart(){
        addtocart.click();


    }
    }



