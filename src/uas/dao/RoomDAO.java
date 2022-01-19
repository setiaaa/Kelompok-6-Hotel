package uas.dao;
import uas.bean.*;
import java.util.List;
public interface RoomDAO {

	public List<Room> getAllRoom();
    public void saveRoom(Room room);
    public void updateRoom(Room room);
    public void deleteRoom(Room room);
    public void getRoomById(int id);
    public void getRoomByPrice(float price);
}
