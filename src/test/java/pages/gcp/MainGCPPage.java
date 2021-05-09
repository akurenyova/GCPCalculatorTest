package pages.gcp;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainGCPPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchButton;

    public MainGCPPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainGCPPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public SearchResultsGCPPage searchForTerms(String term) {
        searchButton.click();
        searchButton.sendKeys(term);
        searchButton.sendKeys(Keys.ENTER);
        return new SearchResultsGCPPage(driver, term);
    }

}
