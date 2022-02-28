package com.solvd.qa.apis.apiDollar;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"date", "value"})
public class RiskValue {
    private String date;
    private String value;

    public RiskValue() {
    }

    public RiskValue(String date, String value) {
        this.date = date;
        this.value = value;
    }

    @JsonProperty("fecha")
    public String getDate() {
        return date;
    }

    @JsonProperty("fecha")
    public void setDate(String date) {
        this.date = date;
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
        return "RiskValue{" +
                "date='" + date + '\n' +
                "value='" + value + '\'' +
                '}';
    }
}
