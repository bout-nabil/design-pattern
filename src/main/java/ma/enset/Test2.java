package ma.enset;

import ma.enset.model.*;

public class Test2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        BankAccount bankAccount1 = new BankAccount();
        bankAccount1.setIdBankAccount(1L);
        bankAccount1.setCurrency(Currency.MAD);
        bankAccount1.setBalance(6000.0);
        bankAccount1.setType(AccountType.SAVINGS_ACCOUNT);
        bankAccount1.setStatus(AccountStatus.ACTIVATED);
        bankAccount1.setCustomer(new Customer(1L, "Nabil"));

        //BankAccount bankAccount2 = bankAccount1.clone();
        BankAccount bankAccount3 = bankAccount1.clone();

        System.out.println(bankAccount1);
        //System.out.println(bankAccount2);
        System.out.println(bankAccount3);

        bankAccount1.getCustomer().setName("Tawfiq");

        System.out.println("======================");
        System.out.println(bankAccount1);
        System.out.println(bankAccount3);

    }
}
