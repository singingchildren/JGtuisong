package com.example.twoji.view;

/**
 * author:${张四佟}
 * date:2019/3/7 19:12
 * description
 */
public interface IView<T> {
    void theData(T data);
    void theError(T error);
}
