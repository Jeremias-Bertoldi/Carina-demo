package com.solvd.qa.apis.apiDollar;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"date", "buyPrice", "sellPrice"})
public class Dollar {
    private String date;
    private String purchasePrice;
    private String salePrice;

    public Dollar() {
    }

    public Dollar(String date, String purchasePrice, String salePrice) {
        this.date = date;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
    }

    @JsonProperty("fecha")
    public String getDate() {
        return date;
    }

    @JsonProperty("fecha")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("compra")
    public String getPurchasePrice() {
        return purchasePrice;
    }

    @JsonProperty("compra")
    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    @JsonProperty("venta")
    public String getSalePrice() {
        return salePrice;
    }

    @JsonProperty("venta")
    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    @Override
    public String toString() {
        return "Dollar{" +
                "date=' " + date + '\n' +
                "purchasePrice=' " + purchasePrice + '\n' +
                "salePrice=' " + salePrice + '\n' +
                '}';
    }
}
