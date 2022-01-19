package uas.bean;
import java.util.*;
public class Pegawai extends User {
	private String position;
	ArrayList<Customer> listCustomer = new ArrayList<>();
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public ArrayList<Customer> getListCustomer() {
		return listCustomer;
	}
	public void setListCustomer(ArrayList<Customer> listCustomer) {
		this.listCustomer = listCustomer;
	}
}
