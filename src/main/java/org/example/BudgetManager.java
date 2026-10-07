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

    private final Map<String, Double> savingsFunds = new HashMap<>();

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
        } else {
            double incomeAmout = transaction.getTransferMoney();
            double tenPercent = incomeAmout * 0.10;

            updateFundbalance("На отпуск", tenPercent);
            updateFundbalance("Подушка безопасности", tenPercent);
        }
        }

    private void updateFundbalance(String fundName, double amout) {
        if (savingsFunds.containsKey(fundName)) {
            double currentBalance = savingsFunds.get(fundName);
            savingsFunds.put(fundName, currentBalance + amout);
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
        System.out.println("\n --- Накопления ---");
        for (Map.Entry<String, Double> fund : savingsFunds.entrySet()) {
            System.out.printf("Фонд:[%s] | Отложено: %.2f рублей\n", fund.getKey(), fund.getValue());
        }
        System.out.println("========================================");
    }

    public void printUserHistory(User tergetUser) {
        System.out.printf("История трат пользователя[%s]: \n", tergetUser);
        for (Transaction transaction : transactionsHistory) {

            String authorName = transaction.getUser().getName();

            String targetName = tergetUser.getName();

            if (authorName.equals(targetName)) {
                String sing = transaction.isIncomeAndExpenses() ? "+" : "-";
                System.out.printf("   %s %.2f руб. | Категория: %s | %s\n",
                        sing, transaction.getTransferMoney(), transaction.getCategories(), transaction.getComments());

            }
        }
    }

    public void createFund(String fundName) {
        savingsFunds.put(fundName, 0.0);
    }
}
