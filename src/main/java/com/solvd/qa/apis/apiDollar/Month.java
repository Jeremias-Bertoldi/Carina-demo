package com.solvd.qa.apis.apiDollar;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"year", "month", "value"})
public class Month {
    private String year;
    private String month;
    private String value;

    public Month() {
    }


    public Month(String year, String month, String value) {
        this.year = year;
        this.month = month;
        this.value = value;
    }

    @JsonProperty("anio")
    public String getYear() {
        return year;
    }

    @JsonProperty("anio")
    public void setYear(String year) {
        this.year = year;
    }

    @JsonProperty("mes")
    public String getMonth() {
        return month;
    }

    @JsonProperty("mes")
    public void setMonth(String month) {
        this.month = month;
    }

    @JsonProperty("valor")
    public String getValue() {
        return value;
    }

    @JsonProperty("valor")
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Month{" +
                "year='" + year + '\n' +
                "month='" + month + '\n' +
                "value='" + value + '\'' +
                '}';
    }
}
