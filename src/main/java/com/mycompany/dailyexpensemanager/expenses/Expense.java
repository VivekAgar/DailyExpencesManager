package com.mycompany.dailyexpensemanager.expenses;

import java.util.UUID;

public class Expense {

    private String id;
    private float amount;
    private String dateString;
    private String tags;
    private String description;
    private String merchant;
    private String paymentMethod;
    private String category;

    public Expense(float amount, String dateString, String tags, String description, String paymentMethod, String category, String merchant) {

        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.dateString = dateString;
        this.tags = tags;
        this.description = description;
        this.paymentMethod = paymentMethod;
        this.category = category;
        this.merchant = merchant;
    }

    public String getId() {
        return id;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
