
package selenium;

import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EXP38 {

    @Test
    public void registerUser() {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://demoqa.com/automation-practice-form");

            driver.findElement(By.id("firstName"))
                  .sendKeys("Loga");

            driver.findElement(By.id("lastName"))
                  .sendKeys("Dharshana");

            driver.findElement(By.id("userEmail"))
                  .sendKeys("loga@example.com");

            driver.findElement(By.xpath("//label[text()='Female']"))
                  .click();

            driver.findElement(By.id("userNumber"))
                  .sendKeys("9876543210");

            driver.findElement(By.id("submit"))
                  .click();

            WebElement result = driver.findElement(
                By.id("example-modal-sizes-title-lg"));

            System.out.println("Registration Result: "
                               + result.getText());

            assertTrue(result.isDisplayed());

        } finally {
            driver.quit();
        }
    }
}
