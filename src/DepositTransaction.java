public class DepositTransaction extends Transaction {
    public DepositTransaction(Account account, int amount) {
        super(account, amount);
    }

    @Override
    void execute() {
        account.credit(amount);
    }
}
