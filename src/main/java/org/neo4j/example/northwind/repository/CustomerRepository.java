package org.neo4j.example.northwind.repository;

import org.neo4j.example.northwind.model.Customer;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for customers.
 *
 * @author Axel Morgner
*/
@Repository
public interface CustomerRepository extends GraphRepository<Customer> {}
