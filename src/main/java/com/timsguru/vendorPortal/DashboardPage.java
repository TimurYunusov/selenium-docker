package com.timsguru.vendorPortal;

import com.timsguru.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashboardPage extends AbstractPage {
    private static final Logger log = LoggerFactory.getLogger(DashboardPage.class);

    @FindBy(id = "monthly-earning")
    private WebElement monthlyEarningElement;

    @FindBy(id = "annual-earning")
    private WebElement annualEarningElement;

    @FindBy(id = "profit-margin")
    private WebElement profitMarginElement;

    @FindBy(id = "available-inventory")
    private WebElement availableInventoryElement;

    @FindBy(css = "#dataTable_filter input")
    private WebElement searchInput;

    @FindBy(id = "dataTable_info")
    private WebElement searchResultsCountElements;

    @FindBy(css = "#userDropdown .img-profile")
    private WebElement userProfilePictureElement;
    //dropdown-item
    @FindBy(linkText = "Logout")
    private WebElement logoutLinkElement;

    @FindBy(css = "#logoutModal a")
    private WebElement logoutAlertButtonElement;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.annualEarningElement));
        return this.annualEarningElement.isDisplayed();
    }

    public String getMonthlyEarnings(){
        return this.monthlyEarningElement.getText();
    }
    public String getAnnualEarnings(){
        return this.annualEarningElement.getText();
    }
    public String getProfitMargin(){
        return this.profitMarginElement.getText();
    }
    public String getAvailableInventory(){
        return this.availableInventoryElement.getText();
    }
     public void searchOrderHistoryBy(String keyword){
        this.searchInput.sendKeys(keyword);
     }
     public int getSearchResultsCount(){
      // return Integer.getInteger(this.searchResultsCountElements.getText().split("of ")[1]);
    String resultText = this.searchResultsCountElements.getText();
    String [] arr = resultText.split(" ");
    int count = Integer.parseInt(arr[5]);
    log.info("Results count: {}", count);
    return count;
    }

    public void logout(){
        this.userProfilePictureElement.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.logoutLinkElement));
        this.logoutLinkElement.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.logoutAlertButtonElement));
        this.logoutAlertButtonElement.click();
    }

}
