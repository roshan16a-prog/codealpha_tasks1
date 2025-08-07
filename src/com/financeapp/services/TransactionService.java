package com.financeapp.services;

import com.financeapp.models.Transaction;

import java.time.LocalDate;
import java.util.*;

public class TransactionService {
    private HashMap<String, List<Transaction>> transactionMap = new HashMap<>();

    public Transaction addTransaction(String userId, String desc, double amount, LocalDate date, String category) {
        String txnId = UUID.randomUUID().toString();
        Transaction txn = new Transaction(txnId, userId, desc, amount, date, category);

        transactionMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(txn);
        return txn;
    }

    public List<Transaction> getTransactions(String userId) {
        return transactionMap.getOrDefault(userId, new ArrayList<>());
    }
}
