# Test project for the Northwind dataset with SDN4

## Data model

![Data model](data-model.png "Data model")

## Setup database

Setup a [Neo4j server](http://neo4j.com/download) and insert the example Northwind dataset. Start with

    :play northwind graph

You can also just run:

    path/to/neo/bin/neo4j-shell -file northwind_import.cypher

Then clone this repo.

## Project Structure

* Repositories live in: `org.neo4j.example.northwind.repository`
* Domain classes are in: `org.neo4j.example.northwind.model`
* Minimalistic Spring-Data-Neo4j setup happens in: `org.neo4j.example.northwind.AppContext`


## Configure access

Configure host and port in `org.neo4j.example.northwind.AppContext`

	public static final String NEO4J_HOST = "http://localhost:";
	public static final int    NEO4J_PORT = 7474;

If you're running against a 2.2 database, sets username and password:

    public SessionFactory getSessionFactory() {
        System.setProperty("username", "neo4j");
        System.setProperty("password", System.getProperty("password","admin"));
        [...]
    }

Build with

    mvn clean install

Run test app with

    mvn exec:java -Dexec.mainClass=org.neo4j.example.northwind.Run [-Dpassword=admin]

## Results

The output are lists of the nodes and their related nodes of the Northwind graph:

### Products

    [...]
	Product Raclette Courdavault
	  Supplier: Gai pâturage
	  Category: Dairy Products
	Product Rhönbräu Klosterbier
	  Supplier: Plutzer Lebensmittelgroßmärkte AG
	  Category: Beverages
	Product Vegie-spread
	  Supplier: Pavlova
	  Category: Condiments
    [...]
    
### Customers

    [...]
	Customer: Lino Rodriguez
	  Order: 10464
	  Order: 10551
	  Order: 10491
	  Order: 10604
	Customer: Patricio Simpson
	  Order: 10881
	  Order: 10782
	  Order: 10819
    [...]
    
### Categories

    [...]
	Category: Seafood
	  Product: Rogede sild
	  Product: Röd Kaviar
	  Product: Jack's New England Clam Chowder
	  Product: Nord-Ost Matjeshering
	  Product: Konbu
	  Product: Ikura
	Category: Beverages
	  Product: Lakkalikööri
	  Product: Côte de Blaye
	  Product: Laughing Lumberjack Lager
	  Product: Chartreuse verte
	  Product: Steeleye Stout
    [...]

### Suppliers

    [...]
	Supplier: Pasta Buttini s.r.l.
	  Product: Gnocchi di nonna Alice
	  Product: Ravioli Angelo
	Supplier: Leka Trading
	  Product: Ipoh Coffee
	  Product: Singaporean Hokkien Fried Mee
	  Product: Gula Malacca
	Supplier: Heli Süßwaren GmbH & Co. KG
	  Product: NuNuCa Nuß-Nougat-Creme
	  Product: Gumbär Gummibärchen
	  Product: Schoggi Schokolade
    [...]


### Orders

    [...]
	Order: 10997
	  Customer: Carlos González
	  Product: Mascarpone Fabioli
	  Product: Spegesild
	  Product: Filo Mix
	Order: 10610
	  Customer: Annette Roulet
	  Product: Inlagd Sill
	Order: 10904
	  Customer: Karl Jablonski
	  Product: Tarte au sucre
	  Product: Escargots de Bourgogne
	Order: 10505
	  Customer: Jean Fresnière
	  Product: Tarte au sucre
    [...]    
