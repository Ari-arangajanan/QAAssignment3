package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    WebDriver driver;
    private String searchType;

    // Locators using @FindBy
    @FindBy(id = "gh-ac") // Search input field
    WebElement searchBox;

    @FindBy(id = "gh-search-btn") // Search button
    WebElement searchButton;
    @FindBy(id = "gh-cat")
    private WebElement selectCategoryBox;

    // Constructor to initialize elements
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to searchFor
    public void searchFor(String keyword) {
        searchBox.sendKeys(keyword);
        searchButton.click();
    }

    public void searchFor(String keyword, String category) {
        searchBox.sendKeys(keyword);
        selectOptionOnCategoryBox(category);
        searchButton.click();
    }
    public void typeOnSearchField(String value){
        searchBox.clear();
        searchBox.sendKeys(value);
    }
    public void selectOptionOnCategoryBox(String visibleText){
        searchType = visibleText;
        new Select(selectCategoryBox).selectByVisibleText(visibleText);
    }

    public void searchbutton(){
        searchButton.click();
    }






}
