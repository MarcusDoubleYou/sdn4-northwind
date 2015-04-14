/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neo4j.example.northwind.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Entity class to represent a Category entity within the Northwind example dataset.
 * 
 * @author Axel Morgner
 */
@NodeEntity
public class Category {
	
	@GraphId
	public Long id;
	
	public String categoryName;
	public String description;
	public String picture;
	public String categoryID;
	
	public Category() {}

	public Category(Long id, String categoryName, String description, String picture, String categoryID) {
		this.id = id;
		this.categoryName = categoryName;
		this.description = description;
		this.picture = picture;
		this.categoryID = categoryID;
	}
	
}
