package com.ky.ClassBrrowSystem.dao;

import com.ky.ClassBrrowSystem.enity.Room;


public interface RoomDAO {
    public Room queryRoomById(int roomId);

    public Room queryRoomByMedia(Boolean isMedia);
}

