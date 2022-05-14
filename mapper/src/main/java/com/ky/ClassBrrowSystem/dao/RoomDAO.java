package com.ky.ClassBrrowSystem.dao;

import com.ky.ClassBrrowSystem.enity.Room;

import java.util.List;


public interface RoomDAO {
    public List<Room> getAllRoom();

    public List<Room> queryRoomByBorrowOptions(String date,int timeId,int isSpecial);

    public Room queryRoomById(String roomId);

    public Room queryRoomByMedia(Boolean isMedia);
}

