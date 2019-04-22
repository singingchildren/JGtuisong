package com.example.twoji.prsenter;

import com.example.twoji.model.ModelImpl;
import com.example.twoji.utils.MyCallBack;
import com.example.twoji.view.IView;

import java.util.Map;

/**
 * author:${张四佟}
 * date:2019/3/7 19:37
 * description
 */
public class IPrsenterImpl implements IPrsenter {
    private IView iView;
    private final ModelImpl model;

    public IPrsenterImpl(IView iView) {
        this.iView = iView;
        model = new ModelImpl();
    }

    @Override
    public void startRequestData(String mPath, Map<String, String> map, int type) {
        model.getNetData(mPath, map, type, new MyCallBack() {
            @Override
            public void setData(Object data) {
                iView.theData(data);
            }

            @Override
            public void setError(Object error) {
                iView.theError(error);
            }
        });
    }
}
