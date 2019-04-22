package com.example.twoji.model;

import com.example.twoji.utils.MyCallBack;

import java.util.Map;

/**
 * author:${张四佟}
 * date:2019/3/7 19:13
 * description
 */
public interface Model {
    void getNetData(String mPath, Map<String,String> map, int type, MyCallBack myCallBack);
}
