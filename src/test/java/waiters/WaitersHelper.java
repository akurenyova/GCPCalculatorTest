package waiters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitersHelper {

    private static long TIMEOUT_IN_SECONDS = 10;

    public static WebElement waitForVisibilityOf(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, TIMEOUT_IN_SECONDS).until(ExpectedConditions
                .visibilityOf(element));
    }

    public static WebElement waitForPresenceOfElementLocated(WebDriver driver, String xpathLocator) {
        return new WebDriverWait(driver, TIMEOUT_IN_SECONDS).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(xpathLocator)));
    }


}
