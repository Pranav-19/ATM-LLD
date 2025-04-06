public class Account {
    private final String accountNum;
    private double balance;

    public Account(String accountNum, double balance) {
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public double getBalance() {
        return balance;
    }

    public void debit(double amount){
        balance -= amount;
    }

    public void credit(double amount){
        balance+= amount;
    }
}

