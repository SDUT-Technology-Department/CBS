package com.ky.ClassBrrowSystem.service.impl;

import com.ky.ClassBrrowSystem.dao.RoomBorrowedInfoDAO;
import com.ky.ClassBrrowSystem.dao.RoomDAO;
import com.ky.ClassBrrowSystem.enity.Room;
import com.ky.ClassBrrowSystem.enity.RoomBorrowedInfo;
import com.ky.ClassBrrowSystem.service.RoomService;
import com.ky.ClassBrrowSystem.vo.ResultVo;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Scope("singleton")
public class RoomServiceImpl implements RoomService {
    @Resource
    private RoomDAO roomDAO;
    @Resource
    private RoomBorrowedInfoDAO roomBorrowInfoDAO;

    /*
    * 查询教室信息
    * */
    @Override
    public  ResultVo getAllRoom(){
        List<Room> room = roomDAO.getAllRoom();

        if (room == null){
            return new ResultVo(400,"未查询到教室信息",null);
        }else {
            return new ResultVo(200,"查询成功",room);
        }
    }

    @Override
    public ResultVo searchRoomById(String roomId) {
        Room room = roomDAO.queryRoomById(roomId);

        if (room == null){
            return new ResultVo(400,"教室不存在", null);
        }else {
            return new ResultVo(200,"查询成功",room);
        }
    }

    @Override
    public ResultVo queryRoomByBorrowOptions(String date,int timeId,int isSpecial){
        List<Room> room = roomDAO.queryRoomByBorrowOptions(date,timeId,isSpecial);

        if (room == null){
            return new ResultVo(400,"该条件下没有空闲教室",null);
        }else {
            return new ResultVo(200,"查询成功",room);
        }
    }
    /*
     * 查询教室借用信息
     * */
    @Override
    public ResultVo getAllRoomBorrowInfo(){
        List<RoomBorrowedInfo> RBI = roomBorrowInfoDAO.getAllRoomBorrowInfo();

        return new ResultVo(200,"查询成功",RBI);
    }

    @Override
    public ResultVo  queryRBIByOptions(String date, int timeId, String reason, String roomId, String userId) {
        List<RoomBorrowedInfo> RBI = roomBorrowInfoDAO.queryRBIByOptions(date,timeId,reason,roomId,userId);

        if (RBI == null){
            return new ResultVo(400,"该教室没有借用记录", null);
        }else {
            return new ResultVo(200,"查询成功",RBI);
        }
    }

    @Override
    public ResultVo searchBorrowedInfoByUserId(String userId){
        RoomBorrowedInfo RBI = roomBorrowInfoDAO.queryRBIByUserId(userId);

        if (RBI == null){
            return new ResultVo(400,"该用户没有借用记录", null);
        }else {
            return new ResultVo(200,"查询成功",RBI);
        }
    }

    @Override
    public ResultVo searchBorrowedInfoByTimeAndRoomId(int timeId, String data, String roomId) {
        return null;
    }

    @Override
    public ResultVo borrow(String date,int timeId, String timeName,String roomId, String roomName,String user,String reason,String applyTime){
        synchronized (this) {//线程锁
            RoomBorrowedInfo RBI = roomBorrowInfoDAO.queryRBIByTimeAndRoomId(timeId, date, roomId);

            if (RBI == null) {
                roomBorrowInfoDAO.borrow(date,timeId,timeName,roomId,roomName,user,reason,applyTime);

                return new ResultVo(200, "登记成功", null);
            } else {
                return new ResultVo(400, "该教室在此时间段内已被占用", RBI);
            }
        }
    }

    @Override
    public ResultVo cancel(String borrow_room_id,String borrow_user,int borrow_time_id, String borrow_date) {
        int c = roomBorrowInfoDAO.cancel(borrow_room_id,borrow_user,borrow_time_id,borrow_date);
        return new ResultVo(200,"取消成功",c);
    }
}
