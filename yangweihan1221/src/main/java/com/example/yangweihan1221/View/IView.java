package com.example.yangweihan1221.View;

public interface IView<T> {

    void startResponseData(T data);

    void setFail(String msg);
}
