package uas.views;

import java.util.List;
import java.util.Scanner;

import uas.bean.*;
import uas.dao.*;
import uas.daoimpl.*;

public class ViewPegawai {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		PegawaiDAO operation = new PegawaiDAOImpl();
		displayTabelPegawai(operation.getAllPegawai());
	}
	
	public static void displayTabelPegawai(List<Pegawai> listPegawai) {
		char back;
		System.out.println();
		System.out.println("     -------------------------------------------------------------------------------------------------------");
		System.out.println("    |						DATA Pegawai						    |");
		System.out.println("     -------------------------------------------------------------------------------------------------------");
		System.out.println("    |\tID\t|\tNama\t\t\t|       Email       		|         Posisi   	    |");
		System.out.println("     -------------------------------------------------------------------------------------------------------");
		for (Pegawai dPegawai : listPegawai) {
			System.out.println("    |\t"+dPegawai.getId()+"\t|       "+dPegawai.getNama()+"\t        |       "+dPegawai.getEmail()+"\t|\t    "+dPegawai.getPosition()+"\t\t    |");
		}
		System.out.println("     -------------------------------------------------------------------------------------------------------");
		System.out.print("    | [B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = in.next().charAt(0);
		if (back == 'B' || back == 'b') {
			LoginPegawai.profileMenu();
		}
	}
	
	public static void displayTuplePegawai(Pegawai pegawai) {
		char back;
		System.out.println();
		System.out.println("     ---------------------------------------------------");
		System.out.println("    |		DATA Pegawai				|");
		System.out.println("     ---------------------------------------------------");
		System.out.println("    |ID\t\t: " + pegawai.getId()+"\t\t\t\t\t|");
		System.out.println("    |Nama\t: " + pegawai.getNama()+"\t\t\t\t|");
		System.out.println("    |Email\t: " + pegawai.getEmail()+"\t\t|");
		System.out.print("    |Password\t: ");
		for(int i=0;i<pegawai.getPassword().length();i++) {
			System.out.print("*");
		}
		System.out.print("\t\t\t\t|\n");
		System.out.println("    |Posisi\t: " + pegawai.getPosition()+"\t\t\t\t\t|");
		System.out.println("     ---------------------------------------------------");
		System.out.print("    | [B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = in.next().charAt(0);
		if (back == 'B' || back == 'b') {
			LoginPegawai.profileMenu();
		}
	}
	//customer
	
	

}
