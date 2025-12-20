package ma.enset;

import ma.enset.model.*;
import ma.enset.repository.AccountRepositoryImpl;

import java.util.List;


public class Main {
    public static void main(String[] args) {
//        BankAccount account = BankDirector.accountBuilder()
//                .idBankAccount(1L)
//                .balance(5000)
//                .currency(Currency.MAD)
//                .type(AccountType.CURRENT_ACCOUNT)
//                .status(AccountStatus.ACTIVATED)
//                .build();
//        System.out.println(account.toString());

        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
        accountRepository.populateTestData();
        List<BankAccount> accountList = accountRepository.findAll();
        accountList.forEach(System.out::println);

    }
}