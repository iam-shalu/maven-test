package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleSearchTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // ChromeDriver ka path set karein
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testGoogleSearch() {
        // Google website open karein
        driver.get("https://www.google.com");

        // Search box locate karein
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();

        // Title validate karein
        assert driver.getTitle().contains("Selenium WebDriver");
    }

    @AfterClass
    public void tearDown() {
        // Browser band karein
        driver.quit();
    }
}

