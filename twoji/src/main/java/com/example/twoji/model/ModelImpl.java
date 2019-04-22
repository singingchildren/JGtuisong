package com.example.twoji.model;

import com.example.twoji.bean.OneGoodsBean;
import com.example.twoji.bean.TwoGoodsBean;
import com.example.twoji.utils.MyCallBack;
import com.example.twoji.utils.RetrofitUtil;
import com.google.gson.Gson;

import java.util.Map;

/**
 * author:${张四佟}
 * date:2019/3/7 19:33
 * description
 */
public class ModelImpl implements Model {

    @Override
    public void getNetData(String mPath, Map<String, String> map, int type, final MyCallBack myCallBack) {
        if (type == 1){
            RetrofitUtil.getUtil().getAll(mPath).setNetWorkListnner(new RetrofitUtil.NetWorkListnner() {
                @Override
                public void onSuccess(String s) {
                    OneGoodsBean oneGoodsBean = new Gson().fromJson(s,OneGoodsBean.class);
                    myCallBack.setData(oneGoodsBean);
                }

                @Override
                public void onError(String e) {

                }
            });
        }else if (type == 2){
            RetrofitUtil.getUtil().get(mPath,map).setNetWorkListnner(new RetrofitUtil.NetWorkListnner() {
                @Override
                public void onSuccess(String s) {
                    TwoGoodsBean twoGoodsBean = new Gson().fromJson(s,TwoGoodsBean.class);
                    myCallBack.setData(twoGoodsBean);
                }

                @Override
                public void onError(String e) {

                }
            });
        }
    }
}
