package com.example.yangweihan1221.Presenter;

import com.example.yangweihan1221.Model.IModelmpl;
import com.example.yangweihan1221.MyCallBack.MyCallBack;
import com.example.yangweihan1221.View.IView;

public class IPresenterlmpl implements IPresenter {

    private IView iView;
    private IModelmpl iModelmpl;

    public IPresenterlmpl(IView iView) {
        this.iView = iView;
        iModelmpl = new IModelmpl();
    }

    public void onDetache(){
        if (iView != null){
            iView = null;
        }
        if (iModelmpl != null){
            iModelmpl = null;
        }
    }
    @Override
    public void requestData(String url, Class clazz) {
        iModelmpl.startRequsertData(url, clazz, new MyCallBack() {
            @Override
            public void setData(Object data) {
                iView.startResponseData(data);
            }

            @Override
            public void setDataFail(Object data) {

            }
        });
    }
}
