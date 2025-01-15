package TestCases;

import Base.BaseTest;
import Pages.DressResultPage;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.SearchResultsPage;
import Utils.ExcelHandler;
import Utils.ScreenShots;
import org.testng.annotations.Test;

public class SearchbyCategoryTestCase extends BaseTest {

    @Test
    public void searchDressTC() throws InterruptedException {

        // Read data

        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ProductPage productPage = new ProductPage(driver);
        DressResultPage dressResultPage = new DressResultPage(driver);

        // Initialize Excel Information
        String excelFilePath = "src/test/resources/testdata/TestData.xlsx";
        String sheetName = "Data";

        // Initialize ExcelUtils
        ExcelHandler excel = new ExcelHandler(excelFilePath, sheetName);

        // Read data
        String dress = excel.getCellData(2, 1); // Row 1, Column 1
        String dressCategory = excel.getCellData(3, 1); // Row 1, Column 1


        // Step 1: Search for dress using category option
        homePage.searchFor(dress, dressCategory);
        dressResultPage.scroll(0, 200);
        Thread.sleep(3000);
        dressResultPage.clickOnKneeLengthCheckBox();

        Thread.sleep(5000);

        setReportName("Search Dress Test Case");
        startTest("Search Dress Test Case");
        test = extent.createTest("Successful Searched", "System Successfully searched the item and get the result");
        String screenshotPath1 = ScreenShots.takeScreenshot(driver, "SuccessfulSearch");
        test.pass("System Successfully searched the item and get the result").addScreenCaptureFromPath(screenshotPath1);

    }
}

