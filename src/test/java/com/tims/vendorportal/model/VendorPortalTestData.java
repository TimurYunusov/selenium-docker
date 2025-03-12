package com.tests.vendorportal.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VendorPortalTestData(String username,
                                   String password,
                                   String monthlyEarning,
                                   String annualEarning,
                                  // @JsonProperty("profitMargins")
                                   String profitMargin,
                                   String searchKeyword,
                                   String availableInventory,
                                   int searchResultsCount) {
    // "username": "john",
    //  "password": "john",
    //  "monthlyEarning": "$3,453",
    //  "annualEarning" : "$34,485",
    //  "profitMargin" : "-16%",
    //  "searchKeyword": "2024/01/01",
    //  "availableInventory": "67",
    //  "searchResultsCount": 0
}
