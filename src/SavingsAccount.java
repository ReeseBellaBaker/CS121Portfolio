public class SavingsAccount extends Account{
    private double interestRate;

    public SavingsAccount(double deposit, double interestRate) {
        super(deposit);
        this.interestRate = interestRate;
    }
    public void addInterest() {
        double interest = getBalance() * interestRate / 100;
        depositAmount(interest);
        System.out.println("Interest added: $" + interest);
    }
    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
