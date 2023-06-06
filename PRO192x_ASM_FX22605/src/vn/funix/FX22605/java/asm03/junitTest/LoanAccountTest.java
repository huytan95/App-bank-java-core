package vn.funix.FX22605.java.asm03.junitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import vn.funix.FX22605.java.asm03.models.LoanAccount;

public class LoanAccountTest {

    private LoanAccount loanAccount;

    @BeforeEach
    public void setup() {
        loanAccount = new LoanAccount();
        double initialBalance = 1000000;
        loanAccount.setBalance(initialBalance);
    }

    @Test
    public void testWithdrawAcceptedPremium() {
        double initialBalance = 1000000;
        loanAccount.setBalance(initialBalance);
        double amount = 500000;
 
        boolean result = loanAccount.withdraw(amount);

        assertTrue(result);
        double expectedBalance = initialBalance - (amount * (1 + LoanAccount.LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE));
        assertEquals(expectedBalance, loanAccount.getBalance(), 0.0);
    }

    @Test
    public void testWithdrawAcceptedNormal() {
        double initialBalance = 1000000;
        loanAccount.setBalance(initialBalance);
        double amount = 500000;

        boolean result = loanAccount.withdraw(amount);

        assertTrue(result);
        double expectedBalance = initialBalance - (amount * (1 + LoanAccount.LOAN_ACCOUNT_WITHDRAW_FEE));
        assertEquals(expectedBalance, loanAccount.getBalance(), 0.0);
    }

    @Test
    public void testWithdrawNotAccepted() {
    	double initialBalance = 1000000;
        loanAccount.setBalance(initialBalance);
        double amount = 2000000;

        boolean result = loanAccount.withdraw(amount);

        assertFalse(result);
        assertEquals(initialBalance, loanAccount.getBalance(), 0.0);
    }
}
