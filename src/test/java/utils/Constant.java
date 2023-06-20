package utils;

import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

public class Constant {
    public static final String URL = "https://demoqa.com/webtables";
    public static final String WT_URL = "https://demoqa.com/webtables";
    public static final By WT_ADD_NEW_RECORD = By.id("addNewRecordButton");
    public static final By WT_EDIT_RECORD = By.id("edit-record-2");

    public static final By WT_DELETE_RECORD = By.id("delete-record-1");

    public static final By WT_MODAL = By.className("modal");
    public static final By WT_TABLE_CELL = By.className("rt-td");
    public static final By WT_SEARCH_BOX = By.id("searchBox");
    public static final By WT_TABLE_ROWS = By.cssSelector("select[aria-label='rows per page']");
    public static final By WT_NUM_OF_ROWS = By.className("rt-tr-group");
    public static final By WT_FIRST_NAME = By.id("firstName");
    public static final By WT_LAST_NAME = By.id("lastName");
    public static final By WT_USER_EMAIL = By.id("userEmail");
    public static final By WT_AGE = By.id("age");
    public static final By WT_SALARY = By.id("salary");
    public static final By WT_DEPARTMENT = By.id("department");
    public static final By WT_SUBMIT = By.id("submit");


    public static final List<String> WT_NEW_RECORD = Arrays.asList("Eva", "Green", "green@test.com",
            "36", "1500", "QA");
    public static final List<String> WT_NEW_RECORD_2 = Arrays.asList("Mark", "Tven", "mark@test.com",
           "40", "1500", "QA");





    public static final int WT_DELETE_RECORD_INDEX = 1;
    public static final int WT_EDIT_RECORD_INDEX = 2;
    public static final String WT_SET_NUM_OF_ROWS = "25";


}
// //*[@id="edit-record-2"]
// //*[@id="delete-record-1"]

