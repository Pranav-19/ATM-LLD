public abstract class Transaction {
    protected final Account account;
    protected final int amount;

    Transaction(Account account, int amount){
        this.account = account;
        this.amount = amount;
    }

    abstract void execute() throws Exception;
}
