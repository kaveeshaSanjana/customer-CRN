package edu.icet.controller;

import edu.icet.controller.dto.Customer;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController {
    final CustomerService customerService;

    @PostMapping("/add")
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }

    @GetMapping("/get-all")
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id){
        customerService.deleteById(id);
    }

    @PutMapping("/update")
    public void updateById(@RequestBody Customer customer){
        customerService.updateById(customer);
    }

    @GetMapping("/search-by-id/{id}")
    public Customer getCustomer(@PathVariable Integer id){
        return  customerService.searchCustomer(id);
    }

    @GetMapping("/search-by-name/{name}")
    public List<Customer> getCustomer(@PathVariable String name){
        return  customerService.searchCustomer(name);
    }

    @GetMapping("/search-by-address/{address}")
    public List<Customer> getCustomerByAddress(@PathVariable String address){
        return  customerService.searchCustomerByAddress(address);
    }

}
