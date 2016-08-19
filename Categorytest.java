package com.niit.testbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Categorytest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext();
				c.scan("com.niit");
				c.refresh();
				
				CategoryDAO categoryDAO = (CategoryDAO) c.getBean("categoryDAO.class");
				
				CategoryDAO category = (Category) c.getBean("category.class");
				
				 
				 
				 			 System.out.println("succesfully the category");
	}
				 
			}




