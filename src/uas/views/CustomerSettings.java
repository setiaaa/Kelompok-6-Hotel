package uas.views;

import java.util.Scanner;

import uas.bean.*;
import uas.dao.*;
import uas.daoimpl.*;

public class CustomerSettings {
	static Scanner in = new Scanner(System.in);
	public static void updateCustomer() {
		int id = IndexPegawai.inId;
		char back;
		Customer customer = new Customer();
		CustomerDAO operation = new CustomerDAOImpl();
		System.out.println();
		System.out.println("              *****************************************                  ");
        System.out.println("              | 		Edit Profile		 	       |                  ");
        System.out.println("              *****************************************                  ");
        System.out.print("              | ID			:");
        System.out.println(id);
        customer.setId(id);
        System.out.print("              | Nama		        :");
        customer.setNama(in.nextLine());
        System.out.print("              | Email                   :");
        customer.setEmail(in.nextLine());
        System.out.print("              | NO HP					  :");
        customer.setNohp(in.nextLine());
        System.out.print("              | Alamat	        	  :");
        customer.setAlamat(in.nextLine());
        System.out.println("              *****************************************					 ");
        operation.updateCustomer(customer);;
        System.out.print("[B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = in.next().charAt(0);
		if (back == 'B' || back == 'b') {
			LoginCustomer.profileMenu();
		}
	}
}
