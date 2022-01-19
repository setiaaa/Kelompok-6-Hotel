package uas.daoimpl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import uas.dao.*;
import uas.bean.*;
import uas.utils.DatabaseUtil;
import uas.views.*;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public void getCustomerById(int id) {
		DatabaseUtil db = new DatabaseUtil();
		Customer customer = new Customer();
		try {
			db.connect();
 
            String query = "SELECT * FROM customer WHERE id = '"+id+"'";
            ResultSet rs = db.readData(query);
 
            // process query results
            if (rs.next()) {
 
                ResultSetMetaData metaData = rs.getMetaData();
                int jumlahKolom = metaData.getColumnCount();
                do {
                    for (int i = 1; i <= jumlahKolom; i++) {
                    	customer.setId(Integer.parseInt(rs.getObject(1).toString()));
                    	customer.setNama(rs.getObject(2).toString());
                        customer.setEmail(rs.getObject(3).toString());
                        customer.setPassword(rs.getObject(4).toString());
                        customer.setAlamat(rs.getObject(5).toString());
                        customer.setNohp(rs.getObject(6).toString());
                    }
                } while (rs.next());
                
            } else {
            	customer.setId(0);
            }

            db.disconnect();            
 
        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
		ViewCustomer.displayTupleCustomer(customer);
	}
	@Override
	public void deleteCustomer(Customer customer) {
		DatabaseUtil db = new DatabaseUtil();
		String query;
		try {
			db.connect();
			query = "DELETE FROM customer WHERE id='"+customer.getId()+"'";
			db.executeQuery(query);
			ViewCustomer.displayTabelCustomer(getAllCustomer());
		} catch (Exception e) {
			System.out.println("Terjadi error: " + e.getMessage());
		}
	}

	@Override
	public void saveCustomer(Customer customer) {
		DatabaseUtil db = new DatabaseUtil();
		String query;
		try {
			db.connect();
			query = "INSERT INTO pegawai (id, nama, email, password, no_hp, alamat)"
					+ " VALUES ("+customer.getId()+", '"
					+ customer.getNama()+"', '"
					+ customer.getEmail()+"', '"
					+ customer.getPassword()+"', '"
					+ customer.getNohp()+"', '"
					+ customer.getAlamat()+"')";
			
			db.executeQuery(query);
			System.out.println("Data berhasil ditambahkan!");
		} catch (Exception ex) {
			System.out.println("Terjadi error: " + ex.getMessage());
		}
	}
	@Override
	public void updateCustomer(Customer customer) {
		DatabaseUtil db = new DatabaseUtil();
		String query;
		try {
			db.connect();
			query = "UPDATE customer SET nama='"+customer.getNama()+"',"
					+ " email='"+customer.getEmail()+"',"
					+ " password='"+customer.getPassword()+"',"
					+ " no hp="+customer.getNohp()+"',"
					+ " alamat="+customer.getAlamat()+"',"
					+ " WHERE id='"+customer.getId()+"'";
			
			db.executeQuery(query);
			System.out.println("Data berhasil diperbarui!");
		} catch (Exception e) {
			System.out.println("Terjadi error: " + e.getMessage());
		}
		
	}
	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> listCustomer = new ArrayList<Customer>();
		DatabaseUtil db = new DatabaseUtil();
		try {
			db.connect();
			 
            String query = "SELECT * FROM customer";
         
            ResultSet rs = db.readData(query);
 
            // process query results
            while (rs.next()) {
            	Customer customer = new Customer();
            	
            	customer.setId(Integer.parseInt(rs.getObject(1).toString()));
            	customer.setNama(rs.getObject(2).toString());
                customer.setEmail(rs.getObject(3).toString());
                customer.setPassword(rs.getObject(4).toString());
                customer.setNohp(rs.getObject(5).toString());
                customer.setAlamat(rs.getObject(6).toString());
                listCustomer.add(customer);

            } 
            db.disconnect();
			
		} catch (SQLException ex) {
			System.out.println("Terjadi error: " + ex.getMessage());
		}
		
		return listCustomer;
	}
	@Override
	public void getCustomerByEmail(String email) {
		DatabaseUtil db = new DatabaseUtil();
		Customer customer = new Customer();
		try {
			db.connect();
 
            String query = "SELECT * FROM customer WHERE email = '"+email+"'";
            ResultSet rs = db.readData(query);
 
            // process query results
            if (rs.next()) {
 
                ResultSetMetaData metaData = rs.getMetaData();
                int jumlahKolom = metaData.getColumnCount();
                do {
                    for (int i = 1; i <= jumlahKolom; i++) {
                    	customer.setId(Integer.parseInt(rs.getObject(1).toString()));
                    	customer.setNama(rs.getObject(2).toString());
                        customer.setEmail(rs.getObject(3).toString());
                        customer.setPassword(rs.getObject(4).toString());
                        customer.setAlamat(rs.getObject(5).toString());
                        customer.setNohp(rs.getObject(6).toString());
                    }
                } while (rs.next());
                
            } else {
            	customer.setId(0);
            }

            db.disconnect();            
 
        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
		
		ViewCustomer.displayTupleCustomer(customer);
	}
	
	
		
		
}
