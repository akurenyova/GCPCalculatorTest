package com.epam.ta.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.epam.ta.pages.gcp.PricingCalculatorGCPPage;


public class PriceCalculationGCPSmokeTest extends CommonConditions {

    @DataProvider(name = "valuesForPriceCalculation")
    public Object[][] valuesForPriceCalculation() {
         return new Object[][]{
                {"Google Cloud Platform Pricing Calculator"}
            };
        }

   @Test(dataProvider = "valuesForPriceCalculation")
   public void calculatePriceForGCPSmokeTest(String searchString) {

        PricingCalculatorGCPPage pricingCalculatorGCPPage = new PricingCalculatorGCPPage(driver, null)
                .openPricingCalculatorGCPPage(searchString)
                .selectComputeEngineSection();
        Assert.assertNotNull(pricingCalculatorGCPPage, "pricingCalculatorGCPPage is empty");
    }
}
