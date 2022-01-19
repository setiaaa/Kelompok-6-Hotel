package uas.views;

import java.util.List;

import uas.bean.*;
import uas.dao.*;
import uas.daoimpl.*;
import java.util.*;
public class ViewCustomer {
	static Scanner in =new Scanner(System.in);
	public static void main(String[] args) {
		CustomerDAO operation = new CustomerDAOImpl();
		displayTabelCustomer(operation.getAllCustomer());
	}
	public static void displayTabelCustomer(List<Customer> listCustomer) {
		char back;
		System.out.println();
		System.out.println("     -------------------------------------------------------------------------------------------------------");
		System.out.println("    |						DATA Custumer						    |");
		System.out.println("     -------------------------------------------------------------------------------------------------------");
		System.out.println("    |\tID\t|\tNama\t\t\t|       Email       		|         Nomor HP	    |");
		System.out.println("     -------------------------------------------------------------------------------------------------------");
		for (Customer dCustomer : listCustomer) {
			System.out.println("    |\t"+dCustomer.getId()+"\t|       "+dCustomer.getNama()+"\t        |       "+dCustomer.getEmail()+"\t|\t"+dCustomer.getNohp()+"\t    |");
		}
		System.out.println("     -------------------------------------------------------------------------------------------------------");
		System.out.print("    | [B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = in.next().charAt(0);
		if (back == 'B' || back == 'b') {
			MenuCustomer.displayMenuCustomer();
		}
	}
	public static void displayTupleCustomer(Customer customer) {
		char back;
		System.out.println();
		System.out.println("     -------------------------------------------");
		System.out.println("    |		DATA Customer			|");
		System.out.println("     -------------------------------------------");
		System.out.println("    |ID\t\t: " + customer.getId()+"\t\t\t\t|");
		System.out.println("    |Nama\t: " + customer.getNama()+"\t\t\t|");
		System.out.println("    |Email\t: " + customer.getEmail()+"\t\t|");
		System.out.println("    |No HP\t: " + customer.getNohp()+"\t\t|");
		System.out.println("    |Alamat\t: " + customer.getAlamat()+"\t\t\t|");
		System.out.println("     -------------------------------------------");
		System.out.print("    | [B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = in.next().charAt(0);
		if (back == 'B' || back == 'b') {
			MenuCustomer.displayMenuCustomer();
		}
	}
}
