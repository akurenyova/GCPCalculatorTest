package pages.gcp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waiters.WaitersHelper;

public class EstimateResultGCPPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[contains(text(),'VM class:')]")
    private WebElement machineClassLabel;

    @FindBy(xpath = "//div[contains(text(),'Instance type:')]")
    private WebElement instanceTypeLabel;

    @FindBy(xpath = "//div[contains(text(),'Region:')]")
    private WebElement datacenterLocationLabel;

    @FindBy(xpath = "//div[contains(text(),'Total available local SSD space')]")
    private WebElement localSSdLabel;

    @FindBy(xpath = "//div[contains(text(),'Commitment term:')]")
    private WebElement commitedUsageLabel;

    @FindBy(xpath = "//*[@id='resultBlock']/md-card/md-card-content/div/div/div/h2/b")
    private WebElement estimationResultLabel;

    @FindBy(xpath = "//button[contains(text(),'Email Estimate')]")
    private WebElement emailEstimateButton;

    public EstimateResultGCPPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SendEmailGCPPage openEmailEstimateForm() {
        emailEstimateButton.click();
        return new SendEmailGCPPage(driver);
    }

    public String totalEstimation() {
        WaitersHelper.waitForVisibilityOf(driver,estimationResultLabel);
        return estimationResultLabel.getText();
    }

    public String machineClassLabelText() {
        return machineClassLabel.getText();
    }

    public String datacenterLocationLabelText() {
        return datacenterLocationLabel.getText();
    }

    public String localSSdLabelText() {
        return localSSdLabel.getText();
    } //название экшен - get

    public String commitedUsageLabelText() {
        return commitedUsageLabel.getText();
    } //

    public String instanceTypeLabelText() {
        return instanceTypeLabel.getText();
    }

}
