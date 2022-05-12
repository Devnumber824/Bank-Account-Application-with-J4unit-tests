
import java.util.*;
import java.util.List;

public class HDFCBank implements Bank {
    List<Account> accounts = new ArrayList<>();
    
    @Override
    public int openAccount(int amount, String name, String city, int pin) throws BankException {
        if (amount != 0)
            if (name != null || name.length() != 0)
                if (city != null || city.length() != 0) {
                    Account acct = new Account(name, amount, city, pin);
                    this.accounts.add(acct);
                    return acct.getAccno();
                } else
                    throw new BankException("City can not be NUll or Blank");
            else
                throw new BankException("Name can not be NUll or Blank");
        else
            throw new BankException("Amount can not be Zero");
    }
    @Override
    public List<Account> getAccountsAll() {
        return this.accounts;
    }
    @Override
    public int withdraw(int accno, int amount) throws InvalidAccountException, InsufficientBalanceException {
    	if (accno != 0) 
            if (amount != 0) {
            	Account ac= searchAccount(accno);
            	if(ac != null)           		
            		if (ac.getBalance() > amount) {
            			ac.setBalance(ac.getBalance() - amount);
            			return ac.getBalance();
            		}
            		else 
                        throw new InsufficientBalanceException("Insufficient Balance");
            	else
            		throw new InvalidAccountException("Invalid Account Number");
            } else 
            	throw new InsufficientBalanceException("Withdraw amount can not be zero");
        else 
            throw new InvalidAccountException("Account number can not be Zero!");
    }
    @Override
    public int deposit(int accno, int amount) throws InvalidAccountException {
    	if (accno != 0) { 
    		Account ac= searchAccount(accno);
    		if(ac != null) {    			
    			ac.setBalance(ac.getBalance() + amount);
            	return ac.getBalance();
    		} else 
				throw new InvalidAccountException("Invalid Account Number");
    	} else
            throw new InvalidAccountException("Account number can not be Zero!");
    }
    @Override
    public int closeAccount(int accno) throws InvalidAccountException {
    	if (accno != 0) {
    		Account ac= searchAccount(accno);
    		if(ac != null) {   
    			accounts.remove(ac);
    			return 1;
    		}
    		else 
				throw new InvalidAccountException("Invalid Account Number");
    	} else
            throw new InvalidAccountException("Account number can not be Zero!");
    }
    public Account searchAccount(int accno)
    {
    	for(Account ac : accounts)
    		if(ac.getAccno()==accno)
    			return ac;
    	return null;
    }
}
