package model;

public class SavingsAccount {
    private String id;
    private String accountCode;
    private String name;
    private String accountCreationDate;
    private String depositAmount;
    private String depositDate;
    private String interestRate;
    private String term;

    public SavingsAccount(String id, String accountCode, String name, String accountCreationDate, String depositAmount, String depositDate, String interestRate, String term) {
        this.id = id;
        this.accountCode = accountCode;
        this.name = name;
        this.accountCreationDate = accountCreationDate;
        this.depositAmount = depositAmount;
        this.depositDate = depositDate;
        this.interestRate = interestRate;
        this.term = term;
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

    public String getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(String depositAmount) {
        this.depositAmount = depositAmount;
    }

    public String getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(String depositDate) {
        this.depositDate = depositDate;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public static SavingsAccount fromCSV(String csvLine) {
        String[] values = csvLine.split(",");
        return new SavingsAccount(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7]);
    }

    public String convertData(){
        return String.join(",", id, accountCode, name, accountCreationDate, depositAmount, depositDate, interestRate, term) ;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "id='" + id + '\'' +
                ", accountCode='" + accountCode + '\'' +
                ", name='" + name + '\'' +
                ", accountCreationDate='" + accountCreationDate + '\'' +
                ", depositAmount='" + depositAmount + '\'' +
                ", depositDate='" + depositDate + '\'' +
                ", interestRate='" + interestRate + '\'' +
                ", term='" + term + '\'' +
                '}';
    }
}
