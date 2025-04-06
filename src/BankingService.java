import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BankingService {
    private Map<String, Account> accounts;

    public BankingService() {
        this.accounts = new ConcurrentHashMap<>();
    }

    public void createAccount(Account account) throws Exception {
        if(accounts.containsKey(account.getAccountNum())){
            throw new Exception("Account already exists!");
        }
        accounts.put(account.getAccountNum(), account);
    }

    public Account getAccount(String accountNum) {
        return accounts.get(accountNum);
    }

    public void processTransaction(Transaction transaction) throws Exception {
        transaction.execute();
    }
}
