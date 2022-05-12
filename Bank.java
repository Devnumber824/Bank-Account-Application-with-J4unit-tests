
import java.util.List;

public interface Bank {

    public List<Account> getAccountsAll();

    int openAccount(int amount, String name, String city, int pin) throws BankException;

    int withdraw(int accno, int amount) throws InvalidAccountException, InsufficientBalanceException;

    int deposit(int accno, int amount) throws InvalidAccountException;

    int closeAccount(int accno) throws InvalidAccountException;

}
