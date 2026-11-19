
package selenium;

import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class EXP40 {

    @Test
    public void logoutTest() {

        WebDriver driver = new ChromeDriver();

        try {

            // STEP 1: OPEN LOGIN PAGE
            driver.get("https://the-internet.herokuapp.com/login");
            driver.manage().window().maximize();

            // STEP 2: ENTER VALID LOGIN DETAILS
            driver.findElement(By.id("username"))
                  .sendKeys("tomsmith");

            driver.findElement(By.id("password"))
                  .sendKeys("SuperSecretPassword!");

            // STEP 3: CLICK LOGIN
            driver.findElement(By.cssSelector("button[type='submit']"))
                  .click();

            WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(10));

            // STEP 4: VERIFY SUCCESSFUL LOGIN
            wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.id("flash"), "You logged into a secure area!"));

            System.out.println("Login Successful!");

            // STEP 5: CLICK LOGOUT
            driver.findElement(By.cssSelector("a[href='/logout']"))
                  .click();

            // STEP 6: VERIFY LOGOUT
            wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.id("flash"), "You logged out"));

            System.out.println("Logout Successful!");

            assertTrue(driver.getCurrentUrl().contains("/login"));

        } finally {
            driver.quit();
        }
    }
}
