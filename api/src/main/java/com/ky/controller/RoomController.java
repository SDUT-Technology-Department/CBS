package com.ky.controller;

import com.ky.ClassBrrowSystem.service.RoomService;
import com.ky.ClassBrrowSystem.vo.ResultVo;
import io.swagger.annotations.Api;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


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

    @RequestMapping(value = "/searchRoomForBorrow", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo searchRoomForBorrow(@RequestBody JSONObject jsonParam){

        String date = jsonParam.getAsString("date");
        int timeId = (int) jsonParam.getAsNumber("timeId");

        int isSpecial;

        String isSpecialS = jsonParam.getAsString("isSpecial");

        if (isSpecialS.equals("true")){
            isSpecial = 1;
        }else {
            isSpecial = 0;
        }

        return roomService.queryRoomByBorrowOptions(date,timeId,isSpecial);
    }
    //-------------SearchRoomBorrowInfo-------------
    @RequestMapping(value = "getAllRBI", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo getAllRBI(){

        return roomService.getAllRoomBorrowInfo();
    }

    @RequestMapping(value = "/searchBorrowedInfoByOptions",method = RequestMethod.POST)
    public ResultVo searchBorrowedInfoByOptions(@RequestBody JSONObject jsonParam) {

//        System.out.println(jsonParam);

        String date = null;
        if (!jsonParam.get("date").equals("")) {
            date = jsonParam.getAsString("date");
        }

        //timeId默认为0不可能为空
        int timeId = (int) jsonParam.getAsNumber("timeId");


        String reason = null;
        if (!jsonParam.get("reason").equals("")) {
            reason = jsonParam.getAsString("reason");
        }

        //roomId默认为0不可能为空
        String roomId = null;
        if (!jsonParam.get("roomId").equals("")) {
            roomId = jsonParam.getAsString("roomId");
        }


        String userId = null;
        if (!jsonParam.get("userId").equals("")) {
            userId = jsonParam.getAsString("userId");
        }

//        System.out.println(date);
//        System.out.println(timeId);
//        System.out.println(reason);
//        System.out.println(roomId);
//        System.out.println(userId);

        if (date == null && reason == null && timeId == 0 && roomId == null){
//            System.out.println(3546546);
            return roomService.getAllRoomBorrowInfo();
        }else{
//            System.out.println(1111111111);
            return roomService.queryRBIByOptions(date, timeId, reason, roomId, userId);
        }
//        return null;
    }

    @RequestMapping(value = "/searchBorrowedInfoByUserId/{userId}",method = RequestMethod.GET)
    public ResultVo searchBorrowedInfoByUserId(@PathVariable("userId") String userId){
        return roomService.searchBorrowedInfoByUserId(userId);
    }

    //---------------RoomBorrowOperator---------------
    @PostMapping(value = "/borrow")//等价格于RequestMapping(value = "/borrow/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo borrowRoom(@RequestBody JSONObject jsonParam){
        String date = jsonParam.getAsString("date");
        int timeId = (int) jsonParam.getAsNumber("timeId");
        String timeName = jsonParam.getAsString("timeName");
        String roomId = jsonParam.getAsString("roomId");
        String roomName = jsonParam.getAsString("roomName");
        String user = jsonParam.getAsString("user");
        String reason = jsonParam.getAsString("reason");
        String applyTime = jsonParam.getAsString("applyTime");


        return roomService.borrow(date,timeId,timeName,roomId,roomName,user,reason,applyTime);
    }

    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo cancel(@RequestBody JSONObject jsonParam){

        String borrow_room_id = jsonParam.getAsString("roomId");
        String borrow_user = jsonParam.getAsString("userId");
        int borrow_time_id = (int) jsonParam.getAsNumber("timeId");
        String borrow_date = jsonParam.getAsString("date");


        return roomService.cancel(borrow_room_id,borrow_user,borrow_time_id, borrow_date);

    }

}

