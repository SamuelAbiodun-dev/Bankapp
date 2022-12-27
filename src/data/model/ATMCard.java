package data.model;

public class ATMCard {
    private String cardNumber;
    private String securityCardNumber;
    private String pinNumber;


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getSecurityCardNumber() {
        return securityCardNumber;
    }

    public void setSecurityCardNumber(String securityCardNumber) {
        this.securityCardNumber = securityCardNumber;
    }

    public String getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }
}
