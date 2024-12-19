import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

public class GoogleSearchTest {

    @Test
    public void testGoogleSearch() {
        // Set the path of the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver_win32/chromedriver.exe");  // Ensure this path is correct

        // Create an instance of Chrome WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open Google homepage
            driver.get("https://www.google.com");

            // Wait for the search bar to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));

            // Locate the search bar and enter the search query
            searchBox.sendKeys("Selenium WebDriver");

            // Wait for the search button and submit the form
            WebElement searchButton = driver.findElement(By.name("btnK"));
            searchButton.submit();

            // Wait for the results to load and verify the page title contains the search query
            wait.until(ExpectedConditions.titleContains("Selenium WebDriver"));
            assertTrue(driver.getTitle().contains("Selenium WebDriver"));
        } finally {
            // Close the browser after the test
            driver.quit();
        }
    }
}
