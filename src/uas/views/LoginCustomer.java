package uas.views;
import java.util.Scanner;

public class LoginCustomer {
	protected static int nomor, jumlah;
	public static void profileMenu() {
		int menu;
		Scanner in = new Scanner(System.in);
		boolean left = false;
        do {
        	System.out.println("1. Check In Kamar\n"
    				+ "2. Check Out\n"
    				+ "3. Perbarui Profil\n"
    				+ "3. Log Out");
		    System.out.print("Pilih menu: ");
		    menu = in.nextInt();
		    switch (menu) {
		        case 1:
		    		Transaksi.CheckIn();
		        	break;
		        case 2:
		        	System.out.print("Total yang biaya : ");
		        	Transaksi.getPrice(nomor, jumlah);
		        	;
		        	break;
		        case 3:
		        	IndexCustomer.inId = 0;
		        	IndexCustomer.inNama = null;
		        	Driver.main(null);
		        	break;
		        default:
		        	System.out.println("Warning: Pilihan yang anda masukkan salah!");  	
		    }
        } while(!left);
        
        in.close();
	}
}