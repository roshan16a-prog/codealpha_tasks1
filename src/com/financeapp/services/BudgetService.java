package com.financeapp.services;

import com.financeapp.models.Transaction;

import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BudgetService {

    public void printMonthlySpending(List<Transaction> txns) {
        System.out.println("\n=== Monthly Spending Summary ===");
        Map<Month, Double> summary = txns.stream()
            .collect(Collectors.groupingBy(t -> t.getDate().getMonth(),
                    Collectors.summingDouble(Transaction::getAmount)));

        summary.forEach((month, total) ->
            System.out.println(month + ": ₹" + total));
    }
}
