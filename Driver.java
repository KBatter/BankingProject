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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class Driver {


    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        boolean done = false;
        String name;
        String city;
        int amount;
        double interestRate;

        System.out.print("Enter the name of the bank > ");
        name = stdin.readLine().trim();
        System.out.println(name);
        System.out.print("Enter the location of the bank > ");
        city = stdin.readLine().trim();
        System.out.println(city);
        System.out.print("Enter the assets of the bank > ");
        amount = Integer.parseInt(stdin.readLine().trim());
        System.out.println(amount);
        Bank bank = new Bank(name, city, amount);
        System.out.print("""
                         0. Exit.
                         1. Award a loan at the bank.
                         2. Open a checking account at the bank.
                         3. Make a loan payment.
                         4. Make a checking account transaction.
                         5. Pay off a loan and close the account.
                         6. Withdraw balance and close a checking account.
                         7. Change the interest rate on a loan.
                         8. Update the assets of the bank.
                         9. Display information about loans.
                         10. Display information about checking accounts.
                         11. Display detailed bank information.
                         """);
        while(!done) {


        System.out.print("Make your menu selection now > ");
            int option = Integer.parseInt(stdin.readLine().trim());
            System.out.println(option);

            switch (option) {
            case 0 -> {
                    System.out.println("Exiting...");
                    done = true;
                }

            case 1 -> {
                    System.out.println("You are awarding a new loan");
                    System.out.print("Please enter a name for the account > ");
                    name = stdin.readLine();
                    System.out.println(name);
                    if(bank.hasLoan(name)) {
                        System.out.println("Customer already has a loan.");
                        break;
                    }
                    System.out.print("Please enter a city for the account > ");
                    city = stdin.readLine();
                    System.out.println(city);
                    System.out.print("Please enter an initial loan > ");
                    amount = Integer.parseInt(stdin.readLine().trim());
                    if(amount <= 0) {
                        System.out.println("Loan amount must be positive");
                        break;
                    }
                    System.out.println(amount);
                    System.out.print("Please enter an interest rate > ");
                    interestRate = Double.parseDouble(stdin.readLine().trim());
                    if(interestRate <= 0) {
                        System.out.println("Loan interest must be positive");
                        break;
                    }
                    System.out.println(interestRate);
                    bank.openLoanAccount(amount, interestRate, name, city);

                    System.out.print("Customer already has a loan.");


                }
            case 2 -> {
                    System.out.println("You are opening a new checking account");
                    System.out.print("Please enter a name for the account > ");
                    name = stdin.readLine();
                    System.out.println(name);
                    if(bank.hasChecking(name)) {
                        System.out.println("Customer already has a checking account.");
                        break;
                    }

                    System.out.print("Please enter a city for the account > ");
                    city = stdin.readLine();
                    System.out.println(city);
                    System.out.print("Please enter an initial amount (min $100) > ");
                    amount = Integer.parseInt(stdin.readLine().trim());
                    System.out.println(amount);
                    if(amount < 100) {
                        System.out.println("You cannot enter an initial deposit less than the minimum balance.");
                        break;
                    }
                    bank.openCheckingAccount(amount, name, city);

                }
            case 3 -> {
                    System.out.println("You are paying a loan");
                    System.out.print("Please enter the account owner's name > ");
                    name = stdin.readLine().trim();
                    System.out.println(name);
                    if(!bank.hasLoan(name)) {
                        System.out.println("Customer does not have a loan.");
                        break;
                    }
                    System.out.print("Please enter a payment (min. $1) > ");
                    amount = Integer.parseInt(stdin.readLine().trim());
                    System.out.println(amount);
                    if(amount <= 0) {
                        System.out.println("Payment must be greater than 0");
                        break;
                    }
                    try {
                        bank.payLoan(amount, name);
                    } catch (Exception e) {
                        System.out.println("Payment is greater than remaining loan.");
                    }
                }
            case 4 -> {
                    System.out.println("You are making a checking account transaction");
                    System.out.print("Please enter the account owner's name > ");
                    name = stdin.readLine().trim();
                    System.out.println(name);
                    if(!bank.hasChecking(name)) {
                        System.out.println("Customer already has a checking account.");
                        break;
                    }
                    System.out.print("Please enter a payment > ");
                    amount = Integer.parseInt(stdin.readLine().trim());
                    System.out.println(amount);
                    try {
                        bank.transaction(amount, name);
                    } catch (Exception e) {
                        System.out.println("Transaction would leave owner with less than $100 in account.");
                    }
                }
            case 5 -> {
                    System.out.println("You are paying off a loan");
                    System.out.print("Please enter the owner's name > ");
                    name = stdin.readLine().trim();
                    System.out.println(name);
                    try {
                        bank.payOff(name);
                    } catch (Exception e) {
                        System.out.println("No loan exists under that name.");
                    }
                }
            case 6 -> {
                    System.out.println("You are closing a checking account");
                    System.out.print("Please enter the owner's name > ");
                    name = stdin.readLine().trim();
                    System.out.println(name);
                    try {
                        bank.closeChecking(name);
                    } catch (Exception e) {
                        System.out.println("No checking account exists under that name.");
                    }
                }
            case 7 -> {
                    System.out.println("You are adjusting an interest rate");
                    System.out.print("Please enter the owner's name > ");
                    name = stdin.readLine().trim();
                    System.out.println(name);
                    if(!bank.hasLoan(name)) {
                        System.out.println("Customer does not have a loan.");
                        break;
                    }
                    System.out.print("Please enter a new interest rate, greater than zero > ");
                    interestRate = Double.parseDouble(stdin.readLine().trim());
                    System.out.println(interestRate);
                    if(interestRate <= 0) {
                        System.out.println("Interest rate must be greater than zero");
                        break;
                    }
                    bank.newInterestRate(name, interestRate);
                }
            case 8 -> {
                    System.out.println("You are adjusting the banks assets");
                    System.out.print("Please enter a new amount (min. $0) > ");
                    amount = Integer.parseInt(stdin.readLine().trim());
                    System.out.println(amount);
                    if(amount <= 0) {
                        System.out.println("New amount must be greater than or equal to 0");
                        break;
                    }
                    bank.setAssets(amount);
                }
            case 9 -> System.out.println(bank.getLoans());
            case 10 -> System.out.println(bank.getChecking());
            case 11 -> System.out.println(bank);
            }
        }
    }
}
