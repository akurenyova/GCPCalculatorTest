package pages.gcp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsGCPPage {

    private WebDriver driver;
    private String searchTerm;
    private final String locatorForSearchBegin = "//div[@class='gs-title']/a/b[contains(text(),'";
    private final String locatorForSearchEnd = "')]";
    private final String frameName = "myFrame";

    public SearchResultsGCPPage(WebDriver driver, String searchTerm) {
        this.driver = driver;
        this.searchTerm = searchTerm;
        PageFactory.initElements(driver, this);
    }

    public PricingCalculatorGCPPage openPricingCalculator() {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(buildLocatorForSearch()))).click();
        switchToMyFrame();
        return new PricingCalculatorGCPPage(driver);
    }

    private void switchToMyFrame() {
        driver.switchTo().frame(0).switchTo().frame(frameName);
    }

    private String buildLocatorForSearch() {
        return  locatorForSearchBegin + searchTerm + locatorForSearchEnd;
    }

}
