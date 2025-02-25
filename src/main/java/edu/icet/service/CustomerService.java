package edu.icet.service;

import edu.icet.controller.dto.Customer;

import java.util.List;

public interface CustomerService {
    boolean addCustomer(Customer customer);

    List<Customer> getAll();

    void deleteById(Integer id);

    void updateById(Customer customer);

    Customer searchCustomer(Integer id);
    List<Customer> searchCustomer(String name);
    List<Customer> searchCustomerByAddress(String address);
}
