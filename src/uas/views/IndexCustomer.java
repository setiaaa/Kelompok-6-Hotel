package uas.views;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import uas.bean.*;
import uas.utils.DatabaseUtil;

public class IndexCustomer {
	public static int inId;
	static String inNama;
	static Scanner in = new Scanner(System.in);
	static Scanner in2 = new Scanner(System.in);
	
	public static void Page() {
		System.out.println("--- Main ---");
		System.out.println("1. Login\n"
				+ "2. Register");
		System.out.print("Masukan Pilihan: "); int pilihan = in.nextInt();
		switch (pilihan) {
		case 1: {
			loginCustomer();
			loggedOn();
			break;
		}
		case 2: {
			FormView.insertCustomer();
			break;
		}
		default:
			System.out.print("Pilihan tidak ada");
		}
		
	}
	public static void loginCustomer() {
		System.out.print("Masukan Email    : "); String email = in2.next();
		System.out.print("Masukan Password : "); String password = in2.next();
		DatabaseUtil db = new DatabaseUtil();
		Customer customer = new Customer();
		try {
			db.connect();
 
            String query = "SELECT * FROM customer WHERE email = '"+email+"' and password = '"+password+"'";
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
                    	customer.setNohp(rs.getObject(5).toString());
                    	customer.setAlamat(rs.getObject(6).toString());
                        if(email.equals(rs.getObject(3).toString()) && password.equals(rs.getObject(4).toString())) {
                        	System.out.println("Login berhasil");
                        	System.out.println("Selamat Datang - "+rs.getObject(2).toString());
                        	inId = Integer.parseInt(rs.getObject(1).toString());
                        	inNama = rs.getObject(2).toString();
        		        	LoginCustomer.profileMenu();
                        	break;
                        }
                        if(i == (jumlahKolom-1)) {
                        	System.out.println("Login Gagal - Email atau Password salah");
                        }
                    }
                } while (rs.next());
                
            } else {
            	customer.setId(0);
            	System.out.println("Login Gagal - Email atau Password salah");
            }
            db.disconnect();            
            
        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }		
	}
	public static void loggedOn() {
		System.out.println(inId+" - "+inNama);
	}
}
