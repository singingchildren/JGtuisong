package com.example.twoji.prsenter;

import java.util.Map;

/**
 * author:${张四佟}
 * date:2019/3/7 19:34
 * description
 */
public interface IPrsenter {
    void startRequestData(String mPath, Map<String,String> map, int type);
}
