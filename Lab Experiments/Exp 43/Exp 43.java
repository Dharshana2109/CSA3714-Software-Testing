package selenium;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class PromptPopupstest {

    @Test
    public void alertHandling() {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");

            // Alert
            driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
            driver.switchTo().alert().accept();

            // Confirm
            driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
            driver.switchTo().alert().accept();

            // Prompt
            driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
            Alert prompt = driver.switchTo().alert();
            prompt.sendKeys("Hello Selenium");
            prompt.accept();

            System.out.println("All pop-ups handled successfully");

        } finally {
           // driver.quit();
        }
    }
}
