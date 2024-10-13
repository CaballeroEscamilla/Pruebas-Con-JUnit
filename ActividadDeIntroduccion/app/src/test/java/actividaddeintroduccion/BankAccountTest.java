package actividaddeintroduccion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    // Test para comprobar el depósito válido
    @Test
    void testDepositValidAmount() {
        BankAccount account = new BankAccount(100);
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    // Test para comprobar la excepción al depositar una cantidad negativa
    @Test
    void testDepositNegativeAmountThrowsException() {
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-50);
        });
    }

    // Test para comprobar el retiro válido
    @Test
    void testWithdrawValidAmount() {
        BankAccount account = new BankAccount(100);
        account.withdraw(50);
        assertEquals(50, account.getBalance());
    }

    // Test para comprobar la excepción cuando el saldo es insuficiente
    @Test
    void testWithdrawInsufficientFundsThrowsException() {
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(150);
        });
    }

    // Test para comprobar la excepción al retirar una cantidad negativa
    @Test
    void testWithdrawNegativeAmountThrowsException() {
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-50);
        });
    }

    // Test para comprobar el saldo inicial no negativo
    @Test
    void testInitialBalanceCannotBeNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount(-100);
        });
    }

    // Test para comprobar la obtención del saldo después de múltiples operaciones
    @Test
    void testBalanceAfterMultipleOperations() {
        BankAccount account = new BankAccount(200);
        account.deposit(100);
        account.withdraw(50);
        assertEquals(250, account.getBalance());
    }
}
