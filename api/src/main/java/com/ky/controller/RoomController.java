package com.ky.controller;

import com.ky.ClassBrrowSystem.service.RoomService;
import com.ky.ClassBrrowSystem.vo.ResultVo;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
/*
* 等价于
* @Controller
* @ResponseBody //返回值为json格式
* */

@RequestMapping("/room")
@Api(value = "教室借用相关接口", tags = "借教室管理")
@CrossOrigin
public class RoomController {
    @Resource
    private RoomService roomService;


    /*
    * POST 添加
    * GET 查询
    * PUT 修改
    * DELETE 删除
    * */
    //----------------SearchRoomInfo----------------
    @RequestMapping(value = "/getAllRoom",method = RequestMethod.GET)
    public ResultVo getAllRoom(){
        return roomService.getAllRoom();
    }

    @RequestMapping(value = "/searchRoomById", method = RequestMethod.POST)
    public ResultVo searchRoomById(String roomId){
        return roomService.searchRoomById(roomId);
    }

    //-------------SearchRoomBorrowInfo-------------
    @RequestMapping(value = "/searchBorrowedInfoByRoomId/{roomId}",method = RequestMethod.GET)
    public ResultVo searchBorrowedInfoByRoomId(@PathVariable("roomId") String roomId){
        return roomService.searchBorrowedInfoByRoomId(roomId);
    }

    @RequestMapping(value = "/searchBorrowedInfoByUserId/{userId}",method = RequestMethod.GET)
    public ResultVo searchBorrowedInfoByUserId(@PathVariable("userId") String userId){
        return roomService.searchBorrowedInfoByUserId(userId);
    }

    @RequestMapping(value = "/searchBorrowedInfoByTime", method = RequestMethod.POST)
    public ResultVo searchBorrowedInfoByTime(String date, int timeId){
        return roomService.searchBorrowedInfoByTime(date,timeId);
    }

    @RequestMapping(value = "/searchBorrowedInfoByTimeAndRoomId", method = RequestMethod.POST)
    public ResultVo searchBorrowedInfoByTimeAndRoomId(int timeId,String data,String roomId){
        return roomService.searchBorrowedInfoByTimeAndRoomId(timeId,data,roomId);
    }

    //---------------RoomBorrowOperator---------------
    @PostMapping(value = "/borrow")                                    //等价格于RequestMapping(value = "/borrow/{id}", method = RequestMethod.POST)
    public ResultVo borrowRoom(String roomId,int timeId, String borrowUser,String date,String reason,int isNeedMedia){
        return roomService.borrow(roomId,timeId,borrowUser,date,reason,isNeedMedia);
    }

    @RequestMapping(value = "/cancel/{logId}", method = RequestMethod.DELETE)
    public ResultVo cancelBorrow(@PathVariable("logId") String logId){

        return null;
    }

}
