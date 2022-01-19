package uas.dao;

import java.util.List;

import uas.bean.Customer;

public interface CustomerDAO {
	public void getCustomerById(int id);
    public void getCustomerByEmail(String email);
    
    public List<Customer> getAllCustomer();
    public void saveCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(Customer customer);
}
