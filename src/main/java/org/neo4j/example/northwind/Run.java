package org.neo4j.example.northwind;

import org.neo4j.example.northwind.model.Category;
import org.neo4j.example.northwind.model.Customer;
import org.neo4j.example.northwind.model.Order;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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

		final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);

		listProducts(ctx.getBean(ProductRepository.class));
		listCustomers(ctx.getBean(CustomerRepository.class));
		listCategories(ctx.getBean(CategoryRepository.class));
		listSuppliers(ctx.getBean(SupplierRepository.class));
		listOrders(ctx.getBean(OrderRepository.class));
		
		System.out.println(ctx.getBean(ProductRepository.class).findByName("Chang").productName);

	}

	public static void listProducts(final ProductRepository  productRepository) {
		for (final Product p : productRepository.findAll()) {			
			System.out.println("Product " + p.productName);
			System.out.println("  Supplier: " + p.supplier.companyName);
			System.out.println("  Category: " + p.category.categoryName);
		}
	}
	
	public static void listCustomers(final CustomerRepository customerRepository) {
		for (final Customer c : customerRepository.findAll()) {
			System.out.println("Customer: " + c.contactName);
			for (Order o : c.orders) {
				System.out.println("  Order: " + o.orderID);
			}
		}
	}

	public static void listCategories(final CategoryRepository categoryRepository) {
		for (final Category c : categoryRepository.findAll()) {
			System.out.println("Category: " + c.categoryName);
			for (Product p : c.products) {
				System.out.println("  Product: " + p.productName);
			}
		}
	}

	public static void listSuppliers(final SupplierRepository supplierRepository) {
		for (final Supplier s : supplierRepository.findAll()) {
			System.out.println("Supplier: " + s.companyName);
			for (Product p : s.products) {
				System.out.println("  Product: " + p.productName);
			}
		}
	}
	
	public static void listOrders(final OrderRepository    orderRepository) {
		for (final Order o : orderRepository.findAll()) {
			System.out.println("Order: " + o.orderID);
			System.out.println("  Customer: " + o.customer.contactName);
			for (Product p : o.products) {
				System.out.println("  Product: " + p.productName);
			}
		}
	}

}
