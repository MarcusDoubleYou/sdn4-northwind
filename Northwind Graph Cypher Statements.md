# Northwind Graph Cypher Statements

## Import products

	LOAD CSV WITH HEADERS FROM "http://data.neo4j.com/northwind/products.csv" AS row
	CREATE (n:Product)
	SET n = row,
	  n.unitPrice = toFloat(row.unitPrice),
	  n.unitsInStock = toInt(row.unitsInStock), n.unitsOnOrder = toInt(row.unitsOnOrder),
	  n.reorderLevel = toInt(row.reorderLevel), n.discontinued = (row.discontinued <> "0")


## Import categories

	LOAD CSV WITH HEADERS FROM "http://data.neo4j.com/northwind/categories.csv" AS row
	CREATE (n:Category)
	SET n = row

## Import suppliers

	LOAD CSV WITH HEADERS FROM "http://data.neo4j.com/northwind/suppliers.csv" AS row
	CREATE (n:Supplier)
	SET n = row

## Create indexes on products, categories and suppliers

	CREATE INDEX ON :Product(productID)
	CREATE INDEX ON :Category(categoryID)
	CREATE INDEX ON :Supplier(supplierID)

## Create relationships (:Product)-[:PART_OF]->(:Category) [*:1]

	MATCH (p:Product),(c:Category)
	WHERE p.categoryID = c.categoryID
	CREATE (p)-[:PART_OF]->(c)

## Create relationships (:Product)<-[:SUPPLIES]-(:Supplier) [*:1]

	MATCH (p:Product),(s:Supplier)
	WHERE p.supplierID = s.supplierID
	CREATE (s)-[:SUPPLIES]->(p)

## Import customers

	LOAD CSV WITH HEADERS FROM "http://data.neo4j.com/northwind/customers.csv" AS row
	CREATE (n:Customer)
	SET n = row

## Import orders

	LOAD CSV WITH HEADERS FROM "http://data.neo4j.com/northwind/orders.csv" AS row
	CREATE (n:Order)
	SET n = row

## Create indexes for customers and orders

	CREATE INDEX ON :Customer(customerID)
	CREATE INDEX ON :Order(orderID)

## Create relationships (:Customer)-[:PURCHASED]->(:Order) [1:*]

	MATCH (c:Customer),(o:Order)
	WHERE c.customerID = o.customerID
	CREATE (c)-[:PURCHASED]->(o)

## Import order details as relationships (:Order)-[ORDERS]->(:Product) [1:*]

	LOAD CSV WITH HEADERS FROM "http://data.neo4j.com/northwind/order-details.csv" AS row
	MATCH (p:Product), (o:Order)
	WHERE p.productID = row.productID AND o.orderID = row.orderID
	CREATE (o)-[details:ORDERS]->(p)
	SET details = row,
	  details.quantity = toInt(row.quantity)
