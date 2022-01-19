package uas.bean;
import java.util.ArrayList;
public class Room {
	private int id;
	private String nama;
	private float price;
	public ArrayList<Room> getListRoom() {
		return listRoom;
	}
	public void setListRoom(ArrayList<Room> listRoom) {
		this.listRoom = listRoom;
	}
	ArrayList<Room> listRoom = new ArrayList<Room>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
