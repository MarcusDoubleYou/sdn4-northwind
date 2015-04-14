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

		final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);

		final ProductRepository  productRepository  = context.getBean(ProductRepository.class);
		final CustomerRepository customerRepository = context.getBean(CustomerRepository.class);
		final CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);
		final SupplierRepository supplierRepository = context.getBean(SupplierRepository.class);
		final OrderRepository    orderRepository    = context.getBean(OrderRepository.class);

		listProducts(productRepository);
		listCustomers(customerRepository);
		listCategories(categoryRepository);
		listSuppliers(supplierRepository);
		listOrders(orderRepository);

	}

	public static void listProducts(final ProductRepository  productRepository) {
		final Iterable<Product> products = productRepository.findAll();
		for (final Product p : products) {			
			System.out.println("Product " + p.productName);
			System.out.println("  Supplier: " + p.supplier.companyName);
			System.out.println("  Category: " + p.category.categoryName);
		}
	}
	
	public static void listCustomers(final CustomerRepository customerRepository) {
		final Iterable<Customer> customers = customerRepository.findAll();
		for (final Customer c : customers) {
			System.out.println("Customer: " + c.contactName);
			for (Order o : c.orders) {
				System.out.println("  Order: " + o.orderID);
			}
		}
	}

	public static void listCategories(final CategoryRepository categoryRepository) {
		final Iterable<Category> category = categoryRepository.findAll();
		for (final Category c : category) {
			System.out.println("Category: " + c.categoryName);
			for (Product p : c.products) {
				System.out.println("  Product: " + p.productName);
			}
		}
	}

	public static void listSuppliers(final SupplierRepository supplierRepository) {
		final Iterable<Supplier> supplier = supplierRepository.findAll();
		for (final Supplier s : supplier) {
			System.out.println("Supplier: " + s.companyName);
			for (Product p : s.products) {
				System.out.println("  Product: " + p.productName);
			}
		}
	}
	
	public static void listOrders(final OrderRepository    orderRepository) {
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
