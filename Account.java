
public class Account {

    static int i = 0;
    int accno;
    int balance;
    String name;
    String city;
    int pin;
    
    public Account(String name, int amount, String city, int pin) {
        this.accno = ++i;
        this.name = name;
        this.balance = amount;
        this.city = city;
        this.pin = pin;
    }

    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
    
    public int getAccno() {
        return accno;
    }

    public void setAccno(int accno) {
        this.accno = accno;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
