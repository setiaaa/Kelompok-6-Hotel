package uas.views;

import java.util.Scanner;

import uas.dao.*;
import uas.daoimpl.*;

public class MenuRoom {
	public static void displayMenuRoom() {
		int menu;
		Scanner in = new Scanner(System.in);
		RoomDAO operation = new RoomDAOImpl();
		System.out.println();			        
	    System.out.println("              *****************************************");
	    System.out.println("              |            Data Room		      |");
	    System.out.println("              ***************************************** ");
	    System.out.println("              | Pilihan:                              |");
	    System.out.println("              |        1. Input Data		      |");
	    System.out.println("              |        2. Cari Data By Id             |");
	    System.out.println("              |        3. Tampilkan Seluruh Data      |");
	    System.out.println("              |        4. Perbarui Data      	    |");
	    System.out.println("              |        5. Hapus Data                  |");
	    System.out.println("              |        6. Kembali                     |");  
	    System.out.println("              *****************************************");	
	    System.out.println();
	    System.out.print("Pilih menu: ");
	    menu = in.nextInt();
	    switch (menu) {
	        case 1:
	        	FormView.insertRoom();
	        	break;
	        case 2:
	        	FormView.searchRoomById();
	        	break;
	        case 3:
	        	ViewRoom.displayTabelRoom(operation.getAllRoom());
	        	break;
	        case 4:
	        	FormView.updateRoom();
	        case 5:
	        	FormView.deleteRoom();
	        	break;
	        case 6:
	        	LoginPegawai.profileMenu();
	        	break;
	        default:
	        	System.out.println("Warning: Pilihan yang anda masukkan salah!");  	
	    }
	    in.close();
	}
}
