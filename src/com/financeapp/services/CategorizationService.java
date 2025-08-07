package com.financeapp.services;

public class CategorizationService {
    public String categorize(String description) {
        description = description.toLowerCase();

        if (description.contains("uber") || description.contains("taxi")) return "TRANSPORT";
        if (description.contains("grocery") || description.contains("market")) return "GROCERIES";
        if (description.contains("netflix") || description.contains("movie")) return "ENTERTAINMENT";
        if (description.contains("electricity") || description.contains("water")) return "UTILITIES";
        if (description.contains("hospital") || description.contains("pharmacy")) return "HEALTH";
        if (description.contains("bill") || description.contains("insurance")) return "BILLS";

        return "OTHER";
    }
}
