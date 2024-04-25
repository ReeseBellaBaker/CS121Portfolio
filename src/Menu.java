import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank();

    //default constructor

    public void displayMainMenu() {
        while (true) {
            System.out.println("**********MENU**********");
            System.out.println("\n");
            System.out.println("Please make a selection:");
            System.out.println("1. Access Account\n2. Open a New Account\n3. Close All Accounts\n4. Exit\n");
            int answer = Integer.parseInt(scanner.nextLine());
            //createNewCustomer();
            if (answer == 1) {
                accessAccount();
            } else if (answer == 2) {
                openNewAccount();
            } else if (answer == 3) {
                closeAllAccounts();
            } else if (answer == 4) {
                System.out.println("Thank you for using BSU Banking App, Goodbye. \nExiting...");
                return;
            } else {
                System.out.println("Invalid Entry");
            }
        }
    }

    private void accessAccount() {
        System.out.println("Enter PIN number: ");
        int pinNumber = Integer.parseInt(scanner.nextLine());
        Customer customer = bank.getCustomer(pinNumber);
        if (customer == null) {
            System.out.println("PIN is not valid");
            return;
        }
        System.out.println("Your accounts\n " + customer.getAllAccounts());
        System.out.println("Enter account number you want: ");
        int accountNumber = Integer.parseInt(scanner.nextLine());
        Account account = customer.getAccount(accountNumber);
        if (account == null) {
            System.out.println("Account number invalid");
            return;
        } else {
            //public void displaySecondMenu(){
            while (true) {
                System.out.println("\n********Account Menu********");
                System.out.println("1. Make a deposit\n2. Make a withdrawal\n3. See account balance\n4.Add Interest\n5. Exit\n");
                int answer = Integer.parseInt(scanner.nextLine());

                if (answer == 1) {
                    makeDeposit(account);
                } else if (answer == 2) {
                    makeWithdrawal(account);
                } else if (answer == 3) {
                    accountBalance(account);
                } else if (answer == 4) {
                    addInterest((SavingsAccount) account);
                } else if (answer == 5){
                    return;
                } else {
                    System.out.println("Invalid Entry");
                }
            }
        }
    }
    private void makeDeposit(Account account) {
        System.out.println("How much would you like to deposit: ");
        double deposit = Double.parseDouble((scanner.nextLine()));
        //scanner.nextLine();
        double total = account.getBalance();
        double overAll = total + deposit;
        account.setBalance(overAll);
        System.out.println("You have deposited: $" + deposit );
        System.out.println("New balance: $" + overAll );

        return;
    }
    private void makeWithdrawal(Account account){
        System.out.println("How much would you like to withdrawal: ");
        int withdrawal = Integer.parseInt(scanner.nextLine());
        //scanner.nextLine();
        account.withDraw(withdrawal);
        return;
    }
    private void accountBalance(Account account){
        System.out.println("Account balance: $" + account.getBalance());
        return;
    }
    private void addInterest(SavingsAccount account){
        account.addInterest();
    }
    /*private void closeAccount(Account account){
        System.out.println("What is your PIN number?");
        int pinNumber = Integer.parseInt(scanner.nextLine());
        Customer customerPin = bank.getCustomer(pinNumber);
        if (customerPin == null) {
            displayMainMenu();
        }
        else{
            //return customerPin;
            bank.removeCustomer(customerPin);
            int number = account.getAccountNumber();
            System.out.println("Account number " + number + " closed.");
        }
    }

     */

    private void openNewAccount() {
        Customer customer;
        System.out.println("Are you a new customer? (yes/no) ");
        String answerNewCust = scanner.nextLine();
        if (answerNewCust.equals("yes")) {
            customer = createNewCustomer();
        }//else if (answerNewCust.equals("no")) {
        else {
            System.out.println("Provide PIN number: ");
            int PINNumber = Integer.parseInt(scanner.nextLine());
            customer = bank.getCustomer(PINNumber);
            if (customer == null) {
                System.out.println("PIN is invalid");
                displayMainMenu();
            }
        }
        System.out.println("Enter deposit amount for new account: ");
        double depAmount = Double.parseDouble((scanner.nextLine()));
        System.out.println("Enter the interest rate for the savings account(in %): ");
        double interestRate = Double.parseDouble((scanner.nextLine()));
        SavingsAccount account1 = new SavingsAccount(depAmount, interestRate);

        customer.addAccount(account1);
        System.out.println("New Account Opened " + account1.getAccountNumber());
    }
    private Customer createNewCustomer(){
        System.out.println("What is your first name?");
        String firstName = scanner.nextLine();
        System.out.println("What is your last name?");
        String lastName = scanner.nextLine();
        System.out.println("What is your PIN number?");
        int pinNumber = Integer.parseInt(scanner.nextLine());
        Customer newCustomer = new Customer(firstName, lastName, pinNumber);
        bank.addCustomer(newCustomer);
        return newCustomer;
    }
    private void closeAllAccounts(){
        System.out.println("What is your PIN number?");
        int pinNumber = Integer.parseInt(scanner.nextLine());
        Customer customerPin = bank.getCustomer(pinNumber);
        if (customerPin == null) {
            displayMainMenu();
        }
        else{
            //return customerPin;
            bank.removeCustomer(customerPin);
            System.out.println("You have been removed from the bank registry");
        }
    }
}


