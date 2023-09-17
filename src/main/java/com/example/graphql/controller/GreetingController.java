package com.example.graphql.controller;

import com.example.graphql.entity.Customer;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.List;

@Controller
public class GreetingController {

    @QueryMapping
    String helloWithName(@Argument String name) {
        return "Hello, " + name + "!";
    }

    @QueryMapping
    public String hello() {
        return "hello";
    }

    @QueryMapping
    Customer customerById(@Argument Integer id) {
        return new Customer(id, Math.random() > .5 ? "Customer 1" : "Customer 2");
    }

    @QueryMapping
    Collection<Customer> customers() {
        return List.of(
                new Customer(1, "Customer 1"),
                new Customer(2, "Customer 2")
        );
    }
}
