
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestBankApp {

    @Test
    public void testOpenAccount() throws BankException {
        Bank bank = new HDFCBank();
        int newaccountNo = bank.openAccount(100, "PRANAV", "Mumbai", 411004);
        assertEquals(1, newaccountNo);
    }

    @Test
    public void testOpenAccountWithStorage() throws BankException {
        Bank bank = new HDFCBank();
        int newaccountNo1 = bank.openAccount(100, "PRANAV", "Mumbai", 411004);
        int newaccountNo2 = bank.openAccount(100, "PRANAV", "Mumbai", 411004);
        //expected account no is 1
        assertEquals(2, bank.getAccountsAll().size());
    }

    @Test(expected = BankException.class)
    public void testOpenAccountWithWrongData() throws BankException {
        Bank bank = new HDFCBank();
        bank.openAccount(0, "PRANAV", "Mumbai", 411004);
    }

    @Test
    public void testCloseAccount() throws InvalidAccountException, BankException {
    	Bank bank = new HDFCBank();
        int newaccountNo = bank.openAccount(100, "PRANAV", "Mumbai", 411004);
        int closeAccount = bank.closeAccount(newaccountNo);
        assertEquals(1, closeAccount);
    }

    @Test(expected = InvalidAccountException.class)
    public void testCloseAccountWithWrongAccountNo() throws InvalidAccountException {
    	Bank bank = new HDFCBank();
        bank.closeAccount(0);
    }

    @Test
    public void testWithdraw() throws InvalidAccountException, InsufficientBalanceException, BankException {
        Bank bank = new HDFCBank();
        int newaccountNo = bank.openAccount(5000, "PRANAV", "Mumbai", 411004);
        int withdraw = bank.withdraw(newaccountNo, 2000);
        assertEquals(3000, withdraw);
    }

    @Test(expected = InvalidAccountException.class)
    public void testWithdrawWithInvalidAccountNo() throws InvalidAccountException, InsufficientBalanceException {
        Bank bank = new HDFCBank();
        bank.withdraw(0, 2000);
    }

    @Test(expected = InsufficientBalanceException.class)
    public void testWithdrawInsufficientBalance() throws InvalidAccountException, InsufficientBalanceException {
        Bank bank = new HDFCBank();
        bank.withdraw(1, 0);
    }

    @Test
    public void testDeposit() throws InvalidAccountException, BankException {
        Bank bank = new HDFCBank();
        int newaccountNo = bank.openAccount(5000, "PRANAV", "Mumbai", 411004);
        int deposit = bank.deposit(newaccountNo, 2000);
        assertEquals(7000, deposit);
    }
       
    @Test(expected = InvalidAccountException.class)
    public void testDepositWithWrongAccountNo() throws InvalidAccountException {
        Bank bank = new HDFCBank();
        bank.deposit(0, 2000);
    }

}
