package com.niit.testbackend;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@EnableTransactionManagement
@Repository(value="SupplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	public SupplierDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public boolean save (Supplier supplier)
	{
	try{
		sessionFactory.getCurrentSession().save(supplier);
	return true;
	}
	catch (HibernateException e)
	{
		e.printStackTrace();
		return false;
	}
	}
	@Transactional
	public boolean update (Supplier supplier)
	{
	try{
		sessionFactory.getCurrentSession().update(supplier);
	return true;
	}
	catch (HibernateException e)
	{
		e.printStackTrace();
		return false;
	}
	}
	@Transactional
	public boolean delete(Supplier supplier)
	{
	try{
		sessionFactory.getCurrentSession().delete(supplier);
	return true;
	}
	catch (HibernateException e)
	{
		e.printStackTrace();
		return false;
	}
	}
	@Transactional
	public Supplier get(String id){
		String hql = "from supplier where id="+" '"+id+"'";
		@SuppressWarnings({"deprecation" })
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Supplier> list = query.list();
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
	public List<Supplier> list()
	{
	String hql = "from supplier";
	Query query =sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();

	}
	}	


