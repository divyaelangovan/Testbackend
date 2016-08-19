package com.niit.testbackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Testcasecategory {
	

	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	Category category;
	AnnotationConfigApplicationContext context;
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		category = (Category)context.getBean("category");
	}
		@Test
		public void  categoryListTestCase(){
		
		List<Category> list = categoryDAO.list();
		int rowcount = list.size();
		 assertEquals("category List Test Case",rowcount, 0);
		}
		 
		 @Test
		  public void categoryAddTestCase()
		  {
			 category.setId("cg002");
			 category.setName("divya");
			 
			 boolean flag = categoryDAO.save(category);
			 assertEquals(flag,true);
		  }
		 @Test
		 public void categoryGetTestCase()
		 {
			 category = categoryDAO.get("101");
			 System.out.println(category.getDescription());
			 System.out.println(category.getName());
			 assertEquals(category.getName(),"divya");
			 
		  }
		


	}


