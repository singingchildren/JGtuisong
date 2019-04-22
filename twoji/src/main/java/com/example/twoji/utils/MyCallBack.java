package com.example.twoji.utils;

/**
 * author:${张四佟}
 * date:2019/3/7 19:12
 * description
 */
public interface MyCallBack<T> {
    void setData(T data);
    void setError(T error);
}
