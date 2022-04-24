package com.example.ezinvoicecustomer;

public class InvoiceModel {
    private String businessName;
    private String description;
    private String price;
    private String paidStatus;
    private String date;

    // Constructor
    public InvoiceModel(String businessName, String description, String price, String paidStatus, String date) {
        this.businessName = businessName;
        this.description = description;
        this.price = price;
        this.paidStatus = paidStatus;
        this.date = date;
    }

    // Getter and Setter
    public String getbusinessName() {
        return businessName;
    }

    public void setbusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public String getprice() {
        return price;
    }

    public void setprice(String price) {
        this.price = price;
    }

    public String getpaidStatus() {
        return paidStatus;
    }

    public void setpaidStatus(String paidStatus) {
        this.paidStatus = paidStatus;
    }

    public String getdate() {
        return date;
    }

    public void setdate(String date) {
        this.date = date;
    }
}