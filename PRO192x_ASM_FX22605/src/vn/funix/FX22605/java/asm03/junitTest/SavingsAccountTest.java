package vn.funix.FX22605.java.asm03.junitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import vn.funix.FX22605.java.asm03.models.SavingsAccount;

public class SavingsAccountTest {

	 private SavingsAccount savingsAccount;

	    @BeforeEach
	    public void setUp() {
	    	savingsAccount = new SavingsAccount();
	        savingsAccount.setBalance(100000); // Thiết lập số dư ban đầu cho tài khoản
	    }

	    @Test
	    public void testWithdraw_withValidAmount() {
	        double withdrawAmount = 5000;

	        boolean result = savingsAccount.withdraw(withdrawAmount);

	        assertTrue(result);
	        assertEquals(95000, savingsAccount.getBalance(), 0.0); // Kiểm tra số dư sau khi rút tiền
	    }

	    @Test
	    public void testWithdraw_withInvalidAmount() {
	        double withdrawAmount = 200000;

	        boolean result = savingsAccount.withdraw(withdrawAmount);

	        assertFalse(result);
	        assertEquals(100000, savingsAccount.getBalance(), 0.0); // Kiểm tra số dư không bị thay đổi khi rút số tiền không hợp lệ
	    }

}
