package com.example.handler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * author:${张四佟}
 * date:2019/3/13 8:43
 * description
 */
public abstract class BaseRecyAdapter<T> extends RecyclerView.Adapter<BaseHolder> {
    protected Context context;
    private List<T> datas;
    int[] layoutIds;

    //不使用多种布局时的构造函数
    public BaseRecyAdapter(Context context, List<T> datas, int layoutId) {
        this.context = context;
        this.datas = datas;
        this.layoutIds = new int[]{layoutId};
    }

    //使用多种布局时的构造函数
    public BaseRecyAdapter(Context context, List<T> datas, int[] layoutIds) {
        this.context = context;
        this.datas = datas;
        this.layoutIds = layoutIds;
    }

    public void setData(List<T> datas) {
        this.datas = datas;
    }

    public List<T> getData() {
        return datas;
    }

    //使用一种布局时的viewType默认为0,使用多种布局时的viewType需要指定
    @Override
    public BaseHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return BaseHolder.getHolder(context, viewGroup, layoutIds[viewType]);
    }

    @Override
    public void onBindViewHolder(BaseHolder baseHolder, int postion) {
        onBindData(baseHolder, datas.get(postion), postion);
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    //让子类实现具体的数据绑定方法
    protected abstract void onBindData(BaseHolder baseHolder, T t, int postion);
}
