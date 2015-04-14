package org.neo4j.example.northwind.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;
import org.neo4j.example.northwind.model.Product;

/**
 * Repository interface for products.
 *
 * @author Axel Morgner
*/
@Repository
public interface ProductRepository extends GraphRepository<Product> {}
