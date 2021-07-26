package pages.gcp;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.mail.TenMinuteMailPage;
import waiters.WaitersHelper;

import java.util.Iterator;
import java.util.Set;

public class SendEmailGCPPage {

    private WebDriver driver;
    private static final String TENMINUTEEMAIL_URL = "https://10minutemail.com/";

    @FindBy(id = "input_400")
    private WebElement emailInput;

    @FindBy(xpath = "//button[contains(text(),'Send Email')]")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//button[contains(text(),'Email Estimate')]")
    private WebElement emailEstimateButton;

    public SendEmailGCPPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TenMinuteMailPage openTenMinuteMailPage() {
        ((JavascriptExecutor)driver).executeScript("window.open(\""+ TENMINUTEEMAIL_URL + "\");");
        switchToNextTab();
        return new TenMinuteMailPage(driver);
    }

    public SendEmailGCPPage switchToSendEmailPage() {
        Set<String> handles = driver.getWindowHandles();
        driver.switchTo().window(handles.stream().findFirst().get());
        return new SendEmailGCPPage(driver);
    }

    public TenMinuteMailPage switchToTenMinuteEmailPage() {
        switchToNextTab();
        return new TenMinuteMailPage(driver);
    }

    public SendEmailGCPPage sendEstimationViaEmail() {
        driver.navigate().refresh();
        driver.switchTo().frame(0).switchTo().frame("myFrame");
        WaitersHelper.waitForVisibilityOf(driver, emailEstimateButton);
        emailEstimateButton.click();
        WaitersHelper.waitForVisibilityOf(driver, emailInput);
        emailInput.click();
        //emailInput.sendKeys(Keys.CONTROL + "v");
        new Actions(driver).sendKeys(emailInput, Keys.CONTROL + "v").build().perform(); // action на вставку, js executor
        new Actions(driver).click(sendEmailButton).build().perform();
        //sendEmailButton.click();
        return new SendEmailGCPPage(driver);
    }

    private void switchToNextTab() {
        String subWindowHandler = null;
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler);
    }

}