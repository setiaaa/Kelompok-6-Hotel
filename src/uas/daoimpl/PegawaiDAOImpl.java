package uas.daoimpl;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import uas.bean.*;
import uas.dao.*;
import uas.utils.DatabaseUtil;
import uas.views.ViewPegawai;

public class PegawaiDAOImpl implements PegawaiDAO {
	@Override
	public void viewProfilePegawai(int id) {
		DatabaseUtil db = new DatabaseUtil();
		Pegawai pegawai = new Pegawai();
		try {
			db.connect();
 
            String query = "SELECT * FROM pegawai WHERE id = '"+id+"'";
            ResultSet rs = db.readData(query);
 
            // process query results
            if (rs.next()) {
 
                ResultSetMetaData metaData = rs.getMetaData();
                int jumlahKolom = metaData.getColumnCount();
                do {
                    for (int i = 1; i <= jumlahKolom; i++) {
                    	pegawai.setId(Integer.parseInt(rs.getObject(1).toString()));
                    	pegawai.setNama(rs.getObject(2).toString());
                        pegawai.setEmail(rs.getObject(3).toString());
                        pegawai.setPassword(rs.getObject(4).toString());
                        pegawai.setPosition(rs.getObject(5).toString());
                        pegawai.setAlamat(rs.getObject(6).toString());
                        pegawai.setNohp(rs.getObject(7).toString());
                    }
                } while (rs.next());
                
            } else {
            	pegawai.setId(0);
            }

            db.disconnect();            
 
        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
		
		ViewPegawai.displayTuplePegawai(pegawai);
	}
	@Override
	public void getPegawaiByEmail(String email) {
		DatabaseUtil db = new DatabaseUtil();
		Pegawai pegawai = new Pegawai();
		try {
			db.connect();
 
            String query = "SELECT * FROM pegawai WHERE email = '"+email+"'";
            ResultSet rs = db.readData(query);
 
            // process query results
            if (rs.next()) {
 
                ResultSetMetaData metaData = rs.getMetaData();
                int jumlahKolom = metaData.getColumnCount();
                do {
                    for (int i = 1; i <= jumlahKolom; i++) {
                    	pegawai.setId(Integer.parseInt(rs.getObject(1).toString()));
                    	pegawai.setNama(rs.getObject(2).toString());
                        pegawai.setEmail(rs.getObject(3).toString());
                        pegawai.setPassword(rs.getObject(4).toString());
                        pegawai.setPosition(rs.getObject(5).toString());
                        pegawai.setAlamat(rs.getObject(6).toString());
                        pegawai.setNohp(rs.getObject(7).toString());
                    }
                } while (rs.next());
                
            } else {
            	pegawai.setId(0);
            }

            db.disconnect();            
 
        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
		
		ViewPegawai.displayTuplePegawai(pegawai);
	}
	@Override
	public List<Pegawai> getAllPegawai() {
		List<Pegawai> listPegawai = new ArrayList<Pegawai>();
		DatabaseUtil db = new DatabaseUtil();
		try {
			db.connect();
			 
            String query = "SELECT * FROM pegawai";
         
            ResultSet rs = db.readData(query);
 
            // process query results
            while (rs.next()) {
 
        		Pegawai pegawai = new Pegawai();
            	
        		pegawai.setId(Integer.parseInt(rs.getObject(1).toString()));
            	pegawai.setNama(rs.getObject(2).toString());
                pegawai.setEmail(rs.getObject(3).toString());
                pegawai.setPosition(rs.getObject(4).toString());
                pegawai.setAlamat(rs.getObject(5).toString());
                pegawai.setNohp(rs.getObject(6).toString());
                
                listPegawai.add(pegawai);
 
            } 
            db.disconnect();
			
		} catch (SQLException ex) {
			System.out.println("Terjadi error: " + ex.getMessage());
		}
		
		return listPegawai;
	}

	@Override
	public void updatePegawai(Pegawai pegawai) {
		DatabaseUtil db = new DatabaseUtil();
		String query;
		try {
			db.connect();
			query = "UPDATE pegawai SET nama='"+pegawai.getNama()+"',"
					+ " email='"+pegawai.getEmail()+"',"
					+ " password+'"+pegawai.getPassword()+"',"
					+ " position+'"+pegawai.getPosition()+"',"
					+ " alamat="+pegawai.getAlamat()+"',"
					+ " no hp="+pegawai.getNohp()+"',"
					+ " WHERE id='"+pegawai.getId()+"'";
			
			db.executeQuery(query);
			System.out.println("Data berhasil diperbarui!");
		} catch (Exception e) {
			System.out.println("Terjadi error: " + e.getMessage());
		}
		
	}

	@Override
	public void deletePegawai(Pegawai pegawai) {
		DatabaseUtil db = new DatabaseUtil();
		String query;
		try {
			db.connect();
			query = "DELETE FROM pegawai WHERE id='"+pegawai.getId()+"'";
			db.executeQuery(query);
			ViewPegawai.displayTabelPegawai(getAllPegawai());
		} catch (Exception e) {
			System.out.println("Terjadi error: " + e.getMessage());
		}
	}

	@Override
	public void savePegawai(Pegawai pegawai) {
		DatabaseUtil db = new DatabaseUtil();
		String query;
		try {
			db.connect();
			query = "INSERT INTO pegawai (id, nama, email, position, no_hp, alamat)"
					+ " VALUES ("+pegawai.getId()+", '"
					+ pegawai.getNama()+"', '"
					+ pegawai.getEmail()+"', '"
					+ pegawai.getPassword()+"', '"
					+ pegawai.getPosition()+"', '"
					+ pegawai.getNohp()+"', '"
					+ pegawai.getAlamat()+"')";
			
			db.executeQuery(query);
			System.out.println("Data berhasil ditambahkan!");
		} catch (Exception ex) {
			System.out.println("Terjadi error: " + ex.getMessage());
		}
	}
	
}
