package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressResultPage extends BaseTest {
    WebDriver driver;
    @FindBy(xpath = "//span[text()='Knee Length' and @class]")
    WebElement kneeLengthCheckBox;
    @FindBy(xpath = "//*[@id=\"x-refine__group_1__0\"]/ul/li[1]/div/a/div/span/input")
    WebElement menWatchCheckBox;

    public DressResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnKneeLengthCheckBox(){
        kneeLengthCheckBox.click();
    }
    public void clickOnMenWatchCheckBox(){
        menWatchCheckBox.click();
    }

    public void scroll(int x, int y){
//        Actions actions = new Actions(driver);
        new Actions(driver).scrollByAmount(x, y).perform();
    }
}
