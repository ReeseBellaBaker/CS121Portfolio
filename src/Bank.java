import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customerArrayList = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customerArrayList.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customerArrayList.remove(customer);
    }

    public Customer getCustomer(int pinNumber) {
        Customer foundCustomer = null;
        //enhanced for loop
        for (Customer customer : customerArrayList) {
            if (customer.getPinNum() == pinNumber) {
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;
    }

    public StringBuilder getAllCustomer() {
        StringBuilder studentStringBuilder = new StringBuilder();

        for (Customer customer : customerArrayList) {
            studentStringBuilder.append(customer.toString());
        }
        return studentStringBuilder;
    }
}

