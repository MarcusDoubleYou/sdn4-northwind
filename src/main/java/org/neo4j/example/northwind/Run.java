/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neo4j.example.northwind;

import org.neo4j.example.northwind.model.Category;
import org.neo4j.example.northwind.model.Customer;
import org.neo4j.example.northwind.model.Order;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.neo4j.example.northwind.model.Product;
import org.neo4j.example.northwind.model.Supplier;
import org.neo4j.example.northwind.repository.CategoryRepository;
import org.neo4j.example.northwind.repository.CustomerRepository;
import org.neo4j.example.northwind.repository.OrderRepository;
import org.neo4j.example.northwind.repository.ProductRepository;
import org.neo4j.example.northwind.repository.SupplierRepository;

/**
 * Runnable Test class.
 * 
 * As the @Autowired annotation doesn't work in static context,
 * we're using context.getBean(...) here instead.
 *
 * @author Axel Morgner
 */
public class Run {
	
	public static void main(final String[] args) {

		final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);

		listProducts(context);
		listCustomers(context);
		listCategories(context);
		listSuppliers(context);
		listOrders(context);

	}

	public static void listProducts(final GenericApplicationContext context) {
		final ProductRepository productRepository = context.getBean(ProductRepository.class);
		final Iterable<Product> products = productRepository.findAll();
		for (final Product p : products) {			
			System.out.println("Product " + p.productName);
			System.out.println("  Supplier: " + p.supplier.companyName);
			System.out.println("  Category: " + p.category.categoryName);
		}
	}
	
	public static void listCustomers(final GenericApplicationContext context) {
		final CustomerRepository customerRepository = context.getBean(CustomerRepository.class);
		final Iterable<Customer> customers = customerRepository.findAll();
		for (final Customer c : customers) {
			System.out.println("Customer: " + c.contactName);
			for (Order o : c.orders) {
				System.out.println("  Order: " + o.orderID);
			}
		}
	}

	public static void listCategories(final GenericApplicationContext context) {
		final CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);
		final Iterable<Category> category = categoryRepository.findAll();
		for (final Category c : category) {
			System.out.println("Category: " + c.categoryName);
			for (Product p : c.products) {
				System.out.println("  Product: " + p.productName);
			}
		}
	}

	public static void listSuppliers(final GenericApplicationContext context) {
		final SupplierRepository supplierRepository = context.getBean(SupplierRepository.class);
		final Iterable<Supplier> supplier = supplierRepository.findAll();
		for (final Supplier s : supplier) {
			System.out.println("Supplier: " + s.companyName);
			for (Product p : s.products) {
				System.out.println("  Product: " + p.productName);
			}
		}
	}
	
	public static void listOrders(final GenericApplicationContext context) {
		final OrderRepository orderRepository = context.getBean(OrderRepository.class);
		final Iterable<Order> order = orderRepository.findAll();
		for (final Order o : order) {
			System.out.println("Order: " + o.orderID);
			System.out.println("  Customer: " + o.customer.contactName);
			for (Product p : o.products) {
				System.out.println("  Product: " + p.productName);
			}
		}
	}

}
