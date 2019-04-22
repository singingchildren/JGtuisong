package com.example.twoji;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.twoji.adapter.MainAdapter;
import com.example.twoji.adapter.SunAdapter;
import com.example.twoji.bean.OneGoodsBean;
import com.example.twoji.bean.TwoGoodsBean;
import com.example.twoji.network.MyPath;
import com.example.twoji.prsenter.IPrsenterImpl;
import com.example.twoji.view.IView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity<T> extends AppCompatActivity implements IView<T> {

    @BindView(R.id.leftRecy)
    RecyclerView leftRecy;
    @BindView(R.id.rightRecy)
    RecyclerView rightRecy;
    private IPrsenterImpl iPrsenter;
    private MainAdapter mainAdapter;
    private SunAdapter sunAdapter;
    private List<TwoGoodsBean.DataBean> twoList;
    private List<OneGoodsBean.DataBean> oneList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        iPrsenter = new IPrsenterImpl(this);
        mainAdapter = new MainAdapter(this);
        iPrsenter.startRequestData(MyPath.ONE_URL,null,1);
        sunAdapter = new SunAdapter(this);

        mainAdapter.setGetIdListnner(new MainAdapter.GetIdListnner() {
            @Override
            public void getId(int id) {
                Map<String,String> map = new HashMap<>();
                map.put("cid",id+"");
                iPrsenter.startRequestData(MyPath.TWO_URL,map,2);
            }
        });


    }

    @Override
    public void theData(T data) {
        if (data instanceof OneGoodsBean){
            OneGoodsBean oneGoodsBean = (OneGoodsBean) data;
            oneList = new ArrayList<>();
            oneList.addAll(oneGoodsBean.getData());
            mainAdapter.setOneGoodsBeans(oneList);
            mainAdapter.setTwoGoodsBeans(twoList);
            leftRecy.setAdapter(mainAdapter);
            leftRecy.setLayoutManager(new LinearLayoutManager(this));
        }else if (data instanceof TwoGoodsBean){
            TwoGoodsBean twoGoodsBean = (TwoGoodsBean) data;
            twoList = new ArrayList<>();
            twoList.addAll(twoGoodsBean.getData());
            sunAdapter.setDataBeans(twoList);
            rightRecy.setAdapter(sunAdapter);
            rightRecy.setLayoutManager(new GridLayoutManager(this,3));
        }
    }

    @Override
    public void theError(T error) {

    }
}
