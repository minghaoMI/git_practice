package com.xiaomi.search.global.cms.goldenset.base;

/**
 * Created by minghao on 16-7-7.
 */
public class Result {

    public enum RunStatus { SUCCESS, FAIL }

    protected RunStatus status;

    protected  String message;

    public Result() {
        this.status = RunStatus.SUCCESS;
        this.message = null;
    }

    public RunStatus getStatus() {
        return status;
    }

    public void setStatus(RunStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
