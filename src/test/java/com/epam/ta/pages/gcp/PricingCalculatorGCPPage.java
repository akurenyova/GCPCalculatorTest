package com.epam.ta.pages.gcp;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.epam.ta.pages.AbstractPage;
import com.epam.ta.testdata.TestDataGCP;
import com.epam.ta.waiters.WaitersHelper;


public class PricingCalculatorGCPPage extends AbstractPage {

    private final String seriesMachineTypeLocator = "//md-select[@placeholder='Instance type']";
    private final String seriesMachineTypeN1S8Locator = "//md-option/div[contains(text(),'n1-standard-8')]";
    private final String addGPUsCheckboxLocator = "//md-checkbox[@aria-label='Add GPUs']/div[@class='md-container md-ink-ripple']";
    private final String numberOfGPUsDropdownLocator = "//label[contains(text(),'Number of GPUs')]/parent::md-input-container/md-select";
    private final TestDataGCP testDataGCP;

    @FindBy(xpath = "//md-tab-item[1]/div/div/div[2]")
    private WebElement computeEngineButton;

    @FindBy(xpath = "//label[contains(text(),'Number of instances')]/following-sibling::input")
    private WebElement numberOfInstancesInput;

    @FindBy(xpath = "//label[contains(text(),'Operating System')]/parent::md-input-container/md-select")
    private WebElement softwareDropdown;

    @FindBy(xpath = "//label[contains(text(),'Operating System')]")
    private WebElement softwareDropdownLabel;

    @FindBy(xpath = "//md-option/div[contains(text(),'Free: Debian,')]")
    private WebElement softwareDropdownFree;

    @FindBy(xpath = "//label[contains(text(),'Machine Class')]/parent::md-input-container/md-select")
    private WebElement machineClassDropdown;

    @FindBy(xpath = "//label[contains(text(),'Machine Class')]/parent::md-input-container/md-select/md-select-value/span/div[contains(text(),'Regular')]")
    private WebElement machineClassDropdownRegular;

    @FindBy(xpath = "//md-select[@name='series'] ")
    private WebElement seriesDropdown;

    @FindBy(xpath = "//md-option/div[contains(text(),'N1')]")
    private WebElement seriesDropdownN1;

    @FindBy(xpath = seriesMachineTypeLocator)
    private WebElement seriesMachineType;

    @FindBy(xpath = seriesMachineTypeN1S8Locator)
    private WebElement seriesMachineTypeN1S8;

    @FindBy(xpath = addGPUsCheckboxLocator)
    private WebElement addGPUsCheckbox;

    @FindBy(xpath = numberOfGPUsDropdownLocator)
    private WebElement numberOfGPUsDropdown;

    @FindBy(xpath = "//div[7]/md-select-menu/md-content/md-option[2]/div")
    private WebElement numberOfGPUsDropdownN1;

    @FindBy(xpath = "//label[contains(text(),'GPU type')]/parent::md-input-container/md-select")
    private WebElement gpuTypeDropdown;

    @FindBy(xpath = "//md-option[@value=\"NVIDIA_TESLA_V100\"]")
    private WebElement gpuTypeDropdownNTV100;

    @FindBy(xpath = "//label[contains(text(),'Local SSD')]/parent::md-input-container/md-select")
    private WebElement localSSdDropdown;

    @FindBy(xpath = "//md-option/div[contains(text(),'2x375 GB')]")
    private WebElement localSSdDropdown2x375GB;

    @FindBy(xpath = "//label[contains(text(),'Local SSD')]/parent::md-input-container/md-select")
    private WebElement datacenterLocationDropdown;

    @FindBy(xpath = "//div[10]/md-select-menu/md-content/md-option[2]/div")
    private WebElement datacenterLocationDropdownCarolina;

    @FindBy(xpath = "//label[contains(text(),'Committed usage')]/parent::md-input-container/md-select")
    private WebElement commitedUsageDropdown;

    @FindBy(xpath = "//div[11]/md-select-menu/md-content/md-option[2]/div")
    private WebElement commitedUsageDropdown1year;

    @FindBy(xpath = "//button[contains(text(),'Add to Estimate')]")
    private WebElement addToEstimateButton;

    public PricingCalculatorGCPPage(WebDriver driver, TestDataGCP testDataGCP) {
        super(driver);
        this.testDataGCP = testDataGCP;
        PageFactory.initElements(driver, this);
    }

    public PricingCalculatorGCPPage selectComputeEngineSection() {
        WaitersHelper.waitForVisibilityOf(driver,computeEngineButton).click();
        return this;
    }

    public PricingCalculatorGCPPage openPricingCalculatorGCPPage(String searchString) {
        SearchResultsGCPPage searchResultsGCPPage = new MainGCPPage(driver)
                .openPage()
                .searchForTerms(searchString);
        return searchResultsGCPPage.openPricingCalculator(testDataGCP);
    }

    public PricingCalculatorGCPPage fillInEstimationForm(TestDataGCP testDataGCP) {
        this.fillInNumberOfInstances(testDataGCP.getInstances())
                .fillInAddGPUs(testDataGCP.getAddGPUs())
                .fillInSoftware(testDataGCP.getSoftware())
                .fillInMachineClass(testDataGCP.getMashineClass())
                .fillInSeries(testDataGCP.getSeries())
                .fillInMachineType(testDataGCP.getMachineType())
                .fillInNumberOfGPUs(testDataGCP.getNumberOfGPUs())
                .fillInGpuType(testDataGCP.getGpuType())
                .fillInLocalSSd(testDataGCP.getLocalSSd())
                .fillInDatacenterLocation(testDataGCP.getDataCenterLocation())
                .fillInCommitedUsage(testDataGCP.getCommitedUsage());
        return this;
    }

    public PricingCalculatorGCPPage fillInNumberOfInstances(String numberOfInstances) {
        WaitersHelper.waitForVisibilityOf(driver,numberOfInstancesInput).click();
        numberOfInstancesInput.sendKeys(numberOfInstances);
        return this;
    }

    public PricingCalculatorGCPPage fillInSoftware(String softwareDropdownValue) {
        softwareDropdown.sendKeys(softwareDropdownValue);
        softwareDropdownFree.click();
        return this;
    }

    public PricingCalculatorGCPPage fillInMachineClass(String machineClassDropdownValue) {
        machineClassDropdown.sendKeys(machineClassDropdownValue);
        machineClassDropdown.sendKeys(Keys.TAB);
        return this;
    }

    public PricingCalculatorGCPPage fillInSeries(String seriesDropdownValue) {
        seriesDropdown.sendKeys(seriesDropdownValue);
        seriesDropdown.sendKeys(Keys.TAB);
        return this;
    }

    public PricingCalculatorGCPPage fillInMachineType(String seriesMachineTypeValue) {
        WaitersHelper.waitForPresenceOfElementLocated(driver,seriesMachineTypeLocator);
        seriesMachineType.sendKeys(seriesMachineTypeValue);
        seriesMachineTypeN1S8.click();
        return this;
    }

    public PricingCalculatorGCPPage fillInAddGPUs(boolean addGPUsCheckboxValue) {
        if (addGPUsCheckboxValue == true)
        {
            WaitersHelper.waitForPresenceOfElementLocated(driver,addGPUsCheckboxLocator);
            addGPUsCheckbox.click();
        }
        return this;
    }

    public PricingCalculatorGCPPage fillInNumberOfGPUs(String numberOfGPUsDropdownValue) {
        WaitersHelper.waitForPresenceOfElementLocated(driver,numberOfGPUsDropdownLocator);
        numberOfGPUsDropdown.sendKeys(numberOfGPUsDropdownValue);
        numberOfGPUsDropdown.sendKeys(Keys.TAB);
        return this;
    }

    public PricingCalculatorGCPPage fillInGpuType(String gpuTypeDropdownValue) {
        gpuTypeDropdown.sendKeys(gpuTypeDropdownValue);
        gpuTypeDropdown.sendKeys(Keys.TAB);
        return this;
    }

    public PricingCalculatorGCPPage fillInLocalSSd(String localSSdDropdownValue) {
        WaitersHelper.waitForVisibilityOf(driver, localSSdDropdown).click();
        localSSdDropdown.sendKeys(localSSdDropdownValue);
        localSSdDropdown.sendKeys(Keys.TAB);
        return this;
    }

    public PricingCalculatorGCPPage fillInDatacenterLocation(String datacenterLocationDropdownValue) {
        datacenterLocationDropdown.sendKeys(datacenterLocationDropdownValue);
        datacenterLocationDropdown.sendKeys(Keys.TAB);
        return this;
    }

    public PricingCalculatorGCPPage fillInCommitedUsage(String commitedUsageDropdownValue) {
        commitedUsageDropdown.sendKeys(commitedUsageDropdownValue);
        commitedUsageDropdown.sendKeys(Keys.TAB);
        return this;
    }

    public EstimateResultGCPPage calculateEstimation() {
        addToEstimateButton.click();
        return new EstimateResultGCPPage(driver);
    }

}
