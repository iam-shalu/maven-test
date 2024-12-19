package com.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleSearchTest {

    @Test
    public void testGoogleSearch() {
        // Set the path of the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\tools\chromedriver_win32/chromedriver"); // Replace with your chromedriver path

        // Create an instance of Chrome WebDriver
        WebDriver driver = new ChromeDriver();
        
        try {
            // Open Google homepage
            driver.get("https://www.google.com");

            // Locate the search bar using its name attribute and enter the search query
            driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");

            // Submit the search form
            driver.findElement(By.name("btnK")).submit();
            
            // Verify the page title contains the search query
            assertTrue(driver.getTitle().contains("Selenium WebDriver"));
        } finally {
            // Close the browser after the test
            driver.quit();
        }
    }
}
