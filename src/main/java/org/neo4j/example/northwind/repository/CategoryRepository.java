/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neo4j.example.northwind.repository;

import org.neo4j.example.northwind.model.Category;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for categories.
 *
 * @author Axel Morgner
*/
@Repository
public interface CategoryRepository extends GraphRepository<Category> {}
