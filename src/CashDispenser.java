public class CashDispenser {
    private int balance;

    public CashDispenser(int balance) {
        this.balance = balance;
    }

    public synchronized void dispenseCash(int amount) throws Exception {
        if(balance < amount) {
            throw new Exception("Not enough funds!");
        }
        balance -= amount;
    }

    public synchronized void addCash(int amount){
        balance += amount;
    }
}
