package bg.tu_varna.sit.task5;

public class DepositAccount extends Account{
    public DepositAccount(int id, AccountType type, Currency currency, double balance) {
        super(id, type, currency, balance);
    }

    @Override
    public String toString() {
        return "Deposit Account: "+
                "\n Id: " + this.getId()+
                "\n AccountType: " + this.getType() +
                "\n Currency: " + this.getCurrency() +
                "\n Balance: "+ this.getBalance();
    }

    @Override
    public double calculateInterestValue() {
        if (this.getType() == AccountType.PERSONAL) return this.getBalance() * 0.09;
        if (this.getCurrency() == Currency.BGN) return this.getBalance() * 0.07;
        if (this.getCurrency() == Currency.USD) return this.getBalance() * 0.05;
        if (this.getCurrency() == Currency.EUR) return this.getBalance() * 0.02;
        return this.getBalance() * 0.01;
    }
}
