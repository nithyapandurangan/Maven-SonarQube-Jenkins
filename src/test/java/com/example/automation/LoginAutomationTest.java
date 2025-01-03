package com.example.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;

class LoginAutomationTest {

    @Test
    void testLogin() {
        // Setting up WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");

        // Adding more options to the ChromeDriver for improved stability
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-logging");
        options.addArguments("--disable-cache");
        options.addArguments("--disk-cache-size=0");
        options.addArguments("--remote-debugging-port=9223");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage"); // New argument
        options.addArguments("--no-sandbox");           // New argument

        // Initialize WebDriver with options
        WebDriver driver = new ChromeDriver(options);

        // Login credentials and URL
        String baseUrl = "https://www.saucedemo.com/";
        String username = "standard_user";
        String password = "secret_sauce";

        try {
            // Navigate to the login page
            driver.get(baseUrl);

            // Locate elements
            WebElement usernameField = driver.findElement(By.id("user-name"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("login-button"));

            // Perform login
            usernameField.sendKeys(username);
            passwordField.sendKeys(password);

            // Wait for the login button to be clickable with a longer timeout
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));  // Increased timeout
            loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
            loginButton.click();

            // Wait for the page to load after login (check title or element visibility)
            WebDriverWait pageWait = new WebDriverWait(driver, Duration.ofSeconds(30));  // Increased timeout
            pageWait.until(ExpectedConditions.titleIs("Swag Labs"));

            // Validate successful login by checking page title
            String expectedTitle = "Swag Labs";  // Correct title after login
            String actualTitle = driver.getTitle();
            assertEquals(expectedTitle, actualTitle);  // Adding assertion to validate login success

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Test failed due to exception: " + e.getMessage());
        } finally {
            // Ensure browser quits after the test to avoid hanging processes
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
