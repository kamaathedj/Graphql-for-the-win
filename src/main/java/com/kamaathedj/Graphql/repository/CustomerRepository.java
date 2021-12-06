package com.kamaathedj.Graphql.repository;

import com.kamaathedj.Graphql.model.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CustomerRepository extends ReactiveCrudRepository<Customer,Integer> {

    Mono<Customer> findByName(String name);
}
