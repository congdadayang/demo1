package com.example.demo.service;

import com.example.demo.Bean.ResultBean;

public class BaseService {
   public static ResultBean resultBean = new ResultBean();
    public static ResultBean success() {
        resultBean.setSuccess(true);
        resultBean.setCode("0");
        resultBean.setData(null);
        return resultBean;
    }

    public static ResultBean success(Object data) {
        resultBean.setSuccess(true);
        resultBean.setCode("0");
        resultBean.setData(data);
        return resultBean;
    }

    public static  ResultBean failure() {
        resultBean.setSuccess(false);
        resultBean.setCode("-1");
        resultBean.setMsg("msg", "");
        return resultBean;
    }

    public static ResultBean failure(String msg) {
        resultBean.setSuccess(false);
        resultBean.setCode("-1");
        resultBean.setMsg("msg", msg);
        return resultBean;
    }

    public static ResultBean failure(int code) {
        resultBean.setSuccess(false);
        resultBean.setCode("-1");
        resultBean.setMsg("msg", "");
        return resultBean;
    }

    public static ResultBean failure(int code, String msg) {
        resultBean.setSuccess(false);
        resultBean.setCode("-1");
        resultBean.setMsg("msg", msg);
        return resultBean;
    }
}
