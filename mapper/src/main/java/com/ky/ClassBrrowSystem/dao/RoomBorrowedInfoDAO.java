package com.ky.ClassBrrowSystem.dao;

import com.ky.ClassBrrowSystem.enity.Room;
import com.ky.ClassBrrowSystem.enity.RoomBorrowedInfo;

import java.util.List;

public interface RoomBorrowedInfoDAO {
    public List<RoomBorrowedInfo>  queryRBIByOptions(String date, int timeId, String reason, String roomId, String userId);

    public RoomBorrowedInfo queryRBIByUserId(String userId);

    public RoomBorrowedInfo queryRBIByTimeAndRoomId(int timeId,String date, String roomId);

    public RoomBorrowedInfo cancel(String logId);

    public RoomBorrowedInfo borrow(String date, int timeId, String timeName, String roomId, String roomName, String user, String reason, String applyTime);
}
