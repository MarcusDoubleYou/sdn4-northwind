/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neo4j.example.northwind.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Entity class to represent a Order entity within the Northwind example dataset.
 * 
 * @author Axel Morgner
 */
@NodeEntity
public class Order {
	
	@GraphId
	public Long id;

	public String customerID;
	public String orderID;
	public String orderDate;
	public String shipAddress;
	public String shipRegion;
	public String freight;
	public String shipCity;
	public String shipCountry;
	public String shipName;
	public String employeeID;
	public String shippedDate;
	public String requiredDate;
	public String shipPostalCode;
	public String shipVia;
	
	public Order() {}

	public Order(Long id, String customerID, String orderID, String orderDate, String shipAddress, String shipRegion, String freight, String shipCity, String shipCountry, String shipName, String employeeID, String shippedDate, String requiredDate, String shipPostalCode, String shipVia) {
		this.id = id;
		this.customerID = customerID;
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.shipAddress = shipAddress;
		this.shipRegion = shipRegion;
		this.freight = freight;
		this.shipCity = shipCity;
		this.shipCountry = shipCountry;
		this.shipName = shipName;
		this.employeeID = employeeID;
		this.shippedDate = shippedDate;
		this.requiredDate = requiredDate;
		this.shipPostalCode = shipPostalCode;
		this.shipVia = shipVia;
	}
	
}
