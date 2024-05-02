/*
 * Purpose: Data Structure and Algorithms Review assignment
 * Status: Complete and thoroughly tested
 * Last update: 01/26/24
 * Submitted:  01/26/24
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: Kian Battermann
 * @version: 2024.01.26
 */

//Parent class for Loan account and Checking account

public class Account {
    private Customer customer;
    private final int accountNumber;

    public Account(String customerName, String customerCity, int accountNumber) {
        customer = new Customer(customerName, customerCity);
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customer.getCustomerName();
    }

    public String getCustomerCity() {
        return customer.getCustomerCity();
    }

    public boolean hasLoan() {
        return false;
    }

    public void payLoan(int payment) throws Exception {

    }

    public boolean hasChecking() {
        return false;
    }

    public void transaction(int payment) throws Exception {

    }

    public void setLoanRate(double newRate) {

    }

    public int getLoanBalance() {
        return 0;
    }

    public int getBalance() {
        return 0;
    }
}
