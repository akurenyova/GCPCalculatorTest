package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.gcp.EstimateResultGCPPage;
import pages.gcp.MainGCPPage;
import pages.gcp.PricingCalculatorGCPPage;
import pages.gcp.SearchResultsGCPPage;
import pages.mail.TenMinuteMailPage;

public class PriceCalculationGCPTest {

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @DataProvider(name = "valuesForPriceCalculation")
    public Object[][] valuesForPriceCalculation() {
        return new Object[][]{
                {"Google Cloud Platform Pricing Calculator", "4", "regular",
                        "n1-standard-8", "South Carolina",
                        "2x375 GiB", "1 Year", "Total Estimated Cost: USD 5,413.06 per 1 month"}
        };
    }

    @Test (dataProvider = "valuesForPriceCalculation")
    public void calculatePriceForGCPTest(String searchTerm, String numberOfInstance, String machineClass,
                                         String instanceType, String datacenterLocation,
                                         String localSSd, String commitedUsage, String expectedEstimation) {

        SearchResultsGCPPage searchResultsGCPPage = new MainGCPPage(driver)
                .openPage()
                .searchForTerms(searchTerm);
        PricingCalculatorGCPPage pricingCalculatorGCPPage = searchResultsGCPPage.openPricingCalculator();

        EstimateResultGCPPage estimateResultGCPPage = pricingCalculatorGCPPage
                .selectComputeEngineSection()
                .fillInNumberOfInstances(numberOfInstance)
                .fillInEstimationForm()
                .calculateEstimation();

        String actualEstimation = estimateResultGCPPage.totalEstimation();

        Assert.assertTrue(estimateResultGCPPage.machineClassLabelText().contains(machineClass),
                "Machine Class is incorrect");
        Assert.assertTrue(estimateResultGCPPage.instanceTypeLabelText().contains(instanceType),
                "Instance Type is incorrect");
        Assert.assertTrue(estimateResultGCPPage.datacenterLocationLabelText().contains(datacenterLocation),
                "Datacenter Location is incorrect");
        Assert.assertTrue(estimateResultGCPPage.localSSdLabelText().contains(localSSd),
                "Local SSD is incorrect");
        Assert.assertTrue(estimateResultGCPPage.commitedUsageLabelText().contains(commitedUsage),
                "Commited Usage is incorrect");

        Assert.assertEquals(actualEstimation, expectedEstimation, "Estimation is incorrect");
    }

    @DataProvider(name = "valuesForEmailEstimation")
    public Object[][] valuesForEmailEstimation() {
        return new Object[][]{
                {"Google Cloud Platform Pricing Calculator", "4", "Estimated Monthly Cost: USD 5,413.06"}
        };
    }

    @Test (dataProvider = "valuesForEmailEstimation")
    public void sendAndVerifyEmailEstimationPriceForGCPTest(String searchTerm, String numberOfInstance,
                                                            String expectedEstimation) {

        SearchResultsGCPPage searchResultsGCPPage = new MainGCPPage(driver)
                .openPage()
                .searchForTerms(searchTerm);
        PricingCalculatorGCPPage pricingCalculatorGCPPage = searchResultsGCPPage.openPricingCalculator();

        TenMinuteMailPage tenMinuteMailPage = pricingCalculatorGCPPage
                .selectComputeEngineSection()
                .fillInNumberOfInstances(numberOfInstance)
                .fillInEstimationForm()
                .calculateEstimation()
                .openEmailEstimateForm()
                .openTenMinuteMailPage();

        String actualEstimation = tenMinuteMailPage
                .getTempEmail()
                .switchToSendEmailPage()
                .sendEstimationViaEmail()
                .switchToTenMinuteEmailPage()
                .openEmail()
                .estimationFromEmail();

        Assert.assertEquals(actualEstimation, expectedEstimation, "Estimation is incorrect");

    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
