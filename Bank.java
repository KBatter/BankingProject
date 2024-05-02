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
//Bank class
import java.util.Random;
import java.util.ArrayList;
public class Bank {
    private final String name;
    private final String city;
    private int assets;
    private ArrayList<Account> accounts = new ArrayList<>();
    private ArrayList<Integer> accountNumbers = new ArrayList<>();
    private final Random random = new Random();
    private int trackedAccount = 0;
    private int numLoans = 0;
    private int numChecking = 0;

    public Bank(String name, String city, int assets) {
        this.name = name;
        this.city = city;
        this.assets = assets;
    }

    public String toString() {
        int totalLoans = totalLoans();
        int totalChecking = totalChecking();
        double averageLoan = numLoans > 0? totalLoans/numLoans:0;
        double averageChecking = numChecking > 0? totalChecking/numChecking:0;
        StringBuilder info = new StringBuilder("\n\n");
        int i = 1;
        for(Account a : accounts) {
            info.append("\n ").append(i++).append(". ").append(a);
        }

        return "Bank " + name + " in " + city + " ($" + assets + " in assets) has: " + numLoans + " loan and " + numChecking +
               " checking accounts:\nCumulative amount of loans: $" + totalLoans + "\nAverage amount of loan balance: $" +
               averageLoan + "\nAverage amount of balances: $" + averageChecking + info;
    }

    public void openLoanAccount(int loanAmount, double loanRate, String customerName, String customerCity) {
        int toAdd = random.nextInt(100, 1000);
        while (accountNumbers.contains(toAdd)) {
            toAdd = random.nextInt(100, 1000);
        }
        accounts.add(new LoanAccount(loanAmount, loanRate, customerName, customerCity, toAdd));
        numLoans++;
    }

    public void openCheckingAccount(int accountBalance, String customerName, String customerCity) {
        int toAdd = random.nextInt(100, 1000);
        while (accountNumbers.contains(toAdd)) {
            toAdd = random.nextInt(100, 1000);
        }
        accounts.add(new CheckingAccount(accountBalance, customerName, customerCity, toAdd));
        numChecking++;
    }

    public boolean hasLoan(String customerName) {
        trackedAccount = 0;
        for(Account a : accounts) {
            if(a.getCustomerName().equals(customerName) && a.hasLoan()) {
                return true;
            }
            trackedAccount++;
        }
        return false;
    }

    public boolean hasChecking(String customerName) {
        trackedAccount = 0;
        for(Account a : accounts) {
            if(a.getCustomerName().equals(customerName) && a.hasChecking()) {
                return true;
            }
            trackedAccount++;
        }
        return false;
    }

    public void payLoan(int payment, String customerName) throws Exception {
        if(hasLoan(customerName)) {
            try {
                accounts.get(trackedAccount).payLoan(payment);
            } catch (Exception e) {
                throw new Exception();
            }
        }
    }

    public void transaction(int payment, String customerName) throws Exception {
        if(hasChecking(customerName)) {
            try {
                accounts.get(trackedAccount).transaction(payment);
            } catch (Exception e) {
                throw new Exception();
            }
        }
    }

    public void payOff(String customerName) throws Exception {
        if(hasLoan(customerName)) {
            accountNumbers.remove(accounts.get(trackedAccount).getAccountNumber());
            accounts.remove(trackedAccount);
            numLoans--;
        } else {
            throw new Exception();
        }
    }

    public void closeChecking(String customerName) throws Exception {
        if(hasChecking(customerName)) {
            accountNumbers.remove(accounts.get(trackedAccount).getAccountNumber());
            accounts.remove(trackedAccount);
            numChecking--;
        } else {
            throw new Exception();
        }
    }

    public void newInterestRate(String customerName, double newRate) {
        if(hasLoan(customerName)) {
            accounts.get(trackedAccount).setLoanRate(newRate);
        }
    }

    private int totalLoans() {
        int totalAmount = 0;
        for(Account a : accounts) {
            if(a.hasLoan()) {
                totalAmount += a.getLoanBalance();
            }
        }

        return totalAmount;
    }

    private int totalChecking() {
        int totalAmount = 0;
        for(Account a : accounts) {
            if(a.hasChecking()) {
                totalAmount += a.getBalance();
            }
        }
        return totalAmount;
    }

    public String getLoans() {
        int totalAmount = totalLoans();
        double averageLoan = numLoans > 0? totalAmount/numLoans:0;
        StringBuilder info = new StringBuilder("\nAccount info:");
        for(Account a : accounts) {
            if(a.hasLoan()) {
                info.append("\n").append(a);
            }
        }
        if(!info.equals(new StringBuilder("\nAccount info:"))) {
            return "Cumulative loans: $" + totalAmount + "\nAverage loan balance: $" + averageLoan + info;
        } else {
            return "Cumulative loans: $" + totalAmount + "\nAverage loan balance: $" + averageLoan;
        }
    }

    public String getChecking() {
        int totalAmount = totalChecking();
        double averageChecking = numChecking > 0? totalAmount/numChecking:0;
        StringBuilder info = new StringBuilder("\nAccount info:");
        for(Account a : accounts) {
            if(a.hasChecking()) {
                info.append("\n").append(a);
            }
        }
        if(!info.equals(new StringBuilder("\nAccount info:"))) {
            return "Average checking account balance: $" + averageChecking + info;
        } else {
            return "Average checking account balance: $" + averageChecking;
        }
    }

    public void setAssets(int assets) {
        this.assets = assets;
    }
}
