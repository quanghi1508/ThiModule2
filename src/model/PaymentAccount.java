package model;

public class PaymentAccount  {
    private String id;
    private String accountCode;
    private String name;
    private String accountCreationDate;
    private String cardNumber;
    private String balance;

    public PaymentAccount(String id, String accountCode, String name, String accountCreationDate, String cardNumber, String balance) {
        this.id = id;
        this.accountCode = accountCode;
        this.name = name;
        this.accountCreationDate = accountCreationDate;
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(String accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public static PaymentAccount fromCSV(String csvLine) {
        String[] values = csvLine.split(",");
        return new PaymentAccount(values[0], values[1], values[2], values[3], values[4], values[5]);
    }

    public String convertData(){
        return String.join(",", id, accountCode, name, accountCreationDate, cardNumber, balance) ;
    }

    @Override
    public String toString() {
        return "PaymentAccount{" +
                "id='" + id + '\'' +
                ", accountCode='" + accountCode + '\'' +
                ", name='" + name + '\'' +
                ", accountCreationDate='" + accountCreationDate + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
