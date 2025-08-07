package com.financeapp.models;

import java.time.LocalDate;

public class Transaction {
    private String transactionId;
    private String userId;
    private String description;
    private double amount;
    private LocalDate date;
    private String category;

    public Transaction(String transactionId, String userId, String description, double amount, LocalDate date, String category) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    public String getTransactionId() { return transactionId; }
    public String getUserId() { return userId; }
    public String getDescription() { return description; }
    public double getAmount() { return amount; }
    public LocalDate getDate() { return date; }
    public String getCategory() { return category; }
}
