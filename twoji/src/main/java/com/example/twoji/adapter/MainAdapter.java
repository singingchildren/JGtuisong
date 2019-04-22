package com.example.twoji.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.twoji.R;
import com.example.twoji.bean.OneGoodsBean;
import com.example.twoji.bean.TwoGoodsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * author:${张四佟}
 * date:2019/3/7 19:49
 * description
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private Context context;
    private List<OneGoodsBean.DataBean> oneGoodsBeans = new ArrayList<>();
    private List<TwoGoodsBean.DataBean> twoGoodsBeans = new ArrayList<>();

    public MainAdapter(Context context) {
        this.context = context;
    }

    public void setOneGoodsBeans(List<OneGoodsBean.DataBean> oneGoodsBeans) {
        this.oneGoodsBeans = oneGoodsBeans;
    }

    public void setTwoGoodsBeans(List<TwoGoodsBean.DataBean> twoGoodsBeans) {
        this.twoGoodsBeans = twoGoodsBeans;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.left_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.leftText.setText(oneGoodsBeans.get(i).getName());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getIdListnner!=null){
                    getIdListnner.getId(oneGoodsBeans.get(i).getCid());
                }
            }
        });
        viewHolder.leftCheck.setChecked(oneGoodsBeans.get(i).isLeftCheck());


    }

    @Override
    public int getItemCount() {
        return oneGoodsBeans.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView leftText;
        private final CheckBox leftCheck;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            leftText = itemView.findViewById(R.id.left_text);
            leftCheck = itemView.findViewById(R.id.left_check);
        }
    }

    public interface GetIdListnner{
        void getId(int id);
    }
    public GetIdListnner getIdListnner;

    public void setGetIdListnner(GetIdListnner getIdListnner) {
        this.getIdListnner = getIdListnner;
    }

    public interface AllCheckListnner{
        void isCheck(boolean is);
    }
    public AllCheckListnner allCheckListnner;

    public void setAllCheckListnner(AllCheckListnner allCheckListnner) {
        allCheckListnner = allCheckListnner;
    }
}
