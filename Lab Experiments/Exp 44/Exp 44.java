package selenium;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class FileUpload {

    @Test
    public void fileUpload() {

        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://the-internet.herokuapp.com/upload");

            WebElement upload = driver.findElement(By.id("file-upload"));

            upload.sendKeys("C:\\Users\\daran\\Desktop\\test.txt");

            driver.findElement(By.id("file-submit")).click();

            String result = driver.findElement(By.tagName("h3")).getText();

            assertEquals("File Uploaded!", result);

            System.out.println("File uploaded successfully");

        } finally {

            // driver.quit();

        }
    }
}
