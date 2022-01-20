package uas.views;

import java.util.Scanner;

import uas.bean.*;
import uas.dao.*;
import uas.daoimpl.*;

public class FormView {
	static Scanner in = new Scanner(System.in);
	static Scanner in2 = new Scanner(System.in);
	public static void insertPegawai() {
		char back;
		Pegawai pegawai = new Pegawai();
		PegawaiDAO operation = new PegawaiDAOImpl();
		System.out.println("              *****************************************                  ");
        System.out.println("              | Form Insert Data Pegawai	          |                  ");
        System.out.println("              *****************************************                  ");
        System.out.print("              | ID		:");
        pegawai.setId(in.nextInt());
        System.out.print("              | Nama		:");
        pegawai.setNama(in2.nextLine());
        System.out.print("              | Email		:");
        pegawai.setEmail(in2.nextLine());
        System.out.print("              | Password	:");
        pegawai.setPassword(in2.nextLine());
        System.out.print("              | Posisi	:");
        pegawai.setPosition(in2.nextLine());
        System.out.print("              | NO HP		:");
        pegawai.setNohp(in2.nextLine());
        System.out.print("              | Alamat	:");
        pegawai.setAlamat(in2.nextLine());
        System.out.println("              *****************************************					 ");
        operation.savePegawai(pegawai);
        System.out.print("[B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = in2.next().charAt(0);
		if (back == 'B' || back == 'b') {
			IndexPegawai.Page();
		}
	}
	
	public static void updatePegawai() {
		int id;
		char back;
		Pegawai pegawai = new Pegawai();
		PegawaiDAO operation = new PegawaiDAOImpl();
		id = IndexPegawai.inId;
		System.out.println();
		System.out.println("              *****************************************                  ");
        System.out.println("              | Form Update Data Pegawai        |                  ");
        System.out.println("              *****************************************                  ");
        System.out.print("              | ID		: ");
        System.out.println(id);
        pegawai.setId(id);
        System.out.print("              | Nama		: ");
        pegawai.setNama(in2.nextLine());
        System.out.print("              | Email		: ");
        pegawai.setEmail(in2.nextLine());
        System.out.print("              | Password	: ");
        pegawai.setPassword(in2.nextLine());
        System.out.print("              | Posisi	: ");
        pegawai.setPosition(in2.nextLine());
        System.out.print("              | NO HP		: ");
        pegawai.setNohp(in2.nextLine());
        System.out.print("              | Alamat	: ");
        pegawai.setAlamat(in2.nextLine());
        System.out.println("              *****************************************					 ");
        operation.updatePegawai(pegawai);;
        System.out.print("[B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = in2.next().charAt(0);
		if (back == 'B' || back == 'b') {
			IndexPegawai.Page();
		}
	}
	public static void deletePegawai() {
		int id;
		Pegawai pegawai = new Pegawai();
		PegawaiDAO operation = new PegawaiDAOImpl();
		System.out.print("Masukkan ID dari data yang akan dihapus: ");
		id = in.nextInt();
		pegawai.setId(id);
		operation.deletePegawai(pegawai);	
	}
	
	public static void searchPegawaiByEmail() {
		String email;
		Pegawai pegawai = new Pegawai();
		PegawaiDAO operation = new PegawaiDAOImpl();
		System.out.print("Masukkan email dari data yang akan dicari: ");
		email = in.nextLine();
		pegawai.setEmail(email);
		operation.getPegawaiByEmail(email);	
	}
	public static void viewProfilPegawai() {
		int id = IndexPegawai.inId;
		Pegawai pegawai = new Pegawai();
		PegawaiDAO operation = new PegawaiDAOImpl();
		pegawai.setId(id);
		operation.viewProfilePegawai(id);	
	}
	
	public static void insertCustomer() {
		char back;
		Customer customer = new Customer();
		CustomerDAO operation = new CustomerDAOImpl();
		System.out.println("              *****************************************                  ");
        System.out.println("              | Form Insert Data Customer	          |                  ");
        System.out.println("              *****************************************                  ");
        System.out.print("              | ID		: ");
        customer.setId(in.nextInt());
        System.out.print("              | Nama		: ");
        customer.setNama(in2.nextLine());
        System.out.print("              | Email		: ");
        customer.setEmail(in2.nextLine());
        System.out.print("              | Password	: ");
        customer.setPassword(in2.nextLine());
        System.out.print("              | NO HP		: ");
        customer.setNohp(in2.nextLine());
        System.out.print("              | Alamat	: ");
        customer.setAlamat(in2.nextLine());
        System.out.println("              *****************************************					 ");
        operation.saveCustomer(customer);
        System.out.print("[B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = in2.next().charAt(0);
		if (back == 'B' || back == 'b') {
			MenuCustomer.displayMenuCustomer();
		}
	}
	
	public static void updateCustomer() {
		int id;
		char back;
		Customer customer = new Customer();
		CustomerDAO operation = new CustomerDAOImpl();
		System.out.print("Masukkan ID dari data yang akan diupdate: ");
		id = in.nextInt();
		System.out.println();
		System.out.println("              *****************************************                  ");
        System.out.println("              | Form Update Data Customer		       |                  ");
        System.out.println("              *****************************************                  ");
        System.out.print("              | ID		: ");
        System.out.println(id);
        customer.setId(id);
        System.out.print("              | Nama		: ");
        customer.setNama(in2.nextLine());
        System.out.print("              | Email		: ");
        customer.setEmail(in2.nextLine());
        System.out.print("              | Password	: ");
        customer.setPassword(in2.nextLine());
        System.out.print("              | NO HP		: ");
        customer.setNohp(in2.nextLine());
        System.out.print("              | Alamat	: ");
        customer.setAlamat(in2.nextLine());
        System.out.println("              *****************************************					 ");
        operation.updateCustomer(customer);;
        System.out.print("[B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = in2.next().charAt(0);
		if (back == 'B' || back == 'b') {
			if(IndexPegawai.inId != 0) {
				MenuCustomer.displayMenuCustomer();
			}
			else {
				IndexCustomer.Page();
			}
			// Menambahkan fitur check
		}
	}
	public static void deleteCustomer() {
		int id;
		Customer customer = new Customer();
		CustomerDAO operation = new CustomerDAOImpl();
		System.out.print("Masukkan ID dari data yang akan dihapus: ");
		id = in.nextInt();
		customer.setId(id);
		operation.deleteCustomer(customer);	
	}
	
	public static void searchCustomerByEmail() {
		String email;
		Customer customer = new Customer();
		CustomerDAO operation = new CustomerDAOImpl();
		System.out.print("Masukkan email dari data yang akan dicari: ");
		email = in.nextLine();
		customer.setEmail(email);
		operation.getCustomerByEmail(email);	
	}
	public static void viewProfileCustomer() {
		int id = IndexCustomer.inId;
		Customer customer = new Customer();
		CustomerDAO operation = new CustomerDAOImpl();
		customer.setId(id);
		operation.getCustomerById(id);	
	}
	public static void searchCustomerById() {
		int id;
		Customer customer = new Customer();
		CustomerDAO operation = new CustomerDAOImpl();
		System.out.print("Masukkan ID dari data yang akan dicari: ");
		id = in.nextInt();
		customer.setId(id);
		operation.getCustomerById(id);	
	}
	public static void insertRoom() {
		char back;
		Room room = new Room();
		RoomDAO operation = new RoomDAOImpl();
		System.out.println("              *****************************************                  ");
        System.out.println("              | Form Insert Data Room	          |                  ");
        System.out.println("              *****************************************                  ");
        System.out.print("              | ID	: ");
        room.setId(in.nextInt());
        System.out.print("              | Nama	: ");
        room.setNama(in2.nextLine());
        System.out.print("              | Harga	: ");
        room.setPrice(in2.nextFloat());
        System.out.println("              *****************************************					 ");
        operation.saveRoom(room);
        System.out.print("[B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = in2.next().charAt(0);
		if (back == 'B' || back == 'b') {
			MenuRoom.displayMenuRoom();
		}
	}
	
	public static void updateRoom() {
		int id;
		char back;
		Room room = new Room();
		RoomDAO operation = new RoomDAOImpl();
		System.out.println();
		System.out.print("Masukkan ID dari data yang akan diupdate: ");
		id = in.nextInt();
		System.out.println("              *****************************************");
        System.out.println("              | Form Update Data Room				  |");
        System.out.println("              *****************************************");
        System.out.print("              | ID	: ");
        System.out.println(id);
        room.setId(id);
        System.out.print("              | Nama	: ");
        room.setNama(in2.nextLine());
        System.out.print("              | Price	: ");
        room.setPrice(in.nextFloat());
        System.out.println("              *****************************************					 ");
        operation.updateRoom(room);;
        System.out.print("[B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = in2.next().charAt(0);
		// memperbaiki form insert dan update
		if (back == 'B' || back == 'b') {
			MenuRoom.displayMenuRoom();
		}
	}
	public static void deleteRoom() {
		int id;
		Room room = new Room();
		RoomDAO operation = new RoomDAOImpl();
		System.out.print("Masukkan ID dari data yang akan dihapus: ");
		id = in.nextInt();
		room.setId(id);
		operation.deleteRoom(room);	
	}
	public static void searchRoomById() {
		int id;
		Room room = new Room();
		RoomDAO operation = new RoomDAOImpl();
		System.out.print("Masukkan ID dari data yang akan dicari: ");
		id = in.nextInt();
		room.setId(id);
		operation.getRoomById(id);	
	}
}
