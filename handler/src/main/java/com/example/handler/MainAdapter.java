package com.example.handler;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 * author:${张四佟}
 * date:2019/3/13 8:49
 * description
 */
public class MainAdapter extends BaseRecyAdapter {
    private Context context;
    private List<String> list = new ArrayList<>();
    private int layoutId;
    private TextView name;

    public MainAdapter(Context context, List datas, int layoutId) {
        super(context, datas, layoutId);
        this.context = context;
        this.list = datas;
        this.layoutId = layoutId;
    }

    @Override
    protected void onBindData(BaseHolder baseHolder, Object o, int postion) {
        baseHolder.setText(R.id.text_name,);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        TextView name = viewHolder.itemView.findViewById(R.id.text_name);
        ImageView title = viewHolder.itemView.findViewById(R.id.title_image);
        name.setText(list.get(i));
        title.setImageResource(R.drawable.tx);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
