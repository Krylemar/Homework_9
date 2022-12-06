package bg.tu_varna.sit.task5;

import java.util.HashSet;
import java.util.Set;

public class Bank {
    Set<Account> accounts;

    public boolean createAccount(Account account){
        return accounts.add(account);
    }

    public boolean closeAccount(Account account){
        return accounts.remove(account);
    }

    public Bank() {
        this.accounts = new HashSet<>();
    }

    public int calculateNumberOfSalaryAccounts(){
        int count = 0;
        for (Account account : accounts)
            if (account instanceof SalaryAccount) count ++;
        return count;
    }

    public double calculateAverageInterestByCurrency(Currency currency){
        double totalInterest = 0.00d;
        int count = 0;
        for (Account account : accounts){
            if (account != null && account.getCurrency() == currency) {
                totalInterest += account.calculateInterestValue();
                count ++;
            }
        }
        return totalInterest/count;
    }

    public double findHighestInterest(){
        double maxInterest = 0.00d;
        for (Account account : accounts) {
            if (account.getCurrency() != Currency.BGN){
                double interest;
                switch (account.getCurrency()){
                    case USD -> {
                        interest = account.calculateInterestValue() * 1.87;
                        if (interest > maxInterest) maxInterest = interest;
                    }
                    case EUR -> {
                        interest = account.calculateInterestValue() * 1.96;
                        if (interest > maxInterest) maxInterest = interest;
                    }
                    case GBP -> {
                        interest = account.calculateInterestValue() * 2.27;
                        if (interest > maxInterest) maxInterest = interest;
                    }
                }
            }
        }
        return maxInterest;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Account account : accounts) {
            stringBuilder.append(account.toString()).append("\n\n");
        }
        return stringBuilder.toString();
    }
}
