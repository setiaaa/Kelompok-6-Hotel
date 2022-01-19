package uas.views;

import java.util.Scanner;

public class LoginPegawai {
	public static void profileMenu() {
		boolean left = false;
		Scanner scanner = new Scanner(System.in);
		do {
			int menu;
	        System.out.println("1. Pengaturan Profil\n"
	        				+ "2. Lihat Profil\n"
	        				+ "3. Hapus Akun\n"
	        				+ "4. Kelola Akun Customer\n"
	        				+ "5. Kelola Room\n"
	        				+ "6. Log Out");
	        System.out.print("Pilih menu: ");
	        menu = scanner.nextInt();
	        switch (menu) {
		        case 1:
		        	PegawaiSettings.updatePegawai();
		        	break;
		        case 2:
		        	FormView.viewProfilPegawai();
		        	break;
		        case 3:
		        	PegawaiSettings.deleteAccount();
		        	IndexPegawai.inId = 0;
		        	IndexPegawai.inNama = null;
		        	IndexPegawai.loginPegawai();;
		        	break;
		        case 4:
		        	MenuCustomer.displayMenuCustomer();
		        	break;
		        case 5:
		        	MenuRoom.displayMenuRoom();
		        	break;
		        case 6:
		        	IndexPegawai.inId = 0;
		        	IndexPegawai.inNama = null;
		        	Driver.main(null);
		        	break;
		        default:
		        	System.out.println("Warning: Pilihan yang anda masukkan salah!");  	
	        }
		} while(!left);
        scanner.close();
	}
}
