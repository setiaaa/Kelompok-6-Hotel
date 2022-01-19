package uas.views;

import java.util.Scanner;

import uas.dao.*;
import uas.daoimpl.*;

public class MenuCustomer {
	public static void displayMenuCustomer() {
		int menu;
		Scanner scanner = new Scanner(System.in);
		CustomerDAO operation = new CustomerDAOImpl();
		System.out.println();			        
	    System.out.println("              *****************************************                  ");
	    System.out.println("              |            Data Customer		      |                  ");
	    System.out.println("              *****************************************                  ");
	    System.out.println("              | Pilihan:                              |                  ");
	    System.out.println("              |        1. Input Data		      |  				 ");
	    System.out.println("              |        2. Cari Data By Id             |                  ");
	    System.out.println("              |        3. Cari Data By Email          |                  ");
	    System.out.println("              |        4. Tampilkan Seluruh Data      |                  ");
	    System.out.println("              |        5. Perbarui Data               |                  ");
	    System.out.println("              |        6. Hapus Data                  |                  ");
	    System.out.println("              |        7. Kembali                     |                  ");
	    System.out.println("              *****************************************                  ");	
	    System.out.println();
	    System.out.print("Pilih menu: ");
	    menu = scanner.nextInt();
	    switch (menu) {
	        case 1:
	        	FormView.insertCustomer();
	        	break;
	        case 2:
	        	FormView.searchCustomerById();
	        	break;
	        case 3:
	        	FormView.searchCustomerByEmail();
	        	break;
	        case 4:
	        	ViewCustomer.displayTabelCustomer(operation.getAllCustomer());
	        	break;
	        case 5:
	        	FormView.updateCustomer();
	        	break;
	        case 6:
	        	FormView.deleteCustomer();
	        	break;
	        case 7:
	        	LoginPegawai.profileMenu();
	        	break;
	        default:
	        	System.out.println("Warning: Pilihan yang anda masukkan salah!");  	
	    }
	    
	    scanner.close();
	}
}
