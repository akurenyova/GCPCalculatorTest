package com.epam.ta.pages.gcp;

import com.epam.ta.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.epam.ta.testdata.TestDataGCP;
import com.epam.ta.waiters.WaitersHelper;

public class EstimateResultGCPPage extends AbstractPage {

    @FindBy(xpath = "")
    private WebElement instancesLabel;

    @FindBy(xpath = "//div[contains(text(),'VM class:')]")
    private WebElement machineClassLabel;

    @FindBy(xpath = "")
    private WebElement seriesLabel;

    @FindBy(xpath = "//div[contains(text(),'Instance type:')]")
    private WebElement machineTypeLabel;

    @FindBy(xpath = "")
    private WebElement numberOfGPUsLabel;

    @FindBy(xpath = "")
    private WebElement gpuTypeLabel;

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
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SendEmailGCPPage openEmailEstimateForm() {
        emailEstimateButton.click();
        return new SendEmailGCPPage(driver);
    }

    public String getTotalEstimation() {
        WaitersHelper.waitForVisibilityOf(driver,estimationResultLabel).click();
        return estimationResultLabel.getText();
    }
    public TestDataGCP getTotalEstimationValues() {
        return new TestDataGCP(
                instancesLabel.getText(),
                machineClassLabel.getText(),
                seriesLabel.getText(),
                seriesLabel.getText(),
                machineTypeLabel.getText(),
                gpuTypeLabel.isEnabled(),
                numberOfGPUsLabel.getText(),
                gpuTypeLabel.getText(),
                localSSdLabel.getText(),
                datacenterLocationLabel.getText(),
                commitedUsageLabel.getText()
        );
    }


    public String getMachineClassLabelText() {
        return machineClassLabel.getText();
    }

    public String getDatacenterLocationLabelText() {
        return datacenterLocationLabel.getText();
    }

    public String getLocalSSdLabelText() {
        return localSSdLabel.getText();
    } //название экшен - get

    public String getCommitedUsageLabelText() {
        return commitedUsageLabel.getText();
    } //

    public String getInstanceTypeLabelText() {
        return machineTypeLabel.getText();
    }



}
