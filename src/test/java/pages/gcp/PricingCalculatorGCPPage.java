package pages.gcp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PricingCalculatorGCPPage {

    private final String seriesMachineTypeLocator = "//md-select[@placeholder='Instance type']";
    private final String seriesMachineTypeN1S8Locator = "//md-option/div[contains(text(),'n1-standard-8')]";
    private final String addGPUsCheckboxLocator = "//md-checkbox[@aria-label='Add GPUs']/div[@class='md-container md-ink-ripple']";
    private final String numberOfGPUsDropdownLocator = "select_value_label_408";
    private WebDriver driver;

    @FindBy(xpath = "//md-tab-item[1]/div/div/div[2]")
    private WebElement computeEngineButton;

    @FindBy(xpath = "//*[@id=\"input_66\"]")
    private WebElement numberOfInstancesInput;

    @FindBy(id = "select_value_label_59")
    private WebElement softwareDropdown;

    @FindBy(xpath = "//md-option/div[contains(text(),'Free: Debian,')]")
    private WebElement softwareDropdownFree;

    @FindBy(id = "select_value_label_60")
    private WebElement machineClassDropdown;

    @FindBy(id = "select_option_81")
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

    @FindBy(id = numberOfGPUsDropdownLocator)
    private WebElement numberOfGPUsDropdown;

    @FindBy(xpath = "//div[7]/md-select-menu/md-content/md-option[2]/div")
    private WebElement numberOfGPUsDropdownN1;

    @FindBy(id = "select_value_label_409")
    private WebElement gpuTypeDropdown;

    @FindBy(xpath = "//md-option[@value=\"NVIDIA_TESLA_V100\"]")
    private WebElement gpuTypeDropdownNTV100;

    @FindBy(id = "select_value_label_370")
    private WebElement localSSdDropdown;

    @FindBy(xpath = "//md-option/div[contains(text(),'2x375 GB')]")
    private WebElement localSSdDropdown2x375GB;

    @FindBy(id = "select_value_label_64")
    private WebElement datacenterLocationDropdown;

    @FindBy(xpath = "//div[10]/md-select-menu/md-content/md-option[2]/div")
    private WebElement datacenterLocationDropdownCarolina;

    @FindBy(id = "select_value_label_65")
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
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .visibilityOf(computeEngineButton));
        computeEngineButton.click();
        return this;
    }

    public PricingCalculatorGCPPage fillInNumberOfInstances(String numberOfInstances) {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .visibilityOf(numberOfInstancesInput));
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
        machineClassDropdownRegular.click();
        return this;
    }

    public PricingCalculatorGCPPage fillInSeries() {
        seriesDropdown.click();
        seriesDropdownN1.click();
        return this;
    }

    public PricingCalculatorGCPPage fillInMachineType() {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(seriesMachineTypeLocator)));
        seriesMachineType.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(seriesMachineTypeN1S8Locator)));
        seriesMachineTypeN1S8.click();
        return this;
    }

    public PricingCalculatorGCPPage fillInAddGPUs() {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(addGPUsCheckboxLocator)));
        addGPUsCheckbox.click();
        return this;
    }

    public PricingCalculatorGCPPage fillInNumberOfGPUs() {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .presenceOfElementLocated(By.id(numberOfGPUsDropdownLocator)));
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
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .visibilityOf(localSSdDropdown));
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
