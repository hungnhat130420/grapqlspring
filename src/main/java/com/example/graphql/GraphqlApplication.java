package com.example.graphql;

import com.example.graphql.service.CustomerService;
import graphql.schema.idl.RuntimeWiring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@SpringBootApplication
public class GraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphqlApplication.class, args);
    }


    @Bean
    RuntimeWiringConfigurer runtimeWiringConfigurer(CustomerService customerService) {
        return  builder -> {
            builder.type("Query", typeWiring -> typeWiring
//                    .dataFetcher("customers", env -> customerService.getCustomers())
//                    .dataFetcher("customerById", env -> customerService.getCustomerById(Integer.parseInt(env.getArgument("id"))))
                    .dataFetcher("profile", env -> customerService.getProfile(env.getSource()))
            );
        };
    }
}
