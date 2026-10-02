package com.P1.Gaser.Services;

import com.P1.Gaser.Entity.Customer;
import com.P1.Gaser.Exception.ResourceNotFoundException;
import com.P1.Gaser.Repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Customer not found with id: " + id));
    }


    public Customer updateCustomer(Long id, Customer customer) {

        Customer existingCustomer =
                customerRepository.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found with id : "+id));
        existingCustomer.setCustomerName(customer.getCustomerName());
        existingCustomer.setPhoneNumber(customer.getPhoneNumber());
        existingCustomer.setEmail(customer.getEmail());

        return customerRepository.save(existingCustomer);

    }

    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)){
            throw new ResourceNotFoundException("Customer not found with id :" +id);
        }
        customerRepository.deleteById(id);
    }
}