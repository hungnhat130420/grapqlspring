package com.example.graphql.service;

import com.example.graphql.entity.Customer;
import com.example.graphql.entity.Profile;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CustomerService {
    public Collection<Customer> getCustomers() {
        return List.of(
              new Customer(1, "Customer 1"),
              new Customer(2, "Customer 2")
        );
    }

    public Customer getCustomerById(Integer id) {
        return new Customer(id, Math.random() > .5 ? "Customer 1" : "Customer 2");
    }

    public Profile getProfile(Customer customer) {
        return new Profile(customer.id(), customer.id());
    }
}
