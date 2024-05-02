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

public class LoanAccount extends Account {
    private final int loanAmount;
    private int loanBalance;
    private double loanRate;

    public LoanAccount(int loanAmount, double loanRate, String customerName, String customerCity, int accountNumber) {
        super(customerName, customerCity, accountNumber);
        this.loanAmount = loanAmount;
        this.loanBalance = loanAmount;
        this.loanRate = loanRate;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public int getLoanBalance() {
        return loanBalance;
    }

    public double getLoanRate() {
        return loanRate;
    }

    public void setLoanBalance(int loanBalance) {
        this.loanBalance = loanBalance;
    }

    public void setLoanRate(double loanRate) {
        this.loanRate = loanRate;
    }

    public void payLoan(int payment) throws Exception {
        if (payment > loanBalance) {
            throw new Exception();
        } else {
            loanBalance -= payment;
        }
    }

    @Override
    public boolean hasLoan() {
        return true;
    }

    public String toString() {
        return "Borrower " + getCustomerName() + " residing in " + getCustomerCity() +  " \nAccount number: " + super.getAccountNumber()
               + "\nInitial loan amount: $" + loanAmount + "\nLoan balance: $" + loanBalance + "\nInterest Rate: " + loanRate + "%";
    }
}
