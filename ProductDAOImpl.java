package com.niit.testbackend;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@EnableTransactionManagement
@Repository
public class ProductDAOImpl implements ProductDAO {
public static final Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public boolean save (Product product)
	{
	try{
		log.debug("starting of the method save");
		sessionFactory.getCurrentSession().save(product);
		log.debug("starting of the mathod save");
	return true;
	}
	catch (Exception e)
	{
		log.error("Exception occured in the save method" +e.getMessage());
		e.printStackTrace();
		return false;
	}
	}
	@Transactional
	public boolean update (Product product)
	{
	try{
		sessionFactory.getCurrentSession().update(product);
	return true;
	}
	catch (Exception e)
	{
		e.printStackTrace();
		return false;
	}
	}
	@Transactional
	public boolean delete(Product product)
	{
	try{
		sessionFactory.getCurrentSession().delete(product);
	return true;
	}
	catch (Exception e)
	{
		e.printStackTrace();
		return false;
	}
	}
	@Transactional
	public Product get(String id){
		String hql = "from product where id="+" '"+id+"'";
	
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
	
		List<Product> list = query.list();
		if(list == null)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	@Transactional
	public List<Product> list()
	{
	String hql = "from product";
	
	Query query =sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();

	}

}
