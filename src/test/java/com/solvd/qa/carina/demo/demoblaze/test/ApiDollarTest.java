package com.solvd.qa.carina.demo.demoblaze.test;

import com.solvd.qa.apis.apiDollar.Dollar;
import com.solvd.qa.apis.apiDollar.Evolution;
import com.solvd.qa.apis.apiDollar.RiskValue;
import com.solvd.qa.carina.demo.demoblaze.services.IApiDollarService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiDollarTest implements IApiDollarService {

    @DataProvider
    static Object[][] endPoints(){
        return new Object[][] {
                {"api","dolaroficial"},
                {"api","dolarblue"},
                {"api","dolarbolsa"},
                {"api","contadoliqui"},
        };
    }

    @DataProvider
    static Object[][] endPointsEvolution(){
        return new Object[][] {
                {"api", "evolucion", "dolaroficial"},
                {"api", "evolucion", "dolarblue"},
                {"api", "evolucion", "realoficial"},
                {"api", "evolucion", "eurooficial"},
        };
    }


    @Test(dataProvider = "endPoints")
    public void testConnection(String api, String evolution){
        Dollar dollar = connectDollar(api, evolution);
        System.out.println(dollar);
    }

    @Test
    public void testCountryRisk(){
        RiskValue riskValue = connectRiskValue();
        System.out.println(riskValue);
    }

    @Test(dataProvider = "endPointsEvolution")
    public void testEvolution(String api, String evolution, String currency){
        Evolution evo = connectEvolution(api, evolution, currency);
        System.out.println(evo);
    }

}
