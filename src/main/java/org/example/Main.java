package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        BudgetCategory products = new BudgetCategory("Продукты", 12000, 0.0);
        BudgetCategory entertainment = new BudgetCategory("Развлечения", 5000, 0.0);
        User Dad = new User("@Dad", "Папа");
        User Mam = new User("@Mam", "Мама");
        BudgetManager manager = new BudgetManager();
        manager.createFund("На отпуск");
        manager.createFund("Подушка безопасности");

        manager.addUser(Dad);
        manager.addUser(Mam);
        manager.addCategory(products);
        manager.addCategory(entertainment);
        Transaction expense1 = new Transaction(Dad,2500.0, "Продукты", false, "Закупка еды на неделю");
        manager.registerTransaction(expense1);
        Transaction expense2 = new Transaction(Mam,1200.0, "Продукты", false, "Купила молоко и хлеб");
        manager.registerTransaction(expense2);
        Transaction income = new Transaction(Dad,45000.0, "Зарплата", true, "Аванс на карту");
        Transaction income1 = new Transaction(Dad,55000.0, "Зарплата", true, "Аванс на карту");
        manager.registerTransaction(income);

        manager.printAnalytics();


        System.out.println("\nПопытка совершить слишком дорогую покупку...");
        Transaction crazyExpense = new Transaction(Mam,1000.0, "Продукты", false, "Купили черную икру");
        manager.printUserHistory(Dad);
        manager.printUserHistory(Mam);


        manager.registerTransaction(crazyExpense);
        manager.printAnalytics();

    }
}