package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;
import java.util.List;

import static utils.Constant.*;


public class WebTables extends AbstractPageObject {


    public WebDriver driver;
    public WebDriverWait wdwait;

    public WebTables(WebDriver driver) {
        super(driver);
    }


    public void goToWebTables(String url) {
        driver.navigate().to(WT_URL);
    }

    public WebElement getFirstName() {
        return driver.findElement(WT_FIRST_NAME);
    }

    public WebElement getLastName() {
        return driver.findElement(WT_LAST_NAME);
    }

    public WebElement getUserName() {
        return driver.findElement(WT_USER_EMAIL);
    }

    public WebElement getAge() {
        return driver.findElement(WT_AGE);
    }

    public WebElement getSalary() {
        return driver.findElement(WT_SALARY);
    }

    public WebElement getDepartment() {
        return driver.findElement(WT_DEPARTMENT);
    }

    public WebElement getSubmit() {
        return driver.findElement(WT_SUBMIT);
    }

    public List<WebElement> getTableCells() {
        return driver.findElements(WT_TABLE_CELL);
    }

    public WebElement getSearchBox() {
        return driver.findElement(WT_SEARCH_BOX);
    }

    public WebElement getTableRows() {
        return driver.findElement(WT_TABLE_ROWS);
    }

    public List<WebElement> getNumOfRows() {
        return driver.findElements(WT_NUM_OF_ROWS);
    }


    public void addNewElement(List<String> newRecord) {
        driver.findElement(WT_ADD_NEW_RECORD).click();
        wdwait.until(ExpectedConditions.visibilityOfElementLocated(WT_MODAL));
        populateModal(newRecord);
    }

    public String deleteRecord(int i) {
        String id = "delete-record-" + i;
        driver.findElement(By.id(id)).click();
        return id;
    }

    public void editRecord(int i, List<String> newRecord) {
        String id = "edit-record-" + i;
        driver.findElement(By.id(id)).click();

        wdwait.until(ExpectedConditions.visibilityOfElementLocated(WT_MODAL));
        populateModal(newRecord);
    }

    public void populateModal(List<String> newRecord) {
        getFirstName().sendKeys(Keys.chord(Keys.CONTROL, "a"), newRecord.get(0));
        getLastName().sendKeys(Keys.chord(Keys.CONTROL, "a"), newRecord.get(1));
        getUserName().sendKeys(Keys.chord(Keys.CONTROL, "a"), newRecord.get(2));
        getAge().sendKeys(Keys.chord(Keys.CONTROL, "a"), newRecord.get(3));
        getSalary().sendKeys(Keys.chord(Keys.CONTROL, "a"), newRecord.get(4));
        getDepartment().sendKeys(Keys.chord(Keys.CONTROL, "a"), newRecord.get(5));
        getSubmit().click();
    }


    public List<String> search(String text) {
        List<String> cellTexts = new ArrayList<>();
        getSearchBox().sendKeys(text);
        List<WebElement> tableCells = getTableCells();
        for (WebElement cell : tableCells) {
            if (!cell.getText().isEmpty()) {
                cellTexts.add(cell.getText());
            }
        }
        return cellTexts;
    }

    public int pageSize(String rowNum) {
        Select select = new Select(getTableRows());
        select.selectByValue(rowNum);
        return Integer.parseInt(rowNum);
    }
}