package com.solvd.qa.carina.demo.demoblaze.services;

import com.solvd.qa.apis.apiDollar.Dollar;
import com.solvd.qa.apis.apiDollar.Evolution;
import com.solvd.qa.apis.apiDollar.RiskValue;
import org.testng.annotations.DataProvider;

import static io.restassured.RestAssured.given;

public interface IApiDollarService {
    String BASE_URL = "https://api-dolar-argentina.herokuapp.com/";

    default Dollar connectDollar(String api, String endpoint){
        Dollar dollar =
                given().pathParams("api", api).pathParams("endPoint", endpoint).
                        when().
                        get(BASE_URL+"{api}/{endPoint}").
                        as(Dollar.class);
        return dollar;
    }

    default RiskValue connectRiskValue(){
        RiskValue riskValue =
                given().
                        when().
                        get(BASE_URL+"api/riesgopais").
                        as(RiskValue.class);
        return riskValue;
    }

    default Evolution connectEvolution(String api, String evolution, String currency){
        Evolution evo =
                given().pathParams("api", api).pathParams("evolution", evolution, "currency", currency)
                        .when()
                        .get(BASE_URL+"{api}/{evolution}/{currency}").
                        as(Evolution.class);
        return evo;
    }
}
