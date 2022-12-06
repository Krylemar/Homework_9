package bg.tu_varna.sit.task5;

import java.util.Calendar;

public class Application {
    public static void main(String[] args) {
        Bank dsk = new Bank();
        dsk.createAccount(new DepositAccount(1,AccountType.PERSONAL,Currency.EUR, 50.00));
        dsk.createAccount(new SalaryAccount(2,AccountType.CORPORATE,Currency.GBP, 150000.00));
        dsk.createAccount(new SavingsAccount(3,AccountType.PERSONAL,Currency.USD, 0.5));
        dsk.createAccount(new DepositAccount(4,AccountType.CORPORATE,Currency.BGN, 300000.00));
        dsk.createAccount(new SavingsAccount(5,AccountType.PERSONAL,Currency.USD, 0));

        System.out.println("Number of salary accounts: " + dsk.calculateNumberOfSalaryAccounts());
        System.out.println();
        System.out.println("Average interest for USD: " + dsk.calculateAverageInterestByCurrency(Currency.USD));
        System.out.println();
        System.out.println("Highest interest: " + dsk.findHighestInterest());
        System.out.println();
        System.out.println("All bank accounts: " + dsk.toString());

    }
}
