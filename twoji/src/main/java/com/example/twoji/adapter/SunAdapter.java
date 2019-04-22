package com.example.twoji.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.twoji.R;
import com.example.twoji.bean.OneGoodsBean;
import com.example.twoji.bean.TwoGoodsBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * author:${张四佟}
 * date:2019/3/7 19:49
 * description
 */
public class SunAdapter extends RecyclerView.Adapter<SunAdapter.ViewHolder> {
    private Context context;
    private List<TwoGoodsBean.DataBean> dataBeans = new ArrayList<>();

    public SunAdapter(Context context) {
        this.context = context;
    }

    public void setDataBeans(List<TwoGoodsBean.DataBean> dataBeans) {
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public SunAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.right_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SunAdapter.ViewHolder viewHolder, int i) {
        viewHolder.reghtimage.setImageURI(dataBeans.get(i).getPcid());
        viewHolder.rightText.setText(dataBeans.get(i).getName());
        viewHolder.check.setChecked(dataBeans.get(i).isXuanz());
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView reghtimage;
        private final TextView rightText;
        private final CheckBox check;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            reghtimage = itemView.findViewById(R.id.reghtimage);
            rightText = itemView.findViewById(R.id.rightText);
            check = itemView.findViewById(R.id.check);
        }
    }
}
