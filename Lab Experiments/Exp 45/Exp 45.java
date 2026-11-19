package selenium;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CaptureScreenshot {

    @Test
    public void captureScreenshot() throws Exception {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.google.com");

            File screenshot = ((TakesScreenshot)driver)
                    .getScreenshotAs(OutputType.FILE);

            Files.createDirectories(Paths.get("screenshots"));

            Files.copy(screenshot.toPath(),
                    Paths.get("screenshots/page.png"),
                    StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Screenshot saved successfully");

        } finally {
            //driver.quit();
        }
    }
}
