package bg.tu_varna.sit.task5;

public class SalaryAccount extends Account{
    public SalaryAccount(int id, AccountType type, Currency currency, double balance) {
        super(id, type, currency, balance);
    }

    @Override
    public String toString() {
        return "Salary Account: "+
                "\n Id: " + this.getId()+
                "\n AccountType: " + this.getType() +
                "\n Currency: " + this.getCurrency() +
                "\n Balance: "+ this.getBalance();
    }

    @Override
    public double calculateInterestValue() {
        if (this.getType() == AccountType.CORPORATE) return 0.00d;
        if (this.getCurrency() == Currency.BGN) return this.getBalance() * 0.05;
        if (this.getCurrency() == Currency.USD) return this.getBalance() * 0.03;
        if (this.getCurrency() == Currency.EUR) return this.getBalance() * 0.02;
        return this.getBalance() * 0.01;
    }
}
