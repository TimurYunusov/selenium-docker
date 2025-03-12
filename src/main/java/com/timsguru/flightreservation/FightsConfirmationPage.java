package com.timsguru.flightreservation;

import com.timsguru.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FightsConfirmationPage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(FightsConfirmationPage.class);

    @FindBy(css="#flights-confirmation-section .card-body .row:nth-child(1) .col:nth-child(2)")
    private WebElement flightConformationElement;

    @FindBy(css = "#flights-confirmation-section .card-body .row:nth-child(2) .col:nth-child(2)")
    private WebElement flightTaxElement;

    @FindBy(css ="#flights-confirmation-section .card-body .row:nth-child(3) .col:nth-child(2)")
    private WebElement totalPriceElement;





    public FightsConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.totalPriceElement));
        return this.totalPriceElement.isDisplayed();
    }

    public String getPrice(){
        String confirmation = this.flightConformationElement.getText();
        String price = this.totalPriceElement.getText();
        log.info("Flight confirmation# : {}", confirmation);
        log.info("Flight price# : {}", price);
        return price;
    }
}
