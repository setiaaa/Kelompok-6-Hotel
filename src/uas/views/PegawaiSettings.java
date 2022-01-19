package uas.views;

import uas.bean.Pegawai;
import uas.dao.PegawaiDAO;
import uas.daoimpl.PegawaiDAOImpl;
import java.util.*;
public class PegawaiSettings {
	static Scanner in = new Scanner(System.in);
	public static void updatePegawai() {
		int id = IndexPegawai.inId;
		char back;
		Pegawai pegawai = new Pegawai();
		PegawaiDAO operation = new PegawaiDAOImpl();
		System.out.println();
		System.out.println("              *****************************************                  ");
        System.out.println("              | 		Edit Profile		 	       |                  ");
        System.out.println("              *****************************************                  ");
        System.out.print("              | ID			:");
        System.out.println(id);
        pegawai.setId(id);
        System.out.print("              | Nama		        :");
        pegawai.setNama(in.nextLine());
        System.out.print("              | Email                   :");
        pegawai.setEmail(in.nextLine());
        System.out.print("              | Posisi				  :");
        pegawai.setPosition(in.nextLine());
        System.out.print("              | NO HP					  :");
        pegawai.setNohp(in.nextLine());
        System.out.print("              | Alamat	        	  :");
        pegawai.setAlamat(in.nextLine());
        System.out.println("              *****************************************					 ");
        operation.updatePegawai(pegawai);;
        System.out.print("[B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = in.next().charAt(0);
		if (back == 'B' || back == 'b') {
			LoginPegawai.profileMenu();
		}
	}
	public static void deleteAccount() {
		int id = IndexPegawai.inId;
		Pegawai pegawai = new Pegawai();
		PegawaiDAO operation = new PegawaiDAOImpl();
		pegawai.setId(id);
		operation.deletePegawai(pegawai);	
	}
}
