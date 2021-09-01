package pages.gcp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waiters.WaitersHelper;


public class PricingCalculatorGCPPage {

    private final String seriesMachineTypeLocator = "//md-select[@placeholder='Instance type']";
    private final String seriesMachineTypeN1S8Locator = "//md-option/div[contains(text(),'n1-standard-8')]";
    private final String addGPUsCheckboxLocator = "//md-checkbox[@aria-label='Add GPUs']/div[@class='md-container md-ink-ripple']";
    private final String numberOfGPUsDropdownLocator = "//label[contains(text(),'Number of GPUs')]/parent::md-input-container/md-select";
    private WebDriver driver;

    @FindBy(xpath = "//md-tab-item[1]/div/div/div[2]")
    private WebElement computeEngineButton;

    @FindBy(xpath = "//label[contains(text(),'Number of instances')]/following-sibling::input")
    private WebElement numberOfInstancesInput;

    @FindBy(xpath = "//label[contains(text(),'Operating System')]/parent::md-input-container/md-select")
    private WebElement softwareDropdown;

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

    public PricingCalculatorGCPPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PricingCalculatorGCPPage selectComputeEngineSection() {
        WaitersHelper.waitForVisibilityOf(driver,computeEngineButton).click();
        return this;
    }

    public PricingCalculatorGCPPage fillInNumberOfInstances(String numberOfInstances) {
        WaitersHelper.waitForVisibilityOf(driver,numberOfInstancesInput).click();
        numberOfInstancesInput.sendKeys(numberOfInstances);
        return this;
    }

    public PricingCalculatorGCPPage fillInEstimationForm() {
        this.fillInSoftware()
                .fillInMachineClass()
                .fillInSeries()
                .fillInMachineType()
                .fillInAddGPUs()
                .fillInNumberOfGPUs()
                .fillInGpuType()
                .fillInLocalSSd()
                .fillInDatacenterLocation()
                .fillInCommitedUsage();
        return this;
    }

    public PricingCalculatorGCPPage fillInSoftware() {
        softwareDropdown.click();
        softwareDropdownFree.click();
        return this;
    }

    public PricingCalculatorGCPPage fillInMachineClass() {
        machineClassDropdown.click();
        WaitersHelper.waitForVisibilityOf(driver,machineClassDropdownRegular).click();
        machineClassDropdownRegular.click();
        return this;
    }

    public PricingCalculatorGCPPage fillInSeries() {
        seriesDropdown.click();
        seriesDropdownN1.click(); // не кликом, заполнять, все
        return this;
    }

    public PricingCalculatorGCPPage fillInMachineType() {
        WaitersHelper.waitForPresenceOfElementLocated(driver,seriesMachineTypeLocator);
        seriesMachineType.click();
        WaitersHelper.waitForPresenceOfElementLocated(driver,seriesMachineTypeN1S8Locator);
        seriesMachineTypeN1S8.click();
        return this;
    }

    public PricingCalculatorGCPPage fillInAddGPUs() {
        WaitersHelper.waitForPresenceOfElementLocated(driver,addGPUsCheckboxLocator);
        addGPUsCheckbox.click();
        return this;
    }

    public PricingCalculatorGCPPage fillInNumberOfGPUs() {
        WaitersHelper.waitForPresenceOfElementLocated(driver,numberOfGPUsDropdownLocator).click();
        numberOfGPUsDropdown.click();
        numberOfGPUsDropdownN1.click();
        return this;
    }

    public PricingCalculatorGCPPage fillInGpuType() {
        gpuTypeDropdown.click();
        gpuTypeDropdownNTV100.click();
        return this;
    }

    public PricingCalculatorGCPPage fillInLocalSSd() {
        WaitersHelper.waitForVisibilityOf(driver, localSSdDropdown).click();
        localSSdDropdown.click();
        localSSdDropdown2x375GB.click();
        return this;
    }

    public PricingCalculatorGCPPage fillInDatacenterLocation() {
        datacenterLocationDropdown.click();
        datacenterLocationDropdownCarolina.click();
        return this;
    }

    public PricingCalculatorGCPPage fillInCommitedUsage() {
        commitedUsageDropdown.click();
        commitedUsageDropdown1year.click();
        return this;
    }

    public EstimateResultGCPPage calculateEstimation() {
        addToEstimateButton.click();
        return new EstimateResultGCPPage(driver);
    }

}
