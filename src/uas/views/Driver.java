package uas.views;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		int pilihan;
		Scanner in = new Scanner(System.in);
		boolean left = false;
        do {
        	System.out.println();		        
            System.out.println("|--- Selamat Datang di Menu Utama ---|\n"
            				+ "|\t\t\t\t     |");
            System.out.println("|1. Sebagai Pegawai		     |\n"
            				+ "|2. Sebagai Customer		     |\n"
            				+ "|3. Keluar			     |\n"
            				+ "|\t\t\t\t     |");
            System.out.println("|------------------------------------|");
            System.out.print("Pilih menu: ");
            pilihan = in.nextInt();
		    switch (pilihan) {
		        case 1:
		        	IndexPegawai.Page();
		        	break;
		        case 2:
		        	IndexCustomer.Page();
		        	break;
		        case 3:
		        	System.out.println("Terima kasih, Anda keluar dari aplikasi!");
		        	System.exit(0);
		        default:
		        	System.out.println("Warning: Pilihan yang anda masukkan salah!");  	
		    }
        } while(!left);
        in.close();
	}
}
