package com.solvd.qa.apis.apiDollar;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"date", "months"})
public class Evolution {
    private String date;
    private List<Month>  months;

    public Evolution() {
    }

    public Evolution(String date, List<Month> months) {
        this.date = date;
        this.months = months;
    }

    @JsonProperty("fecha")
    public String getDate() {
        return date;
    }

    @JsonProperty("fecha")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("meses")
    public List<Month> getMonths() {
        return months;
    }

    @JsonProperty("meses")
    public void setMonths(List<Month> months) {
        this.months = months;
    }

    @Override
    public String toString() {
        return "Evolution{" +
                "date='" + date + '\n' +
                "months=" + months +
                '}';
    }
}
