package com.tims.flightreservation;

import com.tims.AbstractTest;
import com.tims.flightreservation.model.FlightReservationTestData;
import com.tims.util.Config;
import com.tims.util.Constants;
import com.tims.util.JsonUtil;
import com.timsguru.flightreservation.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class FlightReservationTest extends AbstractTest {

    private FlightReservationTestData testData;

    @BeforeClass
    @Parameters({"testDataPath"})
    public void setParameters(String testDataPath) {
//        this.noOfPassengers = noOfPassengers;
//        this.expectedPrice = expectedPrice;
        //driver set up
      this.testData = JsonUtil.getTestData(testDataPath, FlightReservationTestData.class);
    }

    @Test
    public void userRegistration() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo(Config.get(Constants.FLIGHT_RESERVATION_URL));

        Assert.assertTrue(registrationPage.isAt());
        registrationPage.enterUserDetails(testData.firstName(), testData.lastName());
        registrationPage.enterUserCredentials(testData.email(), testData.password());
        registrationPage.enterAddress(testData.street(), testData.city(), testData.zip());
        registrationPage.register();
    }

    @Test(dependsOnMethods = "userRegistration")
    public void registrationConfirmationTest() {
        RegistrationConformationPage registrationConformationPage = new RegistrationConformationPage(driver);
        Assert.assertTrue(registrationConformationPage.isAt());
        Assert.assertEquals(registrationConformationPage.getFirstName(), testData.firstName());
        registrationConformationPage.goToFlightsSearch();
    }

    @Test(dependsOnMethods = "registrationConfirmationTest")
    public void flightSearchTest() {
        FlightSearchPage flightSearchPage = new FlightSearchPage(driver);
        Assert.assertTrue(flightSearchPage.isAt());
        flightSearchPage.selectPassengers(testData.passengersCount());
        flightSearchPage.setSearchFlightsClick();
    }

    @Test(dependsOnMethods = "flightSearchTest")
    public void flightSelectionTest() {
        FlightSelectionPage flightSelectionPage = new FlightSelectionPage(driver);
        Assert.assertTrue(flightSelectionPage.isAt());
        flightSelectionPage.selectFlights();
        flightSelectionPage.confirmFlights();
    }

    @Test(dependsOnMethods = "flightSelectionTest")
    public void flightReservationConfirmationTest() {
        FightsConfirmationPage fightsConfirmationPage = new FightsConfirmationPage(driver);
        Assert.assertTrue(fightsConfirmationPage.isAt());
        Assert.assertEquals(fightsConfirmationPage.getPrice(), testData.expectedPrice());
    }
}
