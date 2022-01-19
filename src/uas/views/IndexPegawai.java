package uas.views;
import uas.bean.Pegawai;
import uas.utils.DatabaseUtil;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class IndexPegawai {
	public static int inId;
	static String inNama;
	static Scanner in = new Scanner(System.in);
	static Scanner in2 = new Scanner(System.in);
	public static void Page() {
		System.out.println("--- Main ---");
		System.out.println("1. Login\n"
				+ "2. Register");
		System.out.print("Masukan Pilihan: "); int pilihan = in.nextInt();
		switch (pilihan) {
		case 1: {
			loginPegawai();
			loggedOn();
			break;
		}
		case 2: {
			FormView.insertPegawai();
			break;
		}
		default:
			System.out.print("Pilihan tidak ada");
		}
	}
	public static void loginPegawai() {
		System.out.print("Masukan Email    : "); String email = in2.next();
		System.out.print("Masukan Password : "); String password = in2.next();
		DatabaseUtil db = new DatabaseUtil();
		Pegawai pegawai = new Pegawai();
		try {
			db.connect();
 
            String query = "SELECT * FROM pegawai WHERE email = '"+email+"' and password = '"+password+"'";
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
                        if(email.equals(rs.getObject(3).toString()) && password.equals(rs.getObject(4).toString())) {
                        	System.out.println("Login berhasil");
                        	System.out.println("Selamat Datang - "+rs.getObject(2).toString());
                        	inId = Integer.parseInt(rs.getObject(1).toString());
                        	inNama = rs.getObject(2).toString();
        		        	LoginPegawai.profileMenu();
                        	break;
                        }
                    }
                } while (rs.next());
                
            } else {
            	pegawai.setId(0);
            	System.out.println("Login Gagal - Email atau Password salah");
            }
            db.disconnect();            
            
        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }		
	}
	public static void loggedOn() {
		System.out.println(inId+" - "+inNama);
	}
}
