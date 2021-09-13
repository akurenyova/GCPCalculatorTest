package com.epam.ta.pages.gcp;

import com.epam.ta.pages.AbstractPage;
import com.epam.ta.pages.mail.TenMinuteMailPage;
import com.epam.ta.utils.BrowserTabUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.epam.ta.waiters.WaitersHelper;

import java.util.Set;

public class SendEmailGCPPage extends AbstractPage {

    @FindBy(id = "//label[contains(text(),'Email')]/following-sibling::input")
    private WebElement emailInput;

    @FindBy(xpath = "//button[contains(text(),'Send Email')]")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//button[contains(text(),'Email Estimate')]")
    private WebElement emailEstimateButton;

    public SendEmailGCPPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public TenMinuteMailPage openTenMinuteMailPage() {
        ((JavascriptExecutor)driver).executeScript("window.open(\""+ TENMINUTEEMAIL_URL + "\");");
        new BrowserTabUtils(driver).switchToNextTab();
        return new TenMinuteMailPage(driver);
    }

    public SendEmailGCPPage switchToSendEmailPage() {
        Set<String> handles = driver.getWindowHandles();
        driver.switchTo().window(handles.stream().findFirst().get());
        return new SendEmailGCPPage(driver);
    }

    public TenMinuteMailPage switchToTenMinuteEmailPage() {
        new BrowserTabUtils(driver).switchToNextTab();
        return new TenMinuteMailPage(driver);
    }

    public SendEmailGCPPage sendEstimationViaEmail() {
        driver.navigate().refresh();
        driver.switchTo().frame(0).switchTo().frame("myFrame");
        WaitersHelper.waitForVisibilityOf(driver, emailEstimateButton).click();
        emailEstimateButton.click();
        WaitersHelper.waitForVisibilityOf(driver, emailInput).click();
        emailInput.click();
        //emailInput.sendKeys(Keys.CONTROL + "v");
        new Actions(driver).sendKeys(emailInput, Keys.CONTROL + "v").build().perform(); // action на вставку, js executor
        new Actions(driver).click(sendEmailButton).build().perform();
        //sendEmailButton.click();
        return new SendEmailGCPPage(driver);
    }

}
