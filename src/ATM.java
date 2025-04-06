public class ATM {
    private final BankingService bankingService;
    private final CashDispenser cashDispenser;
    private Account currentUser;

    public ATM(BankingService bankingService, CashDispenser cashDispenser) {
        this.bankingService = bankingService;
        this.cashDispenser = cashDispenser;
        this.currentUser = null;
    }

    public synchronized void authenticateUser(Card card, String enteredPin) throws Exception {
        String accountNumber = card.authenticate(enteredPin);
        this.currentUser = bankingService.getAccount(accountNumber);
        System.out.println("User is authenticated");
    }

    public synchronized void withdrawCash(int amount) throws Exception {
        if(this.currentUser == null){
            throw new Exception("Please authenticate first");
        }
        Transaction withdrawTransaction = new WithdrawTransaction(currentUser, amount);
        bankingService.processTransaction(withdrawTransaction);
        cashDispenser.dispenseCash(amount);
        System.out.println("Withdrawn amount successfully: " + amount);
        this.currentUser = null;
    }

    public synchronized void depositCash(int amount) throws Exception {
        if(this.currentUser == null){
            throw new Exception("Please authenticate first");
        }
        Transaction transaction = new DepositTransaction(currentUser, amount);
        bankingService.processTransaction(transaction);
        cashDispenser.addCash(amount);
        System.out.println("Deposited amount successfully: " + amount);
        this.currentUser = null;
    }

    public double checkBalance() throws Exception {
        if(this.currentUser == null){
            throw new Exception("Please authenticate first");
        }
        System.out.println("Current balance is: " + currentUser.getBalance());
        double balance = currentUser.getBalance();
        this.currentUser = null;
        return balance;
    }
}
