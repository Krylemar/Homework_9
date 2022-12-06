package bg.tu_varna.sit.task5;

public class SavingsAccount extends Account{
    public SavingsAccount(int id, AccountType type, Currency currency, double balance) {
        super(id, type, currency, balance);
    }

    @Override
    public String toString() {
        return "Savings Account: "+
                "\n Id: " + this.getId()+
                "\n AccountType: " + this.getType() +
                "\n Currency: " + this.getCurrency() +
                "\n Balance: "+ this.getBalance();
    }

    @Override
    public double calculateInterestValue() {
        if (this.getCurrency() == Currency.BGN && this.getType() == AccountType.PERSONAL) return this.getBalance() * 0.15;
        if (this.getCurrency() == Currency.BGN && this.getType() != AccountType.PERSONAL) return this.getBalance() * 0.05;
        if (this.getCurrency() == Currency.USD && this.getType() == AccountType.PERSONAL) return this.getBalance() * 0.1;
        return this.getBalance() * 0.01;
    }
}
