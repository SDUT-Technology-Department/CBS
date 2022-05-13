package com.ky.ClassBrrowSystem.dao;

import com.ky.ClassBrrowSystem.enity.RoomBorrowedInfo;

public interface RoomBorrowedInfoDAO {
    public RoomBorrowedInfo queryRBIByRoomId(int roomId);

    public RoomBorrowedInfo queryRBIByUserId(String userId);

    public RoomBorrowedInfo queryRBIByTime(String date, int timeId);

    public RoomBorrowedInfo queryRBIByTimeAndRoomId(int timeId,String date,int roomId);

    //    public RoomBorrowedInfo borrow(int roomId, String borrowUser,int timeId, String borrowDate,String borrowReason, String applyTime, int isNeedMedia, int isAdmit);
    public RoomBorrowedInfo borrow(int roomId, int timeId, String borrowUser, String date, String reason, int isNeedMedia);


    public RoomBorrowedInfo cancel(String logId);
}
