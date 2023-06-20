package tests;


import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AbstractPageObject;
import utils.Constant;

import java.time.Duration;
import java.util.List;


public class AddRecordTest extends BaseTest {


    @Test
    @Description("The test opens the https://demoqa.com/webtables page, clicks the [Add] button, " +
                "fills the field holders, adds new record")
     //public static void addNewRecordTest() {
//public static void main(String[] args) {
            public static void addNewRecordTest(){

        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        // Open the webtables page
        driver.get(Constant.URL);

        // Click the [ADD] button
        wait.until(ExpectedConditions.elementToBeClickable(Constant.WT_ADD_NEW_RECORD)).click();

        // Fill the fields in the Registration Form
        wait.until(ExpectedConditions.visibilityOfElementLocated(Constant.WT_MODAL));
        driver.findElement(Constant.WT_FIRST_NAME).sendKeys(Constant.WT_NEW_RECORD.get(0));
        driver.findElement(Constant.WT_LAST_NAME).sendKeys(Constant.WT_NEW_RECORD.get(1));
        driver.findElement(Constant.WT_USER_EMAIL).sendKeys(Constant.WT_NEW_RECORD.get(2));
        driver.findElement(Constant.WT_AGE).sendKeys(Constant.WT_NEW_RECORD.get(3));
        driver.findElement(Constant.WT_SALARY).sendKeys(Constant.WT_NEW_RECORD.get(4));
        driver.findElement(Constant.WT_DEPARTMENT).sendKeys(Constant.WT_NEW_RECORD.get(5));

        // Submit the form
        driver.findElement(Constant.WT_SUBMIT).click();

       // Check that the new user is added

        boolean isNewRecordAdded = // Implement your verification logic here
                driver.findElement(Constant.WT_TABLE_ROWS).getText().contains(Constant.WT_NEW_RECORD.get(0));

        // Assert the new user is added
        Assert.assertEquals(isNewRecordAdded, isNewRecordAdded, "New record was not added successfully.");

        // Close the browser
        driver.quit();
    }
@Test
    // additional checking logic

    private boolean isRecordPresentInTable(WebDriver driver, List<String> recordData) {
        String recordName = recordData.get(0);
        String tableRowsText = driver.findElement(Constant.WT_TABLE_ROWS).getText();
        return tableRowsText.contains(recordName);
    }
}

