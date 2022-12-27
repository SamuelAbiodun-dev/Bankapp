package data.model;

import java.math.BigDecimal;

public class Account {
    private BankCustomer customerFirstname;
    private  BankCustomer customerLastname;
    private BankCustomer AcctNumber;
    private BankCustomer customerPhoneNumber;
    private BankCustomer verificationNumber;
    private BigDecimal balance;


    public Account(BankCustomer customerFirstname, BankCustomer customerLastname, BankCustomer acctNumber, BankCustomer customerPhoneNumber,
                   BankCustomer verificationNumber, BigDecimal balance) {
        this.customerFirstname = customerFirstname;
        this.customerLastname = customerLastname;
        AcctNumber = acctNumber;
        this.customerPhoneNumber = customerPhoneNumber;
        this.verificationNumber = verificationNumber;
        if(balance.doubleValue() > 0.0){
            this.balance = balance;
        }
    }

    public Account() {

    }

    public BankCustomer getCustomerFirstname() {
        return customerFirstname;
    }

    public void setCustomerFirstname(BankCustomer customerFirstname) {
        this.customerFirstname = customerFirstname;
    }

    public BankCustomer getCustomerLastname() {
        return customerLastname;
    }

    public void setCustomerLastname(BankCustomer customerLastname) {
        this.customerLastname = customerLastname;
    }

    public BankCustomer getAcctNumber() {
        return AcctNumber;
    }

    public void setAcctNumber(BankCustomer acctNumber) {
        AcctNumber = acctNumber;
    }

    public BankCustomer getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(BankCustomer customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public BankCustomer getVerificationNumber() {
        return verificationNumber;
    }

    public void setVerificationNumber(BankCustomer verificationNumber) {
        this.verificationNumber = verificationNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal moneyToBeDeposited) {
        if(moneyToBeDeposited.doubleValue() > 0.0){
            balance = balance.add(moneyToBeDeposited);
        }
    }
    public void withDrawAmount(BigDecimal moneyToBeWithDrawn){
        if(moneyToBeWithDrawn.doubleValue() > balance.doubleValue()) throw new IllegalArgumentException("Minimum withdrawal " +
                "amount exceeded");
        balance = balance.subtract(moneyToBeWithDrawn);
    }

    public void transferAmount(Account2 account2, BigDecimal amountToBeTransferredFromAccountOne){
        if(amountToBeTransferredFromAccountOne.doubleValue() > balance.doubleValue()) throw  new IllegalArgumentException("Insufficient fund");
        Account account1 = new Account();
        account1.withDrawAmount(amountToBeTransferredFromAccountOne);
//            balance = balance.subtract(amountToBeTransferred);
        account2.deposit(balance.add(amountToBeTransferredFromAccountOne));
    }
    public void receiveAmountThroughTransfer(Account2 account2, BigDecimal amountToBeReceivedFromAccountTwo){
        Account account1 = new Account();
        account2.withDrawAmount(amountToBeReceivedFromAccountTwo);
        account1.deposit(balance.add(amountToBeReceivedFromAccountTwo));
    }
}
