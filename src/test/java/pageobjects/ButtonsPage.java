package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;



public class ButtonsPage extends AbstractPageObject {

    private final By mainTitle = By.cssSelector(".main-header");
    private final By doubleClickButton = By.cssSelector("#doubleClickBtn");
    private final By rightClickButton = By.cssSelector("#rightClickBtn");
    private final By clickMeButton = By.xpath("//button[text()='Click Me']");

    private By dynamicClickMessage = By.id("dynamicClickMessage");

    public ButtonsPage(WebDriver driver) {
        super(driver);
        driver.get("https://demoqa.com/buttons/");
    }

    public String getTitleText() {
        return getElement(mainTitle).getText();
    }

    public String clickOnClickMeButton() {
        getElement(clickMeButton).click();
        clickOnElementWithJS(clickMeButton);
        return "You have done a dynamic click";
    }

    public void clickOnDoubleClickButton() {
        doubleClickOnElement(doubleClickButton);
    }

    private void doubleClickOnElement(By locator) {
        actions().doubleClick(getElement(locator)).perform();
    }

    private Actions actions() {
        return new Actions(driver);
    }

    public void clickRightMouseButtonOnRightClickButton() {
        rightClickOnElement(rightClickButton);
    }

    private void rightClickOnElement(By locator) {
        actions().contextClick(getElement(locator)).perform();
    }

    public String getDynamicClickMessage() {
        return getElement(dynamicClickMessage).getText();
    }

}

