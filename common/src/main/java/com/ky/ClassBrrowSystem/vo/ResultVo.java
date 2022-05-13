package com.ky.ClassBrrowSystem.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVo {
    //响应状态码
    private int code;
    //响应信息
    private String msg;
    //响应内容
    private Object data;

}
