package uas.dao;

import java.util.List;

import uas.bean.*;

public interface PegawaiDAO {
	public void viewProfilePegawai(int id);
	public void getPegawaiByEmail(String email);
    public List<Pegawai> getAllPegawai();
    public void savePegawai(Pegawai pegawai);
    public void updatePegawai(Pegawai pegawai);
    public void deletePegawai(Pegawai pegawai);
}
