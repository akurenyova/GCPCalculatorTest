package com.epam.ta.pages.mail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.epam.ta.pages.AbstractPage;
import com.epam.ta.pages.gcp.SendEmailGCPPage;
import com.epam.ta.waiters.WaitersHelper;

public class TenMinuteMailPage extends AbstractPage {

    @FindBy(id = "copy_address")
    private WebElement tempEmailText;

    @FindBy(xpath = "//div[@class='message_top']")
    private WebElement emailMessage;

    @FindBy(xpath = "//h2[contains(text(),'Estimated Monthly Cost:')]")
    private WebElement estimationFromEmail;

    public TenMinuteMailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SendEmailGCPPage getTempEmail() {
        tempEmailText.click();
        return new SendEmailGCPPage(driver);
    }

    public TenMinuteMailPage openEmail() {
        WaitersHelper.waitForVisibilityOf(driver, emailMessage).click(); // 30 s
        emailMessage.click();
        return this;
    }

    public String estimationFromEmail() {
        return estimationFromEmail.getText();
    }

}
