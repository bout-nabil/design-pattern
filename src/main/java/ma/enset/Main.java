package ma.enset;

import ma.enset.model.*;
import ma.enset.repository.AccountRepositoryImpl;
import ma.enset.util.JsonSerializer;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;


public class Main {
    public static void main(String[] args) throws IOException {
//        BankAccount account = BankDirector.accountBuilder()
//                .idBankAccount(1L)
//                .balance(5000)
//                .currency(Currency.MAD)
//                .type(AccountType.CURRENT_ACCOUNT)
//                .status(AccountStatus.ACTIVATED)
//                .build();
//        System.out.println(account.toString());

        JsonSerializer<BankAccount> bankAccountJsonSerializer = new JsonSerializer<>();
        AccountRepositoryImpl accountRepository = AccountRepositoryImpl.getInstance();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                accountRepository.populateTestData();
            }).start();
        }

        System.out.println("Tapez sur une touche pour continuer...");
        System.in.read();
//        accountRepository.populateTestData();

        List<BankAccount> accountList = accountRepository.findAll();

        accountList.stream()
                .map(bankAccountJsonSerializer::toJson)
                .forEach(System.out::println);

        System.out.println("====================");

//        BankAccount account = accountRepository.findById(2L).orElse(null);
//        if (account != null) {
//            System.out.println(bankAccountJsonSerializer.toJson(account));
//        }
    }
}