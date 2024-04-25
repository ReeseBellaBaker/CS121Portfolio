public class Account {
    private double balance;
    private int accountNumber;
    private static int numberOfAccounts = 1000;

    //constructor
    public Account(double deposit){
        this.balance = deposit;
        this.accountNumber = numberOfAccounts;
    }

    public void depositAmount(double depAmount){
        balance += depAmount;
        System.out.println("Amount Deposited: " + depAmount);
        System.out.println("Updated Balance: " + balance);
    }
    public void withDraw(int withDrawAmount){
        if(withDrawAmount > balance) {
            System.out.println("Insufficient funds");
        }
        else{
            balance = balance - withDrawAmount;
            System.out.println("Amount withdrawn: $" + withDrawAmount);
            System.out.println("Updated Balance: $" + balance);
        }
    }
    //toString
    @Override
    public String toString(){
        return String.format("Account Number: %d\nBalance: $%f\n\n",accountNumber,balance);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        numberOfAccounts = numberOfAccounts + 1;
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public static void setNumberOfAccounts(int numberOfAccounts) {
        Account.numberOfAccounts = numberOfAccounts;
    }
}
