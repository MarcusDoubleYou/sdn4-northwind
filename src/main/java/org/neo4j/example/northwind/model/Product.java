/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neo4j.example.northwind.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Entity class to represent a Product entity within the Northwind example dataset.
 * 
 * @author Axel Morgner
 */
@NodeEntity
public class Product {
	
	@GraphId
	public Long id;
	
	// String attributes: productID, productName, supplierID, categoryID, quantityPerUnit
	public String productID;
	public String productName;
	public String supplierID;
	public String categoryID;
	public String quantityPerUnit;
	
	// Float attributes:
	// unitPrice
	public Double unitPrice;
	
	// Integer attributes: unitsInStock, unitsOnOrder, reorderLevel
	public Integer unitsInStock;
	public Integer unitsOnOrder;
	public Integer reorderLevel;
	
	// Boolean attributes: discontinued
	public Boolean discontinued;
	
	public Product() {}
	
	public Product(Long id, String productID, String productName, String supplierID, String categoryID, String quantityPerUnit, Double unitPrice, Integer unitsInStock, Integer unitsOnOrder, Integer reorderLevel, Boolean discontinued) {
		this.id = id;
		this.productID = productID;
		this.productName = productName;
		this.supplierID = supplierID;
		this.categoryID = categoryID;
		this.quantityPerUnit = quantityPerUnit;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.unitsOnOrder = unitsOnOrder;
		this.reorderLevel = reorderLevel;
		this.discontinued = discontinued;
	}
	
}
