package com.udemy.cursospring.resources.exception;

public class StandardError {

    private String msg;
    private Long timeStamp;
    private Integer status;

    public StandardError(String msg, Long timeStamp, Integer status) {
        this.msg = msg;
        this.timeStamp = timeStamp;
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
