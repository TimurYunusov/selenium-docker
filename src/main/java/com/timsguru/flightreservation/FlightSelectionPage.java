package com.timsguru.flightreservation;

import com.timsguru.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FlightSelectionPage extends AbstractPage {

    @FindBy(name = "departure-flight")
    private List<WebElement> departureFlightsOptions;

    @FindBy(name = "arrival-flight")
    private List<WebElement> arrivalFlightsOptions;

    @FindBy(id = "confirm-flights")
    private WebElement confirmElementsButton;

    public FlightSelectionPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.confirmElementsButton));
        return this.confirmElementsButton.isDisplayed();
    }

    public void selectFlights() {
        int random = ThreadLocalRandom.current().nextInt(0, departureFlightsOptions.size());
        this.departureFlightsOptions.get(random).click();
        this.arrivalFlightsOptions.get(random).click();
    }

    public void confirmFlights() {
        this.confirmElementsButton.click();
    }
}
