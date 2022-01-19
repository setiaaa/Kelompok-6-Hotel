package uas.daoimpl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import uas.dao.RoomDAO;
import uas.bean.Room;
import uas.utils.DatabaseUtil;
import uas.views.*;

public class RoomDAOImpl implements RoomDAO {
	@Override
	public List<Room> getAllRoom() {
		List<Room> listRoom = new ArrayList<Room>();
		DatabaseUtil db = new DatabaseUtil();
		try {
			db.connect();
			 
            String query = "SELECT * FROM room";
         
            ResultSet rs = db.readData(query);
 
            // process query results
            while (rs.next()) {
 
        		Room room = new Room();
            	room.setId(Integer.parseInt(rs.getObject(1).toString()));
            	room.setNama(rs.getObject(2).toString());
                room.setPrice(Float.parseFloat(rs.getObject(3).toString()));
                listRoom.add(room);
 
            } 
            db.disconnect();
			
		} catch (SQLException ex) {
			System.out.println("Terjadi error: " + ex.getMessage());
		}
		
		return listRoom;
	}
	@Override
	public void getRoomById(int id) {
		DatabaseUtil db = new DatabaseUtil();
		Room room = new Room();
		try {
			db.connect();
 
            String query = "SELECT * FROM room WHERE id = '"+id+"'";
            ResultSet rs = db.readData(query);
 
            // process query results
            if (rs.next()) {
 
                ResultSetMetaData metaData = rs.getMetaData();
                int jumlahKolom = metaData.getColumnCount();
                do {
                    for (int i = 1; i <= jumlahKolom; i++) {
                    	room.setId(Integer.parseInt(rs.getObject(1).toString()));
                    	room.setNama(rs.getObject(2).toString());
                        room.setPrice(Float.parseFloat(rs.getObject(3).toString()));
                    }
                } while (rs.next());
                
            } else {
            	room.setId(0);
            }

            db.disconnect();            
 
        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
		
		ViewRoom.displayTupleRoom(room);
	}
	@Override
	public void getRoomByPrice(float price) {
		DatabaseUtil db = new DatabaseUtil();
		Room room = new Room();
		try {
			db.connect();
 
            String query = "SELECT * FROM room WHERE price = '"+price+"'";
            ResultSet rs = db.readData(query);
 
            // process query results
            if (rs.next()) {
 
                ResultSetMetaData metaData = rs.getMetaData();
                int jumlahKolom = metaData.getColumnCount();
                do {
                    for (int i = 1; i <= jumlahKolom; i++) {
                    	room.setId(Integer.parseInt(rs.getObject(1).toString()));
                    	room.setNama(rs.getObject(2).toString());
                        room.setPrice(Float.parseFloat(rs.getObject(3).toString()));
                    }
                } while (rs.next());
                
            } else {
            	room.setId(0);
            }

            db.disconnect();            
 
        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
		
		ViewRoom.displayTupleRoom(room);
	}
	@Override
	public void deleteRoom(Room room) {
		DatabaseUtil db = new DatabaseUtil();
		String query;
		try {
			db.connect();
			query = "DELETE FROM room WHERE id='"+room.getId()+"'";
			db.executeQuery(query);
			ViewRoom.displayTabelRoom(getAllRoom());
		} catch (Exception e) {
			System.out.println("Terjadi error: " + e.getMessage());
		}
	}

	@Override
	public void saveRoom(Room room) {
		DatabaseUtil db = new DatabaseUtil();
		String query;
		try {
			db.connect();
			query = "INSERT INTO room (id, nama, price)"
					+ " VALUES ("+room.getId()+", '"
					+ room.getNama()+"', '"
					+ room.getPrice()+"')";
			
			db.executeQuery(query);
			System.out.println("Data berhasil ditambahkan!");
		} catch (Exception ex) {
			System.out.println("Terjadi error: " + ex.getMessage());
		}
	}
	@Override
	public void updateRoom(Room room) {
		DatabaseUtil db = new DatabaseUtil();
		String query;
		try {
			db.connect();
			query = "UPDATE customer SET nama='"+room.getNama()+"',"
					+ " price='"+room.getPrice()+"',"
					+ " WHERE id='"+room.getId()+"'";
			
			db.executeQuery(query);
			System.out.println("Data berhasil diperbarui!");
		} catch (Exception e) {
			System.out.println("Terjadi error: " + e.getMessage());
		}
		
	}
}
