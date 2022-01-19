package uas.views;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

import uas.bean.Room;
import uas.dao.*;
import uas.daoimpl.*;

public class ViewRoom {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		RoomDAO operation = new RoomDAOImpl();
		displayTabelRoom(operation.getAllRoom());
	}
	
	public static void displayTabelRoom(List<Room> listRoom) {
		char back;
		DecimalFormat df = new DecimalFormat("Rp ###,###,###.##");
		System.out.println();
		System.out.println("     ---------------------------------------------------");
		System.out.println("    |			Data Room						    |");
		System.out.println("     ---------------------------------------------------");
		System.out.println("    |\tID\t|\tNama\t    |       Price       |");
		System.out.println("     ---------------------------------------------------");
		for (Room kamar : listRoom) {
			System.out.println("    |\t"+kamar.getId()+"\t|     "+kamar.getNama()+"\t    |     "+df.format(kamar.getPrice())+" \t|");
		}
		System.out.println("     ---------------------------------------------------");
		System.out.print("    | [B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = in.next().charAt(0);
		if (back == 'B' || back == 'b') {
			MenuRoom.displayMenuRoom();
		}
	}
	
	public static void displayTupleRoom(Room room) {
		char back;
		DecimalFormat df = new DecimalFormat("Rp ###,###,###.##");
		System.out.println();
		System.out.println("     -----------------------------------");
		System.out.println("    |		DATA Room		|");
		System.out.println("     -----------------------------------");
		System.out.println("    |ID\t\t: " + room.getId()+"\t\t\t|");
		System.out.println("    |Nama\t: " + room.getNama()+"\t\t|");
		System.out.println("    |Harga\t: " + df.format(room.getPrice())+"\t\t|");
		System.out.println("     -----------------------------------");
		System.out.print("    | [B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = in.next().charAt(0);
		if (back == 'B' || back == 'b') {
			MenuRoom.displayMenuRoom();
		}
	}
}
