package com.epam.ta.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import com.epam.ta.pages.gcp.EstimateResultGCPPage;
import com.epam.ta.pages.gcp.PricingCalculatorGCPPage;
import com.epam.ta.testdata.TestDataGCP;

public class PriceCalculationGCPTest extends CommonConditions {

    @DataProvider(name = "valuesForPriceCalculation")
    public Object[][] valuesForPriceCalculation() {
        return new Object[][]{
                {"Google Cloud Platform Pricing Calculator",
                        new TestDataGCP (
                        "4",
                        "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)",
                        "Regular",
                        "N1",
                        "n1-standard-8 (vCPUs: 8, RAM: 30GB)",
                        true,
                        "1",
                        "NVIDIA Tesla V100",
                        "2x375 GB",
                        "South Carolina (us-east1)",
                        "1 Year"
                        ), "Total Estimated Cost: USD 5,413.06 per 1 month"}
        }; // передавать все данные
    }

    @Test(dataProvider = "valuesForPriceCalculation")
    public void calculateAndVerifyPriceForGCPTest(String searchString, TestDataGCP testDataGCP, String expectedResult) {

        // 1. go to the GCP calculator form
        // 2. insert search data
        // 3. get actual result and mach with expected

        PricingCalculatorGCPPage pricingCalculatorGCPPage = new PricingCalculatorGCPPage(driver, testDataGCP)
                .openPricingCalculatorGCPPage(searchString);

        EstimateResultGCPPage estimateResultGCPPage = pricingCalculatorGCPPage
                .selectComputeEngineSection()
                .fillInEstimationForm(testDataGCP)
                .calculateEstimation();

        String actualEstimation = estimateResultGCPPage.getTotalEstimation();


        /*Assert.assertTrue(actualDataGCP.contains(testDataGCP),

        Assert.assertTrue(estimateResultGCPPage.getMachineClassLabelText().contains(machineClass),
                "Machine Class is incorrect");
        Assert.assertTrue(estimateResultGCPPage.getInstanceTypeLabelText().contains(instanceType),
                "Instance Type is incorrect");
        Assert.assertTrue(estimateResultGCPPage.getDatacenterLocationLabelText().contains(datacenterLocation),
                "Datacenter Location is incorrect");
        Assert.assertTrue(estimateResultGCPPage.getLocalSSdLabelText().contains(localSSd),
                "Local SSD is incorrect");
        Assert.assertTrue(estimateResultGCPPage.getCommitedUsageLabelText().contains(commitedUsage),
                "Commited Usage is incorrect");

        Assert.assertEquals(actualEstimation, expectedEstimation, "Estimation is incorrect");*/
    }



    @DataProvider(name = "valuesForEmailEstimation")
    public Object[][] valuesForEmailEstimation() {
        return new Object[][]{
                {"Google Cloud Platform Pricing Calculator", "4", "Estimated Monthly Cost: USD 5,413.06"}
        };
    }

    /*@Test(dataProvider = "valuesForEmailEstimation")
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

    }*/

    @Test(dataProvider = "valuesForPriceCalculation")
    public void calculatePriceForGCPSmokeTest(String searchString, TestDataGCP testDataGCP, String expectedResult) {

        PricingCalculatorGCPPage pricingCalculatorGCPPage = new PricingCalculatorGCPPage(driver, testDataGCP)
                .openPricingCalculatorGCPPage(searchString)
                .selectComputeEngineSection();
        Assert.assertNotNull(pricingCalculatorGCPPage, "pricingCalculatorGCPPage is empty");
    }

}