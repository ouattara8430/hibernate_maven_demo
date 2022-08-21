package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Customer;
import com.util.HibernateUtil;

public class CustomerDao implements ICustomerDao {
	
	// save a customer
	@Override
	public void saveCustomer(Customer customer) {
		Transaction transaction = null;
		try(
				Session session = HibernateUtil.getSessionFactory().openSession();
		){
			// begin transaction
			transaction = session.beginTransaction();
			
			// save customer
			session.save(customer);
			
			// commit
			transaction.commit();
			
		} catch(Exception e) {
			if(transaction == null) {
				// rollback the transaction
				transaction.rollback();
			}
		}
		
	}
	
	// update a customer
	
	// get customer by id
	@Override
	public Customer getCustomerById(int id) {
		Transaction transaction = null;
		Customer customer = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession();){
			transaction = session.beginTransaction();
			
			// get the customer
			customer = session.get(Customer.class, id);
			// customer = session.load(Customer.class, id);
			
			transaction.commit();
		} catch(Exception e) {
			if(transaction == null) {
				transaction.rollback();
			}
		} 
//		finally {
//			HibernateUtil.Shutdown();
//		}
		return customer;
	}
	
	// get all customers
	@Override
	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers(){
		Transaction transaction = null;
		List<Customer> customers = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession();){
			// begin transaction
			transaction = session.beginTransaction();
			
			// get the records
			customers = session.createQuery("from customer").list();
			
			// commit
			transaction.commit();
			
		} catch(Exception e) {
			if(transaction == null) {
				transaction.rollback();
			}
		}
		return customers;
	}
	
	// delete a customer

}
