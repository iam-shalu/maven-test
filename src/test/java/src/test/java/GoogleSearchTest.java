package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

public class ChromeDriverTest {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        // Set the path for ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/your/chromedriver.exe");
        // Initialize the ChromeDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testLaunchWebsite() {
        // Launch a website
        driver.get("https://www.google.com");
        // Perform assertions if needed, for example:
        // Assert.assertEquals(driver.getTitle(), "Google");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser after the test is completed
        if (driver != null) {
            driver.quit();
        }
    }
}
