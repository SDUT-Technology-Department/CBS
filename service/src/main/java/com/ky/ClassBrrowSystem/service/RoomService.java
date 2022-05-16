package com.ky.ClassBrrowSystem.service;

import com.ky.ClassBrrowSystem.vo.ResultVo;

public interface RoomService {
    //----------------SearchRoomInfo----------------
    public ResultVo getAllRoom();

    public ResultVo queryRoomByBorrowOptions(String date,int timeId,int isSpecial);

    public ResultVo searchRoomById (String roomId);//依据id查询教室信息
    //-------------SearchRoomBorrowInfo-------------
    public ResultVo  queryRBIByOptions(String date, int timeId, String reason, String roomId, String userId);//该按条件查询教室

    public ResultVo searchBorrowedInfoByUserId(String userid);//查询用户的所有借用记录

    public ResultVo searchBorrowedInfoByTimeAndRoomId(int timeId,String date, String roomId);//该教室该时间是否空余

    //-------------RoomBorrowOperate-------------
    public ResultVo borrow (String date,int timeId, String timeName,String roomId, String roomName,String user,String reason,String applyTime);


    public ResultVo cancel (int logId);//借用记录id
}
