package model;

public abstract class BankAccount {
    private String id;
    private String accountCode;
    private String name;
    private String accountCreationDate;

    public BankAccount(String id, String accountCode, String name, String accountCreationDate) {
        this.id = id;
        this.accountCode = accountCode;
        this.name = name;
        this.accountCreationDate = accountCreationDate;
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

    public static BankAccount fromCSV(String csvLine) {
        String[] values = csvLine.split(",");
        return new BankAccount(values[0], values[1], values[2], values[3]) {

            @Override
            public void displayDetails() {

            }
        };

    }

    public String convertData(){
        return String.join(",",id,accountCode ,name ,accountCreationDate) ;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id='" + id + '\'' +
                ", accountCode='" + accountCode + '\'' +
                ", name='" + name + '\'' +
                ", accountCreationDate='" + accountCreationDate + '\'' +
                '}';
    }

    public abstract void displayDetails();
}
