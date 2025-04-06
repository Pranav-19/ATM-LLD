public class WithdrawTransaction extends Transaction{

    public WithdrawTransaction(Account account, int amount) {
        super(account, amount);
    }

    @Override
    public void execute() throws Exception {
        if(account.getBalance() < amount){
            throw new Exception("Not enough balance!");
        }
       account.debit(amount);
    }
}
