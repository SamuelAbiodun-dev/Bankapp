package data.model;

public class AppUser extends BankCustomer{

    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
    private int age;
    private Account account;


    public AppUser(String firstName, String email, String password, String phoneNumber, String number, Account account, ATMCard atmCard) {
        super(account, atmCard);

        this.userName = firstName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.account = account;
    }

    public AppUser() {
        super();
    }


    public String getFirstName() {
        return userName;
    }

    public void setFirstName(String firstName) {
        this.userName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
