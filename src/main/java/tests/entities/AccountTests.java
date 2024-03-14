package tests.entities;

import entities.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.factory.AccountFactory;

public class AccountTests {

    @Test
    public void depositShouldIncreaseBalanceWhenPositiveAmount(){

        double amount = 200.0;
        double expectedValue = 196.0;
        Account account = AccountFactory.createEmpityAccount();

        account.deposit(amount);

        Assertions.assertEquals(expectedValue, account.getBalance());
    }

    @Test
    public void depositShouldDoNothingWhenNegativeAmount() {
        double expectedValue = 100.0;
        Account account = AccountFactory.createAccount(expectedValue);
        double amount = -200.0;

        account.deposit(amount);

        Assertions.assertEquals(expectedValue, account.getBalance());
    }

    @Test
    public void fullWithdrawShouldClearBalance () {
        double expectedValue = 0.0;
        Account account = AccountFactory.createAccount(500.0);

       account.fullWithdraw();

        Assertions.assertTrue(account.getBalance() == expectedValue);
    }

}
