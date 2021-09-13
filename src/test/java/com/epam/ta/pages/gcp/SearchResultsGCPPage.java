package com.epam.ta.pages.gcp;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.epam.ta.pages.AbstractPage;
import com.epam.ta.testdata.TestDataGCP;
import com.epam.ta.waiters.WaitersHelper;

public class SearchResultsGCPPage extends AbstractPage {

    private String searchTerm;
    private final String locatorForSearchBeginAtag = "//a[@class='gs-title'][contains(text(),'";
    private final String locatorForSearchBeginBtag = "//div[@class='gs-title']/a/b[contains(text(),'";
    private final String locatorForSearchEnd = "')]";
    private final String frameName = "myFrame";

    public SearchResultsGCPPage(WebDriver driver, String searchTerm) {
        super(driver);
        this.searchTerm = searchTerm;
        PageFactory.initElements(driver, this);
    }

    public PricingCalculatorGCPPage openPricingCalculator(TestDataGCP testDataGCP) {
        String locatorForSearchAtag = buildLocatorForSearch(locatorForSearchBeginAtag);
        String locatorForSearchBtag = buildLocatorForSearch(locatorForSearchBeginBtag);
        try {
            WaitersHelper.waitForPresenceOfElementLocated(driver, locatorForSearchBtag).click();
        }
        catch (TimeoutException e) {
            WaitersHelper.waitForPresenceOfElementLocated(driver, locatorForSearchAtag).click();
        }
        switchToMyFrame();
        return new PricingCalculatorGCPPage(driver, testDataGCP);
    }

    private void switchToMyFrame() {
        driver.switchTo().frame(0).switchTo().frame(frameName); // внутри страницы PrC
    }

    private String buildLocatorForSearch(String locatorForSearchBegintag) {
        return  locatorForSearchBegintag + searchTerm + locatorForSearchEnd;
    } // маска

}
