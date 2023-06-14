
package Bank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount("123456789", 1000);
    }

    @Test
    public void testGetAccountNumber() {
        String accountNumber = account.getAccountNumber();
        Assertions.assertEquals("123456789", accountNumber);
    }

    @Test
    public void testGetBalance() {
        double balance = account.getBalance();
        Assertions.assertEquals(1000, balance, 0.001);
    }

    @Test
    public void testDeposit() {
        account.deposit(500);
        double balance = account.getBalance();
        Assertions.assertEquals(1500, balance, 0.001);
    }

    @Test
    public void testWithdrawSufficientBalance() {
        account.withdraw(500);
        double balance = account.getBalance();
        Assertions.assertEquals(500, balance, 0.001);
    }

    @Test
    public void testWithdrawInsufficientBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(1500);
        });
    }
}