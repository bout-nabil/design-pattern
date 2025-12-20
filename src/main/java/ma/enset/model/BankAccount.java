package ma.enset.model;

public class BankAccount {
    private Long idBankAccount;
    private double balance;
    private Currency currency;
    private AccountType type;
    private AccountStatus status;

    // Constructors
    public BankAccount() {
    }

    public BankAccount(Long idBankAccount, double balance, Currency currency, AccountType type, AccountStatus status) {
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

    public Currency getCurrency() {
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

    public void setCurrency(Currency currency) {
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

    public static AccountBuilder builder() {
        return new AccountBuilder();
    }

    public static class AccountBuilder{
        private BankAccount bankAccount = new BankAccount();

        public AccountBuilder idBankAccount(Long idBankAccount) {
            bankAccount.idBankAccount = idBankAccount;
            return this;
        }
        public AccountBuilder balance(double balance) {
            bankAccount.balance = balance;
            return this;
        }
        public AccountBuilder currency(Currency currency) {
            bankAccount.currency = currency;
            return this;
        }
        public AccountBuilder type(AccountType type) {
            bankAccount.type = type;
            return this;
        }
        public AccountBuilder status(AccountStatus status) {
            bankAccount.status = status;
            return this;
        }

        public BankAccount build() {
            return this.bankAccount;
        }
    }
}
