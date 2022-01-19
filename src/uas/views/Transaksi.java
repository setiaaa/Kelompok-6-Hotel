package uas.views;
import uas.bean.*;
import uas.utils.DatabaseUtil;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;
public class Transaksi {
	public static void CheckIn() {
		Scanner in = new Scanner(System.in);
		System.out.print("Masukan Nomor Room: ");
		LoginCustomer.nomor = in.nextInt();
		System.out.print("Jumlah Room");
		LoginCustomer.jumlah = in.nextInt();
		in.close();
	}
	public static float getPrice(int id, int quantity) {
		float price = 0;
		Room room = new Room();
		DatabaseUtil db = new DatabaseUtil();
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
                        	price = Integer.parseInt(rs.getObject(1).toString()) * quantity;
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
