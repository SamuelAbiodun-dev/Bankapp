package data.model;

public class BankCustomer {
    private Account account;
    private ATMCard atmCard;

    public BankCustomer(Account account, ATMCard atmCard) {
        this.account = account;
        this.atmCard = atmCard;
    }

    public BankCustomer() {

    }

    public ATMCard getAtmCard(){
        return atmCard;
    }
}
