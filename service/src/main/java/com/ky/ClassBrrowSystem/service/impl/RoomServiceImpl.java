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
import java.beans.Transient;

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
    public ResultVo searchRoomById(int roomId) {
        Room room = roomDAO.queryRoomById(roomId);

        if (room == null){
            return new ResultVo(400,"教室不存在", null);
        }else {
            return new ResultVo(200,"查询成功",room);
        }
    }

    @Override
    public ResultVo searchBorrowedInfoByRoomId(int roomId) {
        RoomBorrowedInfo RBI = roomBorrowInfoDAO.queryRBIByRoomId(roomId);

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
    public ResultVo searchBorrowedInfoByTime(String date, int timeId) {
        RoomBorrowedInfo RBI = roomBorrowInfoDAO.queryRBIByTime(date,timeId);

        if (RBI == null){
            return new ResultVo(400,"该时间段没有可用教室", null);
        }else {
            return new ResultVo(200,"查询成功",RBI);
        }
    }

    @Override
    public ResultVo searchBorrowedInfoByTimeAndRoomId(int timeId,String data,int roomId){
        RoomBorrowedInfo RBI = roomBorrowInfoDAO.queryRBIByTimeAndRoomId(timeId,data,roomId);

        if (RBI == null){
            return new ResultVo(400,"该时间段没有可用教室", null);
        }else {
            return new ResultVo(200,"查询成功",RBI);
        }
    }
//    @Override
//    public ResultVo searchBorrowedInfoBySpan(String name, String Data, String TimeBegin, String TimeEnd) {
//        return null;
//    }

    @Transient
    public ResultVo borrow(int roomId,int timeId, String borrowUser,String date,String reason,int isNeedMedia){
        synchronized (this) {//线程锁
            RoomBorrowedInfo RBI = roomBorrowInfoDAO.queryRBIByTimeAndRoomId(timeId, date, roomId);

            if (RBI == null) {
                RBI = new RoomBorrowedInfo();
                RBI.setBorrowRoomId(roomId);
                RBI.setBorrowUserId(borrowUser);
                RBI.setBorrowTimeId(timeId);
                RBI.setBorrowDate(date);
                RBI.setBorrowReason(reason);
                RBI.setIsNeedMedia(isNeedMedia);
                RBI.setIsAdmit(1);
                System.out.println("--------" + RBI);
//                int i = roomBorrowInfoDAO.borrow(RBI);
                return new ResultVo(200, "登记成功", null);
            } else {
                return new ResultVo(400, "该教室在此时间段内已被占用", RBI);
            }
        }
    }

    @Override
    public ResultVo cancel(int id) {
        return null;
    }
}
