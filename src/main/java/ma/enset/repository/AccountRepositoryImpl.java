package ma.enset.repository;

import ma.enset.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AccountRepositoryImpl implements AccountRepository {

    private static final AccountRepositoryImpl accountRepository;
    static {
        System.out.println("Static block executed: Initializing");
        accountRepository = new AccountRepositoryImpl();
    }

    private Map<Long, BankAccount> bankAccountMap = new HashMap<>();
    private Long accountIdSequence = 0L;

    @Override
    public BankAccount save(BankAccount bankAccount) {
        Long accountId;
        synchronized (this) { // Synchronize to ensure thread safety when generating unique account IDs
            accountId = ++accountIdSequence;
        }
        bankAccount.setIdBankAccount(accountId);
        synchronized (this) {
            bankAccountMap.put(accountId, bankAccount);
        }
        return bankAccount;
    }

    @Override
    public List<BankAccount> findAll() {
        return bankAccountMap.values().stream().toList();
    }

    @Override
    public Optional<BankAccount> findById(Long id) {
        BankAccount account = bankAccountMap.get(id);
        if (account == null) {
            return Optional.empty();
        }else {
            return Optional.of(account);
        }
    }

    @Override
    public List<BankAccount> searchAccounts(Predicate<BankAccount> predicate) {
        return bankAccountMap.values().stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    @Override
    public BankAccount update(BankAccount bankAccount) {
        bankAccountMap.put(bankAccount.getIdBankAccount(), bankAccount);
        return bankAccount;
    }

    @Override
    public void deleteById(Long id) {
        bankAccountMap.remove(id);
    }

    public synchronized void populateTestData() {
        for (int i = 0; i < 10; i++) {
            BankAccount account = BankDirector.accountBuilder()
                    .idBankAccount(++accountIdSequence)
                    .balance(1000 + Math.random() * 9000)
                    .currency(Math.random()>0.5? Currency.MAD: Currency.USD)
                    .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT: AccountType.SAVINGS_ACCOUNT)
                    .status(Math.random()>0.5? AccountStatus.ACTIVATED: AccountStatus.CREATED)
                    .build();
            save(account);
        }
        System.out.println("******************************");
        System.out.println(Thread.currentThread().getName());
        System.out.println("Account count:" + accountIdSequence);
        System.out.println("Account size: " + bankAccountMap.size());
        System.out.println("*******************************");
    }

    public synchronized static AccountRepositoryImpl getInstance(){
//        if (accountRepository==null){
//            System.out.println("Static block executed: Initializing");
//            accountRepository = new AccountRepositoryImpl();
//        }
        return accountRepository;
    }
}






