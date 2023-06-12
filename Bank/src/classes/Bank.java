package classes;

import java.io.Serializable;
import java.util.*;

public class Bank implements Serializable{
    private ArrayList<Customer> customers = new ArrayList<>();
    
    void addCustomer(Customer customer) {
        if(accountExists(customer.getAccount().getAccountNumber())) {
            customer.getAccount().setAccountNumber(findValidAccountNumber());
        }
        customers.add(customer);
    }

    private int findValidAccountNumber() {
        int accountNumber = 0;
        do {
            accountNumber = Account.getNextAccountNumber();
        } while(accountExists(accountNumber));
        return accountNumber;
    }
    
    private boolean accountExists(int accountNumber) {
        for(Customer c : customers) {
            if(c.getAccount().getAccountNumber() == accountNumber) {
                return true;
            }
        }
        return false;
    }
    
    Customer getCustomer(int account) {
       return customers.get(account);
    }
    ArrayList<Customer> getCustomers(){
        return customers;
    }

    Customer getCustomerByAccountNumber(int accountNumber) {
        Customer customer = null;
        for(Customer c : customers){
            if(c.getAccount().getAccountNumber() == accountNumber){
                customer = c;
                break;
            }
        }
        return customer;
    }

    void removeCustomer(Customer customer) {
        customers.remove(customer);
    }
}