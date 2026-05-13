import java.util.Date;

class Account {
    private int id = 0;
    private double balance = 0.0;
    private double annualInterestRate = 0.0;
    private Date dateCreated;
    public Account() {
        this.dateCreated = new Date();
    }
    public Account(int id, double balance) {
        this();
        this.id = id;
        this.balance = balance;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public double getAnnualInterestRate() { return annualInterestRate; }
    public void setAnnualInterestRate(double annualInterestRate) { this.annualInterestRate = annualInterestRate; }
    public Date getDateCreated() { return dateCreated; }
    public double getMonthlyInterestRate() { 
        return (annualInterestRate / 100) / 12; 
    }    
    public double getMonthlyInterest() { 
        return balance * getMonthlyInterestRate(); 
    }
    public void withdraw(double amount) { 
        this.balance -= amount; 
    }
    public void deposit(double amount) { 
        this.balance += amount; 
    }
}
class CheckingAccount extends Account {
    private double overdraftLimit;
    public CheckingAccount() {
        super();
        this.overdraftLimit = 0.0;
    }
    public CheckingAccount(int id, double balance, double overdraftLimit) {
        super(id, balance);
        this.overdraftLimit = overdraftLimit;
    }
    public double getOverdraftLimit() { return overdraftLimit; }
    public void setOverdraftLimit(double overdraftLimit) { this.overdraftLimit = overdraftLimit; }
    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount >= -overdraftLimit) {
            setBalance(getBalance() - amount);
        } else {
            System.out.println("Error: Overdraft limit exceeded.");
        }
    }
}
class SavingsAccount extends Account {
    public SavingsAccount() {
        super();
    }
    public SavingsAccount(int id, double balance) {
        super(id, balance);
    }
    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount >= 0) {
            setBalance(getBalance() - amount);
        } else {
            System.out.println("Error: Savings account cannot be overdrawn.");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        CheckingAccount checking = new CheckingAccount(1, 100.0, 50.0);
        SavingsAccount savings = new SavingsAccount(2, 100.0);

        checking.withdraw(120.0); 
        System.out.println("Checking Balance: $" + checking.getBalance());

        checking.withdraw(40.0); 

        savings.withdraw(120.0); 
        System.out.println("Savings Balance: $" + savings.getBalance());
    }
}