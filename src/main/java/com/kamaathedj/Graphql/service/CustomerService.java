package com.kamaathedj.Graphql.service;

import com.kamaathedj.Graphql.model.Customer;
import com.kamaathedj.Graphql.repository.CustomerRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    //@Secured({"ROLE_ADMIN"})
    public Flux<Customer> getCustomers(){
        return repository.findAll();
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Mono<Customer> getCustomerByName(String name ){
        return repository.findByName(name);
    }

    public Mono<Customer> addCustomer(String name){
        Customer customer =new Customer(null,name, LocalDate.now());
        return repository.save(customer);
    }

    public Mono<Boolean> removeCustomer( int id){
        return repository.deleteById(id).thenReturn(true).onErrorReturn(false);
    }
}
