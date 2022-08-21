package com.dao;

import java.util.List;

import com.model.Customer;

public interface ICustomerDao {

	// save a customer
	void saveCustomer(Customer customer);

	// get customer by id
	Customer getCustomerById(int id);

	// get all customers
	List<Customer> getAllCustomers();

}