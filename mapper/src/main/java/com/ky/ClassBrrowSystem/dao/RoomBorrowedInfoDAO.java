package com.ky.ClassBrrowSystem.dao;

import com.ky.ClassBrrowSystem.enity.RoomBorrowedInfo;

public interface RoomBorrowedInfoDAO {
    public RoomBorrowedInfo queryRBIByRoomId(String roomId);

    public RoomBorrowedInfo queryRBIByUserId(String userId);

    public RoomBorrowedInfo queryRBIByTimeAndRoomId(int timeId,String date, String roomId);

    public RoomBorrowedInfo cancel(String logId);

    public RoomBorrowedInfo borrow(String date, int timeId, String timeName, String roomId, String roomName, String user, String reason, String applyTime);
}
