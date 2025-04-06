public class Card {
    private final String cardNumber;
    private String pin;
    private final String accountNumber;

    public Card(String cardNumber, String pin, String accountNumber) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.accountNumber = accountNumber;
    }

    public void setPin(String pin, String oldPin) throws Exception {
        validatePin(oldPin);
        this.pin = pin;
    }

    public void validatePin(String enteredPin) throws Exception {
        if(enteredPin != this.pin){
            throw new Exception("Wrong pin entered");
        }
    }

    public String authenticate(String pin) throws Exception {
        validatePin(pin);
        return accountNumber;
    }
}
