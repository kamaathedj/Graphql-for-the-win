package com.kamaathedj.Graphql.controller;

import com.kamaathedj.Graphql.model.Customer;
import com.kamaathedj.Graphql.model.Order;
import com.kamaathedj.Graphql.model.OrderType;
import com.kamaathedj.Graphql.service.CustomerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Controller
public class CustomerController {

   private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @SchemaMapping(typeName= "Customer",field = "orders")
    Flux<Order> Orders(Customer customer){
        var orders = new ArrayList<Order>();
        for (int orderId = 0; orderId <= (Math.random()*100) ; orderId++) {
            orders.add(new Order(orderId, customer.id(), orderId%2==0?OrderType.electronic:OrderType.food));
        }
        return Flux.fromIterable(orders);
    }

    @SchemaMapping(typeName= "Customer")
    String registered(Customer customer){
        return customer.registered().toString();
    }

    @QueryMapping()
    Flux<Customer> customers(){
        return service.getCustomers();
    }

    @QueryMapping
    Mono<Customer> getByName(@Argument String name){
        return service.getCustomerByName(name);
    }

    @MutationMapping
    Mono<Customer> addCustomer(@Argument String name){
        return service.addCustomer(name);
    }

    @MutationMapping
    Mono<Boolean> removeCustomer(@Argument int id){
        return service.removeCustomer(id);
    }


}

