package com.niit.testbackend;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Testcaseproduct {

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	Product product;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shopping");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
		product = (Product) context.getBean("product");
	}
	@Test
	public void deletecategoryTestCase()
	{
		product.setId("PRD-001");
		
	boolean flag =	productDAO.delete(product);
	 assertEquals("deleteProductTestCase", flag, false);	
	}
	@Test
	public void addproductTestCase()
	{
		product.setId("MOB_001");
		product.setName("iphone");
		product.setPrice(10);
		
		assertEquals("addproductTestCase",productDAO.save(product),true);
	}
	@Test
	public void listProductTestCase()
	{
		assertEquals("addProductTestCase",productDAO.list().size(),0);
	}
}
	
		
		
	


