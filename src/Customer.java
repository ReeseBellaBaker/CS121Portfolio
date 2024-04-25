import java.util.ArrayList;

public class Customer {
    private String firstName;
    private String lastName;
    private int pinNum;
    private ArrayList<Account> accountArrayList = new ArrayList<>();

    public Customer(String firstName, String lastName, int pinNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pinNum = pinNum;
    }

    public void addAccount(Account account) {
        accountArrayList.add(account);
    }

    public void removeAccount(Account account) {
        accountArrayList.remove(account);
    }

    public Account getAccount(int accountNum) {
        Account foundAccount = null;
        //enhanced for loop
        for (Account account : accountArrayList) {
            if (account.getAccountNumber() == accountNum) {
                foundAccount = account;
                break;
            }
        }
        return foundAccount;
    }

    public StringBuilder getAllAccounts() {
        StringBuilder studentStringBuilder = new StringBuilder();

        for (Account account : accountArrayList) {
            studentStringBuilder.append(account.toString());
        }
        return studentStringBuilder;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPinNum() {
        return pinNum;
    }

    public void setPinNum(int pinNum) {
        this.pinNum = pinNum;
    }

    /*public ArrayList<Account> getAccountArrayList() {
        return accountArrayList;
    }

    public void setAccountArrayList(ArrayList<Account> accountArrayList) {
        this.accountArrayList = accountArrayList;
    }
     */
    @Override
    public String toString(){
        return String.format("First Name: %s\nLast Name: %s\nPin Number: %d\n",firstName,lastName,pinNum);
    }
}