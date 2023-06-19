package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;


public class GeneralPage extends AbstractPageObject {

    private final By mainTitle = By.cssSelector(".main-header");
    private final By menuList = By.cssSelector(".menu-list");
    private final By buttonsItem = By.xpath("//span[text()='Buttons']");

    public GeneralPage(WebDriver driver) {
        super(driver);
        driver.get("https://demoqa.com/elements");

    }

    @Step("The user is able to click on Buttons item")
    public ButtonsPage clickButtonsItem() {
        getElement(buttonsItem).click();
        return new ButtonsPage(driver);
    }

    public String getTitleText() {
        return getElement(mainTitle).getText();
    }

    public List<WebElement> getMenuItems() {
        return getElements(menuList);
    }
}
