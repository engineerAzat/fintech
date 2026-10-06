package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        BudgetCategory products = new BudgetCategory("Продукты", 12000, 0.0);
        User Dad = new User("@Dad", "Папа");
        User Mam = new User("@Mam", "Мама");
        BudgetManager manager = new BudgetManager();
        manager.addUser(Dad);
        manager.addUser(Mam);
        manager.addCategory(products);
        Transaction expense1 = new Transaction(2500.0, "Продукты", false, "Закупка еды на неделю");
        manager.registerTransaction(expense1);
        Transaction expense2 = new Transaction(1200.0, "Продукты", false, "Купила молоко и хлеб");
        manager.registerTransaction(expense2);
        Transaction income = new Transaction(45000.0, "Зарплата", true, "Аванс на карту");
        manager.registerTransaction(income);
        manager.printAnalytics();

    }
}