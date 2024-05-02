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

public class CheckingAccount extends Account {
    private int accountBalance;

    public CheckingAccount(int accountBalance, String customerName, String customerCity, int accountNumber) {
        super(customerName, customerCity, accountNumber);
        this.accountBalance = accountBalance;
    }

    public int getBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public boolean hasChecking() {
        return true;
    }

    @Override
    public void transaction(int payment) throws Exception {
        if(payment + accountBalance < 100) {
            throw new Exception();
        } else {
            accountBalance += payment;
        }
    }

    public String toString() {
        return "Depositor " + getCustomerName() + " residing in " + getCustomerCity() +  " \nAccount number: " + super.getAccountNumber()
               + "\nAccount balance: $" +  accountBalance;
    }
}
