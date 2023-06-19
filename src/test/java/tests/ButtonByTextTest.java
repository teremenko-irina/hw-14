package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonByTextTest extends BaseTest {

    private final static String buttonName = "Click Me";


    @Test
    @Description("The test opens the https://demoqa.com/elements page, clicks the Buttons item" +
            ", clicks [Click Me] button, and verifies the expected message.")
    public static void testButtonClick() {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");

        // Create an instance of WebDriver
        WebDriver driver = new ChromeDriver();




        // Navigate to the desired webpage
        driver.get("https://demoqa.com/buttons");


        // Find the button element by exact text using XPath
        String buttonText = "Click Me";
        String xpathExpression = "//button[text()='" + buttonText + "']";
        WebElement buttonElement = driver.findElement(By.xpath(xpathExpression));

        // Perform actions on the button element
        buttonElement.click();


        Assert.assertEquals("You have done a dynamic click", "You have done a dynamic click",
                "Message is correct");

        driver.quit();
    }
}