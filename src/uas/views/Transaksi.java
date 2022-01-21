package uas.views;
import uas.bean.*;
import uas.utils.DatabaseUtil;
import uas.daoimpl.*;
import uas.dao.*;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Scanner;
public class Transaksi {
	public static void CheckIn() {
		Scanner in = new Scanner(System.in);
		Room room = new Room();
		RoomDAO operation = new RoomDAOImpl();
		ViewRoom.displayTabelRoom(operation.getAllRoom());
		System.out.println("Jika Check In lebih dari 1 kamar\n"
				+ "Maka mendapatkan diskon 10%"
				+ "Services Charge 5% dari Harga kamar");
		System.out.print("Masukan Nomor Room	: ");
		LoginCustomer.nomor = in.nextInt();
		System.out.print("Jumlah Room		: ");
		LoginCustomer.jumlah = in.nextInt();
	}
	public static float getPrice(int id, int quantity) {
		float price = 0;
		float services = 0.05f;
		Room room = new Room();
		DatabaseUtil db = new DatabaseUtil();
		DecimalFormat df = new DecimalFormat("Rp ###,###,###.##");
		try {
			db.connect();
 
            String query = "SELECT * FROM room WHERE id = '"+id+"'";
            ResultSet rs = db.readData(query);
            if (rs.next()) {
 
                ResultSetMetaData metaData = rs.getMetaData();
                int jumlahKolom = metaData.getColumnCount();
                do {
                    for (int i = 1; i <= jumlahKolom; i++) {
                    	room.setId(Integer.parseInt(rs.getObject(1).toString()));
                    	room.setNama(rs.getObject(2).toString());
                        room.setPrice(Float.parseFloat(rs.getObject(3).toString()));
                        if(id == Integer.parseInt(rs.getObject(1).toString())) {
                        	if(quantity > 1) {
                        		price = Float.parseFloat(rs.getObject(3).toString()) * quantity;
                        		price -= (price *0.10);
                            	System.out.println(df.format(price + (price * services)));
                        	}
                        	else {
                        		price = Float.parseFloat(rs.getObject(3).toString()) * quantity;
                            	System.out.println(df.format(price + (price * services)));
                        	}
                        	break;
                        }
                    }
                } while (rs.next());
                
            } else {
            	room.setId(0);
            }

            db.disconnect();            
 
        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
		return price;
	}
}
