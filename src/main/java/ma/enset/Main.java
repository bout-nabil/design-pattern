package ma.enset;

import ma.enset.model.*;
import ma.enset.repository.AccountRepositoryImpl;
import ma.enset.util.JsonSerializer;

import java.util.List;
import java.util.function.Predicate;


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

        JsonSerializer<BankAccount> bankAccountJsonSerializer = new JsonSerializer<>();

        AccountRepositoryImpl accountRepository = AccountRepositoryImpl.getInstance();
        accountRepository.populateTestData();
        List<BankAccount> accountList = accountRepository
                .searchAccounts(bankAccount ->
                        bankAccount.getStatus().equals(AccountStatus.ACTIVATED));

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