package org.example;

public class BudgetCategory {

    private String categories;                          // Категории
    private double monthlyLimit;                        // Лимит на месяц
    private double moneySpentInTheCategoryThisMonth;    // Потраченных денег в этом месяце

    public BudgetCategory(String categories,
                          double monthlyLimit,
                          double moneySpentInTheCategoryThisMonth) {

        this.categories = categories;
        this.monthlyLimit = monthlyLimit;
        this.moneySpentInTheCategoryThisMonth  = 0.0;
    }

    public String getCategories() {
        return categories;
    }

    public double getMonthlyLimit() {
        return monthlyLimit;
    }

    public double getMoneySpentInTheCategoryThisMonth() {
        return moneySpentInTheCategoryThisMonth;
    }

    public void setMonthlyLimit(double monthlyLimit) {
        this.monthlyLimit = monthlyLimit;
    }

    public void addExpense(double amount) {
        if (moneySpentInTheCategoryThisMonth + amount > monthlyLimit) {
            String errorMessage = String.format(
                    "Операция оклонена! Превышен лимит по категории [%s]. Осталось: %.2f рублей, а вы пытаетесь потратить: %.2f рублей.",
                    categories, (monthlyLimit - moneySpentInTheCategoryThisMonth), amount
            );
            throw new LimitExceededException(errorMessage);
        }
        this.moneySpentInTheCategoryThisMonth += amount;
    }




}
