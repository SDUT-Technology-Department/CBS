package com.ky.ClassBrrowSystem.service;

import com.ky.ClassBrrowSystem.vo.ResultVo;

public interface RoomService {
    //----------------SearchRoomInfo----------------
    public ResultVo getAllRoom();

    public ResultVo queryRoomByBorrowOptions(String date,int timeId,int isSpecial);

    //-------------SearchRoomBorrowInfo-------------
    public ResultVo getAllRoomBorrowInfo();

    public ResultVo  queryRBIByOptions(String date, int timeId, String reason, String roomId, String userId);//该按条件查询教室

    public ResultVo searchBorrowedInfoByUserId(String userid);//查询用户的所有借用记录

    //-------------RoomBorrowOperate-------------
    public ResultVo borrow (String date,int timeId, String timeName,String roomId, String roomName,String user,String reason,String applyTime);


    public ResultVo cancel (String borrow_room_id,String borrow_user,int borrow_time_id, String borrow_date);//借用记录id
}
