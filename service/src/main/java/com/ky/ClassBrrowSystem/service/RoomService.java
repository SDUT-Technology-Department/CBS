package com.ky.ClassBrrowSystem.service;

import com.ky.ClassBrrowSystem.vo.ResultVo;

public interface RoomService {
    //----------------SearchRoomInfo----------------
    public ResultVo searchRoomById (int roomId);//依据id查询教室信息

    //-------------SearchRoomBorrowInfo-------------
    public ResultVo searchBorrowedInfoByRoomId(int roomId);//该教室的所有借用信息

    public ResultVo searchBorrowedInfoByUserId(String userid);//查询用户的所有借阅记录

    public ResultVo searchBorrowedInfoByTime(String date, int timeId);//该时间空余的教室

    public ResultVo searchBorrowedInfoByTimeAndRoomId(int timeId,String data,int roomId);//该教室该时间是否空余

    //public ResultVo searchBorrowedInfoBySpan(String name, String Data, String TimeBegin, String TimeEnd);//查看该教室某时间段内的借用信息

    //-------------RoomBorrowOperate-------------
//    public ResultVo borrow (int roomId, String borrowUser,int timeId, String borrowDate,String borrowReason, String applyTime, int isNeedMedia, int isAdmit);
    public ResultVo borrow (int roomId,int timeId, String borrowUser,String date,String reason,int isNeedMedia);


    public ResultVo cancel (int logId);//借用记录id
}
