package com.main;

import java.util.List;
import java.util.function.Consumer;

import com.dao.CustomerDao;
import com.dao.ICustomerDao;
import com.model.Customer;

public class HibernateMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ICustomerDao customerDao = new CustomerDao();
		
		Customer customer = new Customer("ismo", "OUATTARA", "Anyama");
		customerDao.saveCustomer(customer);	// save customer
		
		// get a customer
		customer = customerDao.getCustomerById(customer.getId());
		System.out.println("record found with the id " + customer.getId() + "\n" + customer);
		
		// get the records
		List<Customer> customers = customerDao.getAllCustomers();
		System.out.println("all records: " + customer);
		
//		customer.setFirstName("Lagniny Ismael");
//		customer.setLastName("OUATTARA");
//		customer.setHomeAddress("Abobo");
//		

	}

}
