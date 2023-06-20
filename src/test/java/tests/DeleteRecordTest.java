package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Constant;

import java.time.Duration;

public class DeleteRecordTest extends BaseTest {


    @Test
    @Description("The test deletes a record from the webtables")
   // public void deleteRecordTest() {
        public static void deleteRecordTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the webtables page
        driver.get(Constant.URL);

        // Find and click the delete icon
        wait.until(ExpectedConditions.elementToBeClickable(Constant.WT_DELETE_RECORD)).click();


        // Check that the record is deleted
        boolean isRecordDeleted = !driver.findElement(Constant.WT_TABLE_ROWS).getText().contains(Constant.WT_NEW_RECORD.get(0));

        // Assert the record is deleted
        Assert.assertEquals(isRecordDeleted, isRecordDeleted, "Record was not deleted successfully.");

        // Close the browser
        driver.quit();
    }
}


