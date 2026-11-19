
package selenium;

import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EXP39 {

    @Test
    public void invalidLoginTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        try {

            // STEP 1: LOAD LOGIN PAGE
            driver.get("https://the-internet.herokuapp.com/login");
            driver.manage().window().maximize();

            System.out.println("Login page opened successfully.");

            Thread.sleep(3000);

            // STEP 2: ENTER INVALID CREDENTIALS
            driver.findElement(By.id("username"))
                  .sendKeys("invaliduser");

            driver.findElement(By.id("password"))
                  .sendKeys("wrongpass");

            System.out.println("Invalid credentials entered.");

            Thread.sleep(3000);

            // STEP 3: CLICK LOGIN
            driver.findElement(By.cssSelector("button[type='submit']"))
                  .click();

            // STEP 4: WAIT FOR ERROR MESSAGE
            WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(10));

            WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.id("flash")));

            String message = errorMessage.getText();

            System.out.println("Error Message: " + message);

            // STEP 5: VERIFY INVALID LOGIN
            assertTrue(
                "Invalid login error message not found.",
                message.toLowerCase().contains("invalid")
            );

            System.out.println("Invalid Login Validation Successful!");

        } finally {
            driver.quit();
        }
    }
}
