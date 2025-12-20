package ma.enset.model;

public class BankAccount {
    private Long idBankAccount;
    private double balance;
    private String currency;
    private AccountType type;
    private AccountStatus status;

    // Constructors
    public BankAccount() {
    }

    public BankAccount(Long idBankAccount, double balance, String currency, AccountType type, AccountStatus status) {
        this.idBankAccount = idBankAccount;
        this.balance = balance;
        this.currency = currency;
        this.type = type;
        this.status = status;
    }

    // Getters
    public Long getIdBankAccount() {
        return idBankAccount;
    }

    public double getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public AccountType getType() {
        return type;
    }

    public AccountStatus getStatus() {
        return status;
    }

    // Setters

    public void setIdBankAccount(Long idBankAccount) {
        this.idBankAccount = idBankAccount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    // toString method

    @Override
    public String toString() {
        return "BankAccount{" +
                "idBankAccount=" + idBankAccount +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", type=" + type +
                ", status=" + status +
                '}';
    }
}
