package data.model;

import java.math.BigDecimal;

public class Account2 {
        private BankCustomer customerFirstname;
        private  BankCustomer customerLastname;
        private BankCustomer AcctNumber;
        private BankCustomer customerPhoneNumber;
        private BankCustomer verificationNumber;
        private BigDecimal balance;


        public Account2(BankCustomer customerFirstname, BankCustomer customerLastname, BankCustomer acctNumber, BankCustomer customerPhoneNumber,
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

    public Account2() {

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

        public void transferAmount(Account account1, BigDecimal amountToBeTransferred){
            if(amountToBeTransferred.doubleValue() > balance.doubleValue()) throw  new IllegalArgumentException("Insufficient fund");
            Account2 account2 = new Account2();
            account2.withDrawAmount(balance.subtract(amountToBeTransferred));
//            balance = balance.subtract(amountToBeTransferred);
           account1.deposit(balance.add(amountToBeTransferred));
        }
        public void receiveAmountThroughTransfer(Account account1, BigDecimal amountToBeReceivedByAccountTwo){
            Account2 account2 = new Account2();
            account1.withDrawAmount(amountToBeReceivedByAccountTwo);
            account2.deposit(balance.add(amountToBeReceivedByAccountTwo));
        }
    }

