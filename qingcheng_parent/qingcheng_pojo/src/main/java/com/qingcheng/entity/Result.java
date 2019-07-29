package com.qingcheng.entity;

import java.io.Serializable;

/**
 * 返回前端的消息封装
 */
public class Result implements Serializable {

    private Integer code;//返回的业务代码 0执行成功；1执行失败
    private String message;//消息提醒

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result() {
        this.code=0;
        this.message="执行成功";
}

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
