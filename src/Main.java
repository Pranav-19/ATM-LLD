
public class Main {
    public static void main(String[] args) throws Exception {
        BankingService bankingService = new BankingService();
        CashDispenser cashDispenser = new CashDispenser(10000);
        Account a1 = new Account("1", 1000);
        Account a2 = new Account("2", 20000);
        Account a3 = new Account("3", 500);

        bankingService.createAccount(a1);
        bankingService.createAccount(a2);
        bankingService.createAccount(a3);

        Card c1 = new Card("1234567", "1111", "1");
        Card c2 = new Card("12234234", "2222", "2");
        Card c3 = new Card("142324312", "3333", "3");

        ATM atm = new ATM(bankingService, cashDispenser);

        atm.authenticateUser(c1, "1111");
        atm.withdrawCash(500);

        atm.authenticateUser(c1, "1111");
        atm.checkBalance();

        atm.authenticateUser(c3, "3333");
        atm.depositCash(3000);

        atm.authenticateUser(c3, "3333");
        atm.checkBalance();

//        atm.authenticateUser(c2, "2222");
//        atm.withdrawCash(50000);

    }
}