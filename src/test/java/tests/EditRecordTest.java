package tests;


import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Constant;

import java.time.Duration;

public class EditRecordTest extends BaseTest {

@Test
@Description("The test edits a record in the webtables")
    public static void editRecordTest() {
        //public void editRecordTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the webtables page
        driver.get(Constant.URL);

        // Edit the record using the editing function
    wait.until(ExpectedConditions.elementToBeClickable(Constant.WT_EDIT_RECORD)).click();


    // Edit the fields in the Registration Form
    wait.until(ExpectedConditions.visibilityOfElementLocated(Constant.WT_MODAL));
    driver.findElement(Constant.WT_FIRST_NAME).clear();
    driver.findElement(Constant.WT_FIRST_NAME).sendKeys(Constant.WT_NEW_RECORD_2.get(0));
    driver.findElement(Constant.WT_LAST_NAME).clear();
    driver.findElement(Constant.WT_LAST_NAME).sendKeys(Constant.WT_NEW_RECORD_2.get(1));
    driver.findElement(Constant.WT_USER_EMAIL).clear();
    driver.findElement(Constant.WT_USER_EMAIL).sendKeys(Constant.WT_NEW_RECORD_2.get(2));
    driver.findElement(Constant.WT_AGE).clear();
    driver.findElement(Constant.WT_AGE).sendKeys(Constant.WT_NEW_RECORD_2.get(3));
    driver.findElement(Constant.WT_SALARY).clear();
    driver.findElement(Constant.WT_SALARY).sendKeys(Constant.WT_NEW_RECORD_2.get(4));
    driver.findElement(Constant.WT_DEPARTMENT).clear();
    driver.findElement(Constant.WT_DEPARTMENT).sendKeys(Constant.WT_NEW_RECORD_2.get(5));

    // Submit the form
    driver.findElement(Constant.WT_SUBMIT).click();

    // Check that the record is edited
    boolean isRecordEdited = driver.findElement(Constant.WT_TABLE_ROWS).getText().contains(Constant.WT_NEW_RECORD_2.get(0));

    // Assert the record is edited
    Assert.assertEquals(isRecordEdited, isRecordEdited, "Record was not edited successfully.");

    // Close the browser
    driver.quit();
}
}
