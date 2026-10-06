package org.example;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BudgetManager {

    private final List<Transaction> transactionsHistory = new ArrayList<>();

    private final Map<String, BudgetCategory> categoriesMap = new HashMap<>();

    private final Set<User> familyMembers = new HashSet<>();

    public void addUser(User user) {
        familyMembers.add(user);
    }

    public void addCategory(BudgetCategory category) {
        categoriesMap.put(category.getCategories(), category);
    }

    public void registerTransaction(Transaction transaction) {
        transactionsHistory.add(transaction);

        if (!transaction.isIncomeAndExpenses()) {

            String categoryName = transaction.getCategories();
            BudgetCategory category = categoriesMap.get(categoryName);

            if (category != null) {
                category.addExpense(transaction.getTransferMoney());

            }
        }
        }

    public void printAnalytics() {
        System.out.println("\n --- ФИНАНСОВЫЙ ОТЧЕТ ЗА МЕСЯЦ ---");

        for (BudgetCategory category : categoriesMap.values()) {

            double limit = category.getMonthlyLimit();
            double spent = category.getMoneySpentInTheCategoryThisMonth();
            double remains = limit - spent;
            System.out.printf("Категория: [%s] | Лимит: %.2f руб. | Потрачено: %.2f руб. | Остаток: %.2f руб.\n",
                    category.getCategories(), limit, spent, remains);
        }
        System.out.println("========================================");
        }


}
