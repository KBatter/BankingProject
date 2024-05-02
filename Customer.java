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

public class Customer {
    private String customerName;
    private String customerCity;

    public Customer(String customerName, String customerCity) {
        this.customerName = customerName;
        this.customerCity = customerCity;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
