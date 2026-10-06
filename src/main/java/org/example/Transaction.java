package org.example;

public class Transaction {

    private static int transactionId = 1;           // Номер операции

    private double transferMoney;                   // Сумма операции
    private String categories;                      // Категории трат (продукты, развлечения, техника)
    private boolean incomeAndExpenses;              // true - доход, falsh - расход
    private String comments;                        // Коментрарии о тратах или доходах
    private final int transactionNumber;

    public Transaction(double transferMoney,
                       String categories,
                       boolean incomeAndExpenses,
                       String comments) {
        this.transactionNumber = transactionId++;
        this.transferMoney = transferMoney;
        this.categories = categories;
        this.incomeAndExpenses = incomeAndExpenses;
        this.comments = comments;
    }

    public static int getTransactionId() {
        return transactionId;
    }

    public double getTransferMoney() {
        return transferMoney;
    }

    public String getCategories() {
        return categories;
    }

    public boolean isIncomeAndExpenses() {
        return incomeAndExpenses;
    }

    public String getComments() {
        return comments;
    }

    public int getTransactionNumber() {
        return transactionNumber;
    }
}

