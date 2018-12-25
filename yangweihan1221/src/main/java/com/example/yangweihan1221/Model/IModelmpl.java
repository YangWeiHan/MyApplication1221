package com.example.yangweihan1221.Model;

import com.example.yangweihan1221.MyCallBack.MyCallBack;
import com.example.yangweihan1221.OkHttp.ICallBack;
import com.example.yangweihan1221.OkHttp.OkHttpUtils;

public class IModelmpl implements IModel {
    @Override
    public void startRequsertData(String url, Class clazz, final MyCallBack myCallBack) {
        OkHttpUtils.getInstance().getEnqueue(url, clazz, new ICallBack() {
            @Override
            public void setData(Object o) {
                myCallBack.setData(o);
            }

            @Override
            public void setFail(Exception msg) {

            }
        });
    }
}
