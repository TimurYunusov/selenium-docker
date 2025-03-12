package com.tims.vendorportal;

import com.tims.AbstractTest;
import com.tims.util.Config;
import com.tims.util.Constants;
import com.tims.util.JsonUtil;
import com.timsguru.vendorPortal.DashboardPage;
import com.timsguru.vendorPortal.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.tests.vendorportal.model.VendorPortalTestData;

public class VendorPortalTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(VendorPortalTest.class);
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private VendorPortalTestData testData;

    @BeforeTest
    @Parameters("testDataPath")
    public void setPageObjects(String testDataPath ) {
        this.loginPage = new LoginPage(driver);
        this.dashboardPage = new DashboardPage(driver);
        this.testData = JsonUtil.getTestData(testDataPath, VendorPortalTestData.class);
    }

    @Test
    public void loginTest() {
        loginPage.goTo(Config.get(Constants.VENDOR_PORTAL_URL));
        Assert.assertTrue(loginPage.isAt());
        loginPage.login(testData.username(), testData.password());
    }

    @Test(dependsOnMethods = "loginTest")
    public void dashboardTest() {
        Assert.assertTrue(dashboardPage.isAt());
        //finance metrics
        Assert.assertEquals(dashboardPage.getMonthlyEarnings(), testData.monthlyEarning());
        log.info("Monthly earnings are: {}", dashboardPage.getMonthlyEarnings());
        Assert.assertEquals(dashboardPage.getAnnualEarnings(), testData.annualEarning());
        log.info("Annual earnings are: {}", dashboardPage.getAnnualEarnings());
        Assert.assertEquals(dashboardPage.getProfitMargin(), testData.profitMargin());
        log.info("Profit margin is: {}", dashboardPage.getProfitMargin());
        Assert.assertEquals(dashboardPage.getAvailableInventory(), testData.availableInventory());
        log.info("Available inventory is: {}", dashboardPage.getAvailableInventory());
        //order history search
        dashboardPage.searchOrderHistoryBy(testData.searchKeyword());
        Assert.assertEquals(dashboardPage.getSearchResultsCount(), testData.searchResultsCount());

    }

    @Test(dependsOnMethods = "dashboardTest")
    public void logoutTest() {
        dashboardPage.logout();
        Assert.assertTrue(loginPage.isAt());
    }


}
