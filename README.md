# Test project for the Northwind dataset with SDN4

## Data model

![Data model](data-model.png "Data model")

## Setup database

Setup a Neo4j server and load the complete Northwind dataset. Start with

    :play northwind graph

Then clone this repo.

## Configure access

Configure host and port in org.neo4j.example.northwind.AppContext

	public static final String NEO4J_HOST = "http://localhost:";
	public static final int    NEO4J_PORT = 7474;

If you're running against a 2.2 database, set username and password:

    public SessionFactory getSessionFactory() {
        System.setProperty("username", "neo4j");
        System.setProperty("password", "neo4j");
        [...]
    }

Build with

    mvn clean install

Run test app with

    mvn exec:java -Dexec.mainClass=org.neo4j.example.northwind.Run

## Results

The output are lists of the nodes and their related nodes of the Northwind graph.
