package com.financeapp;

import com.financeapp.models.*;
import com.financeapp.services.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        TransactionService transactionService = new TransactionService();
        CategorizationService categorizationService = new CategorizationService();
        BudgetService budgetService = new BudgetService();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username to register: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        User user = authService.register(username, password, email);
        System.out.println("User registered with ID: " + user.getUserId());

        System.out.print("Add a transaction description: ");
        String desc = scanner.nextLine();
        System.out.print("Amount: ");
        double amount = scanner.nextDouble();

        String category = categorizationService.categorize(desc);
        Transaction txn = transactionService.addTransaction(user.getUserId(), desc, amount, LocalDate.now(), category);

        System.out.println("Transaction added: " + txn.getDescription() + " (" + txn.getCategory() + ")");

        List<Transaction> allTxns = transactionService.getTransactions(user.getUserId());
        budgetService.printMonthlySpending(allTxns);
    }
}
