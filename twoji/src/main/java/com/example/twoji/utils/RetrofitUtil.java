package com.example.twoji.utils;

import com.example.twoji.network.MyApiService;

import java.io.IOException;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * author:${张四佟}
 * date:2019/3/7 18:51
 * description
 */
public class RetrofitUtil {

    private final MyApiService myApiService;

    private RetrofitUtil() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .retryOnConnectionFailure(true)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("http://172.17.8.100/ks/")
                .client(okHttpClient)
                .build();
        myApiService = retrofit.create(MyApiService.class);
    }

    private static class Holder{
        private static RetrofitUtil util = new RetrofitUtil();
    }

    public static RetrofitUtil getUtil() {
        return Holder.util;
    }

    public RetrofitUtil get(String mPath, Map<String,String> map){
        myApiService.get(mPath,map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
        return RetrofitUtil.getUtil();
    }

    public RetrofitUtil getAll(String mPath){
        myApiService.getAll(mPath).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
        return RetrofitUtil.getUtil();
    }

    public Observer observer = new Observer<ResponseBody>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            if (netWorkListnner!=null){
                netWorkListnner.onError(e.getMessage());
            }
        }

        @Override
        public void onNext(ResponseBody responseBody) {
            if (netWorkListnner!=null){
                try {
                    netWorkListnner.onSuccess(responseBody.string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public interface NetWorkListnner{
        void onSuccess(String s);
        void onError(String e);
    }

    public NetWorkListnner netWorkListnner;

    public void setNetWorkListnner(NetWorkListnner netWorkListnner) {
        this.netWorkListnner = netWorkListnner;
    }
}
