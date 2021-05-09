package pages.mail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.gcp.SendEmailGCPPage;

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
        driver.manage().window().maximize();
        tempEmailText.click();
        return new SendEmailGCPPage(driver);
    }

    public TenMinuteMailPage openEmail() {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .visibilityOf(emailMessage));
        emailMessage.click();
        return this;
    }

    public String estimationFromEmail() {
        return estimationFromEmail.getText();
    }

}
