import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

        // Create a new ChromeDriver instance
        driver = new ChromeDriver();
        File file = new File("IfStatement.html");
        // Open the HTML file
        driver.get(file.getAbsolutePath());
    }
    @Test
    public void testIncrementButton() {

        // Find the increment button and click it
        WebElement incrementButton = driver.findElement(By.id("counter"));
        incrementButton.click();

        // Find the display element and verify the incremented value
        WebElement displayElement = driver.findElement(By.id("display"));
        assertEquals("2", displayElement.getText());
        incrementButton.click();

        // Find the display element and verify the incremented value
        assertEquals("3", displayElement.getText());
    }

    @Test
    public void testCheckButton() {

        // Find the checkButton and click it
        WebElement countButton = driver.findElement(By.id("counter"));
        countButton.click();

        // Find the lightText element and verify the text based on the initial value of lightOn
        WebElement evenOrOddTextElement = driver.findElement(By.id("evenOrOddText"));
        String expectedText = "even"; // Assuming number is initially 1, and 2 after a click
        assertEquals(expectedText, evenOrOddTextElement.getText());
        
    }
    @Test
    public void testCheckButton2Clicks() {

        // Find the checkButton and click it
        WebElement countButton = driver.findElement(By.id("counter"));
        countButton.click();
        countButton.click();

        // Find the lightText element and verify the text based on the initial value of lightOn
        WebElement evenOrOddTextElement = driver.findElement(By.id("evenOrOddText"));
        String expectedText = "odd"; // Assuming number is initially 1, and 2 after a click
        assertEquals(expectedText, evenOrOddTextElement.getText());
        
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}