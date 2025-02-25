package edu.icet.service.impl;

import edu.icet.controller.dto.Customer;
import edu.icet.entity.CustomerEntity;
import edu.icet.repository.CustomerDao;
import edu.icet.service.CustomerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    final CustomerDao customerDao;
    final ModelMapper modelMapper;

    @Override
    public boolean addCustomer(Customer customer) {
        CustomerEntity save = customerDao.save(modelMapper.map(customer, CustomerEntity.class));
        return save != null?true:false;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        List<CustomerEntity> all = customerDao.findAll();

        all.forEach(customerEntity ->
            customers.add(modelMapper.map(customerEntity,Customer.class))
        );

        return customers;
    }

    @Override
    public void deleteById(Integer id) {
        customerDao.deleteById(id);
    }

    @Override
    public void updateById(Customer customer) {
        customerDao.save(modelMapper.map(customer,CustomerEntity.class));
    }

    @Override
    public Customer searchCustomer(Integer id) {
        return modelMapper.map(customerDao.findById(id),Customer.class);
    }

    @Override
    public List<Customer> searchCustomer(String name) {
        List<Customer> customers = new ArrayList<>();
        List<CustomerEntity> all = customerDao.findByName(name);
        all.forEach(customerEntity ->
            customers.add(modelMapper.map(customerEntity,Customer.class))
        );
        return customers;
    }

    @Override
    public List<Customer> searchCustomerByAddress(String address) {
        List<Customer> customers = new ArrayList<>();
        List<CustomerEntity> all = customerDao.findByAddress(address);
        all.forEach(customerEntity ->
            customers.add(modelMapper.map(customerEntity,Customer.class))
        );
        return customers;}
}
