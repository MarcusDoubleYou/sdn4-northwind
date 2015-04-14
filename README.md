# Test project for the Northwind dataset with SDN4

Setup a Neo4j server and load the complete Northwind dataset. Start with

    :play northwind graph

Configure host and port in org.neo4j.example.northwind.AppContext

	public static final String NEO4J_HOST = "http://localhost:";
	public static final int    NEO4J_PORT = 7474;

If you're running against a 2.2 database, set username and password:

    public SessionFactory getSessionFactory() {
        System.setProperty("username", "neo4j");
        System.setProperty("password", "neo4j");
        [...]
    }

Clone the repo and build with

    mvn clean install

Run test app with

    mvn exec:java -Dexec.mainClass=org.neo4j.example.northwind.Run

The result is a list of the product names from the Northwind dataset.