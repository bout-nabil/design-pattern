package ma.enset;

import ma.enset.model.AccountStatus;
import ma.enset.model.AccountType;
import ma.enset.model.BankAccount;
import ma.enset.model.Currency;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BankAccount account = BankAccount.builder()
                .idBankAccount(1L)
                .balance(5000)
                .currency(Currency.MAD)
                .type(AccountType.CURRENT_ACCOUNT)
                .status(AccountStatus.ACTIVATED)
                .build();
        System.out.println(account.toString());
    }
}