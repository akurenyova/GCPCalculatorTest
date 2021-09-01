package pages.mail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.gcp.SendEmailGCPPage;
import waiters.WaitersHelper;

public class TenMinuteMailPage {

    private WebDriver driver;

    @FindBy(id = "copy_address")
    private WebElement tempEmailText;

    @FindBy(xpath = "//div[@class='message_top']")
    private WebElement emailMessage;

    @FindBy(xpath = "//h2[contains(text(),'Estimated Monthly Cost:')]")
    private WebElement estimationFromEmail;

    public TenMinuteMailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SendEmailGCPPage getTempEmail() {
        driver.manage().window().maximize(); // сразу
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
