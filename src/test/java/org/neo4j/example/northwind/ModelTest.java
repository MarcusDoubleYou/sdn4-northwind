/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neo4j.example.northwind;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.runner.RunWith;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.testutil.WrappingServerIntegrationTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.neo4j.example.northwind.model.Product;
import org.neo4j.example.northwind.repository.ProductRepository;

/**
 * Test configuration
 *
 * @author Axel Morgner
 */
@ContextConfiguration(classes = { PersistenceContext.class })
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ModelTest extends WrappingServerIntegrationTest {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	Session session;

	@Override
	protected int neoServerPort() {
		return PersistenceContext.NEO4J_PORT;
	}

	@org.junit.Test
	public void basic() {

		Product prod = new Product();
		prod.productName = "Product-1";
		
		productRepository.save(prod);

		final Iterable<Product> products = productRepository.findAll();
		assertTrue(products.iterator().hasNext());
		for (final Product p : products) {
			System.out.println("Product found: " + p.productName);
			assertTrue(p instanceof Product);
			assertEquals(prod.productName, p.productName);
		}

	}

}
