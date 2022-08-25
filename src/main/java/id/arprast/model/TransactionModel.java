package id.arprast.model;

import id.arprast.ref.TransactionType;

import java.util.Date;

public class TransactionModel {
    long transactionId;
    long memberId;
    TransactionType transactionType;
    double amount;
    String currency;
    Date date;
    String name;

    public TransactionModel(long transactionId, long memberId, String transactionType, double amount, String currency, Date date) {
        this.transactionId = transactionId;
        this.memberId = memberId;
        this.transactionType = TransactionType.valueOfId(transactionType);
        this.amount = amount;
        this.currency = currency;
        this.date = date;
    }

    public TransactionModel(long transactionId, String name, long memberId, String transactionType, double amount, String currency, Date date) {
        this.transactionId = transactionId;
        this.name = name;
        this.memberId = memberId;
        this.transactionType = TransactionType.valueOfId(transactionType);
        this.amount = amount;
        this.currency = currency;
        this.date = date;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
